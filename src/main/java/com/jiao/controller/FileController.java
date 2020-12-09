package com.jiao.controller;


import com.jiao.model.Uploadfile;

import com.jiao.service.UploadfileService;
import com.jiao.web.AuthClass;
import com.jiao.web.AuthMethod;
import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URLEncoder;
import java.util.Date;
import java.util.List;

@AuthClass
@Controller
public class FileController {
    @Autowired
    private UploadfileService fileService;
    private static ApplicationContext applicationContext;
    @AuthMethod
    @RequestMapping(value = "/file", method = RequestMethod.GET)
    public String file(HttpSession session){

        return "file";
    }


    @Transactional
    @AuthMethod
    @RequestMapping(value = "/upload", method = RequestMethod.POST)
    public String fileUpload(MultipartFile file, HttpSession session){
        if (file != null){
            //带后缀的全名
            String fileFullName = file.getOriginalFilename();
            //去除后缀的名字，存到数据库
            String filename = fileFullName.substring(0, fileFullName.indexOf("."));
            String filetype = fileFullName.substring(fileFullName.indexOf("."),fileFullName.length());
            String creator = (String) session.getAttribute("userInfo");
            String path = session.getServletContext().getRealPath("/upload/" + fileFullName);
            File destFile = new File(path);

            try {
                FileUtils.copyInputStreamToFile(file.getInputStream(), destFile);
            } catch (IOException e) {
                e.printStackTrace();
            }
            Uploadfile uploadFile = new Uploadfile(creator,filename,filetype, path, new Date());
            fileService.add(uploadFile);

            System.out.println(filename + "---------" + "全名：" + fileFullName + "----------" + creator);
        }
        List<Uploadfile> allFiles = fileService.selectAll();
       session.getServletContext().setAttribute("allFiles", allFiles);

        return "file";
    }

    @AuthMethod
    @RequestMapping(value = "/download", method = RequestMethod.GET)
    public ResponseEntity<byte[]> download(String url, HttpSession session) throws FileNotFoundException {
        try{
            System.out.println("进入下载页面了");
            System.out.println("url是：" + url);
            ServletContext context = session.getServletContext();
            String path = context.getRealPath("/upload" + url);
            if(!new File(path).exists()){
                byte[] body = new String("<html><body><script>alert('资源不存在！');window.location = '../'</script></body></html>").getBytes();
                return new ResponseEntity<>(body, HttpStatus.NOT_FOUND);
            }
            FileInputStream inputStream = new FileInputStream(path);
            byte[] body = new byte[inputStream.available()];
            // 将文件流读入到数组中
            inputStream.read(body);
            // 创建请求头
            HttpHeaders httpHeaders = new HttpHeaders();
            // 对文件名进行编码
            String filename = URLEncoder.encode(url, "UTF-8");
            // 告知浏览器以附件的形式下载
            httpHeaders.add("Content-Disposition","attachment;filename="+filename);
            // 设置响应码
            ResponseEntity<byte[]> responseEntity = new ResponseEntity<>(body, httpHeaders, HttpStatus.OK);
            // 关闭输入流
            inputStream.close();
            // 返回响应报文
            return responseEntity;
        }catch (Exception e){
            e.printStackTrace();
        }

        byte[] body = new String("<html><body><script>alert('下载失败！');window.location = '../index.html'</script></body></html>").getBytes();
        return new ResponseEntity<>(body,HttpStatus.FORBIDDEN);
    }


}

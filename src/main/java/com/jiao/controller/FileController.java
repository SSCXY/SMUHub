package com.jiao.controller;


import com.jiao.model.UploadFile;
import com.jiao.model.User;
import com.jiao.service.FileService;
import com.jiao.web.AuthClass;
import com.jiao.web.AuthMethod;
import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.util.Date;

@AuthClass
@Controller
public class FileController {
    @Autowired
    private FileService fileService;

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
            String creator = (String) session.getAttribute("userInfo");
            String path = session.getServletContext().getRealPath("/upload/" + fileFullName);
            File destFile = new File(path);

            try {
                FileUtils.copyInputStreamToFile(file.getInputStream(), destFile);
            } catch (IOException e) {
                e.printStackTrace();
            }
            UploadFile uploadFile = new UploadFile(creator,filename, path, new Date());
            fileService.add(uploadFile);

            System.out.println(filename + "---------" + "全名：" + fileFullName + "----------" + creator);
        }
        return "文件上传成功";
    }

}

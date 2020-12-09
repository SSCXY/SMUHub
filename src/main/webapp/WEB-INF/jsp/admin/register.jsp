<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>注册</title>
    <meta name="description" content="">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="robots" content="all,follow">
    <!-- Bootstrap CSS-->
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Poppins:300,400,700">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/css/style.default.css" id="theme-stylesheet">
  </head>
  <body>
    <div class="page login-page">
      <div class="container d-flex align-items-center">
        <div class="form-holder has-shadow">
          <div class="row">
            <!-- Logo & Information Panel-->
            <div class="col-lg-12">
              <div class="info d-flex align-items-center">
                <div class="content">
                  <div class="logo">
                    <h1>欢迎注册</h1>
                  </div>
                  <p>SMUResposity</p>
                </div>
              </div>
            </div>
            <!-- Form Panel    -->
            <div class="col-lg-12 bg-white">
              <div class="form d-flex align-items-center">
                <form class="content" id="myform" action="${pageContext.request.contextPath}/regist" method="post">
                    <div class="form-group">
                      <input id="register-username" class="input-material" type="text" name="username" placeholder="请输入用户名/姓名" >
								      <div class="invalid-feedback">
								        	用户名必须在2~10位之间
								      </div>
                    </div>
                    <div class="form-group">
                      <input id="register-password" class="input-material" type="password" name="password" placeholder="请输入密码"   >
                    	<div class="invalid-feedback">
								        	密码必须在4~10位之间
								      </div>
                    </div>
                    <div class="form-group">
                      <input id="register-passwords" class="input-material" type="password" name="passwords" placeholder="确认密码"   >
                    	<div class="invalid-feedback">
								        	两次密码必须相同 且在4~10位之间
								      </div>
                    </div>
                    <div class="form-group">
                      <input id="register-phone" class="input-material" type="text" name="phone" placeholder="手机号"   >
                    	<div class="invalid-feedback">
								        	请输入您的手机号
								      </div>
                    </div>
                    <div class="form-group">
                      <input id="register-email" class="input-material" type="text" name="email" placeholder="邮箱"   >
                    	<div class="invalid-feedback">
								        	请输入您的邮箱地址
								      </div>
                    </div>
                    <div class="form-group">
                      <button id="regbtn" type="button" name="registerSubmit" class="btn btn-primary" onclick="document.getElementById('myform').submit()">注册</button>
                    </div>
                  <small>已有账号?</small><a href="${pageContext.request.contextPath}/login" class="signup">&nbsp;登录</a>
                </form>
              </div>
            </div>
          </div>
        </div>
      </div>
    </div>
    <!-- JavaScript files-->
    <script src="${pageContext.request.contextPath}/static/js/jquery-3.5.1.js"></script>
    <script src="${pageContext.request.contextPath}/static/js/bootstrap.min.js"></script>
    <script>
    	$(function(){
    		/*错误class  form-control is-invalid
    		正确class  form-control is-valid*/
    		var flagName=false;
    		var flagPas=false;
    		var flagPass=false;
    		/*验证用户名*/
    		var name,passWord,passWords,email,phone;
    		$("#register-username").change(function(){
    			name=$("#register-username").val();
    			if(name.length<2||name.length>10){
    				$("#register-username").removeClass("form-control is-valid")
    				$("#register-username").addClass("form-control is-invalid");
    				flagName=false;
    			}else{
    				$("#register-username").removeClass("form-control is-invalid")
    				$("#register-username").addClass("form-control is-valid");
    				flagName=true;
    			}
    		})
    		$("#register-phone").change(function(){
    			phone=$("#register-phone").val();
    			if(phone.length<11 || phone.length>11){
    				$("#register-phone").removeClass("form-control is-valid")
    				$("#register-phone").addClass("form-control is-invalid");
    				flagName=false;
    			}else{
    				$("#register-phone").removeClass("form-control is-invalid")
    				$("#register-phone").addClass("form-control is-valid");
    				flagName=true;
    			}
    		})
    		$("#register-email").change(function(){
              email=$("#register-email").val();
    			if(email.length<8){
    				$("#register-email").removeClass("form-control is-valid")
    				$("#register-email").addClass("form-control is-invalid");
    				flagName=false;
    			}else{
    				$("#register-email").removeClass("form-control is-invalid")
    				$("#register-email").addClass("form-control is-valid");
    				flagName=true;
    			}
    		})
    		/*验证密码*/
    		$("#register-password").change(function(){
    			passWord=$("#register-password").val();
    			if(passWord.length<4||passWord.length>18){
    				$("#register-password").removeClass("form-control is-valid")
    				$("#register-password").addClass("form-control is-invalid");
    				flagPas=false;
    			}else{
    				$("#register-password").removeClass("form-control is-invalid")
    				$("#register-password").addClass("form-control is-valid");
    				flagPas=true;
    			}
    		})
    		/*验证确认密码*/
    		$("#register-passwords").change(function(){
    			passWords=$("#register-passwords").val();
    			if((passWord!=passWords)||(passWords.length<4||passWords.length>18)){
    				$("#register-passwords").removeClass("form-control is-valid")
    				$("#register-passwords").addClass("form-control is-invalid");
    				flagPass=false;
    			}else{
    				$("#register-passwords").removeClass("form-control is-invalid")
    				$("#register-passwords").addClass("form-control is-valid");
    				flagPass=true;
    			}
    		})

    	})
    </script>
  </body>
</html>
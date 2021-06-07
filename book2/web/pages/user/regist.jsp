<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>会员注册页面</title>

  <%--使用静态包含调用公共的头部信息 base标签、css样式、jQuery文件--%>
  <%@include file="/pages/common/head.jsp"%>

  <script type="text/javascript">
    //页面加载完成之后
    $(function (){

      //给验证码图片绑定单价事件
      $("#code_img").click(function () {
        //刷新验证码
        // 在事件响应的function函数中有一个this对象。这个this对象，是当前正在响应事件的dom对象
        // src属性表示验证码img标签的 图片路径。它可读，可写
        // alert(this.src);
        // 后面加一个时间戳，让每次发起的请求都不同，浏览器就不能在缓存里找到之前保存的值
        this.src = "${basePath}kaptcha.jpg?d=" + new Date();
      });

      //给注册绑定单击事件
      $("#sub_btn").click(function () {
        // 验证用户名：必须由字母，数字下划线组成，并且长度为 5 到 12 位
          //1、获取用户名输入框里的内容
        var usernameText = $("#username").val();
          //2、创建正则表达式对象
        var usernamePatt = /^\w{5,12}$/;
          //3、使用test方法验证
        if(!usernamePatt.test(usernameText)){
          //4、提示用户结果
          $("span.errorMsg").text("用户名不合法！");
          return false;   //不合法阻止页面跳转
        }

        // 验证密码：必须由字母，数字下划线组成，并且长度为 5 到 12 位
          //1、获取用户名输入框里的内容
        var passwordText = $("#password").val();
          //2、创建正则表达式对象
        var passwordPatt = /^\w{5,12}$/;
          //3、使用test方法验证
        if(!passwordPatt.test(passwordText)) {
          //4、提示用户结果
          $("span.errorMsg").text("密码不合法！");
          return false;   //不合法阻止页面跳转
        }

        // 验证确认密码：和密码相同
          //1、获取确认密码内容
        var repwdText = $("#repwd").val();
          //2、和密码相比较
        if(repwdText != passwordText){
          //3、提示用户
          $("span.errorMsg").text("确认密码和密码不一致！");
          return false;   //不合法阻止页面跳转
        }

        // 邮箱验证：xxxxx@xxx.com
          //1、获取邮箱内容
        var emailText = $("#email").val();
          //2、创建正则表达式对象
        var emailPatt = /^[a-z\d]+(\.[a-z\d]+)*@([\da-z](-[\da-z])?)+(\.{1,2}[a-z]+)+$/;
          //3、使用test方法验证
        if(!emailPatt.test(emailText)){
          //4、提示用户
          $("span.errorMsg").text("邮箱不合法！");
          return false;   //不合法阻止页面跳转
        }

        // 验证码：现在只需要验证用户已输入。因为还没讲到服务器。验证码生成。
          //1、获取输入的验证码内容
        var codeText = $("#code").val();
          //2、去掉输入的验证码的前后空格
        var codeText = $.trim(codeText);
          //3、判断验证码是否为null或空
        if(codeText == null || codeText == ""){
          //4、提示用户
          $("span.errorMsg").text("请输入验证码！");
          return false;   //不合法阻止页面跳转
        }

        //把“用户名不合法”的提示取消
        $("span.errorMsg").text("");
      });

      /*给注册用户名输入框添加失去焦点事件*/
      $("#username").blur(function () {
        //1、获取用户名
        var username =this.value;

        //2、发起Ajax请求
        $.getJSON("http://localhost:8080/book2/userServlet","action=ajaxExistsUsername&username=" + username,function (data) {
          if(data.existsUsername){
            //为true说明用户名已经存在
            $("span.errorMsg").text("用户名已存在！");
          }else{
            $("span.errorMsg").text("用户名可用！");
          }
        });
      });




    });
  </script>
<style type="text/css">
	.login_form{
		height:420px;
		margin-top: 25px;
	}
</style>
</head>
<body>
		<div id="login_header">
			<img class="logo_img" alt="" src="static/img/log.gif" >
		</div>
			<div class="login_banner">
				<div id="l_content">
					<span class="login_word">欢迎注册</span>
				</div>
				<div id="content">
					<div class="login_form">
						<div class="login_box">
							<div class="tit">
								<h1>注册会员</h1>
								<span class="errorMsg">
                  <%--注册失败，显示错误提示信息--%>
                  <%--表达式脚本：<%=request.getAttribute("msg") == null? "":request.getAttribute("msg") %>--%>
                  <%--EL表达式：--%>${requestScope.msg}
                </span>
							</div>
							<div class="form">
								<form action="userServlet" method="post">
                  <input type="hidden" name="action" value="regist">     <%--添加隐藏域--%>
									<label>用户名称：</label>
									<input class="itxt" type="text" placeholder="请输入用户名"
                         <%--注册失败显示回显信息--%>
                         <%-- 表达式脚本：value="<%=request.getAttribute("username") == null? "":request.getAttribute("username") %>"--%>
                         <%--EL表达式：--%> value="${requestScope.username}"
                         autocomplete="off" tabindex="1" name="username" id="username" />
									<br />
									<br />
									<label>用户密码：</label>
									<input class="itxt" type="password" placeholder="请输入密码"
                          autocomplete="off" tabindex="1" name="password" id="password" />
									<br />
									<br />
									<label>确认密码：</label>
									<input class="itxt" type="password" placeholder="确认密码"
                          autocomplete="off" tabindex="1" name="repwd" id="repwd" />
									<br />
									<br />
									<label>电子邮件：</label>
									<input class="itxt" type="text" placeholder="请输入邮箱地址"
                         <%--注册失败显示回显信息--%>
                         <%--表达式脚本：value="<%=request.getAttribute("email") == null? "":request.getAttribute("email") %>"--%>
                         <%--EL表达式：--%> value="${requestScope.email}"

                         autocomplete="off" tabindex="1" name="email" id="email" />
									<br />
									<br />
									<label>验 证 码 ：</label>
									<input class="itxt" name="code" type="text" style="width: 100px;" id="code" placeholder="请输入验证码"/>

									<img  id="code_img" lt="" src="kaptcha.jpg" style="float: right; margin-right: 40px; width: 110px; height: 38px;">
									<br />
									<br />
									<input type="submit" value="注册" id="sub_btn" />
								</form>
							</div>
						</div>
					</div>
				</div>
			</div>

    <%--静态包含公共的页脚部分--%>
    <%@include file="/pages/common/footer.jsp"%>

</body>
</html>

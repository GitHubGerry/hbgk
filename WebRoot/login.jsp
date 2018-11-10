<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>


<html>
<head>
<link rel="stylesheet" type="text/css" href="gywcss/login.css">
<script type="text/javascript" src="jqeasyui/jquery.min.js"></script>
<script type="text/javascript" src="jqeasyui/jquery.easyui.min.js"></script>
<script type="text/javascript" src="jqeasyui/easyui-lang-zh_CN.js"></script>
<script type="text/javascript" src="jqeasyui/easyui_functions.js"></script>
</head>
  
<body id="main">
<h1 class="text-white custom-font">
何不管库<br>
</h1>  
<h2 class="text-white custom-font">
 管理，游戏般轻松
</h2>  
<a href="javascript:void(0)" onClick="letslogin()" class="btn">现 在 登 录</a>

<script>
//进去后 页面拉开帷幕 出现登录框, 点击登陆后 页面下方木制小人 欢呼。完不成了，没素材。
//a 标签提交表单.submit方法 必须不写href
i=Math.random()*12+58;
i=i-i%1;
function letslogin(){
	str="<div id='login_div'><form id='loginform' action='login' method='post' onsubmit='return check1(this);'><div id='label1'>账号：</div><input type='text' id='userid' name='userid'/>";
	str+="<div id='label2'>密码：</div><input type='password' id='password' name='password'/><img id='checkpic' src='gywpic/checkpic/66.jpg' style='position:relative;top:110px;height:55px;width:140px'/>";
	str+="<div id='label3'>验证码：</div><input type='text' id='answer' onkeydown='if(event.keyCode==13){}'/><a id='btn2' onClick='submit()' class='btn2' style='cursor:pointer'>登 录</a></form></div>";
	$("#main").append(str);
	$("#checkpic").attr('src','gywpic/checkpic/'+i+'.jpg');

}

function submit(){   //a标签提交这样写！
	$("#loginform").submit();
}
//var userid=$("#userid").textbox('getValue');//什么问题
function check1(){
	var userid=$("#userid").val();
	var password=$("#password").val();
	var answer=$("#answer").val();
	var flag=true;
	if(userid=='' || password==''){
		alert('账号或密码不能为空！');
		flag=false;
	}else{
		if(answer!=i){
			alert('验证码错误！');
			flag=false;
	}}
	return flag;
}
</script>
<%
if(request.getAttribute("message")!=null)
{System.out.println(request.getAttribute("message"));
%>
<script>alert('错误的用户名或密码！')</script>
<%	
}
%>  
</body>
</html>

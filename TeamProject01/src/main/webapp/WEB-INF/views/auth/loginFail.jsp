<%-- <%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c'%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Refresh" content="url=Login">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>로그인 실패!</title>
<link rel="stylesheet" type="text/css" href="style.css">
<link rel="shortcut icon" href="https://cdn3.iconfinder.com/data/icons/faticons/32/send-01-24.png">
<script type="text/javascript">
	var Pic = new Array()
	Pic[0] = 'http://4.bp.blogspot.com/-EKptQQal56A/UiX4ddMEYUI/AAAAAAAAANE/xtk3iIxn0ok/s1600/1.jpg'
	Pic[1] = 'http://3.bp.blogspot.com/--ftqEoWXuvI/UiX4d5yG4_I/AAAAAAAAANI/owxZE78DyPY/s1600/2.jpg'
	Pic[2] = 'http://3.bp.blogspot.com/-SmcYEN4DAEU/UiX4ftDt3MI/AAAAAAAAANU/_MUuP30noL4/s1600/3.jpg'
	Pic[3] = 'http://1.bp.blogspot.com/-5jPmO_4cNZE/UiX4gSTJ4BI/AAAAAAAAANc/OI_aMZZ_Jqw/s1600/4.jpg'
	Pic[4] = 'http://1.bp.blogspot.com/-mvCvNR1VmHA/UiX4g5LI0_I/AAAAAAAAANg/_x_5sz19m-I/s1600/5.jpg'

	var p = Pic.length
	var imgLoad = new Array()

	for (i = 0; i < p; i++) {
		imgLoad[i] = new Image()
		imgLoad[i].src = Pic[i]
	}

	window.onload = function setImg() {
			var j = Math.floor(Math.random() * 5);
			document.body.background = Pic[j];
			document.body.background-size = "cover";
	}
</script>
</head>

</head>
<body>
<body>
	<form method="post" action="login.do">
		<div id="form">
			<section> <header> <span id="logo" class="entypo-paper-plane"></span>
			<h1>SPMS.</h1>
			</header> 
			
			<article>
			<div id="contain_fields">
				<input type="text" name="email" id="email"  <c:if test="${cookie_email != ''}">value='${cookie_email}'</c:if>  placeholder="Email" /> 
				<input type="password" name="password" id="password" placeholder="Password">
			    <a href="#" id="tooltip--why"></a>
			</div>
			<input type="submit" value="Login" /> 
			</article>
			
			<div id="error"><p>이메일 또는 암호가 맞지 않습니다.</p></div><br>
			<div class="chk_id">
			<input type="checkbox" name="saveId" <c:if test="${isSaveId}">checked</c:if> class="chk_login"> remember email
			<p>
				<a href="../member/signup.do">Sign up</a> for a new account
			</p>
			</footer> </section>
		</div>
	</form>
</body>
</html> --%>

 <%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c'%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>SPMS_LoginForm</title>
<link href="http://fonts.googleapis.com/css?family=Lato:300,400,300italic,400italic" rel="stylesheet" type="text/" />
<link href="//netdna.bootstrapcdn.com/font-awesome/3.1.1/css/font-awesome.css" rel="stylesheet" />
<link href="css/styles.css" type="text/css" rel="stylesheet">

</head>

<body>
	<section class="m-box--sign-in" role="main">
		<header class="m-box--box-sized">
			<h1>
				Sign In <span>or <a href="../member/signup.do">sign up</a></span>
			</h1>
			<a class="m-link--close" href="#">x </a>
		</header>
		<form class="m-form--sign-in" action="login.do" method="post">
			<fieldset>
				<span class="icon-envelope"></span>
				<input placeholder="Email" name="email" <c:if test="${cookie_email != ''}">value='${cookie_email}'</c:if> required="" type="email" />
				<span class="m-field-error"></span>
			</fieldset>
			<fieldset>
				<span class="icon-lock"></span>
				<input placeholder="Password" name="password" required="" type="password" /><span class="m-field-error"></span>
			</fieldset>
			<div>
				<div id="error"><p>입력하신 이메일이 존재하지 않거나 또는 암호가 맞지 않습니다.</p></div><br>
				<input type="checkbox" name="saveId" <c:if test="${isSaveId}">checked</c:if>><span>remember email</span>
				<a href="#">Forgot password ? </a>
				<button type="submit">Sign In</button>
			</div>
		</form>
		<aside role="complementary">
			<ul class="m-list--other-sign-in">
				<li><a href="#"><i class="icon-google-plus"></i><span>Google+</span></a></li>
				<li><a href="#"><i class="icon-twitter"></i><span>Twitter</span></a></li>
				<li><a href="#"><i class="icon-facebook"></i><span>Facebook</span></a></li>
			</ul>
		</aside>
	</section>
</body>
</html>
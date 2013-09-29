<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c'%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Refresh" content="url=Login">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>로그인 실패!</title>
<link rel="stylesheet" type="text/css" href="style.css">

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
</html>
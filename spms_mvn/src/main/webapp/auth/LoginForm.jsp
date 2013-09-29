<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c'%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html;charset=UTF-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<title>LoginForm</title>

<link rel="stylesheet" type="text/css" href="style.css">

<script type="text/javascript">
	var Pic = new Array()
	Pic[0] = 'http://www.hdwallpapers.in/walls/3d_colorful_squares-wide.jpg'
	Pic[1] = 'http://www.hdwallpapers.in/walls/fantasy_space-wide.jpg'
	Pic[2] = 'http://www.hdwallpapers.in/walls/flower_vector_designs_1080p-HD.jpg'
	Pic[3] = 'http://www.hdwallpapers.in/walls/rainbow_colorful_vector-normal.jpg'
	Pic[4] = 'http://www.hdwallpapers.in/walls/micro_plant-HD.jpg'
	Pic[5] = 'http://www.hdwallpapers.in/walls/relax-HD.jpg'
	Pic[6] = 'http://www.hdwallpapers.in/walls/tiger_skin-wide.jpg'

	var p = Pic.length
	var imgLoad = new Array()

	for (i = 0; i < p; i++) {
		imgLoad[i] = new Image()
		imgLoad[i].src = Pic[i]
	}

	window.onload = function setImg() {
		var j = Math.floor(Math.random() * p)
		document.body.background = Pic[j]
	}
</script>
</head>

<body>
	<form method="post" action="login.do">
		<div id="form">
			<section>
				<header>
					<span id="logo" class="entypo-paper-plane"></span>
					<h1>SPMS.</h1>
				</header>
				<article>
					<div id="contain_fields">
						<input type="text" name="email" <c:if test="${email != ''}">value='${email}'</c:if> placeholder="Email"> 
						<input type="password" name="password" placeholder="password"> 
						<a href="#" id="tooltip--why"></a>
					</div>
					<input type="submit" value="Login"/>
				</article>
				<footer>
					<p>
						<a href="../member/signup.do">Sign up</a> for a new account
					</p>
					<input type="checkbox" name="saveId"
						<c:if test="${isSaveId}">checked</c:if>>remember email
				</footer>
			</section>
		</div>
	</form>
</body>

</html>
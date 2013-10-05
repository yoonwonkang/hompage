<%-- <%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c'%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html;charset=UTF-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<title>SPMS_LoginForm</title>
<link rel="stylesheet" type="text/css" href="style.css">
<link href="http://fonts.googleapis.com/css?family=Lobster&subset=latin" rel="stylesheet" type="text/css">
<link rel="shortcut icon" href="https://cdn3.iconfinder.com/data/icons/faticons/32/send-01-24.png">

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
					<article class="mask-galaxy"><span id="logo" class="entypo-paper-plane"></span></article>
					<article class="mask-galaxy"><mainpage>SPMS</mainpage></article>
				</header>
				<article>
					<div id="contain_fields">
						<input type="text" name="email" <c:if test="${email != ''}">value='${email}'</c:if> placeholder="Email"> 
						<input type="password" name="password" placeholder="password"> 
						<a href="#" id="tooltip--why"></a>
					</div>
					<input type="submit" value="Sign in"/>
				</article>
				<footer>
					<p>
						<a href="../member/signup.do">Sign up</a> for a new account
					</p>
					<input type="checkbox" name="saveId" <c:if test="${isSaveId}">checked</c:if>><span>remember email</span>
				</footer>
			</section>
		</div>
	</form>
</body>

</html>

 --%>
 
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
				Sign IN <span>or <a href="../member/signup.do">sign up</a></span>
			</h1>
			<a class="m-link--close" href="#">x </a>
		</header>
		<form class="m-form--sign-in" action="login.do" method="post">
			<fieldset>
				<span class="icon-envelope"></span>
				<input placeholder="Email" name="email" <c:if test="${email != ''}">value='${email}'</c:if> required="" type="email" />
				<span class="m-field-error"></span>
			</fieldset>
			<fieldset>
				<span class="icon-lock"></span>
				<input placeholder="Password" name="password" required="" type="password" /><span class="m-field-error"></span>
			</fieldset>
			<div>
				<input type="checkbox" name="saveId" <c:if test="${isSaveId}">checked</c:if>><span>remember email</span>
				<a id="forgot" href="#">Forgot password ? </a>
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
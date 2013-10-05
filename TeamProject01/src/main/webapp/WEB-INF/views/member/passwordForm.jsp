<%@page import="net.bitacademy.java41.vo.Project"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>암호변경</title>
<link href="http://fonts.googleapis.com/css?family=Arvo"
	rel="stylesheet" type="text/css" />
<link href="style.css" rel="stylesheet" type="text/css" media="screen" />
<link rel="stylesheet"
	href="<%=application.getContextPath()%>/css/base.css">
<link rel="shortcut icon" href="https://cdn3.iconfinder.com/data/icons/faticons/32/send-01-24.png">	
</head>
<body>
	<div id="wrapper">
		<div id="wrapper-bgbtm">
			<jsp:include page="/header.do"></jsp:include>
			<div id="page">
				<div id="page-bgtop">
					<div id="page-bgbtm">
						<div id="content">
							<div class="post">
								<div class="entry">
									<p>
									<h1>암호변경</h1>
									<div id="comment_form">
									<form action="passwordChange.do" method="post">
										이메일<br><input type="text" name="email" value="${myInfo.email}"
											readonly><br> 이전 암호<br> <input type="password"
											name="password" required><br> 새 암호<br> <input
											type="password" name="newPassword" required><br>
										새 암호 확인<br> <input type="password" name="newPassword2" required><br>
										<input type="submit" value="변경">
									</form>
									</div>
									<a href="updateMyInfo.do">[이전]</a> <a href="list.do">[목록]</a>
									</p>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
			<jsp:include page="/sidebar.do"></jsp:include>
			<div style="clear: both;">&nbsp;</div>
		</div>
	</div>
	<jsp:include page="/tail.do"></jsp:include>
</body>
</html>











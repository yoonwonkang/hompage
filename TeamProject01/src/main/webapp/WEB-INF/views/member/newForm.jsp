<%@page import="net.bitacademy.java41.vo.Project"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>멤버 등록</title>
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
									<h1>멤버 등록</h1>
									<div id="comment_form">
										<form action="add.do" method="post"
											enctype="multipart/form-data">
											이메일<br> <input type="text" name="email" required><br>
											암호<br> <input type="password" name="password" required><br>
											이름<br> <input type="text" name="name" required><br>
											전화<br> <input type="text" name="tel" required><br>
											사진<br> <input type="file" name="memImg"><br> 
											블로그<br> <input type="text" name="blog"><br> 
											우편번호<br> <input	type="text" name="postNo"> 
											<input type="button"	value="우편번호찾기"><br> 
											상세주소<br> <input type="text" name="detailAddr"><br> 
											태그<br> <input type="text" name="tag"><br> 
											권한<br> <select name="memLevel">
												<option value="0" selected>일반회원</option>
												<option value="1">관리자</option>
												<option value="2">PM</option>
												<option value="9">손님</option>
											</select><br> <input type="submit" value="등록"> <input
												type="reset" value="취소">
										</form>
									</div>
									<a href="list.do">[목록]</a>
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











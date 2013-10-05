<%@page import="net.bitacademy.java41.vo.Member"%>
<%@ page language="java" 
	contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:useBean id="member" class="net.bitacademy.java41.vo.Member" 
		scope="session"></jsp:useBean>    
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>SPMS by java41</title>
<link href="http://fonts.googleapis.com/css?family=Arvo" rel="stylesheet" type="text/css" />
<link href="style.css" rel="stylesheet" type="text/css" media="screen" />
<link rel="stylesheet" href="<%=application.getContextPath()%>/css/base.css">
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
										<h1>개인 정보 변경</h1>
										<div id="comment_form">
										<form action="updateMyInfo.do" method="post" enctype="multipart/form-data">
										이메일 <br> <input type="text" name="email" value="${myInfo.email}" readonly><br>
										암호<br> <input type="password" name="password" required ><a href="myInfopasswordChange.do" >비밀번호변경</a><br>
										암호 확인<br> <input type="password" name="configpassword"><br>
										이름<br> <input type="text" name="name" value="${myInfo.name}" required><br>
										전화<br> <input type="text" name="tel" value="${myInfo.tel}" required><br>
										사진<br> <input type="file" name="photo"><br>
										블로그<br> <input type="text" name="blog" value="${myInfo.blog}"><br>
										우편번호<br> <input type="text" name="postno">
												<input type="button" value="우편번호찾기"><br>
										기본주소<br> <input type="text" name="basicAddr"><br>
										상세주소<br> <input type="text" name="detailAddr" value="${myInfo.detailAddr}"><br>
										태그<br> <input type="text" name="tag" value="${myInfo.tag}"><br>
										<input type="submit" value="등록">
										<input type="reset" value="취소">
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

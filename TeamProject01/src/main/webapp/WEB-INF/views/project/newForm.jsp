<%@page import="net.bitacademy.java41.vo.Project"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>프로젝트 등록</title>
<link href="http://fonts.googleapis.com/css?family=Arvo"
	rel="stylesheet" type="text/css" />
<link href="style.css" rel="stylesheet" type="text/css" media="screen" />
<link rel="stylesheet" href="${rootPath}/css/base.css">
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
									<h1>신규 프로젝트</h1>
									<div id="comment_form">
									<form action="add.do?email=${myInfo.email}" method="post">
										프로젝트명<br><input type="text" name="title"><br> 내용<br>
										<textarea name="content" rows="4" cols="50"></textarea>
										<br> 시작일<br><input type="date" name="startDate"
											placeholder="예)2013-4-5"><br> 종료일<br><input
											type="date" name="endDate" placeholder="예)2013-6-5"><br>
										태그<br><input type="text" name="tag"
											placeholder="예)태그1 태그2 태그3 (공백으로 구분)"><br> <input
											type="submit" value="등록"><input type="reset"
											value="취소"><br>
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










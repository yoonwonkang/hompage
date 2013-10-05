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
									<h1>프로젝트 수정</h1>
									<div id="comment_form">
									<form action="update.do" method="post">
										프로젝트번호<br> <input type="text" name="no" value="${project.no}" readonly><br> 프로젝트명<br> <input type="text"
											name="title" value="${project.title}" required><br>
										내용<br>
										<textarea name="content" rows="4" cols="50" required>${project.content}</textarea>
										<br> 시작일<br> <input type="date" name="startDate"
											value="${project.startDate}" required><br> 종료일<br>
										<input type="date" name="endDate" value="${project.endDate}"
											required><br> 태그<br> <input type="text" name="tag"
											value="${project.tag}"><br> <input type="submit"
											value="등록"><input type="reset" value="취소"><br>
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












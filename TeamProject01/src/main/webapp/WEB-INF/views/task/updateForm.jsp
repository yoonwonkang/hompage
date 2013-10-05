<%@page import="net.bitacademy.java41.vo.Project"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>작업 수정</title>
<link rel="stylesheet" href="${rootPath}/css/base.css">
<link href="http://fonts.googleapis.com/css?family=Arvo" rel="stylesheet" type="text/css" />
<link href="http://fonts.googleapis.com/css?family=Lobster&subset=latin" rel="stylesheet" type="text/css">
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
									<h1>작업수정</h1>
									<div id="comment_form">
									<form action="update.do" method="post"
										enctype="multipart/form-data">
										작업 번호<br><input type="text" name="taskNo" value="${task.taskNo}"
											readonly><br> 해당프로젝트 번호<br> <input type="text"
											name="projectNo" value="${task.projectNo}" readonly><br>
										작업명<br> <input type="text" name="title" value="${task.title}"
											required><br> 내용<br>
										<textarea name="content" rows="4" cols="50">${task.content}</textarea>
										<br> UI프로토 타입<br> <input type="file" name="URL"
											value="${task.uiProtoUrl}" required> <br> 시작일<br> <input
											type="date" name="startDate" value="${task.startDate}"
											required><br> 종료일<br> <input type="date"
											name="endDate" value="${task.endDate}" required><br>

										<label>상태</label> <select name="status">
											<option value="0"
												<c:if test="${task.status} == 0"> selected</c:if>>생성</option>
											<option value="1"
												<c:if test="${task.status} == 1"> selected</c:if>>작업중</option>
											<option value="2"
												<c:if test="${task.status} == 2"> selected</c:if>>완료</option>
										</select> <br><input type="submit" value="등록"><input type="reset"
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










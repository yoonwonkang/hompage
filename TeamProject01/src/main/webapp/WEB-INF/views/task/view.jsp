<%@page import="net.bitacademy.java41.vo.Project"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>프로젝트 정보</title>
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
										<a href="../main.do">[메인]</a> | <a
											href="../feed/list.do?projectNo=${task.projectNo}">[feed]</a>
									<h1>작업 정보</h1>
									작업번호: ${task.taskNo} <br> 프로젝트번호: ${task.projectNo} <br>
									작업명: ${task.title } <br> ui프로토타입 : <br> <img
										src="${rootPath}/file/${task.uiProtoUrl}"> <br> 내용:
									<br> ${task.content} <br> 시작일: ${task.startDate } <br>
									종료일: ${task.endDate } <br> 상태:
									<c:choose>
										<c:when test="${task.status == 0}">생성</c:when>
										<c:when test="${task.status == 1}">착수중</c:when>
										<c:when test="${task.status == 2}">완료</c:when>
									</c:choose>
									<br> <a href="../task/list.do?projectNo=${task.projectNo}">[목록]</a>
									<c:choose>
										<c:when test="${ isMyProject == true }">
											<a href="update.do?projectNo=${task.projectNo}&taskNo=${task.taskNo}">[변경]</a>
											<a href="delete.do?taskNo=${task.taskNo}&projectNo=${task.projectNo}">[삭제]</a>
										</c:when>
									</c:choose>
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











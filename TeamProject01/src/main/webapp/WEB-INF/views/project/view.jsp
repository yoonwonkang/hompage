<%@page import="net.bitacademy.java41.vo.Project"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>프로젝트 정보</title>
<link href="http://fonts.googleapis.com/css?family=Arvo"
	rel="stylesheet" type="text/css" />
<link href="style.css" rel="stylesheet" type="text/css" media="screen" />
<link href="http://fonts.googleapis.com/css?family=Arvo" rel="stylesheet" type="text/css" />
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
										<a href="view.do?no=${project.no}">[기본정보]</a>
										<c:choose>
											<c:when test="${ isMyProject == true }">
		 | <a href="../task/list.do?projectNo=${project.no}">[작업들]</a> |
			<a href="../feed/list.do?projectNo=${project.no}">[feed]</a>
											</c:when>
											<c:when test="${ myInfo.memLevel == 1 }">
		 | <a href="../task/list.do?projectNo=${project.no}">[작업들]</a> |
		<a href="../feed/list.do?projectNo=${project.no}">[feed]</a>
											</c:when>
										</c:choose>
									<h1>프로젝트 정보</h1>
									번호: ${project.no}<br> 프로젝트명: ${project.title}<br> 내용:<br>
									${project.content }<br> 시작일: ${project.startDate }<br>
									종료일: ${project.endDate }<br> 태그: ${project.tag }<br>
									<br>
									<table class="order-table">
										<tr>
											<th>이메일</th>
											<th>이름</th>
											<th>상태</th>
										</tr>
										<c:forEach var="projectMember" items="${projectMember}">
											<tr>
												<td>${projectMember.email}</td>
												<td>${projectMember.name}</td>
												<td><c:if test="${projectMember.level == 0}">(PL)</c:if></td>
											</tr>
										</c:forEach>
									</table>

									<a href="list.do">[목록]</a>
									<c:choose>
										<c:when test="${projectLeader == 0}">
											<a href="update.do?no=${project.no}">[변경]</a>
											<a href="delete.do?no=${project.no}">[삭제]</a>
										</c:when>
										<c:when test="${myInfo.memLevel == 1}">
											<a href="update.do?no=${project.no}">[변경]</a>
											<a href="delete.do?no=${project.no}">[삭제]</a>
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







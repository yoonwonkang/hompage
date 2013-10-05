<%@page import="net.bitacademy.java41.vo.Project"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Refresh"
	content="2;url=updateForm.do?email=${memberInfo.email}">
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
										<c:choose>
											<c:when test="${status == 'PASSWORD_EQUALS_ERROR'}">입력하신 암호가 일치하지 않습니다.</c:when>
											<c:when test="${status == 'PASSWORD_CONFIG_ERROR'}">입력하신 암호가 확인 암호와 일치하지 않습니다.</c:when>
											<c:when test="${status == 'FAIL'}">변경 중 오류가 발생하였습니다</c:when>
										</c:choose>
										<br>
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










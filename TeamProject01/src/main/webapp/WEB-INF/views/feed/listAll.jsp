<%@page import="net.bitacademy.java41.vo.Project"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>SPMS</title>
<link rel="stylesheet" href="${rootPath}/css/base.css">
<link rel="stylesheet" href="${rootPath}/css/feed.css">
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
									<c:forEach var="feed" items="${feedAllList}">
										<section class="comments">
											<article class="comment">
												<!-- 수정시작 -->
												<c:set var="doneLoop" value="false"/> 
												<c:forEach var="photo" items="${photoList}">
													<c:choose>
														<c:when test="${feed.email == photo.email && not doneLoop}">
															<a class="comment-img" href="#non"> 
																<img src="${rootPath}/file/${photo.fileName}" width="40" height="40">
																<c:set var="doneLoop" value="true"/> 
															</a>
														</c:when>
													</c:choose>
												</c:forEach>
												<c:choose>
													<c:when test="${doneLoop == false}">
														<a class="comment-img" href="#non"> 
															<img src="${rootPath}/images/test01.png" width="40" height="40">
														</a>
													</c:when>
												</c:choose>
												<!-- 수정끝 -->
												<div class="comment-body">
													<div class="text">
														<feed_p>${feed.content}</feed_p>
													</div>
													<p class="attribution">
														by <a href="#non">${feed.email}</a> at ${feed.regDate}
														<c:choose>
															<c:when test="${myInfo.email == feed.email}">
																<td><a href="delete.do?fno=${feed.feedNo}"><img
																		src="https://cdn1.iconfinder.com/data/icons/oxygen/22x22/actions/edit-trash.png"></a></td>
															</c:when>
														</c:choose>
													</p>
												</div>

											</article>
									</c:forEach>
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










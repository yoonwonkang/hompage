<%@page import="net.bitacademy.java41.service.ProjectService"%>
<%@page import="net.bitacademy.java41.vo.MemberProject"%>
<%@page import="net.bitacademy.java41.vo.Member"%>
<%@page import="org.springframework.web.context.WebApplicationContext"%>
<%@page
	import="org.springframework.web.context.support.WebApplicationContextUtils"%>


<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div id="sidebar">
	<ul>
		<li>
			<h2>Member Info</h2>
			<p>
				<c:choose>
					<c:when test="${myInfo.photos != null}">
						<img id="memberPhoto" src="${rootPath}/file/${myInfo.photos[0]}">
					</c:when>
					<c:otherwise>
						<img id="memberPhoto" src="${rootPath}/images/test01.png">
					</c:otherwise>
				</c:choose>
				<br> <a href="${rootPath}/member/updateMyInfo.do">${myInfo.name}</a><br>
				${myInfo.tel}<br> ${myInfo.email}<br>
			</p>
		</li>
		<li><c:choose>
				<c:when test="${myInfo.memLevel == 0}">
					<h2>내 프로젝트</h2>
					<ul>
						<c:choose>
							<c:when test="${listSize==0}">
								<a href="${rootPath}/project/add.do">[신규 프로젝트]</a>
							</c:when>
							<c:otherwise>
								<c:forEach var="project" items="${myprojects}">
									<li><a href="${rootPath}/project/view.do?no=${project.no}">${project.title}<c:if
												test="${project.level == 0}">(PL)</c:if></a></li>
								</c:forEach>
							</c:otherwise>
						</c:choose>
					</ul>
				</c:when>
				<c:when test="${myInfo.memLevel == 1}">
					<h2>관리</h2>
					<ul>
						<li><a href="${rootPath}/member/list.do">멤버관리</a></li>
						<li><a href="${rootPath}/project/list.do">프로젝트관리</a></li>
					</ul>
				</c:when>
			</c:choose></li>
	</ul>
	<div id="search">
		<h2>Search</h2>
		<form method="get" action="">
			<fieldset>
				<input type="text" name="s" id="search-text" size="15"
					value="enter keywords here..." /> <input type="submit"
					id="search-submit" value="GO" />
			</fieldset>
		</form>
	</div>
</div>







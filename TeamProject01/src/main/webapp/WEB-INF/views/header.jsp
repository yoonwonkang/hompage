<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div id="header">	
	<div id="logo">
		<h1>
			<a href="${rootPath}/main.do">SPMS</a> 
		</h1>
		<p>
			design by <a href="#">Tak! Tak! Tak!</a>
		</p>
	</div>
</div>
<!-- end #header -->
<div id="menu">
	<ul>
		<li><a href="${rootPath}/feed/listAll.do">Feed</a></li>
		<li><a href="${rootPath}/project/list.do">Projects</a></li>
		<c:choose>
		<c:when test="${myInfo.memLevel == 1}">
			<li><a href="${rootPath}/member/list.do">Member</a></li>
		</c:when>
		<c:otherwise>
			<li><a href="#">Member</a></li>
		</c:otherwise>
		</c:choose>
		<li><a href="${rootPath}/task/listAll.do">Task</a></li>
		<li><a href="#">Contact</a></li>
		<li > <a href="<%=application.getContextPath()%>/auth/logout.do">log out</a>
	</ul>
</div>
</div>


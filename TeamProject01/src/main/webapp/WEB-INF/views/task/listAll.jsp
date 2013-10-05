<%@page import="net.bitacademy.java41.vo.Project"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>작업 목록</title>
<link rel="stylesheet" href="${rootPath}/css/base.css">
<link href="http://fonts.googleapis.com/css?family=Arvo" rel="stylesheet" type="text/css" />
<link href="http://fonts.googleapis.com/css?family=Lobster&subset=latin" rel="stylesheet" type="text/css">
<link rel="shortcut icon" href="https://cdn3.iconfinder.com/data/icons/faticons/32/send-01-24.png">
<script type="text/javascript">
(function(document) {
	'use strict';

	var LightTableFilter = (function(Arr) {

		var _input;

		function _onInputEvent(e) {
			_input = e.target;
			var tables = document.getElementsByClassName(_input.getAttribute('data-table'));
			Arr.forEach.call(tables, function(table) {
				Arr.forEach.call(table.tBodies, function(tbody) {
					Arr.forEach.call(tbody.rows, _filter);
				});
			});
		}

		function _filter(row) {
			var text = row.textContent.toLowerCase(), val = _input.value.toLowerCase();
			row.style.display = text.indexOf(val) === -1 ? 'none' : 'table-row';
		}

		return {
			init: function() {
				var inputs = document.getElementsByClassName('light-table-filter');
				Arr.forEach.call(inputs, function(input) {
					input.oninput = _onInputEvent;
				});
			}
		};
	})(Array.prototype);

	document.addEventListener('readystatechange', function() {
		if (document.readyState === 'complete') {
			LightTableFilter.init();
		}
	});

})(document);
</script>
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
									<section class="filterContainer">
									<p>
									<h1>To do List</h1>
									<input type="search" class="light-table-filter" data-table="order-table" placeholder="Filtrer"/>
									<table class="order-table">
										<thread>
											<tr>
											<th>작업번호</th>
											<th>작업명</th>
											<th>UI프로토타입URL주소</th>
											<th>상태</th>
											</tr>	
										</thread>
										<tbody>
										<%	int i = 0;	%>
										<c:forEach var="task" items="${taskAllList}">
										<% i++;%>
											<tr>
												<td><%=i%></td>
												<td><a href="view.do?no=${task.taskNo}">${task.title}</a></td>
												<td>${task.uiProtoUrl}</td>
												<td><c:choose>
														<c:when test="${task.status == 0}">미시작</c:when>
														<c:when test="${task.status == 1}">착수중</c:when>
														<c:when test="${task.status == 2}">완료</c:when>
													</c:choose></td>
											</tr>
										</c:forEach>
										</tbody>
									</table>
									</p>
									</section>
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











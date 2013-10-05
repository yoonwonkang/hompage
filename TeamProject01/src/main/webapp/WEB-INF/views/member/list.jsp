<%@page import="net.bitacademy.java41.vo.Member"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>멤버 목록</title>
<link href="http://fonts.googleapis.com/css?family=Arvo"
	rel="stylesheet" type="text/css" />
<link href="style.css" rel="stylesheet" type="text/css" media="screen" />
<link rel="stylesheet"
	href="<%=application.getContextPath()%>/css/base.css">
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
									<h1>Member List</h1>
									<input type="search" class="light-table-filter" data-table="order-table" placeholder="Filtrer" />
									<table class="order-table">
										<tr>
											<th>이메일</th>
											<th>이름</th>
											<th>전화</th>
											<th>블로그</th>
										</tr>
										<c:forEach var="member" items="${list}">
											<tr>
												<td>${member.email}</td>
												<td><a href="view.do?email=${member.email}">${member.name}</a></td>
												<%-- <td><a href="../member/view.do?email=${member.email}">${member.name}</a></td> --%>
												<td>${member.tel}</td>
												<td>${member.blog}</td>
											</tr>
										</c:forEach>
									</table>
									<a href="${rootPath}/member/add.do">[새멤버]</a>
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






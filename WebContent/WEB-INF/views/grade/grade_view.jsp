<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<table>
		<tr>
			<th>직급 번호</th>
			<th>번호별 직급</th>
			<th>직급별 설명</th>
		</tr>
		<c:forEach items="${ViewGrade }" var="grade">
			<tr>
				<td>${grade.grd_no }</td>
				<td>${grade.grd_name }</td>
				<td>${grade.grd_desc }</td>
			</tr>
		</c:forEach>


	</table>

</body>
</html>
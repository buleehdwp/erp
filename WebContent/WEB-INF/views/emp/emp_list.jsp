<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action ="/views/emp/emp_insert" method = "post">
<button>사원정보 추가</button><br>
사원정보를 수정하려면 사원번호를 클릭하세요
	<table border="1">
		<tr>
			<td>사번</td>
			<td>이름</td>
			<td>월급</td>
			<td>상태</td>
			<td>직급</td>
			<td>입사날짜</td>
			
			
		</tr>
		<c:forEach items="${eList }" var="eList">
			<tr>
				<td><a href="/emp/emp_view?emp_no=${eList.emp_no}">${eList.emp_no }</a></td>
				<td>${eList.emp_name }</td>
				<td>${eList.emp_salary }</td>
				<td>${eList.emp_actvie }</td>
				<td>${eList.grd_no }</td>
				<td>${eList.emp_credat }</td>
				
			</tr>
		</c:forEach>
	</table>
</form>
</body>
</html>
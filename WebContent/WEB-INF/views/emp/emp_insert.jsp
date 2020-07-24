<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action ="/emp/emp_insert" method="post">
사원 이름<input type="text" name="emp_name" value="${eList.emp_name }"><br>
직급 번호<input type="text" name="grd_no" value="${eList.grd_no }"><br>
사원 급여<input type="text" name="emp_salary" value="${eList.emp_salary }"><br>
재직 상태<input type="text" name="emp_actvie" value="${eList.emp_actvie }"><br>
<button>사원 정보 추가</button>
</form>
</body>
</html>
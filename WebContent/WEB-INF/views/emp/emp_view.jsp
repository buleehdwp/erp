<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="/emp/emp_update" method="post" id="frm">
사원 번호: ${eMap.emp_no }<br>
사원 이름<input type = "text" name ="emp_name" value = "${eMap.emp_name }" ><br>
직급 번호<input type = "text" name ="grd_no" value = "${eMap.grd_no }" ><br>
입사 날짜: ${eMap.emp_credat }<br>
사원 급여<input type = "text" name ="emp_salary" value="${eMap.emp_salary }"><br>
재직 상태<input type = "text" name ="emp_actvie" value="${eMap.emp_actvie }"><br>
<button>수정</button><button type="button" onclick="doDelete()">삭제</button>
</form>
<script>
function doDelete(){
	var formObj = document.querySelector("#frm");
	formObj.action="/emp/emp_delete";
	formObj.submit();
}
</script>
</body>
</html>
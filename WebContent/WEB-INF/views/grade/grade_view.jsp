<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form method="post" action="/grade/grade_update" id = "frm">
	<input type="hidden" name ="grd_no" value = "${gradeView.grd_no }">
		<table border="1">
			<tr>
				<th>직급번호</th>
				<th>${gradeView.grd_no }</th>
			</tr>
			<tr>
				<td>직급</td>
				<th><input type="text" name="grd_name"
					value="${gradeView.grd_name}"></th>
			</tr>
			<tr>
				<td>직급설명</td>
				<th><input type="text" name="grd_desc"
					value="${gradeView.grd_desc}"></th>
			</tr>
			<tr>
				<th colspan="2"><button>수정</button><button type ="button" onclick ="doDelete()">삭제</button></th>
			</tr>
		</table>
	</form>
	<script>
	function doDelete(){
		var formObj = document.querySelector("#frm");
		formObj.action ="/grade/grade_delete";
		formObj.submit();
	}
	</script>
</body>
</html>
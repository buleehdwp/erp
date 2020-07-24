<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form method="post" action="/grade/insert" id="other">
		<table>
			<tr>
				<td>직급번호</td>
				<th><input type="text" name="grd_no"
					value="${gradeView.grd_no}"></th>
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
				<th colspan="2"><button>직급 추가</button>
					<button type="button" onclick="doUpdate">직급 수정</button>
					<button type="button" onclick="doDelete">직급 삭제</button></th>
			</tr>
		</table>
	</form>
	<script>
	function doUpdate(){
		var UpObj = document.querySelector("#frm");
		UpObj.action = "/grade/update";
		UpObj.submit();
	}
	function doDelete(){
		var DeObj = document.querySelector("#frm");
		DeObj.action = "/grade/delete";
		DeObj.submit();
	}
	</script>
</body>
</html>
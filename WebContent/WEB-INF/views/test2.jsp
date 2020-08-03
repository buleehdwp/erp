<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	시도:
	<select id="sido" onchange="changeSido(this)">
		<option value="">선택</option>
		<c:forEach items="${SJList }" var="sido">
			<option value="${sido}"
				<c:if test="${sido==param.sido}">
		selected
		</c:if>>${sido}</option>
		</c:forEach>
	</select><br> 
	
	구군:
	<select id="sigungu" onchange="changeSigungu(this)">
		<option value="">선택</option>
		<c:forEach items="${GJList }" var="sigungu">
			<option value="${sigungu}"
				<c:if test="${sigungu==param.sigungu}">
		selected
		</c:if>>${sigungu}</option>
		</c:forEach>
	</select><br> 
	
	읍면동:
	<select>
		<option value="">선택</option>
		<c:forEach items="${DJList }" var="dong">
			<option value="${dong}">${dong}</option>
		</c:forEach>
	</select>
	<script>
	function changeSido(obj){
		location.href="/test2?sido="+obj.value;
	}
	function changeSigungu(obj) {
		var sidoObj = document.querySelector("#sido");
		location.href = "/test2?sido=" + sidoObj.value + "&sigungu="
				+ obj.value;
	}
	
	</script>
</body>
</html>
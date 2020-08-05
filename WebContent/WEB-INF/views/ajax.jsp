<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<script>
		function getAjax() {
			var xhr = new XMLHttpRequest();
			alert(xhr.readyState);//이 순간 xhr이 0이됨 --휴대폰 전원킴
			xhr.open('GET', '/ajax');// --휴대폰 번호 누름
			alert(xhr.readyState);
			xhr.onreadystatechange = function() { // --전화 걸어서 무슨말할지 생각중
				if (xhr.readyState == 4) {
					var obj = JSON.parse(xhr.responseText);
					alert(obj.sido)
				}

			}
			xhr.send(); // --전화검
		}
	</script>
	<button onclick="getAjax()">clickME</button>
</body>
</html>
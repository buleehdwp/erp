<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="/javascript/jquery-3.5.1.js">
	
</script>
<style>
td {
	text-align: center;
	cursor: pointer;
	width: 40px;
	height: 40px;
}

td:hover {
	background-color: black;
	color: white;
	font-weight: bold;
}
</style>
</head>
<body>
	<input type='number' id='maxnum'>
	<button>시작</button>
	<div id="rDiv"></div>
	<script>
		$('button').click(function() {
			var maxNum = $('#maxnum').val();
			var html = '<table border = "1">';
			for (i = 1; i <= (maxNum * maxNum); i++) {
				if (i % maxNum == 1) {
					html += "<tr>";
				}
				html += "<td>" + i + "</td>";
				if (i % maxNum == 0) {
					html += "</tr>";
				}
			}
			html += '</table>';
			$('#rDiv').html(html);//이벤트는 이벤트가 발생할 무언가가 생긴 이후에 만들어 줘야한다.
			alert('게임시작');
			var td = $('td');
			var bomb = Math.floor(Math.random() * (maxNum * maxNum) + 1);
			for (i = 0; i < td.length; i++) {
				td[i].onclick = function(){
					if(this.innerText == bomb){
						alert("지옥으로가~");
					}else{
						this.innerText = "x";
					}
				}
			}

		});
	</script>
</body>
</html>
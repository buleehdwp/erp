<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <c:set var = "str" value ="123" scope = "request" !>
    </c:set>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
request.setAttribute("str","123"); 
request.setAttribute("str1","test");
%>
<br>
<c:if test="${str eq '123' && str1 eq 'test' }">
str은 변수는 아니고 attribute의 키인데 무튼 123맞음
str1은 변수는 아니고 attribute의 키인데 무튼 test맞음
</c:if>
<br>

<c:if test="${str eq '123'}">
str은 변수는 아니고 attribute의키인데 무튼 123 맞음
</c:if>
<br>

<c:if test="${str ne '123'}">
str은 변수는 아니고 attribute의키인데 무튼 123 아님
</c:if>
<br>

<c:choose>
<c:when test="${str=='123' }">
str은 123입니다
</c:when>

<c:when test ="${str1=='test' }">
str1은 test입니다
</c:when>

<c:otherwise>
str은 123이 아니고 str1도 test가 아닙니다
</c:otherwise>
</c:choose>
<!-- 위의 코드는 java에서의 if~else if~else이다  -->

</body>
</html>

세션
리퀘스트 스코프

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
/* //-------------------------------------------------------------------------//

//jsp는 선언 할 수 있는 데이터 타입은 없지만 내부적으로는 가지고 있음
//jsp는 데이터 타입이 선언시마다 바뀌기 때문에 동적언어임
//on이벤트 뒤에 오는 함수들은 전부 소문자로 통일함

var a; //var는 데이터 타입이 아님 이상태의 a는 undifinded타입임
a = null; //이제 a는 null이라는 타입임
a = 1.1; // jsp는 실수, 정수를 number type으로 저장함
a = 'str'; //jsp는 char타입이 없어서 문자를 "" 혹은 ''으로 표시해도 상관없음(문자는 모두 String)
a = true; // boolean
a = function(){
	console.log('난이제 함수') //이제 a는 function데이터 타입
};
a = new Number(1);//크게 통틀어서 object타입이 있음

//--------------------------------------------------------------------------//

//alert('1'==1)이 java는 false지만 jsp는 true결과를 출력함 이유는 jsp에서 ==는 데이터 타입 상관없이 값만 비교함
alert('1'=='2');
//따라서 ===라는 데이터 타입까지 비교해주는 연산자를 제공함 아래 예제를 보면
var n1 = '1';
var n2 = 1;
if(n1===n2){
	alert(n1+n2);
}
//이 코드는 ===를 사용해서 데이터값까지 비교했기 때문에 false가 됨

//--------------------------------------------------------------------------//
var test = function(){
	alert('test');
}
test = 1;
test();
//실행안됨 test펑션 만들어놓고 거기에 1을넣어서 다시 test가 number로 바뀜 그래서 test()펑션 호출이 안됨

//jsp에서의 this는 this가 쓰여진 곳 그 자체를 의미함
//script의 this는 windows를 의미함 */
//--------------------------------------------------------------------------//

//--------------------------------------------------------------------------//
/* var map = new Map();
map.set("sido","서울");
alert(map.get("sido"));
//jsp에도 map이 있음
 
var map2 = {
		sido : '경기',
		sigungu : '남양주',
		dong : '마석'
}
alert(map2.sido + map2.sigungu + map2.dong); */
//이런식으로 여러개의 key, value를 한번에 입력할 수 있음

/* var arr = ["1","2","3"];
alery(arr);*/

/* var person= '{"name":"윤동제","age":"25","address":"경기도 남양주시 마석","hobby":"숙면"}';//String을 map처럼 출력하기
person = JSON.parse(person);
alert(person.name + ',' + person.age + ',' + person.address + ',' + person.hobby); */
//--------------------------------------------------------------------------//

/* var map = {
		sido : 1,
		gugun : 'gu'
};
map.dong = '동';
console.log(map);
map['dong'] = '등촌동';
console.log(map); */


</script>
</body>
</html>
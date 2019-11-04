<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>TEST JSP - Nexacro</title>

</head>
<body>
<header>
  <a href="main.net">main</a>
</header>
ie의 경우 익스플로러의 “도구” -> “인터넷 옵션” 대화창에서 “보안” -> “인터넷 영역” 클릭,<br>
포함된 설정의 “스크립틀릿 허용” 옵션을 “사용”으로 선택하여야 표기 된다.
<%--object 엘리먼트는 포함될 객체를 정의한다.
    type 속성 : 삽입할 객체의 MIME type(파일 종류)
    width 속성 : 객체의 너비
     height 속성 : 객체의 높이
--%>
<object id="testNxcr" width="1200" height="700" type="text/x-scriptlet"> 
<param name="url" value="resources/index.html">  <!-- Nxcr 페이지 -->
<param name="selectablecontent" value="0"> <!-- 내용을 선택할 수 있는지 여부.  1은 범위 선택 가능, 0은 선택 불가. -->
<param name=scrollbar value="1"><!-- 스크롤바 생성 여부. 1은 생성, 0은 생성 안함. -->
</object>
</body>
</html>

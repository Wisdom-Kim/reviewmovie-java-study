<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인</title>
<link rel="stylesheet" href="/static/css/layout.css" />
</head>
<body>
<%@ include file="/views/layout/header.jsp" %>

<div id="container">
	<h1>로그인</h1>
	<form action="/login.do" method="POST" id="loginForm" onsubmit="checkData()">
		<table>
		    <tr>
		    	<td width="200" align="center">
		        	<b>아이디</b>
		        </td>
		        <td height="20" align="center">
		        	<input type="text" name="accountId" size="30" placeholder="아이디">
		        </td>
		    </tr>
		    <tr>
		    	<td width="200" align="center">
		        	<b>비밀번호</b>
		        </td>
		        <td width="450" align="center">
		        	<input type="password" name="passwd" size="30" placeholder="비밀번호">
		        </td>
		    </tr>
		    <tr>
		        <td colspan="2" align="center">
		        	<input type="submit" value="로그인">
				</td>
		    </tr>
		</table>
	</form>
</div>

<%@ include file="/views/layout/footer.jsp" %>

<script type="text/javascript">
	// 회원 정보 입력 값 검증
	function checkData() {
		let insertForm = document.getElementById("insertForm");
		
		if(insertForm.accountId.value == "") {
			
		}
	}	
</script>
</body>
</html>
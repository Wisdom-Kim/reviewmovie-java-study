<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입</title>
</head>
<body>
<%-- <%@ include file="../layout/header.jsp" %> --%>

<div id="container">
	<form action="/insertUser.do" method="POST" id="insertForm" onsubmit="checkData()">
		<table align="center" cellpadding="5" cellspacing="1" width="600" border="1">
		    <tr>
		        <td width="1220" height="20" colspan="2" bgcolor="#336699">
		            <p align="center">
		            	<font color="white" size="3">
		            		<b>회원가입</b>
		            	</font>
		            </p>
		        </td>
		    </tr>
		    <tr>
		        <td width="150" height="20">
		            <p align="center"><b><span style="font-size:12pt;">ID</span></b></p>
		        </td>
		        <td width="450" height="20" align="center">
		        	<b>
		        		<span style="font-size:12pt;">
		        			<input type="text" name="accountId" size="30">
		        		</span>
		        	</b>
		        </td>
		    </tr>
		    <tr>
		        <td width="150" height="20">
		            <p align="center"><b><span style="font-size:12pt;">비밀번호</span></b></p>
		        </td>
		        <td width="450" height="20" align="center">
		        	<b>
		        		<span style="font-size:12pt;">
		        			<input type="password" name="passwd" size="30">
		        		</span>
		        	</b>
		        </td>
		    </tr>
		    <tr>
		        <td width="150" height="20">
		            <p align="center"><b><span style="font-size:12pt;">이름</span></b></p>
		        </td>
		        <td width="450" height="20" align="center">
		        	<b>
		        		<span style="font-size:12pt;">
		        			<input type="text" name="username" size="30">
		        		</span>
		        	</b>
		        </td>
		    </tr>
		    <tr>
		        <td width="150" height="20">
		            <p align="center"><b><span style="font-size:12pt;">생년월일</span></b></p>
		        </td>
		        <td width="450" height="20" align="center">
		        	<b>
		        		<span style="font-size:12pt;">
		        			<input type="date" id="birthday" name="birthday" size="30" max="2024-12-31" value="0000-00-00">
		        		</span>
		        	</b>
		        </td>
		    </tr>
		    <tr>
		        <td width="150" height="20">
		            <p><b><span style="font-size:12pt;">&nbsp;</span></b></p>
		        </td>
		        <td width="450" height="20" align="center">
		        	<b>
		        		<span style="font-size:12pt;">
							<input type="submit" value="가입">
						</span>
					</b>
				</td>
		    </tr>
		</table>
	</form>
</div>

<%-- <%@ include file="../layout/footer.jsp" %> --%>

<script type="text/javascript">
	// 생년월일 오늘 날짜 이후로 지정 못하게 설정
	window.onload = function() {
		today = new Date();
		today = today.toISOString().slice(0, 10);
		birthday = document.getElementById("birthday");
		birthday.max = today;
	}
	
	// 회원 정보 입력 값 검증
	function checkData() {
		let insertForm = document.getElementById("insertForm");
		
		if(insertForm.accountId.value == "") {
			
		}
	}	
</script>
</body>
</html>
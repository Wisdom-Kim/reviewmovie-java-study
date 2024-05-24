<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인</title>
<style type="text/css">
<<<<<<< Updated upstream
	body {
		display: grid;
		justify-items: center;
	}
	
	table {
		align: "center";
		cellpadding: "5"; 
		cellspacing: "1"; 
		width: "1500px";
		border: none;
	}
	
	td {
		height: "20px";
	}
=======
header {
  padding: 10px;
  display: flex;
  justify-content: flex-end;
  align-items: center;
  height: 100px;
}

header div {
  display: flex;
  align-items: center;
}

header span {
  margin-right: 10px;
}

body {
  margin: 0;
}

#container {
  width: 400px;
  margin: 50px auto;
  background-color: #fff;
  padding: 40px;
  border-radius: 20px;
  box-shadow: 0 0 30px rgba(0, 0, 0, 0.1);
  text-align: center;
}

table {
  width: 100%;
  border-collapse: collapse;
}

td {
  padding: 20px 15px;
  background-color: transparent;
  color: #535C91;
  border-bottom: 1px solid #e5e5e5;
}

td:first-child {
  background-color: transparent;
  color: #1B1A55;
  font-weight: bold;
  border-bottom: none;
}

input[type="text"],
input[type="password"],
input[type="date"] {
  width: 100%;
  padding: 15px;
  border: none;
  border-radius: 8px;
  background-color: #f5f5f5;
  color: #535C91;
  font-weight: bold;
  transition: background-color 0.3s ease;
}

input[type="text"]:focus,
input[type="password"]:focus,
input[type="date"]:focus {
  background-color: #e5e5e5;
  outline: none;
}

input[type="submit"],
input[type="button"] {
  background-color: #1B1A55;
  color: #fff;
  padding: 15px 30px;
  border: none;
  border-radius: 8px;
  cursor: pointer;
  font-weight: bold;
  transition: background-color 0.3s ease;
}

input[type="submit"]:hover,
input[type="button"]:hover {
  background-color: #535C91;
}

footer {
  background-color: #9290C3;
  color: white;
  text-align: center;
  height: 100px;
  padding: 10px;
  margin: 0;
}
>>>>>>> Stashed changes
</style>
</head>
<body>
<%-- <%@ include file="../layout/header.jsp" %> --%>

<div id="container">
	<h1>로그인</h1>
	<form action="/login.do" method="POST" id="loginForm" onsubmit="checkData()">
		<table>
		    <tr>
<<<<<<< Updated upstream
		        <td height="50" colspan="2" bgcolor="#336699" align="center">
			    	<b><font color="white">로그인</font></b>
		        </td>
		    </tr>
		    <tr>
=======
>>>>>>> Stashed changes
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

<%-- <%@ include file="../layout/footer.jsp" %> --%>

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
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Staff Join</title>
<link rel="stylesheet" href="http://localhost:9000/hotel/resources/css/login.css">
<script src="http://localhost:9000/hotel/resources/js/jquery-3.6.0.min.js"></script>
<script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
<!-- <script src="http://localhost:9000/hotel/resources/js/myhotel_jquery.js"></script> -->
<style>
.content {
	margin: auto;
    margin-top: 100px;
    margin-bottom: 100px;
    width: 1200PX;
    display: flex;
    position: relative;
    flex-wrap: wrap;
    justify-content: center;
}

.join-container-inner {
	width: 1200px;
}

.join-container {
	width: 120%;
}

.join-input-select h2{
    color: rgb(156,131,106);
    font-size: 13px;
    font-weight: 500;
    /* text-align: left; */
}

.joinul{
    display: flex;
    justify-content: space-between;
}

.join-input-select select {
    width: 150px;
    padding: 10px 10px;
    font-size: 17px;
    border: 1px solid rgb(230,227,223);
    appearance: none;
}
.join-intro-container {
    justify-content: space-around;
}
.join-input-ename{
    width: 394px;
    display: grid;
    font-size: 17px;
    padding: 10px 10px;
    border: 1px solid rgb(230,227,223);
    margin-right: 156px;
}
.join-input-gender{
    margin-bottom: 20px;
}
.join-input-name{
    margin-bottom: 5px;
}
.join-input-birthday{
    width: 80px;
    font-size: 17px;
    padding: 10px 10px;
    border: 1px solid rgb(230,227,223);
    text-align: center;
}
.birthinput{
    display: flex;
    margin-right: 57px;
    align-items: center;
}
.join-input-box span{
	font-size: 13px;
    color: rgb(116,116,116);
    display: block;
}
.join-input-list{
	margin-bottom: 10px;
}
#btnUpdate {
	position: relative;
    float: right;
}

</style>

<script>
$(document).ready(function(){
		
	//주소 버튼 클릭
	/* $("#btnBack").click(function(){
		location.href("http://localhost:9000/hotel/admin_staff_list.do"); 
	}); */
	
	$("#btnUpdate").click(()=>{
		//서버전송
		AdminStaffUpdateForm.submit();
	});
	
	//변경 막게하기
	//$('#accountlevel').attr('disabled', 'true');
	
});
</script>
</head>
<body>
	<!-- Header Include -->
	<%@ include file="../header.jsp" %>

<form name="AdminStaffUpdateForm"  action="admin_staff_update.do"  method="post">
	<input type="hidden" name="sid"  value="${vo.sid}" >
    <main>
        <article class="content">
            <div class="joinintro">
                <h1>회원가입</h1>
                <p>신라리워즈 멤버쉽 회원만을 위한</p>
                <p>다양한 혜택과 서비스를 누려보세요.</p> 
            </div>   
            <div class="join-container">
                <div class="join-container-inner">
                    <div class="join-acount-container">
                    	<div><button type="button" class="join-input join-addrbtn" id="btnUpdate">변경</button></div>
                        <div class="join-intro-container">
                            <p class="join-input-list">아이디 및 비밀번호</p>
                            <p class="join-input-notice">*필수 입력항목</p>            
                        </div>
                        <ul class="joinul">
                            <li class="join-input-box" id="ipcheck">
                                <h2>아이디*</h2>
                                <input name="sid" id="sid" class="join-input input-type1 join-input-id" value=${vo.sid } disabled="disabled">                            
                            </li>
                            <li class="join-input-select">
                                <h2>구분*</h2>
	                                <select id="accountlevel" name="accountlevel" >
												<c:choose>
													<c:when test="${vo.accountlevel == 1}">
														<option value="1">일반</option>
													</c:when>
													<c:otherwise>
														<option value="2">관리자</option>
													</c:otherwise>
												</c:choose>
												<option value="1" title="Public">일반</option>
												<option value="2" title="Admin">관리자</option>		
									</select>
                            </li>
                            <li class="join-input-select">
                                <h2>부서명*</h2>
	                                <select id="teamname" name="teamname" >
												<option value="${vo.teamname }">${vo.teamname } </option>
												<option value="Front Office" title="Front Office">Front Office</option>
												<option value="BacK Office" title="BacK Office">BacK Office</option>
												<option value="Engineer" title="Engineer">Engineer</option>
												<option value="HR" title="HR">HR</option>
									</select>
                            </li>
                            <li class="join-input-select">        
                                <h2>직급*</h2>
                                	<select id="position" name="position" >
												<option value="${vo.position }">${vo.position }</option>
												<option value="Staff" title="Staff">Staff</option>
												<option value="Manager" title="Manager">Manager</option>
												<option value="Admin" title="Admin">Admin</option>
												<option value="Master" title="Master">Master</option>
									</select>
                            </li>        
                        </ul>     
                        <ul class="input-pass-container">
                            <li class="join-input-box">
                                <h2>비밀번호*</h2>
                                <input type="password" name="pass" id="pass" class="join-input input-type1 join-input-pass" value=${vo.pass } disabled="disabled">
                            </li>
                            <li class="join-input-box">                 
                                <h2>비밀번호 확인*</h2>         
                                <input type="password" name="hpass" id="hpass" class="join-input  input-type1 join-input-passcheck" value=${vo.pass } disabled="disabled">
                          		<span id="passCheckMsg4"></span>
                            </li>
                        </ul>
                    </div>
                    <div class="join-block"></div>
                    <div class="join-userinfo-container">
                        <div class="join-intro-container">
                            <p class="join-input-list">기본 정보</p>
                            <p class="join-input-notice">*필수 입력항목</p>
                        </div>
                        <div class="join-user-info">
                           <div class="join-userinfo-left">
                                <ul>
                                    <li class="join-input-box">
                                        <h2>이름(한글)*</h2>
                                        <input name="sname" id="sname" class="join-input join-input-name" value="${vo.sname }" disabled="disabled">
                                        
                                       <h2>성별*</h2>
                                        <select name="gender" id="gender" class="join-input join-input-gender" disabled="disabled">                                          
                                            <option value="default">${vo.gender }</option>
                                            <option value="남자" >남자</option>
                                            <option value="여자" >여자</option>
                                        </select>

                                        <h2>생년월일*</h2>
                                        <div class="birthinput box">
                                            <div class="birthinput"><input name="birthyy" id="birthyy" class="join-input-birthday " value="${vo.birthyy }" disabled="disabled"><h2>년</h2></div>
                                            <div class="birthinput"><input name="birthmm" id="birthmm" class="join-input-birthday " value="${vo.birthmm }" disabled="disabled"><h2>월</h2></div>
                                            <div class="birthinput"><input name="birthdd" id="birthdd" class="join-input-birthday " value="${vo.birthdd }" disabled="disabled"><h2>일</h2></div>
                                        </div>
                                    </li>
                                    <li class="join-input-box">
                                        <h2>이메일*</h2>
                                        <input type="text" id="email" name="email" class="join-input input-type1 join-input-email" value="${vo.email }" disabled="disabled">
                                    </li>
                     
                                </ul>
                           </div>
                           <div class="join-userinfo-right">
                                <ul>
                                    <li class="join-input-box">
                                        <h2>이름(영문)*</h2>
                                        <input id= "ename" name="ename" class="join-input-ename" value="${vo.ename }" disabled="disabled" >
                            
                                    </li>
                                    <li class="join-input-box">
                                        <h2>휴대폰 번호*</h2>
                                        <select name="pnum1" id="pnum1" class="join-input input-type4 join-input-firstnum" disabled="disabled">
                                          <option value="default" >${vo.pnum1 }</option>
												<option value="010" >010</option>
												<option value="011">011</option>
												<option value="016">016</option>
												<option value="017">017</option>
										</select>
                            
                                        <input type="text" name="pnum2" id="pnum2" class="join-input input-type4 join-input-phone1" value="${vo.pnum2 }" disabled="disabled" ></input>

                                        <input type="text" name="pnum3" id="pnum3" class="join-input input-type4 join-input-phone2" value="${vo.pnum3 }" disabled="disabled" ></input>
                                    </li>
                                    <li class="join-input-box">
                                        <h2>주소</h2>
                                        <input type="text" name="zonecode" id="zonecode" class="join-input  join-input-zonecode" value="${vo.zonecode }" disabled="disabled">
                                        <button type="button" class="join-input join-addrbtn" id="btnSearchAddr">우편번호 검색</button>
                                        <input type="text" name="addr1" id="addr1" class="join-input input-type1 join-input-addr1" value="${vo.addr1 }" disabled="disabled">
                                        <input type="text" name="addr2" id="addr2" class="join-input input-type1 join-input-addr2" value="${vo.addr2 }" disabled="disabled">
                                    </li>
                                </ul>
                           </div>
                        </div>
                    </div>
                    <div class="join-block"></div>
                    <div class="join-submit-btn-container">
                        <button type="button" class="join-submit-btn" id="btnBack" onclick="location.href='http://localhost:9000/hotel/admin_staff_list.do'">확인</button>
                    </div>
                </div>
            </div>
        </article>

    </main>
</form>

	<!-- Footer Include -->
	<%@ include file="../footer.jsp" %>
	<script>
 	$("[data-nav=service]").css("display","block");
 	$("[data-nav=service]").children().eq(2).children().first().css("color","white");
 	</script> 
</body>
</html>
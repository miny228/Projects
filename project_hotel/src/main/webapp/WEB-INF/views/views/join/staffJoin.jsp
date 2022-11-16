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
        <script>
        $(".join-getid").click(function(){
            let checked  = $("input[id=join-getid]:checked").val();
            if(checked == "on"){
                let id = $("input[name=sid]").val()
                $("input[name=hemail]").val(id);
                $(".join-getid-point").addClass("join-id-checked");
            }else{
                $("input[name=hemail]").val("");
                $(".join-getid-point").removeClass("join-id-checked");
            }
        })
    </script>
    <script>
$(document).ready(function(){
	
	//중복확인 버튼 이벤트 처리  AJAX 
	$("#idCheck").click(function(){
		
		if($("#sid").val() == ""){
			alert("아이디를 입력해주세요");
			$("#sid").focus();
		}else{
		
			$.ajax({
				url:"sid_check.do?sid="+$("#sid").val(),
				success:function(result){  	
					if(result == 1){
						alert("사용중인 아이디입니다. 다시 입력해주세요")
						$("#sid").val("").focus();						
					}else{
						alert("사용 가능한 아이디 입니다.")		
						$("#pass").focus();
						
					}
				}//success
			});//ajax
		}//if 종료
	}); // click 함수
	}); //ready 함수
</script>
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

</style>

<script>
$(document).ready(function(){
$("#btnJoin").click(()=>{		
		if($("#sid").val() == ""){
			alert("아이디를 입력해주세요");
			$("#sid").focus();
			return false;
		}else if($("#pass").val() == ""){
			alert("패스워드를 입력해주세요");
			$("#pass").focus();
			return false;
		}else if($("#hpass").val() == ""){
			alert("패스워드 확인을 입력해주세요");
			$("#hpass").focus();
			return false;
		}else if($("#accountlevel").val() == "default"){
			alert("직원 구분을 선택해주세요.");
			$("#accountlevel").focus();
			return false;	
		}else if($("#teamname").val() == "default"){
			alert("부서명을 선택해주세요.");
			$("#teamname").focus();
			return false;	
		}else if($("#position").val() == "default"){
			alert("직급을 선택해주세요.");
			$("#position").focus();
			return false;
		}else if($("#sname").val() == ""){
			alert("성명을 입력해주세요");
			$("#sname").focus();
			return false;
		}else if($("#ename").val() == ""){
			alert("영문이름을 입력해주세요");
			$("#ename").focus();
			return false;
		}else if($("#gender").val() == "default"){
			alert("성별을 선택해주세요");
			$("#gender").focus();
			return false;
		}else if($("#email").val() == ""){
			alert("이메일을 입력해주세요");
			$("#email").focus();
			return false;
		}else if($("#pnum1").val() == "default"){
			alert("휴대폰번호를 선택해주세요");
			$("#pnum1").focus();
			return false; 
		}else if($("#pnum2").val() == ""){
			alert("휴대폰번호를 입력해주세요");
			$("#pnum2").focus();
			return false;
		}else if($("#pnum3").val() == ""){
			alert("마지막 번호를 입력해주세요");
			$("#pnum3").focus();
			return false;
		}else if($("#addr1").val() == ""){
			alert("주소를 입력해주세요");
			$("#addr1").focus();
			return false;
		}else if($("#addr2").val() == ""){
			alert("상세주소를 입력해주세요");
			$("#addr2").focus();
			return false;			
		}else{
			//서버전송
			sjoinForm.submit();
		}
		
	});
	
	//주소 버튼 클릭
	$("#btnSearchAddr").click(function(){
		new daum.Postcode({
        oncomplete: function(data) {
            // 팝업에서 검색결과 항목을 클릭했을때 실행할 코드를 작성하는 부분입니다.
            // 예제를 참고하여 다양한 활용법을 확인해 보세요.
            //alert(data.address);
            $("#zonecode").val(data.zonecode);
            $("#addr1").val(data.address);
            $("#addr2").focus();
       	}
    	}).open(); 
	});
	
	//비밀번호 확인
	$("#hpass").on("blur",()=>{
		if($("#pass").val() != "" && $("#hpass").val() != ""){
			if($("#pass").val() == $("#hpass").val()){
				$("#passCheckMsg4").text("비밀번호가 동일합니다.");
					
			}else{
				$("#passCheckMsg4").text("비밀번호가 동일하지 않습니다. 다시 입력해주세요.");
					
				$("#hpass").val("");
				$("#pass").val("").focus();
			}
		}//else{} --> 회원가입 폼의 유효성 체크로 진행됨
	});
	
});
</script>
</head>
<body>
	<!-- Header Include -->
	<%@ include file="../header.jsp" %>

<form name="sjoinForm"  action="sjoinCheck.do"  method="post">
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
                        <div class="join-intro-container">
                            <p class="join-input-list">아이디 및 비밀번호</p>
                            <p class="join-input-notice">*필수 입력항목</p>
                        </div>
                        <ul class="joinul">
                            <li class="join-input-box" id="ipcheck">
                                <h2>아이디*</h2>
                                <input name="sid" id="sid" class="join-input input-type1 join-input-id">
                                <button type="button" id="idCheck" class="join-input join-idCheck">중복확인</button>
                                <span id="idCheckMsg"></span>
                                <p class="input-idcheck-msg"></p> 
                            </li>
                            <li class="join-input-select">
                                <h2>구분*</h2>
	                                <select id="accountlevel" name="accountlevel">
												<option value="default">선택</option>
												<option value="1" title="Public">일반</option>
												<option value="2" title="Admin">관리자</option>			
									</select>
                            </li>
                            <li class="join-input-select">
                                <h2>부서명*</h2>
	                                <select id="teamname" name="teamname">
												<option value="default">선택</option>
												<option value="front" title="Front">Front Office</option>
												<option value="back" title="Back">BacK Office</option>
												<option value="engineer" title="Engineer">Engineer</option>
												<option value="hr" title="HR">HR</option>
									</select>
                            </li>
                            <li class="join-input-select">        
                                <h2>직급*</h2>
                                	<select id="position" name="position">
												<option value="default">선택</option>
												<option value="staff" title="Staff">Staff</option>
												<option value="manager" title="Manager">Manager</option>
												<option value="admin" title="Admin">Admin</option>
												<option value="master" title="Master">Master</option>
									</select>
                            </li>        
                        </ul>     
                        <ul class="input-pass-container">
                            <li class="join-input-box">
                                <h2>비밀번호*</h2>
                                <input type="password" name="pass" id="pass" class="join-input input-type1 join-input-pass">
                            </li>
                            <li class="join-input-box">                 
                                <h2>비밀번호 확인*</h2>         
                                <input type="password" name="hpass" id="hpass" class="join-input  input-type1 join-input-passcheck">
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
                                        <input name="sname" id="sname" class="join-input join-input-name">
                                        
                                       <h2>성별*</h2>
                                        <select name="gender" id="gender" class="join-input join-input-gender" >
                                            <option value="default">선택</option>
                                            <option value="m">남자</option>
                                            <option value="w">여자</option>
                                        </select>

                                        <h2>생년월일*</h2>
                                        <div class="birthinput box">
                                            <div class="birthinput"><input name="birthyy" id="birthyy" class="join-input-birthday " ><h2>년</h2></div>
                                            <div class="birthinput"><input name="birthmm" id="birthmm" class="join-input-birthday " ><h2>월</h2></div>
                                            <div class="birthinput"><input name="birthdd" id="birthdd" class="join-input-birthday " ><h2>일</h2></div>
                                        </div>
                                    </li>
                                    <li class="join-input-box">
                                        <h2>이메일*</h2>
                                        <input type="text" id="email" name="email" class="join-input input-type1 join-input-email">
                                    </li>
                     
                                </ul>
                           </div>
                           <div class="join-userinfo-right">
                                <ul>
                                    <li class="join-input-box">
                                        <h2>이름(영문)*</h2>
                                        <input id= "ename" name="ename" class="join-input-ename" placeholder="영어 닉네임">
                            
                                    </li>
                                    <li class="join-input-box">
                                        <h2>휴대폰 번호*</h2>
                                        <select name="pnum1" id="pnum1" class="join-input input-type4 join-input-firstnum">
                                          <option value="default">선택</option>
												<option value="010">010</option>
												<option value="011">011</option>
												<option value="016">016</option>
												<option value="017">017</option>
										</select>
                            
                                        <input type="text" name="pnum2" id="pnum2" class="join-input input-type4 join-input-phone1"></input>

                                        <input type="text" name="pnum3" id="pnum3" class="join-input input-type4 join-input-phone2"></input>
                                    </li>
                                    <li class="join-input-box">
                                        <h2>주소</h2>
                                        <input type="text" name="zonecode" id="zonecode" class="join-input  join-input-zonecode">
                                        <button type="button" class="join-input join-addrbtn" id="btnSearchAddr">우편번호 검색</button>
                                        <input type="text" name="addr1" id="addr1" class="join-input input-type1 join-input-addr1">
                                        <input type="text" name="addr2" id="addr2" class="join-input input-type1 join-input-addr2">
                                    </li>
                                </ul>
                           </div>
                        </div>
                    </div>
                    <div class="join-block"></div>
                    <div class="join-submit-btn-container">
                        <button type="submit" class="join-submit-btn" id="btnJoin">확인</button>
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
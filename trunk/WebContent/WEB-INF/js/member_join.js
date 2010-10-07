// 입력값 체크
function joinCheck(frm){
 
	if(frm.id.value.length < 3 || frm.id.value.length > 12){ alert("The ID is possible only 3~12 places."); frm.id.focus(); return false;
   }else{
      if(!check_Char(frm.id.value)){ alert("The ID will not be able to use a special letter."); frm.id.focus(); return false; }
   }
 
	if(frm.passwd1.value.length < 4 || frm.passwd1.value.length > 12){ alert("The password is 4~12 places"); frm.passwd1.focus(); return false; }
	if(frm.passwd2.value.length < 4 || frm.passwd2.value.length > 12){ alert("The password is 4~12 places"); frm.passwd2.focus(); return false; }
	if(frm.passwd1.value != frm.passwd2.value){alert("One password does not do");frm.passwd1.focus();return false;}
 
   if(frm.name.value == ""){alert("Input the name");frm.name.focus();return false;
   }else{
      if(!check_nonChar(frm.name.value)){alert("To name there is not a possibility the special letter entering");frm.name.focus();return false;}
   }
 
 
 
 
 
 
   if(frm.post1.value == ""){alert("Input the postal code");frm.post1.focus();return false;}
   if(frm.post2.value == ""){alert("Input the postal code");frm.post2.focus();return false;}
   if(frm.post1.value.length != 4 || frm.post2.value.length != 3){alert("The postal code is not proper");frm.post1.focus();return false;}
   if(frm.address1.value == ""){alert("Input the address");frm.address1.focus();return false;}
   if(frm.address2.value == ""){alert("Input the detailed address");frm.address2.focus();return false;}
 
 
 
   if(frm.tphone1.value == ""){alert("Input the directory number");frm.tphone1.focus();return false;
   }else if(!check_Num(frm.tphone1.value)){alert("The area code is possible only number.");frm.tphone1.focus();return false;}
 
   if(frm.tphone2.value == ""){alert("Input the directory number");frm.tphone2.focus();return false;
   }else if(!check_Num(frm.tphone2.value)){alert("The code is possible only number.");frm.tphone2.focus();return false;}
 
   if(frm.tphone3.value == ""){alert("Input the directory number");frm.tphone3.focus();return false;
   }else if(!check_Num(frm.tphone3.value)){alert("The directory number is possible only number");frm.tphone3.focus();return false;}
 
 
 
   if(frm.hphone1.value == ""){alert("Input the mobile number");frm.hphone1.focus();return false;
   }else if(!check_Num(frm.hphone1.value)){alert("The mobile number is possible only number.");frm.hphone1.focus();return false;}
 
   if(frm.hphone2.value == ""){alert("Input the mobile number");frm.hphone2.focus();return false;
   }else if(!check_Num(frm.hphone2.value)){alert("The mobile number is possible only number.");frm.hphone2.focus();return false;}
 
   if(frm.hphone3.value == ""){alert("Input the mobile number");frm.hphone3.focus();return false;
   }else if(!check_Num(frm.hphone3.value)){alert("The mobile number is possible only number");frm.hphone3.focus();return false;}
 
 
 
 
   if(frm.email.value == ""){alert("Input this mail.");frm.email.focus();return false;
   }else if(!check_Email(frm.email.value)){frm.email.focus();return false;}
 
 	if(frm.secure_login != undefined) {
		if(!frm.secure_login.checked){
			frm.action = "/admin/member_eng/join_save.php";
		}
	}
 
}
 
// 아이디 중복확인
function idCheck(){
   var id = document.joinFrm.id.value;
   var url = "/admin/member_eng/id_check.php?id=" + id;
   window.open(url, "idCheck", "width=350, height=150, menubar=no, scrollbars=no, resizable=no, toolbar=no, status=no, left=150, top=150");
}
// 닉네임 중복확인
function nickCheck(){
   var nick = document.joinFrm.nick.value;
   var url = "/admin/member_eng/nick_check.php?nick=" + nick;
   window.open(url, "nickCheck", "width=350, height=150, menubar=no, scrollbars=no, resizable=no, toolbar=no, status=no, left=150, top=150");
}
 
// 우편번호 찾기
function postSearch(kind){
 
	if(kind == undefined) kind = "";
 
   document.joinFrm.address1.focus();
   var url = "/admin/member_eng/post_search.php?kind="+kind;
   window.open(url, "postSearch", "width=450, height=250, menubar=no, scrollbars=yes, resizable=no, toolbar=no, status=no, left=50, top=50");
}
 
// 주민번호 자동포커스
function jfocus(frm){
	if(frm.resno2 != null){
		var str = frm.resno1.value.length;
		if(str == 6) frm.resno2.focus();
	}
}
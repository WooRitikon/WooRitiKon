var loginCheck = false;
$('#login').click(function(){
	
	// 이메일 중복 검사 - DB와 비교
 	  $.ajax({
    	type : 'post',
    	url : 'loginCheck',
    	data : { nid : $('#nid').val() },
    	contentType : 'application/x-www-form-urlencoded;charset=utf-8',
    	success : function(result){
    		// 중복 검사 후 나오는 결과 에러박스에 출력
    		if(result == 'Y'){
					window.alert("로그인 성공");
	        		loginCheck = true;
				}else{
					window.alert("로그인 실패")
	        		loginCheck = false;
				}
    	},
    	error : function(err){
			alert('실패');
    		console.log(err);
    	}
    }); //end of ajax
    
    
}); // end of $('#btn_emailCheck').click

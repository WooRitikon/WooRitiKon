var sellerCheck = false;
$('#sidck').click(function(){
	
	// 아이디 중복 검사 - DB와 비교
 	  $.ajax({
    	type : 'post',
    	url : 'selleridCheck',
    	data : { sid : $('#sid').val() },
    	contentType : 'application/x-www-form-urlencoded;charset=utf-8',
    	success : function(result){
    		 
    		// 중복 검사 후 나오는 결과 에러박스에 출력
    		if(result == 'Y'){
	        		$('label[for="scheck"] .error_box').css('color','#4ABA99');
	        		$('label[for="scheck"] .error_box').html("사용 가능한 아이디입니다.");
	        		seller = true;
				}else{
	        		$('label[for="scheck"] .error_box').css('color','#ED7A64');
	        		$('label[for="scheck"] .error_box').html("사용할 수 없는 아이디입니다..");
	        		seller = false;
				}
    	},
    	error : function(err){
			alert('실패');
    		console.log(err);
    	}
    }); //end of ajax
    
    
}); // end of $('#btn_emailCheck').click

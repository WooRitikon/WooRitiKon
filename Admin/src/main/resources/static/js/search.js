
$('.searchgi').click(function(){
	
	// 아이디 중복 검사 - DB와 비교
 	  $.ajax({
    	type : 'post',
    	url : 'searchgi',
    	data : { nid : $('#nid').val() },
    	contentType : 'application/x-www-form-urlencoded;charset=utf-8',
    	success : function(result){
    		 
    		alert("성공");
    	},
    	error : function(err){
			alert('실패');
    		console.log(err);
    	}
    }); //end of ajax
    
    
}); // end of $('#btn_emailCheck').click

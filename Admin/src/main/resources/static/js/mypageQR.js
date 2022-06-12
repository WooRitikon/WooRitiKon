$(function(){ 
    $("#text").on("blur", function () {
			makeCode();
			
			$.ajax({
				url:'mypageQRcode.html',
				type:"get",
				success: function(){
					
					$('#text').val();
				},
				error: function(){
					
				}
			})
	}).on("keydown", function (e) {
		if (e.keyCode == 13) {
			makeCode();
		}
	});
 })
  //qr코드 생성 
    var qrcode = new QRCode(document.getElementById("qrcode"), {
    	//가로, 세로 높이 조절
    	width : 100,
    	height : 100
    });

    //input:text에 들어있는 value를 qr코드로 바꿔주는 function
    function makeCode () {		
    	var elText = document.getElementById("text");
    	
    	if (!elText.value) {
    		elText.focus();
    		return;
    	}
    	
    	qrcode.makeCode(elText.value);
    }

    //위에 만든 function 실행
    makeCode();
     $("#text").on("blur", function () {
			makeCode();
			
	}).on("keydown", function (e) {
		if (e.keyCode == 13) {
			makeCode();
			alert("이벤트발생");
		}
	});
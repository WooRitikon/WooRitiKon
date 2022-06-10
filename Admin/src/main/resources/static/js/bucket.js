/**
 * 
 */
/* $(function() {
			$('.pro-qty').click(
					function() {

						var price = $('this').find('.price').text(); // 상품의 가격
						var count = $('this').find('#cartCount').val(); // 상품의 개수
						console.log(count);
						var total = price * count; // 한 상품의 개수*가격
						var len = 0;
						var realTotal = 0; // 장바구니 총합 액수
						alert("작동확인");
						// 
						$(this).find('.total').text(total); // 한 상품의 개수*가격

						<c:forEach items="${tb}" var="t">
						len += 1;
						</c:forEach>

						for (var i = 1; i <= len; i++) { // 장바구니 총합 액수(늘어날수록 증가)
							realTotal += parseInt($('.total[price=' + i + ']')
									.html());
						}

						$('#cartTotal').html(realTotal + '원');
					});
		}) */
		
		
		$(function() {
			$('.pro-qty').click(
					function() {
						var price = $('#price').attr('value'); // 상품의 가격
						var count = $('#cartCount').attr('value');// 장바구니 상품 갯수
						var total = price * count;  // 한 상품의 개수*가격
						//alert(total);
						
						//alert(count);
						var len = 0;
						var realTotal = 0;
						
				});		
		}) 


/*  ---------------------------------------------------
Template Name: Ashion
Description: Ashion ecommerce template
Author: Colorib
Author URI: https://colorlib.com/
Version: 1.0
Created: Colorib
---------------------------------------------------------  */

'use strict';

(function ($) {

    /*------------------
        Preloader
    --------------------*/
    $(window).on('load', function () {
        $(".loader").fadeOut();
        $("#preloder").delay(200).fadeOut("slow");

        /*------------------
            Product filter
        --------------------*/
        $('.filter__controls li').on('click', function () {
            $('.filter__controls li').removeClass('active');
            $(this).addClass('active');
        });
        if ($('.property__gallery').length > 0) {
            var containerEl = document.querySelector('.property__gallery');
            var mixer = mixitup(containerEl);
        }
    });

    /*------------------
        Background Set
    --------------------*/
    $('.set-bg').each(function () {
        var bg = $(this).data('setbg');
        $(this).css('background-image', 'url(' + bg + ')');
    });

    //Search Switch
    $('.search-switch').on('click', function () {
        $('.search-model').fadeIn(400);
    });

    $('.search-close-switch').on('click', function () {
        $('.search-model').fadeOut(400, function () {
            $('#search-input').val('');
        });
    });

    //Canvas Menu
    $(".canvas__open").on('click', function () {
        $(".offcanvas-menu-wrapper").addClass("active");
        $(".offcanvas-menu-overlay").addClass("active");
    });

    $(".offcanvas-menu-overlay, .offcanvas__close").on('click', function () {
        $(".offcanvas-menu-wrapper").removeClass("active");
        $(".offcanvas-menu-overlay").removeClass("active");
    });

    /*------------------
      Navigation
   --------------------*/
    $(".header__menu").slicknav({
        prependTo: '#mobile-menu-wrap',
        allowParentLinks: true
    });

    /*------------------
        Accordin Active
    --------------------*/
    $('.collapse').on('shown.bs.collapse', function () {
        $(this).prev().addClass('active');
    });

    $('.collapse').on('hidden.bs.collapse', function () {
        $(this).prev().removeClass('active');
    });

    /*--------------------------
        Banner Slider
    ----------------------------*/
    $(".banner__slider").owlCarousel({
        loop: true,
        margin: 0,
        items: 1,
        dots: true,
        smartSpeed: 1200,
        autoHeight: false,
        autoplay: true
    });

    /*--------------------------
        Product Details Slider
    ----------------------------*/
    $(".product__details__pic__slider").owlCarousel({
        loop: false,
        margin: 0,
        items: 1,
        dots: false,
        nav: true,
        navText: ["<i class='arrow_carrot-left'></i>","<i class='arrow_carrot-right'></i>"],
        smartSpeed: 1200,
        autoHeight: false,
        autoplay: false,
        mouseDrag: false,
        startPosition: 'URLHash'
    }).on('changed.owl.carousel', function(event) {
        var indexNum = event.item.index + 1;
        product_thumbs(indexNum);
    });

    function product_thumbs (num) {
        var thumbs = document.querySelectorAll('.product__thumb a');
        thumbs.forEach(function (e) {
            e.classList.remove("active");
            if(e.hash.split("-")[1] == num) {
                e.classList.add("active");
            }
        })
    }


    /*------------------
      Magnific
    --------------------*/
    $('.image-popup').magnificPopup({
        type: 'image'
    });


    $(".nice-scroll").niceScroll({
        cursorborder:"",
        cursorcolor:"#dddddd",
        boxzoom:false,
        cursorwidth: 5,
        background: 'rgba(0, 0, 0, 0.2)',
        cursorborderradius:50,
        horizrailenabled: false
    });

    /*------------------
        CountDown
    --------------------*/
    // For demo preview start
    var today = new Date();
    var dd = String(today.getDate()).padStart(2, '0');
    var mm = String(today.getMonth() + 1).padStart(2, '0'); //January is 0!
    var yyyy = today.getFullYear();

    if(mm == 12) {
        mm = '01';
        yyyy = yyyy + 1;
    } else {
        mm = parseInt(mm) + 1;
        mm = String(mm).padStart(2, '0');
    }
    var timerdate = mm + '/' + dd + '/' + yyyy;
    // For demo preview end


    // Uncomment below and use your date //

    /* var timerdate = "2020/12/30" */

   $("#countdown-time").countdown(timerdate, function(event) {
        $(this).html(event.strftime("<div class='countdown__item'><span>%D</span> <p>Day</p> </div>" + "<div class='countdown__item'><span>%H</span> <p>Hour</p> </div>" + "<div class='countdown__item'><span>%M</span> <p>Min</p> </div>" + "<div class='countdown__item'><span>%S</span> <p>Sec</p> </div>"));
    });

    /*-------------------
      Range Slider
   --------------------- */
   var rangeSlider = $(".price-range"),
    minamount = $("#minamount"),
    maxamount = $("#maxamount"),
    minPrice = rangeSlider.data('min'),
    maxPrice = rangeSlider.data('max');
    rangeSlider.slider({
    range: true,
    min: minPrice,
    max: maxPrice,
    values: [minPrice, maxPrice],
    slide: function (event, ui) {
        minamount.val('$' + ui.values[0]);
        maxamount.val('$' + ui.values[1]);
        }
    });
    minamount.val('$' + rangeSlider.slider("values", 0));
    maxamount.val('$' + rangeSlider.slider("values", 1));

    /*------------------
      Single Product
   --------------------*/
   $('.product__thumb .pt').on('click', function(){
      var imgurl = $(this).data('imgbigurl');
      var bigImg = $('.product__big__img').attr('src');
      if(imgurl != bigImg) {
         $('.product__big__img').attr({src: imgurl});
      }
    });
    
    /*-------------------
      Quantity change
   --------------------- */
   var proQty = $('.pro-qty');

   proQty.prepend('<a class="dec qtybtn minus" name="minus" onchange="del();">-</a>');
   proQty.append('<a class="inc qtybtn add" name="add" onchange="add();">+</a>');
   /*proQty.on('click', '.qtybtn', function () {
      var $button = $(this);
      var oldValue = $button.parent().find('input').val();
      if ($button.hasClass('inc')) {
         var newVal = parseFloat(oldValue) + 1;
         
      } else {
         // Don't allow decrementing below zero
         if (oldValue > 0) {
            var newVal = parseFloat(oldValue) - 1;
         } else {
            newVal = 0;
         }
      }
      
      $button.parent().find('input').val(newVal);
      
      var price = $('#price').attr('value'); // 상품의 가격
      
      //var count = $('#input').attr('value');// 장바구니 상품 갯수
      var count=$button.parent().find('input').val();
      var total = price * count;  // 한 상품의 개수*가격
      alert(total);
      $button.parent().parent().find('label').val(price * count);
      
      $("#total").change(function(){
         $(this).val = total;
         
      })
   
    });*/

$('.add').click(function(){
   $(this).prev().val(Number($(this).prev().val())+1)
   var price = Number($(this).parent().parent().prev().find('span').attr('value'))
   $(this).parent().parent().next().find('span').text(Number($(this).prev().val())*price)
   
   

})

$('.minus').click(function(){
   if($(this).next().val()>0){
   $(this).next().val(Number($(this).next().val())-1)
   var price = Number($(this).parent().parent().prev().find('span').attr('value'))
   $(this).parent().parent().next().find('span').text(Number($(this).next().val())* price)
}   
})

   $(".cart__close").click(function(){
      $(this).parents('tr').remove();
   })
   
   

    /*-------------------
      Radio Btn
   --------------------- */
    $(".size__btn label").on('click', function () {
        $(".size__btn label").removeClass('active');
        $(this).addClass('active');
    });

})(jQuery);

$('.add').click(function(){
   
   // 아이디 중복 검사 - DB와 비교
      $.ajax({
       type : 'post',
       url : 'mypagePlus',
       data : { pname : $(this).parent().parent().parent().find('h6').text() },
       contentType : 'application/x-www-form-urlencoded;charset=utf-8',
       success : function(result){
          $('.cartTotal').text(result)
       },
       error : function(err){
         alert('실패');
          console.log(err);
       }
    }); //end of ajax
    
    
}); // end of $('#btn_emailCheck').click

$('.minus').click(function(){

   
   // 아이디 중복 검사 - DB와 비교
      $.ajax({ 
       type : 'post',
       url : 'mypageMinus',
       data : { pname : $(this).parent().parent().parent().find('h6').text() },
       contentType : 'application/x-www-form-urlencoded;charset=utf-8',
       success : function(result){
          $('.cartTotal').text(result)
       },
       error : function(err){
         alert('실패');
          console.log(err);
       }
    }); //end of ajax
    
    
}); // end of $('#btn_emailCheck').click


$(".cart__close").click(function(){

   
   // 아이디 중복 검사 - DB와 비교
      $.ajax({ 
       type : 'post',
       url : 'bucketDelete',
       data : { pname : $(this).parent().find('h6').text() },
       contentType : 'application/x-www-form-urlencoded;charset=utf-8',
       success : function(result){
          
          $('.cartTotal').text(result)
          
   
       },
       error : function(err){
         alert('실패');
          console.log(err);
       }

    }); //end of ajax
    
    
}); // end of $('#btn_emailCheck').click

/*$(".primary-btn").click(function(){

   //버튼 클릭시 총합 데이터베이스 입력
   $.ajax({
      type : 'post',
      url : 'busketTotal',
      data : {ototal: $(#cartTotal).text()},
      dacontentType : 'application/x-www-form-urlencoded;charset=utf-8',
      success: function(result){
            alert(성공);
         },
      error : function(err){
         alert('실패');
          console.log(err);
       }
   })
   

});//end of ajax*/


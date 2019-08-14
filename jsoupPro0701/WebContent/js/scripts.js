
jQuery(document).ready(function() {

    /*
        Background slideshow
    */
    $('.coming-soon').backstretch([
      "img/backgrounds/1.jpg"
    , "img/backgrounds/2.jpg"
    , "img/backgrounds/3.jpg"
    ], {duration: 3000, fade: 750});

    /*
        time initializer
    */
	var info = $(".timer input[type=hidden]").val();
	var dt = info.split(" ");
	var d1 = dt[0].split("-");
	var d2 = dt[1].split(":");
	var date = new Date(d1[0],d1[1]-1,d1[2],d2[0],d2[1],d2[2]);
	var t = date.getTime();
	setInterval(function(){	
		$(".timer .years").html(date.getYear()-100);
		$(".timer .months").html(date.getMonth()+1);
		$(".timer .days").html(date.getDate());
		$(".timer .hours").html(date.getHours());
		$(".timer .minutes").html(date.getMinutes());
		$(".timer .seconds").html(date.getSeconds());
		t += 1000;
		date.setTime(t);
	}, 1000);
   

    /*
        Tooltips
    */
    $('.social a.facebook').tooltip();
    $('.social a.twitter').tooltip();
    $('.social a.dribbble').tooltip();
    $('.social a.googleplus').tooltip();
    $('.social a.pinterest').tooltip();
    $('.social a.flickr').tooltip();

    /*
        Subscription form
    */
    $('.success-message').hide();
    $('.error-message').hide();

    $('.subscribe form').submit(function() {
        var postdata = $('.subscribe form').serialize();
        $.ajax({
            type: 'POST',
            url: 'assets/sendmail.php',
            data: postdata,
            dataType: 'json',
            success: function(json) {
                if(json.valid == 0) {
                    $('.success-message').hide();
                    $('.error-message').hide();
                    $('.error-message').html(json.message);
                    $('.error-message').fadeIn();
                }
                else {
                    $('.error-message').hide();
                    $('.success-message').hide();
                    $('.subscribe form').hide();
                    $('.success-message').html(json.message);
                    $('.success-message').fadeIn();
                }
            }
        });
        return false;
    });

});


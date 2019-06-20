
jQuery(document).ready(function() {
	
    /*
        Fullscreen background
    */
    $.backstretch("assets/img/backgrounds/1.jpg");
    
    /*
        Form validation
    */
    $('.login-form input[type="text"], .login-form input[type="password"], .login-form textarea').on('focus', function() {
    	$(this).removeClass('input-error');
    });
    
    $('.login-form').on('submit', function(e) {
		var  pwd = $("#form-password-check").val();
		var orginal_pwd = $("#form-password").val();
		if(pwd!=orginal_pwd){
			e.preventDefault();
			$("#form-password-check").addClass('input-error');
		}else{
			$("#form-password-check").removeClass('input-error');
		}
    	
    	$(this).find('input[type="text"], input[type="password"], textarea').each(function(){
    		if( $(this).val() == "" ) {
    			e.preventDefault();
    			$(this).addClass('input-error');
    		}
    		else if($(this).prop("type")=="text"){
    			$(this).removeClass('input-error');
    		}
    	});
    	
    });
	$("#form-password-check").on("blur",function(e){
		var  pwd = $(this).val();
		var orginal_pwd = $("#form-password").val();
		if(pwd!=orginal_pwd){
			e.preventDefault();
			$(this).addClass('input-error');
		}
	});
    
    
});

define([], function () {
	function init() {
		$('.carousel').carousel({
	      interval: 2000
	    });
			
		$('#weightEntry button').click(function() {
			var thisButton = $(this);
			if(thisButton.html() == 'lbs') {
				$(this).html('oz');
			} else {
				$(this).html('lbs');
			}
		});
		
		$('#submitWeightSuccessAlert').hide();
		$('body').css({'visibility':'visible'});
	}
	
	return {
		init:init
	};
});

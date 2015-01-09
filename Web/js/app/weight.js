define([], function () {
	console.log("weight!");
	
	function click() {
		$('form.ajax').submit(function() {
			var that = $(this),
			url = that.attr('action'),
			type = that.attr('method'),
			data = {};
			
			that.find('[name]').each(function(index, value) {
				var that = $(this),
				name = that.attr('name'),
				value = that.val(),
				html = that.html();
				if(value == "" && html != "") {
					data[name] = html;
				} else {					
					data[name] = value;
				}
			});
			
			$.ajax({
				url: url,
				type: type,
				data: data,
				success: function(response) {
					$('input[name="weight"]').val('');
					$('#alertMessage').html(response);
					$('#submitWeightSuccessAlert').fadeIn();
					setTimeout(function(){ $('#submitWeightSuccessAlert').fadeOut(); }, 3000);
				}
			});		
			
			return false;
		});
	}
	
	return {
		click:click
	};
});

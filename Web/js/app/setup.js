define(['app/charts'], function (Charts) {
	function init() {			
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
		
		// Charts
		Charts.init();
		var chartList = [];
		$.get('ChartData', {name:'Andre'}, function(data) {
			console.log(data);
			average = [];
			series = [];
			console.log("begin loop: " + data.average.dates.length);
			for(var i=0; i<data.average.dates.length; i++) {
				var array = [];
				array.push(data.average.dates[i]);
				array.push(data.average.maxWeights[i]);
				array.push(data.average.minWeights[i]);
				average.push(array);
			}
			for(var i=0; i<data.series.dates.length; i++) {
				var array = [];
				array.push(data.series.dates[i]);
				array.push(data.series.weights[i]);
				series.push(array);
			}
			data = {name:data.name, average:average, series:series};
			
			chartList.push(Charts.createChart($('#andreChart'), Charts.getOptions(data)));
		});
		$.get('ChartData', {name:'Paola'}, function(data) {
			console.log(data);
			average = [];
			series = [];
			console.log("begin loop: " + data.average.dates.length);
			for(var i=0; i<data.average.dates.length; i++) {
				var array = [];
				array.push(data.average.dates[i]);
				array.push(data.average.maxWeights[i]);
				array.push(data.average.minWeights[i]);
				average.push(array);
			}
			for(var i=0; i<data.series.dates.length; i++) {
				var array = [];
				array.push(data.series.dates[i]);
				array.push(data.series.weights[i]);
				series.push(array);
			}
			data = {name:data.name, average:average, series:series};
			
			chartList.push(Charts.createChart($('#paolaChart'), Charts.getOptions(data)));
		});
		$.get('ChartData', {name:'Cheeky'}, function(data) {
			console.log(data);
			average = [];
			series = [];
			console.log("begin loop: " + data.average.dates.length);
			for(var i=0; i<data.average.dates.length; i++) {
				var array = [];
				array.push(data.average.dates[i]);
				array.push(data.average.maxWeights[i]);
				array.push(data.average.minWeights[i]);
				average.push(array);
			}
			for(var i=0; i<data.series.dates.length; i++) {
				var array = [];
				array.push(data.series.dates[i]);
				array.push(data.series.weights[i]);
				series.push(array);
			}
			data = {name:data.name, average:average, series:series};
			
			chartList.push(Charts.createChart($('#cheekyChart'), Charts.getOptions(data)));
		});
		
//		chartList.push(Charts.createChart($('#paolaChart'), Charts.getData('Paola'), Charts.getOptions('Paola')));
//		chartList.push(Charts.createChart($('#cheekyChart'), Charts.getData('Cheeky'), Charts.getOptions('Cheeky')));
		
		$('#weightCarousel').carousel({
	      interval: 3000
	    }).bind('slide.bs.carousel', function() {
	    	setTimeout(function() {$(window).trigger('resize');} , 1);			
		});
	}
	
	return {
		init:init
	};
});

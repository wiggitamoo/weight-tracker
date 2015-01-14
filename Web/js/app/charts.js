define(['hchart','hmore','hgray'], function (hc, hm, hg) {
	function init() {
		console.log("charts!");
	}
	
	function createChart(chartId, options) {
		var thisChart = chartId.highcharts({
	        title: options.title,
	        xAxis: options.xAxis,
	        yAxis: options.yAxis,
	        tooltip: options.tooltip,
	        legend: options.legend,
	        series: options.series
	    });
		return thisChart;
	}
	
	function getData(person) {
		// retrieve data for person
		var query = "select * from weight where firstname = '" + person + "' order by update_ts";
		
		
		var data = {
				ranges: [
				            [1246406400000, 14.3, 27.7],
				            [1246492800000, 14.5, 27.8],
				            [1246579200000, 15.5, 29.6],
				            [1246665600000, 16.7, 30.7],
				            [1246752000000, 16.5, 25.0],
				            [1246838400000, 17.8, 25.7],
				         
				            [1248134400000, 12.2, 15.5],
				            [1248220800000, 12.0, 20.8],
				            [1248307200000, 12.0, 17.1],
				            [1248393600000, 12.7, 18.3],
				            [1248480000000, 12.4, 19.4],
				            [1248566400000, 12.6, 19.9],
				            [1248652800000, 11.9, 20.2],
				            [1248739200000, 11.0, 19.3],
				            [1248825600000, 10.8, 17.8],
				            [1248912000000, 11.8, 18.5],
				            [1248998400000, 10.8, 16.1]
				        ],
				        averages: [
				            [1246406400000, 21.5],
				            [1246492800000, 22.1],
				            [1246579200000, 23],
				            [1246665600000, 23.8],
				            [1246752000000, 21.4],
				            [1246838400000, 21.3],
				          
				            [1247529600000, 16.8],
				            [1247616000000, 17.7],
				            [1247702400000, 16.3],
				            [1247788800000, 17.8],
				            [1247875200000, 18.1],
				            [1247961600000, 17.2],
				            [1248048000000, 14.4],
				            [1248134400000, 13.7],
				        
				            [1248739200000, 14.8],
				            [1248825600000, 14.4],
				            [1248912000000, 15],
				            [1248998400000, 13.6]
				        ]
		};
		return data;
	}
	
	function getOptions(data) {
		var options = {
				title: {
		            text: data.name + '\'s Weight'
		        },

		        xAxis: {
		            type: 'datetime',
		            title: {
		            	text: 'Date'
		            }
		        },

		        yAxis: {
		            title: {
		                text: (data.name=='Cheeky') ? 'Weight (oz)' : 'Weight (lbs)'
		            }
		        },

		        tooltip: {
		            crosshairs: true,
		            shared: true,
		            valueSuffix: (data.name=='Cheeky') ? ' oz' : ' lbs'
		        },

		        legend: {
		        },
		        
		        series: [{
		            name: 'Weight',
		            data: data.series,
		            zIndex: 1,
		            marker: {
		                fillColor: 'white',
		                lineWidth: 2,
		                lineColor: Highcharts.getOptions().colors[0]
		            }
		        }, {
		            name: 'Margins',
		            data: data.average,
		            type: 'arearange',
		            lineWidth: 0,
		            linkedTo: ':previous',
		            color: Highcharts.getOptions().colors[0],
		            fillOpacity: 0.3,
		            zIndex: 0
		        }]
		};
		return options;
	}
	
	return {
		init:init,
		createChart:createChart,
		getData:getData,
		getOptions:getOptions
	};
});

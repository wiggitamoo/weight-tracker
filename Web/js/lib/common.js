//The build will inline common dependencies into this file.

//For any third party dependencies, like jQuery, place them in the lib folder.

//Configure loading modules from the lib directory,
//except for 'app' ones, which are in a sibling
//directory.
requirejs.config({
    baseUrl: 'js/lib',
    paths: {
    	app: '../app',
    	hchart: 'highcharts/highcharts',
        hgray: 'highcharts/themes/gray',
        hmore: 'highcharts/highcharts-more'
    },
    shim: {
        backbone: {
            deps: ['jquery', 'underscore'],
            exports: 'Backbone'
        },
        underscore: {
            exports: '_'
        },
        hchart: {
            exports: 'Highcharts'
        },
        hmore: {
        	deps: ['hchart']
        },
        hgray: {
        	deps: ['hchart']
        }
    }
});
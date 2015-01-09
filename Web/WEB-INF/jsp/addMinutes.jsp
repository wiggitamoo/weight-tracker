<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>    

<!DOCTYPE html>
<html lang="en">
  
  <head>
    <meta charset="utf-8">
    <title>
    </title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href="assets/css/bootstrap.css" rel="stylesheet">
    <style>
      body { padding-top: 60px; /* 60px to make the container go all the way
      to the bottom of the topbar */ }
    </style>
    <link href="css/bootstrap/bootstrap.css" rel="stylesheet">
	<link href="css/bootstrap/bootstrap-theme.css" rel="stylesheet">
    <link rel="shortcut icon" href="assets/ico/favicon.ico">

	<script type="text/javascript">
		$(document).ready(
			function() {
				$.getJSON('<spring:url value="activities.json"/>', {
					ajax : 'true'
				}, function(data){
					var html = '<option value="">--Please select one--</option>';
					var len = data.length;
					for (var i = 0; i < len; i++) {
						html += '<option value="' + data[i].desc + '">'
								+ data[i].desc + '</option>';
					}
					html += '</option>';
					$('#activities').html(html);
				});
				
			});
		
	</script>
	<style>
		.error {
			color: #ff0000;
		}
		
		.errorblock {
			color: #000;
			background-color: #ffEEEE;
			border: 3px solid #ff0000;
			padding: 8px;
			margin: 16px;
		}
	</style>
  </head>
  <body>
    <div class="navbar navbar-fixed-top navbar-inverse">
      <div class="navbar-inner">
        <div class="container">
          <a class="brand" href="#">
            <spring:message code="minutes.exercised"/>
          </a>
          <ul class="nav">
          </ul>
        </div>
      </div>
    </div>
    <div class="container">
      <div>
        <h1>
          <spring:message code="minutes.exercised"/>
        </h1>
      </div>
      <a class="btn" href="?language=en">
        English
      </a>
      <a class="btn" href="?language=es">
        Spanish
      </a>
      <br/>
      <br/>
      <form:form commandName="exercise">
      	<form:errors path="*" cssClass="errorblock" element="div" />
      	<div class="control-group">
          <label for="textinput1">
            <spring:message code="minutes.text"/>
          </label>
          <form:input path="minutes"/>
          <form:errors path="minutes" cssClass="error" />
        </div>
        
        <div class="control-group">
          <label for="selectinput1">
            <spring:message code="minutes.activity" />
          </label>
          <form:select id="activities" path="activity" />
        </div>
		
		<input type="submit" class="btn" value="<spring:message code="minutes.button.enter"/>"/>
		
	</form:form>
      
      <span class="label">
        <spring:message code="minutes.goal"/> ${goal.minutes}
      </span>
    </div>

	<script src="js/lib/jquery.js"></script>
	<script src="js/lib/bootstrap.js"></script>
  </body>
</html>





















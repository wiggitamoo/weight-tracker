<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html lang="en">
  
  <head>
    <meta charset="utf-8">
    <title>Add Goal</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href="css/bootstrap/bootstrap.css" rel="stylesheet">
	<link href="css/bootstrap/bootstrap-theme.css" rel="stylesheet">
    <link rel="shortcut icon" href="assets/ico/favicon.ico">
    
    <style>
      body { padding-top: 60px; /* 60px to make the container go all the way
      to the bottom of the topbar */ }
    </style>
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
            Add Goal
          </a>
          <ul class="nav">
          </ul>
        </div>
      </div>
    </div>
    <div class="container">
      <div>
        <h1>
          Add Goal
        </h1>
        <p>
          Add your workout goal in minutes for the day.
          <br>
          &nbsp;
        </p>
      </div>
      
      <form:form commandName="goal">
		<form:errors path="*" cssClass="errorblock" element="div" />
			<label for="textinput1">
	          Enter Minutes:
	        </label>	
			<form:input path="minutes" cssErrorClass="error" />
			<form:errors path="minutes" cssClass="error" />
			<br/>
			<input type="submit" class="btn" value="Enter Goal Minutes"/>
	  </form:form>
     
      <div class="control-group">
      </div>
    </div>

	<script src="js/lib/jquery.js"></script>
	<script src="js/lib/bootstrap.js"></script>
  </body>
</html>

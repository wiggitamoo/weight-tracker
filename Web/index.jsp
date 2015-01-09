<!DOCTYPE html>
<html lang="en">

<head>
	<meta charset="utf-8">
	<title>Weight Tracker</title>
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<link href="css/bootstrap/bootstrap.css" rel="stylesheet">
	<link href="css/bootstrap/bootstrap-theme.css" rel="stylesheet">
	<link href="css/main.css" rel="stylesheet">
</head>
<body>
	<nav class="navbar navbar-fixed-top navbar-inverse" role="navigation">
		<!-- Brand and toggle get grouped for better mobile display -->
		<div class="navbar-header">
			<button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#weightTrackerNav">
				<span class="sr-only">Toggle navigation</span> 
				<span class="icon-bar"></span> 
				<span class="icon-bar"></span> 
				<span class="icon-bar"></span>
			</button>
			<a class="navbar-brand" href="#">Weight Tracker</a>
		</div>
		
		<!-- Collect the nav links, forms, and other content for toggling -->
		<div class="collapse navbar-collapse" id="weightTrackerNav">
			<ul class="nav navbar-nav">
				<li class="active"><a href="#">Enter Weight</a></li>
			</ul>
		</div>
		<!-- /.navbar-collapse -->
	</nav>
	<div class="container">
		<!--  Carousel -->
		<div id="weightCarousel" class="carousel slide"> <!-- class of slide for animation -->
			
			<div class="carousel-inner">
				<div class="item active"> <!-- class of active since it's the first item -->
					<img src="http://placehold.it/1200x480" alt="" />
					<div class="carousel-caption">
						<p>Caption text here</p>
					</div>
				</div>
				<div class="item">
					<img src="http://placehold.it/1200x480" alt="" />
					<div class="carousel-caption">
						<p>Caption text here</p>
					</div>
				</div>
				<div class="item">
					<img src="http://placehold.it/1200x480" alt="" />
					<div class="carousel-caption">
						<p>Caption text here</p>
					</div>
				</div>
			</div> <!-- /.carousel-inner -->
			
			<!-- Indicators -->
			<ol class="carousel-indicators">
				<li data-target="#weightCarousel" data-slide-to="0" class="active"></li>
				<li data-target="#weightCarousel" data-slide-to="1"></li>
				<li data-target="#weightCarousel" data-slide-to="2"></li>
			</ol>
		
			<!--  Next and Previous controls below href values must reference the id for this carousel -->
			<a class="carousel-control left" href="#weightCarousel" data-slide="prev">&lsaquo;</a> 
			<a class="carousel-control right" href="#weightCarousel" data-slide="next">&rsaquo;</a>
		</div>
		<!-- /.carousel -->
		
		<div class="hero-unit">
			<div>
				<h1>Welcome to Weight Tracker!</h1>
				<p>To get started, enter your weight for today.</p>
			</div>
			
			<form class="ajax" action="WeightInfo" method="post" >
				<div id="weightEntry" class="input-group input-group-lg">
					<input type="number" step="0.01" class="form-control" name="weight" required> 
					<span class="input-group-btn">
						<button class="btn btn-default" type="button" name="unit">lbs</button>
					</span>
				</div> <!-- /input-group -->
				<br/>
				<button class="btn btn-primary" type="submit">Submit Weight</button>
			</form>
		</div>
		
		<br>
		
		<div class="alert alert-success" id="submitWeightSuccessAlert">
	    	<a href="#" class="close" data-dismiss="alert">&times;</a>
		    <div id="alertMessage"><strong>Success!</strong> Your weight has been recorded.</div>	
		</div>

	</div>

	<script src="js/lib/jquery.js"></script>
	<script src="js/lib/bootstrap.js"></script>
	<script type="text/javascript" src="js/lib/require.js"></script>
	<script type="text/javascript">
    	require(['js/lib/common'], function (common) {
	        //js/common sets the baseUrl to be js/ so
	        //can just ask for 'app/main' here instead
	        //of 'js/app/main'
	        require(['app/main']);
	    });
    </script>
</body>
</html>

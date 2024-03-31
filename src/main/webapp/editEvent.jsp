<!DOCTYPE html>
<html lang="en">

<!-- Basic -->
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">

<!-- Mobile Metas -->
<meta name="viewport"
	content="width=device-width, minimum-scale=1.0, maximum-scale=1.0, user-scalable=no">

<!-- Site Metas -->
<title>Eventos</title>
<meta name="keywords" content="">
<meta name="description" content="">
<meta name="author" content="">

<link rel="apple-touch-icon" sizes="180x180"
	href="/apple-touch-icon.png">
<link rel="icon" type="image/png" sizes="32x32"
	href="/favicon-32x32.png">
<link rel="icon" type="image/png" sizes="16x16"
	href="/favicon-16x16.png">
<link rel="manifest" href="/site.webmanifest">

<!-- Bootstrap CSS -->
<link rel="stylesheet" href="css/bootstrap.min.css">
<!-- Site CSS -->
<link rel="stylesheet" href="style.css">
<link rel="stylesheet" href="editEvent.css">
<!-- Responsive CSS -->
<link rel="stylesheet" href="css/responsive.css">
<!-- Custom CSS -->
<link rel="stylesheet" href="css/custom.css">

<!-- Modernizer for Portfolio -->
<script src="js/modernizer.js"></script>

<!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
      <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->

</head>
<body>
	<!-- LOADER -->
	<div id="preloader">
		<div class="loader">
			<div class="loader__bar"></div>
			<div class="loader__bar"></div>
			<div class="loader__bar"></div>
			<div class="loader__bar"></div>
			<div class="loader__bar"></div>
			<div class="loader__ball"></div>
		</div>
	</div>
	<!-- END LOADER -->


	<header class="header header_style_01">
		<nav class="megamenu navbar navbar-default">
			<div class="container-fluid">
				<div class="navbar-header">
					<button type="button" class="navbar-toggle collapsed"
						data-toggle="collapse" data-target="#navbar" aria-expanded="false"
						aria-controls="navbar">
						<span class="sr-only">Toggle navigation</span> <span
							class="icon-bar"></span> <span class="icon-bar"></span> <span
							class="icon-bar"></span>
					</button>
					<a class="navbar-brand nigga" href="index.html"><h1
							class="logotxt">
							<h1>Eventos</h1>
						</h1></a>
				</div>
				<div id="navbar" class="navbar-collapse collapse">
					<ul class="nav navbar-nav navbar-right">
						<li><a href="index.html">Home</a></li>
						<li><a href="about-us.html">About us</a></li>
						<li><a href="events.html">Events</a></li>
						<li><a href="contact.html">Contact</a></li>
						<li><a href="organizerLogin.html">Login</a></li>
					</ul>
				</div>
			</div>
		</nav>
	</header>



	<!-- Form for editing event details -->


	<section class="edit-event-section">
		<div class="container">
			<div class="row">
				<div class="col-md-8 col-md-offset-2">
					<form id="editEventForm" class="edit-event-form"
						action="EventsRegisterServlet" method="post">
						<h2 class="edit-event-heading">Edit Event Details</h2>
						<div class="form-group">
							<label for="eventName" class="edit-event-label">Event
								Name</label> <input type="text" class="form-control edit-event-input"
								id="eventName" name="eventName" value="event_name" required>
						</div>
						<div class="form-group">
							<label for="location" class="edit-event-label">Location
								(City)</label> <input type="text" class="form-control edit-event-input"
								id="location" name="eventCity" value="event_city" required>
						</div>
						<div class="form-group">
							<label for="description" class="edit-event-label">Description</label>
							<textarea class="form-control edit-event-input" id="description"
								name="eventDescription" required></textarea>
						</div>
						<div class="form-group">
							<label for="eventDate" class="edit-event-label">Date of
								Event</label> <input type="date" class="form-control edit-event-input"
								id="eventDate" name="eventDate" value="event_date" required>
						</div>
						<div class="form-group">
							<label for="imageUrl" class="edit-event-label">Image URL</label>
							<input type="url" class="form-control edit-event-input"
								id="imageUrl" name="eventBanner" required>
						</div>

						<div class="form-group">
							<label for="category" class="edit-event-label">Category</label> <select
								class="form-control edit-event-input" id="category"
								name="category">
								<option value="Stand-up">Stand-up</option>
								<option value="Concert">Concert</option>
								<option value="Heritage Walk">Theatre</option>
								<option value="Others">Others</option>
							</select>
						</div>


						<!-- Ticket types section -->
						<div id="ticketTypes">
							<h3 class="edit-event-subheading">Ticket Types</h3>
							<!-- Ticket type input fields will be dynamically added here -->
						</div>

						<!-- Button to add more ticket types -->
						<button type="button" class="btn btn-default add-ticket-btn"
							id="addTicketTypeBtn" name="">Add Ticket Type</button>

						<button type="submit" class="btn btn-primary save-changes-btn">Save
							Changes</button>
					</form>
				</div>
			</div>
		</div>
	</section>

	<!-- END Form for editing event details -->


	<script>
		var event_name = localStorage.getItem("event_name");
		var event_city = localStorage.getItem("event_city");
		var event_date = localStorage.getItem("event_date");
		console.log(event_city);
		console.log(event_date);

		document.getElementById("eventName").value = event_name;
		document.getElementById("location").value = event_city;
		document.getElementById("eventDate").value = event_date;
	</script>




	<footer class="footer">
		<div class="container">
			<div class="row">
				<div class="col-md-4 col-sm-4 col-xs-12">
					<div class="widget clearfix">
						<div class="widget-title">
							<img src="images/logos/logo.png" alt="" / class="logo">
						</div>
						<p>Explore, Experience, Enjoy: Your one-stop destination for
							seamless event ticketing. Stay connected for updates, offers, and
							exclusive deals. Start planning your next adventure with us
							today!</p>
						<p>Sed fermentum est vitae rhoncus molestie. Cum sociis
							natoque penatibus et magnis dis montes.</p>
					</div>
					<!-- end clearfix -->
				</div>
				<!-- end col -->

				<div class="col-md-4 col-sm-4 col-xs-12">
					<div class="widget clearfix">
						<div class="widget-title">
							<h3>Pages</h3>
						</div>

						<ul class="footer-links hov">
							<li><a href="/index.html">Home <span
									class="icon icon-arrow-right2"></span></a></li>
							<li><a href="about-us.html">About <span
									class="icon icon-arrow-right2"></span></a></li>
							<li><a href="events.html">Events <span
									class="icon icon-arrow-right2"></span></a></li>
							<li><a href="contact.html">Contact <span
									class="icon icon-arrow-right2"></span></a></li>
							<li><a href="login.html">Login <span
									class="icon icon-arrow-right2"></span></a></li>
						</ul>
						<!-- end links -->
					</div>
					<!-- end clearfix -->
				</div>
				<!-- end col -->

				<div class="col-md-4 col-sm-4 col-xs-12">
					<div class="footer-distributed widget clearfix">
						<div class="widget-title">
							<h3>Subscribe</h3>
							<p>Stay in the Loop! Subscribe for Exclusive Offers, Event
								Updates, and Early Access to Tickets. Join Now for a Front Row
								Seat to Your Favorite Experiences!</p>
						</div>

						<div class="footer-right">
							<form method="get" action="#">
								<input placeholder="Subscribe our newsletter.." name="search">
								<i class="fa fa-envelope-o"></i>
							</form>
						</div>
					</div>
					<!-- end clearfix -->
				</div>
				<!-- end col -->
			</div>
			<!-- end row -->
		</div>
		<!-- end container -->
	</footer>
	<!-- end footer -->

	<div class="copyrights">
		<div class="container">
			<div class="footer-distributed">
				<div class="footer-left">
					<p class="footer-company-name">
						All Rights Reserved. &copy; 2024 <a href="#">Eventos</a>
				</div>


			</div>
		</div>
		<!-- end container -->
	</div>
	<!-- end copyrights -->

	<a href="#" id="scroll-to-top" class="dmtop global-radius"><i
		class="fa fa-angle-up"></i></a>

	<!-- ALL JS FILES -->
	<script src="js/all.js"></script>
	<!-- ALL PLUGINS -->
	<script src="js/custom.js"></script>
	<script src="js/portfolio.js"></script>
	<script src="js/hoverdir.js"></script>





	<script>
		// Function to add ticket type fields dynamically
		document
				.getElementById("addTicketTypeBtn")
				.addEventListener(
						"click",
						function() {
							let ticketTypesDiv = document
									.getElementById("ticketTypes");
							let ticketTypeFieldset = document
									.createElement("fieldset");
							ticketTypeFieldset.classList
									.add("ticket-type-fieldset");

							let ticketTypeLabel = document
									.createElement("label");
							ticketTypeLabel.textContent = "Ticket Type";
							let ticketTypeInput = document
									.createElement("input");
							ticketTypeInput.type = "text";
							ticketTypeInput.name = "ticketType[]";
							ticketTypeInput.classList.add("form-control");
							ticketTypeFieldset.appendChild(ticketTypeLabel);
							ticketTypeFieldset.appendChild(ticketTypeInput);

							let ticketQuantityLabel = document
									.createElement("label");
							ticketQuantityLabel.textContent = "Quantity";
							let ticketQuantityInput = document
									.createElement("input");
							ticketQuantityInput.type = "number";
							ticketQuantityInput.name = "ticketQuantity[]";
							ticketQuantityInput.classList.add("form-control");
							ticketTypeFieldset.appendChild(ticketQuantityLabel);
							ticketTypeFieldset.appendChild(ticketQuantityInput);

							let ticketPriceLabel = document
									.createElement("label");
							ticketPriceLabel.textContent = "Price";
							let ticketPriceInput = document
									.createElement("input");
							ticketPriceInput.type = "number";
							ticketPriceInput.name = "ticketPrice[]";
							ticketPriceInput.classList.add("form-control");
							ticketTypeFieldset.appendChild(ticketPriceLabel);
							ticketTypeFieldset.appendChild(ticketPriceInput);

							// Add a remove button
							let removeBtn = document.createElement("button");
							removeBtn.textContent = "Remove";
							removeBtn.type = "button";
							removeBtn.classList.add("btn", "btn-danger",
									"remove-ticket-btn");
							removeBtn.addEventListener("click", function() {
								ticketTypesDiv.removeChild(ticketTypeFieldset);
							});
							ticketTypeFieldset.appendChild(removeBtn);

							ticketTypesDiv.appendChild(ticketTypeFieldset);
						});
	</script>

	</script>


</body>
</html>
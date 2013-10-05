<%-- <%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="${rootPath}/auth/style.css">
<link href="http://fonts.googleapis.com/css?family=Lobster&subset=latin"
	rel="stylesheet" type="text/css">
<link rel="shortcut icon" href="https://cdn3.iconfinder.com/data/icons/faticons/32/send-01-24.png">
<title>SPMS_SignUpForm</title>
<script type="text/javascript">
	var Pic = new Array()
	Pic[0] = 'http://www.hdwallpapers.in/walls/3d_black_ball-wide.jpg'
	Pic[1] = 'http://www.hdwallpapers.in/walls/flow_light-wide.jpg'

	var p = Pic.length
	var imgLoad = new Array()

	for (i = 0; i < p; i++) {
		imgLoad[i] = new Image()
		imgLoad[i].src = Pic[i]
	}

	window.onload = function setImg() {
			var j = Math.floor(Math.random() * 2);
			document.body.background = Pic[j];
			document.body.background-size = "cover";
	}
</script>
</head>

<body>
	<section class='form'>
		<form action="signup.do" method="post" enctype="multipart/form-data">
			<div id="signupform">
				<header>
					<article class="mask-galaxy">
						<span id="logo" class="entypo-paper-plane"></span>
					</article>
					<article class="mask-galaxy">
						<mainpage>SPMS</mainpage>
					</article>
				</header>
				<!-- 
					<input type="text" name="email" placeholder="Email" required="email">
					<input type="password" name="password" placeholder="Password" required>
					<input type="password" name="configPassword" required="required">
					<input type="text" name="name" placeholder="홍길동" required="required">
					<input type="text" name="tel" placeholder="010-0000-0000" required="required">
					<input type="file" name="photo"><br>
				</div>
					<input type="submit" value="Sign Up">
 				-->
				<fieldset>
					<div class="item">
						<label> <span>Name</span> <input
							data-validate-length-range="6" data-validate-words="2"
							name="name" placeholder="hong gil dong" required="required"
							type="text" />
						</label>
						<div class='tooltip help'>
							<span>?</span>
							<div class='content'>
								<b></b>
								<signp>Name must be at least 2 words</signp>
							</div>
						</div>
					</div>
					<div class="item">
						<label> <span>email</span> <input name="email"
							class='email' required="required" placeholder="spms@google.com"
							type="email" />
						</label>
					</div>

					<div class="item">
						<label> <span>Confirm email</span> <input type="email"
							class='email' name="confirm_email" data-validate-linked='email'
							required='required'>
						</label>
					</div>

					<div class="item">
						<label> <span>Password</span> <input type="password"
							name="password" data-validate-length="6,8" required='required'>
						</label>
						<div class='tooltip help'>
							<span>?</span>
							<div class='content'>
								<b></b>
								<signp>Should be of length 6 OR 8 characters</signp>
							</div>
						</div>
					</div>
					<div class="item">
						<label> <span>Repeat password</span> <input
							type="password" name="configPassword" data-validate-linked='password'
							required='required'>
						</label>
					</div>
					<div class="item">
						<label> <span>Telephone</span> <input type="tel"
							class='tel' name="tel" required='required'
							data-validate-length-range="8,20">
						</label>
						<div class='tooltip help'>
							<span>?</span>
							<div class='content'>
								<b></b>
								<signp>Notice that for a phone number user can input a
								'+' sign, a dash '-' or a space ' '</signp>
							</div>
						</div>
					</div>
					<div class="item">
						<label> <span>My Image</span>
							<div class='content'>
								<input placeholder="Image upload" readonly="readonly">
							</div>
							<div class="custom_file_upload">
								<div class="file_upload">
									<input type="file" id="file_upload" name="photo"
										required='required'>
								</div>
							</div>
						</label>
					</div>
				</fieldset>
				<footer>
					<p>
						<a href="${rootPath}/auth/loginForm.do">Log in</a> to your account
					</p>
				</footer>
			</div>

			<bluebutton> <input class="btn" type="submit"
				value="Sign Up"> </bluebutton>
			</div>
		</form>
	</section>
	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.min.js"></script>
	<script src="http://dropthebit.com/demos/validator/multifield.js"></script>
	<script src="http://dropthebit.com/demos/validator/validator.js"></script>
	<script>
		// initialize the validator function
		validator.message['date'] = 'not a real date';

		// validate a field on "blur" event, a 'select' on 'change' event & a '.reuired' classed multifield on 'keyup':
		$('form').on('blur',
				'input[required], input.optional, select.required',
				validator.checkField).on('change', 'select.required',
				validator.checkField);

		$('.multi.required').on('keyup', 'input', function() {
			validator.checkField.apply($(this).siblings().last()[0]);
		}).on('blur', 'input', function() {
			validator.checkField.apply($(this).siblings().last()[0]);
		});

		// bind the validation to the form submit event
		//$('#send').click('submit');//.prop('disabled', true);

		$('form').submit(function(e) {
			e.preventDefault();
			var submit = true;
			// evaluate the form using generic validaing
			if (!validator.checkAll($(this))) {
				submit = false;
			}

			if (submit)
				this.submit();
			return false;
		});

		/* FOR DEMO ONLY */
		$('#vfields').change(function() {
			$('form').toggleClass('mode2');
		}).prop('checked', false);

		$('#alerts').change(function() {
			validator.defaults.alerts = (this.checked) ? false : true;
			if (this.checked)
				$('form .alert').remove();
		}).prop('checked', false);
	</script>



	</form>
</body> --%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<title>SPMS_SignUp</title>
<link
	href="http://fonts.googleapis.com/css?family=Lato:300,400,300italic,400italic"
	rel="stylesheet" type="text/" />
</meta>
</head>
<link
	href="//netdna.bootstrapcdn.com/font-awesome/3.1.1/css/font-awesome.css"
	rel="stylesheet" />
<link href="css/styles.css" type="text/css" rel="stylesheet">
<body>
	<section class="m-box--sign-in" role="main">
		<header class="m-box--box-sized">
			<h1>
				Sign UP<span> or <a href="../auth/loginForm.do">sign in </a></span>
			</h1>
		</header>
		
		<form class="m-form--sign-in" method="post" action="signup.do" enctype="multipart/form-data">
			
			<fieldset>
				<span class="icon-envelope"></span>
				<input placeholder="Email" name="email" required="" type="email" /><span class="m-field-error"></span>
			</fieldset>
			
			<fieldset>
				<span class="icon-lock"></span><input placeholder="Password" name="password"
					required="" type="password" /><span class="m-field-error"></span>
			</fieldset>
			
			<fieldset>
				<span class="icon-lock"></span><input placeholder="Password" name="configPassword"
					required="" type="password" /><span class="m-field-error"></span>
			</fieldset>
			
			<fieldset>
			<span class="icon-name"></span>
				<input placeholder="Input Your Name" name="name" required="" type="text"/><span class="m-field-error"></span>
			</fieldset>
			
			<fieldset>
			<span class="icon-tel"></span>
				<input placeholder="Input Your PhoneNumer" name="tel" required="" type="text"/><span class="m-field-error"></span>
			</fieldset>
			
			<fieldset>
				<input placeholder="사진기입" name="photo" type="file"/>
			</fieldset>
			
				<!-- 	<input type="text" name="tel" placeholder="010-0000-0000" required="required">
					<input type="file" name="photo"><br> -->
			<div>
				<button type="submit">Sign Up</button>
			</div>
		</form>
	</section>
</body>
</html>
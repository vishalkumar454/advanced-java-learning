<html>
<head>
	
</head>

<body>
	<h1>Welcome</h1>
	<h2>Please Enter Your Credential</h2>

	<form action="/02-SERVLET/read" method="post">
		<fieldset >
			<legend>User Data</legend>
			<br>
			<label for="username">User Name : </label>
			<input type="text" placeholder="Enter your name" id="username" name="username" required><br><br>
			
			<label for="email">Email : </label>
			<input type="email" placeholder="Enter your Email" required name="email" id="email"><br><br>
				
			<label for="password">Password : </label>
			<input type="password"
				placeholder="Enter your Password" id="password" name="password" required><br><br>
			<br>
			<button>submit data</button>
		</fieldset>
	</form>
</body>
</html>

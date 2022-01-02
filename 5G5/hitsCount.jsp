<%@page import="java.io.*,java.util.*"%>
<!DOCTYPE html>
<html>
<head>
	<title>Counter Vistor</title>
</head>
<body>
	<form>
		<fieldset style="width: 20%;background-color: #e6ffe6;">
			<legend>Count Visitor</legend>
			<%
			Integer hitsCount=(Integer)application.getAttribute("hitCounter");
			if(hitsCount==null || hitsCount==0)
			{
				out.println("Welcome to my website!!");
				hitsCount=1;
			}
			else{
				out.println("Welcome to my website!!");
				hitsCount+=1;
			}
			application.setAttribute("hitsCounter",hitsCount);
		%>
		<p>Your visitor number:<%=hitsCount%></p>
		</fieldset>
	</form>
</body>
</html>

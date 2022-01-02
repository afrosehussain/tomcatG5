<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<title></title>
</head>
<body>
<%
	double num = Math.random();
	if(num>0.95){
%>
		<h2>You will have a lucky day!!^-^</h2>
<%
	}else{
%>
	<h2>Well life goes on...</h2>
<%
}
%>
<a href="<%=request.getRequestURL()%>">Try Again</a>
</body>
</html>
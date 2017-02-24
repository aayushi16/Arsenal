<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jstl/core_rt"  prefix="c" %>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Multiple File Uploading</title>



</head>
<body>

<h1> Multiple File uploading Example with Database </h1>
<div style="margin-left: 250px;margin-top:40px;padding:20px;width: 550px;height:370px; border: 3px solid black; ">
	
	
	
		<form action="<%=request.getContextPath() %>/YourController" method="post" >

			<iframe src="fileupload.jsp" width="100%" height="250"> </iframe>
			
				<input type="hidden" name="mode" value="1"/> 
				<hr>
				
				
				
				<br><br>
				Attachment Type Name : <input type="text" name="attachmentType" />
				<br><br>
			
				
				<center>
				<input type="submit" value="Add" />
				</center>
	</form>
	
	<hr>
	
</div>

<p>* Make two folder 1.temp and 2.doc in web content </p>
<p>* use iframe src="fileupload.jsp" tag where ever file uploading is required </p> 
<p>* the uploaded file name will be set in the session attribute "fileList" </p>
<p>* use List-Iterator to retrieve the name of file  </p>
<p>* the file path will be displayed on console </p>
<p>* 4 jar are required for file uploading </p>

<ol><li>commons-fileupload-1.2.2.jar</li>
<li>commons-io-2.1.jar</li>
<li>commons-io-2.1-javadoc.jar</li>
<li>commons-io-2.1-sources.jar</li>
 </ol>
 
 

</body>
</html>
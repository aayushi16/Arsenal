<%@page import="java.util.Iterator"%>
<%@page import="java.util.List"%>
<%@page import="java.io.BufferedWriter"%>
<%@page import="java.io.FileWriter"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<body>
<%

String filePath = getServletContext().getRealPath(request.getServletPath());
int path = filePath.lastIndexOf('\\');
String path1= filePath.substring(0, path); //+"\\doc\\";

System.out.println(path1);

FileWriter f=new FileWriter(path1+"\\h.json");
BufferedWriter b=new BufferedWriter(f);

b.write("{\"JSChart\" : {\"datasets\" : [{\"type\" : \"pie\",\"data\" : [");

List ls =(List)session.getAttribute("gunCounts");

System.out.println("List size is : "+ls.size());

int i=0;
for (Iterator iterator = ls.iterator(); iterator.hasNext();) {
	Object type[] = (Object[]) iterator.next();
	String str ="{\"unit\":\""+type[1]+"\",\"value\":\""+type[0]+"\"}";
	
	b.write(str);
	i++;	
	if(i<ls.size()){
		b.write(",");
	}

	
	
	
}

b.write("] } ] } }");

b.close();

%>
</body>
</html>
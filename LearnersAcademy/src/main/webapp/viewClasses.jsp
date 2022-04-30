<%@page import="entity.Subjects"%>
<%@page import="org.hibernate.Session"%>
<%@page import="entity.Classes"%>
<%@page import="java.util.List"%>
<%@page import="util.HibernateUtil"%>
<%@page import="org.hibernate.SessionFactory"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<a href="admin.html">Back to Main Menu</a><br>
<a href="addclasses.html">Add Class</a><br>
<a href="assignSubjectToClass.jsp">Assign Subject to Class</a><br>

<h2>The Following Classes are listed</h2>
<%
	SessionFactory sf  = HibernateUtil.getSessionFactory();
	Session hibernateSession = sf.openSession();
	List<Classes> classes = hibernateSession.createQuery("from Classes").list();
%>
<table>
<tr>
<th>Class Name </th>
<th>Subject Name</th>
</tr>	
	<%		
		for(Classes clas : classes){
			out.print("<tr>");	
			out.print("<td>" + clas.getC_name() + "</td>");
						
			StringBuffer buf = new StringBuffer();
			boolean first = true;
			for (Subjects subject : clas.getSubjects()){
				if(first== true){
					buf.append("<td>" + subject.getS_name()+ "</td>");
					buf.append("</tr>");
					first = false;
				}else{
					buf.append("<tr><td></td>");
					buf.append("<td>" + subject.getS_name() + "</td>");
					buf.append("</tr>");
				}
				
			}
			out.print(buf.toString());
		}
	%>
</table>
</body>
</html>
<%@page import="entity.Subjects"%>
<%@page import="entity.Teachers"%>
<%@page import="java.util.List"%>
<%@page import="org.hibernate.Session"%>
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
<a href="addTeacher.html">Add Teacher</a><br>
<a href="assignTeacherToSubject.jsp">Assign Teacher to Subject</a><br>

<h1>The Following Teachers are listed</h1>
<%
	SessionFactory sf  = HibernateUtil.getSessionFactory();
	Session hibernateSession = sf.openSession();
	List<Teachers> teachers = hibernateSession.createQuery("from Teachers").list();
%>
<table>
<tr>
<th>Name </th>
<th>Assigned Class</th>
</tr>
	<%		
		for(Teachers teacher : teachers){
			out.print("<tr>");	
			out.print("<td>" + teacher.getT_name() + "</td>");
			
			StringBuffer buf = new StringBuffer();
			boolean first = true;
			for (Subjects subject : teacher.getSubjects()){
				if(first== true){
					buf.append("<td>" + subject.getS_name() + "</td>");
					buf.append("</tr>");
					first = false;
				}else{
					buf.append("<tr><td></td><td></td>");
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
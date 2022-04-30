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

<h1>Assign a Teacher to a Subject</h1>
<%
	SessionFactory sf  = HibernateUtil.getSessionFactory();
	Session hibernateSession = sf.openSession();
	List<Teachers> teachers = hibernateSession.createQuery("from Teachers").list();
	List<Subjects> subjects = hibernateSession.createQuery("from Subjects").list();
%>

<form action="assignTeacher" method="post">
<table>
<tr>
<th>Teacher Name </th>
<th>Subject Name </th>
</tr>
<tr>
<td>
<select name="name">
<%
	for (Teachers teacher : teachers){
	out.print("<option>" + teacher.getT_name());
	out.print("</option>");
	}
%>
</select>
</td>

<td>
<select name="subject">
<%
	for (Subjects subject : subjects){
	out.print("<option>" + subject.getS_name());
	out.print("</option>");
	}
%>
</select>
</td>
</tr>
</table>
<input type="submit" value="Submit">
</form>
</body>
</html>
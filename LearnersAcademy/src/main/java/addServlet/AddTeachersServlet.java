package addServlet;

import java.io.IOException;

import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import entity.Teachers;
import util.HibernateUtil;

/**
 * Servlet implementation class AddTeachersServlet
 */
@WebServlet("/AddTeachersServlet")
public class AddTeachersServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddTeachersServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		
		PrintWriter out = response.getWriter();
		
		String name = request.getParameter("t_name");

		
		SessionFactory sf = HibernateUtil.getSessionFactory();
		Session session = sf.openSession();
		
		Transaction tx = session.beginTransaction();
		
		Teachers teacher = new Teachers(name);
		try {
			session.save(teacher);
			tx.commit();
			out.print("<h3 style = 'color:green' >Data updated successfully</h3>");
		} catch (Exception e) {
			tx.rollback();
			e.printStackTrace();
			out.print("<h2 style = 'color:red'>error</h2>");
		}
		session.close();
		out.print("<a href = \"admin.html\">go back to the home page </a><br>");
		out.print("<a href = \"addTeacher.html\">add more Teachers</a><br>");
		out.print("<a href = \"viewTeachers.jsp\">List of Teachers</a><br>");
	}

}

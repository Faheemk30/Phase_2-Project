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

import entity.Subjects;
import util.HibernateUtil;

/**
 * Servlet implementation class AddSubjectServlet
 */
@WebServlet("/AddSubjectServlet")
public class AddSubjectServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddSubjectServlet() {
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
		
		String subject = request.getParameter("s_name");
		
		SessionFactory sf = HibernateUtil.getSessionFactory();
		
		Session session = sf.openSession();
		
		Transaction t = session.beginTransaction();
		
		Subjects subjects = new Subjects(subject);
		
		try {
			session.save(subjects);
			t.commit();
			out.print("<h4 style= 'color: green'> Data added successfully</h4><br>");
		} catch (Exception e) {
			t.rollback();
			e.printStackTrace();
			out.print("<h4 style= 'color: red'> Error</h4><br>");
		}
		
		session.close();
		out.print("<a href = \"admin.html\">go back to the home page </a><br>");
		out.print("<a href = \"addsubjects.html\">add more Subjects</a><br>");
		out.print("<a href = \"viewSubjects.jsp\">List of Subjects</a><br>");
	}

}

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

import entity.Classes;
import util.HibernateUtil;



/**
 * Servlet implementation class AddClassServlet
 */
@WebServlet("/AddClassServlet")
public class AddClassServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddClassServlet() {
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
		// TODO Auto-generated method stub
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String name = request.getParameter("c_name");
		
		SessionFactory sf = HibernateUtil.getSessionFactory();
		Session session= sf.openSession();
		
		
			Transaction t = session.beginTransaction();
		
			Classes classes = new Classes(name);
			try {
				session.save(classes);
				t.commit();
				out.print("<h4 style= 'color: green'> Data added successfully</h4><br>");
			} catch (Exception e) {
				t.rollback();
				e.printStackTrace();
			}
		
		session.close();
		out.print("<a href = \"admin.html\">go back to the home page </a><br>");
		out.print("<a href = \"addclasses.html\">add more classes</a><br>");
		out.print("<a href = \"viewClasses.jsp\">List of classes</a><br>");
	}
}



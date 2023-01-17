package kadai1;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kadaidto.Kadai1dto;

/**
 * Servlet implementation class Kadai1RegisterConfirmServlet
 */
@WebServlet("/Kadai1RegisterConfirmServlet")
public class Kadai1RegisterConfirmServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Kadai1RegisterConfirmServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		String name = request.getParameter("name");
		int Age = Integer.parseInt(request.getParameter("age"));
		String gender = request.getParameter("gender");
		String phototel = request.getParameter("phototel");
		String mail = request.getParameter("mail");
		String pw = request.getParameter("pw");
		
		kadaidto.Kadai1dto ka1 = new Kadai1dto(name,Age,gender,phototel,mail,null,pw,null);
		
		HttpSession session = request.getSession();
		
		session.setAttribute("input_data", ka1);
		
		String view ="WEB-INF/view1/confirm.jsp";
		RequestDispatcher dispatcher = request.getRequestDispatcher(view);
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

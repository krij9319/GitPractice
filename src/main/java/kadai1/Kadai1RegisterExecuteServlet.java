package kadai1;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kadaidao.Kadai1dao;
import kadaidto.Kadai1dto;

/**
 * Servlet implementation class Kadai1RegisterExecuteServlet
 */
@WebServlet("/Kadai1RegisterExecuteServlet")
public class Kadai1RegisterExecuteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Kadai1RegisterExecuteServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		
		Kadai1dto ka1 = (Kadai1dto)session.getAttribute("input_data");
		
		int result = Kadai1dao.register(ka1);
		
		String path = "";
		if(result == 1) {
			session.removeAttribute("input_data");
			path = "WEB-INF/view1/success.jsp";
		}else {
			path = "WEB-INF/view1/form.jsp?error=1";
		}
		RequestDispatcher dispatcher = request.getRequestDispatcher(path);
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

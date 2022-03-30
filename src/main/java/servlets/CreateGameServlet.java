package servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import gameClasses.Player;
import gameClasses.YatzyGame;
import gameUtils.YatzyService;

/**
 * Servlet implementation class CreateGameServlet
 */
@WebServlet("/CreateGameServlet")
public class CreateGameServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CreateGameServlet() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("WEB-INF/Game.jsp").forward(request, response);
	}
		


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		
		String username = request.getParameter("username");
		
		
		Player player = new Player();
		
		YatzyGame game = new YatzyGame();
		
		YatzyService service = new YatzyService();
		
		Integer id = service.createGame(username);
		HttpSession session= request.getSession(true);
		session.setAttribute("GameId", id);
		
		response.sendRedirect("YatzyGameServlet");
		
	
	

		// Integer id = Create game(this.username)
		// Session.setAttribute("GameId", id)
		// request.sendRedirect(YatzyGameServlet)
	}

}

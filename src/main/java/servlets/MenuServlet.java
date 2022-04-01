package servlets;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import gameUtils.PlayerDAO;
import gameUtils.YatzyGameDAO;
import gameUtils.YatzyService;
import utils.UserDAO;

/**
 * Servlet implementation class MenuServlet
 */
@WebServlet("/MenuServlet")
public class MenuServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@EJB
	YatzyGameDAO gamedao;
	
	@EJB
	UserDAO userdao;
	
	@EJB
	PlayerDAO playerdao;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MenuServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		request.getRequestDispatcher("WEB-INF/Menu.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String createGame = request.getParameter("createGame");
		String joinGame = request.getParameter("joinGame");
		
		HttpSession session= request.getSession(true);
		String username = (String) session.getAttribute("username");
		
		YatzyService service = new YatzyService(userdao, gamedao, playerdao);
		
		
		int gameId = 0;
		
		if (createGame != null) {
			gameId = service.createGame(username);
			System.out.println("Game with id" + gameId + " has successfully been created by " + username);
			session.setAttribute("gameId", gameId);
			session.setAttribute("game", gamedao.getGameById(gameId));
			response.sendRedirect("YatzyGameServlet");
			
			
		} else if (joinGame != null) {
			System.out.println("joiner game");
		}

	}

}

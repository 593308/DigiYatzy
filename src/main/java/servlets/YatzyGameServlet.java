package servlets;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import gameClasses.YatzyGame;
import gameUtils.GameState;
import gameUtils.PlayerDAO;
import gameUtils.YatzyGameDAO;
import gameUtils.YatzyService;
import utils.UserDAO;

/**
 * Servlet implementation class YatzyGame
 */
@WebServlet("/YatzyGameServlet")
public class YatzyGameServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@EJB
	PlayerDAO playerdao;
	
	@EJB
	YatzyGameDAO yatzygamedao;
	
	@EJB
	UserDAO userdao;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public YatzyGameServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		YatzyGame game = yatzygamedao.getGameById((int)request.getSession().getAttribute("gameId"));
		request.getSession().setAttribute("game", game);
		request.getRequestDispatcher("WEB-INF/Game.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		YatzyService service = new YatzyService(userdao, yatzygamedao, playerdao);
//		System.out.println(request.getParameter("diceToBeRolled"));
//		
//		System.out.println(request.getParameter("Roll Dice"));
//		
//		String rolledDice = request.getParameter("Roll Dice");
		
		HttpSession session= request.getSession(true);
		String username = (String) session.getAttribute("username");
		System.out.println(username);
		
		int gameId = (int)(session.getAttribute("gameId"));
		
		String selection = request.getParameter("diceSelection");
		
		
		boolean[] diceSelector = new boolean[]{false, false, false, false, false};
		for (int i=0; i<selection.length(); i++) {
			if (selection.charAt(i) == 1)
				diceSelector[i] = true;
		}
		
		
		if (true) {
			if (yatzygamedao.getGameById(gameId).getGameState() == GameState.PLAYER_JOIN)
				service.startGame(gameId, username);	
			service.rollDice(gameId, username, diceSelector);
		}
		
		
		doGet(request,response);
	}

}

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
 * Servlet implementation class CreateGameServlet
 */
@WebServlet("/CreateGameServlet")
public class CreateGameServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@EJB 
	YatzyGameDAO gamedao;
	
	@EJB 
	PlayerDAO playerdao;
	
	@EJB 
	UserDAO userdao;
	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CreateGameServlet() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		
		
		
	
		
		YatzyService service = new YatzyService(userdao, gamedao, playerdao);
		HttpSession session= request.getSession(true);
		String username = (String) session.getAttribute("username");
		Integer id = service.createGame(username);
		session.setAttribute("GameId", id);
		
		
		session.setAttribute("die1", 1);
		session.setAttribute("die2", 2);
		session.setAttribute("die3", 3);
		session.setAttribute("die4", 4);
		session.setAttribute("die5", 5);
		
		
		
		response.sendRedirect("YatzyGameServlet");
		
	
	

		// Integer id = Create game(this.username)
		// Session.setAttribute("GameId", id)
		// request.sendRedirect(YatzyGameServlet)
	}

}

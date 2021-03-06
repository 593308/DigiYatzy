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
import gameUtils.PlayerDAO;
import gameUtils.YatzyGameDAO;
import gameUtils.YatzyService;
import utils.UserDAO;

/**
 * Servlet implementation class JoinGameServlet
 */
@WebServlet("/JoinGameServlet")
public class JoinGameServlet extends HttpServlet {
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
    public JoinGameServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String gameId = request.getParameter("gameId");
		System.out.println(gameId);
		
		
		YatzyService service = new YatzyService(userdao, gamedao, playerdao);
		HttpSession session= request.getSession(true);
		
		//Validate.gameId(request.getAttributt(gameId)) --> if statment
		//if the gameId does not exist --> redirect back to menu
		//resonse.sendRedirct("MenuServlet")
		//If the gameId exsit --> session.setAttributt(request.getAttributt(gameId)
		
		try {   
			session.setAttribute("gameId", gameId);
			service.joinGame(Integer.parseInt((String) session.getAttribute("gameId")), (String) session.getAttribute("username"));
			
			response.sendRedirect("YatzyGameServlet");
			   
			} catch (NumberFormatException e) {
			  // Handle the condition when str is not a number.
			}
		
	}

}

package servlets;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import gameUtils.PlayerDAO;

/**
 * Servlet implementation class JoinGameServlet
 */
@WebServlet("/JoinGameServlet")
public class JoinGameServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	
	@EJB
	private PlayerDAO playerDAO;
       
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
		doGet(request, response);
		
		
		
		//Validate.gameId(request.getAttributt(gameId)) --> if statment
		//if the gameId does not exist --> redirect back to menu
		//resonse.sendRedirct("MenuServlet")
		//If the gameId exsit --> session.setAttributt(request.getAttributt(gameId)
	}

}

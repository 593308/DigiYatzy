package servlets;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import classes.Password;
import classes.YatzyUser;
import gameClasses.YatzyGame;
import gameUtils.YatzyGameDAO;
import utils.UserDAO;

/**
 * Servlet implementation class RegisterServlet
 */
@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@EJB
	UserDAO userdao;
	
	@EJB
	YatzyGameDAO yatzygamedao;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.getRequestDispatcher("WEB-INF/Register.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = request.getParameter("username");
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		
		Password pwd_hash = Password.createPassword(password);
		
		YatzyUser registering_user = new YatzyUser(username, email, pwd_hash);
		
		//Testgreier, DELETE LATER
		
//		String testuser = "Matias";
//		
//		YatzyGame testGame = new YatzyGame(testuser);
//		
//		yatzygamedao.createGame(testGame);
		
		request.getSession().setAttribute("username", username);
		
		userdao.addNewUser(registering_user);
		
		response.sendRedirect("MenuServlet");
		
		
	}

}

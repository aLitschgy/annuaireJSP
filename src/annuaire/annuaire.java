package annuaire;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



/**
 * Servlet implementation class annuaire
 */
@WebServlet("/annuaire")
public class annuaire extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@EJB
	Facade facade;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public annuaire() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String op = request.getParameter("op");
		String rue = request.getParameter("rue");
		String ville = request.getParameter("ville");
		String nom = request.getParameter("nom");
		String prenom = request.getParameter("prenom");
		String idp = request.getParameter("idp");
		String ida = request.getParameter("ida");
		
		RequestDispatcher disp;
		
		switch(op) {
			case "aAddr" :
				if (rue != null && ville != null) {
					facade.ajoutAdresse(rue, ville);
					request.getRequestDispatcher(".").forward(request, response);
				}
				break;
			case "aPers" :
				if (nom != null && prenom != null) {
					facade.ajoutPersonne(nom, prenom);
					request.getRequestDispatcher(".").forward(request, response);

				}
				break;
			case "list" :
				request.setAttribute("lp", facade.listePersonnes());
				disp = request.getRequestDispatcher("Lister.jsp");
				disp.forward(request, response);
				break;
			case "assocForm" :
				request.setAttribute("lp", facade.listePersonnes());
				request.setAttribute("la", facade.listeAdresses());
				disp = request.getRequestDispatcher("Associer.jsp");
				disp.forward(request, response);
				break;
			case "assoc" :
				if (idp != null && ida != null) {
					facade.associer(Integer.parseInt(idp), Integer.parseInt(ida));
					request.getRequestDispatcher(".").forward(request, response);

				}
				break;
		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

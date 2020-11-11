package deutscherv.boundary;

import java.io.IOException;
import java.util.Collection;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import deutscherv.entity.Merch;


@WebServlet("/warenkorbanzeige")
public class WarenkorbAnzeigen extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@Inject
	private Warenkorb warenkorb;
       
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	
		request.setAttribute("me", warenkorb); // null ist okay
		request.getRequestDispatcher("/displaymerch.jsp").forward(request, response);

	}

}
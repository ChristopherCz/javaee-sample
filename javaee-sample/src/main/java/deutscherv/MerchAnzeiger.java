package deutscherv;

import java.io.IOException;
import java.util.Collection;
import java.util.LinkedList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class MerchAnzeiger
 */
@WebServlet("/showmerch")
public class MerchAnzeiger extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	Collection<Merch> Merch = new LinkedList<>();
	Merch.add(new Merch(1,"Banner 4x4",true));
	Merch.add(new Merch(2,"LTD Tourbox",false));
	Merch.add(new Merch(3,"Shirt 'No Solace'",true));

	request.setAttribute("me", Merch);
	request.getRequestDispatcher("/displaymerch.jsp")
	.forward(request, response);
}
}

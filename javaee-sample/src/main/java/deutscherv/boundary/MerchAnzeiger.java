package deutscherv.boundary;

import java.io.IOException;
import java.util.Collection;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import deutscherv.control.Merchbestand;
import deutscherv.entity.Merch;


@WebServlet("/showmerch")
public class MerchAnzeiger extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	Collection<Merch> Merch = Merchbestand.getInstance().getMerch();
	

	request.setAttribute("me", Merch);
	request.getRequestDispatcher("/displaymerch.jsp")
	.forward(request, response);
}
}

package deutscherv.boundary;

import java.io.IOException;
import java.util.Collection;
import java.util.stream.Collectors;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import deutscherv.control.Merchbestand;
import deutscherv.entity.Merch;


@WebServlet("/artikelsuche")
public class MerchSucheServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	@Inject
	private Merchbestand bestand;
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String suchtext = request.getParameter("suchtext");
		// Validierung?
		if (null == suchtext) {

			// response.sendRedirect("suche.html");
			response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Parameter suchtext must not be null!");

		} else {

			// Logik, z.B. DB-Zugriff o.Ä.

			Collection<Merch> merch = bestand.getMerch();
			Collection<Merch> suchErgebnisse = merch.stream()
					.filter(me -> me.getName().toLowerCase().contains(suchtext.toLowerCase()))
					.collect(Collectors.toList());
							
			

			// Antwort generieren in JSP, kein PrintWriter!
			request.setAttribute("me", suchErgebnisse);
			request.getRequestDispatcher("/displaymerch.jsp").forward(request, response);
		}

	}

}

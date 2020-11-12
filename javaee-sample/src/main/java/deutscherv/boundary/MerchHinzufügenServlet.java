package deutscherv.boundary;


import java.io.IOException;
import java.util.Comparator;
import java.util.Optional;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import deutscherv.control.Merchbestand;
import deutscherv.entity.Merch;


@WebServlet("/MerchNeu")
public class MerchHinzufügenServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Inject
	private Merchbestand bestand;

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String anr = request.getParameter("artikelnr");
		String name = request.getParameter("name");
		String liefer= request.getParameter("lieferbar");
		// Konvertierung / Validierung
		int artikelnr = Integer.valueOf(anr);
		boolean lieferbar = Boolean.valueOf(liefer);
		// neue ID finden
		//Optional<Integer> max = bestand.getMerch().stream().map(Merch::getArtikelnr).max(Comparator.naturalOrder());
		// Fahrzeug einfÃ¼gen
		bestand.add(new Merch(artikelnr, name, lieferbar));
		
		// Anzeige der Fahrzeugdaten
		response.sendRedirect("showmerch");

	}

}

package deutscherv.boundary;


import java.io.IOException;
import java.io.PrintWriter;
import java.util.Comparator;
import java.util.Optional;
import java.util.Set;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.ConstraintViolation;
import javax.validation.Validator;

import deutscherv.control.Merchbestand;
import deutscherv.entity.Merch;


@WebServlet("/MerchNeu")
public class MerchHinzufügenServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Inject
	private Merchbestand bestand;
	@Inject
	private Validator validator;

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String anr = request.getParameter("artikelnr");
		String name = request.getParameter("name");
		String liefer= request.getParameter("lieferbar");
		
		if(null == anr||null==name||anr.isEmpty()||name.isEmpty()) {
			response.sendError(HttpServletResponse.SC_BAD_REQUEST);
			return;
		}
		
		// Konvertierung / Validierung
		int artikelnr;
		try {
			artikelnr = Integer.valueOf(anr);
		} catch (NumberFormatException e) {
			response.sendError(HttpServletResponse.SC_BAD_REQUEST);
			return;
		}
		boolean lieferbar = Boolean.valueOf(liefer);
		//merch object
		Merch merch = new Merch(artikelnr, name, lieferbar);
		//JSR 303 Bean Valid
		Set<ConstraintViolation<Merch>> violations = validator.validate(merch);
		if(!violations.isEmpty()) {
			// fachlicher Fehler, kein technischer Fehler
			response.setContentType("text/plain");
			try(PrintWriter out = response.getWriter()) {
				out.println("Objekt ist fehlerhaft, konnte nicht eingefügt werden");
				violations.forEach(v -> out.printf(" - %s %s%n", v.getPropertyPath(), v.getMessage()));
			}
			return;
		}
		
		// neue ID finden
		//Optional<Integer> max = bestand.getMerch().stream().map(Merch::getArtikelnr).max(Comparator.naturalOrder());
		// Fahrzeug einfÃ¼gen
		bestand.add(new Merch(artikelnr, name, lieferbar));
		
		// Anzeige der Fahrzeugdaten
		response.sendRedirect("showmerch");

	}

}

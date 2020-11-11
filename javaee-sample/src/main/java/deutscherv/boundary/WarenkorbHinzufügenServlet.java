package deutscherv.boundary;

import java.io.IOException;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import deutscherv.control.Merchbestand;
import deutscherv.entity.Merch;

@WebServlet("/warenkorbplus")
public class WarenkorbHinzufügenServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Inject
	private Merchbestand bestand;
	@Inject
	private Warenkorb warenkorb;
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String[] anrs = request.getParameterValues("artikelnr");
		if (null != anrs && anrs.length > 0) {
			
			Set<Integer> idSet = Arrays.stream(anrs).map(Integer::valueOf).collect(Collectors.toSet());
			// alles aus bestand, dessen ID in idSet (=Parameter) zu finden ist, wird in die Merkliste gepackt.
			bestand.getMerch().stream().filter(m -> idSet.contains(m.getArtikelnr())).forEach(warenkorb.getMerch()::add);
		}
		response.sendRedirect("warenkorbanzeige");
	}
}

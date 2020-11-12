package deutscherv.control;

import java.io.Serializable;

import javax.interceptor.AroundInvoke;
import javax.interceptor.Interceptor;
import javax.interceptor.InvocationContext;

import deutscherv.entity.Merch;

@MerchHandling
@Interceptor
public class MerchHandlingInterceptor implements Serializable { // fÃ¼r SessionScoped Beans

	private static final long serialVersionUID = 1L;

	@AroundInvoke
	public Object aroundInvoke(InvocationContext ic) throws Exception {

		// Suchen nach dem Parameter vom Typ Fahrzeug
		for (Object o : ic.getParameters()) {
			if (o instanceof Merch) {
				Merch m = (Merch) o;
				if (m.isLieferbar() == false) {
					System.out.println("Artikel nicht lieferbar");
				} else {
					System.out.printf("Lieferbare Artikel an Methoden übergeben. ", m.isLieferbar(),
							ic.getMethod().getName());
				}
			}
		}

		// Aufruf der Original-Methode
		return ic.proceed();

	}

}


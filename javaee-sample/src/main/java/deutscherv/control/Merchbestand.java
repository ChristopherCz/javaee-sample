package deutscherv.control;

import java.util.Collection;
import java.util.LinkedList;

import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;

import deutscherv.entity.Merch;

@MerchHandling
public class Merchbestand {
	
	private final Collection<Merch> merch = new LinkedList<>();

	// nur 1 Bestand in der Anwendung -> Singleton


	public Collection<Merch> getMerch() {
		return merch;
	}

	public boolean add(Merch e) {
		return merch.add(e);
	}

	public boolean remove(Merch o) {
		return merch.remove(o);
	}

}
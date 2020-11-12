package deutscherv.boundary;

import java.io.Serializable;
import java.util.Collection;
import java.util.Comparator;
import java.util.TreeSet;

import javax.enterprise.context.SessionScoped;

import deutscherv.entity.Merch;

@SessionScoped
public class Warenkorb implements Serializable {

	private static final long serialVersionUID = 1L;

	private final Collection<Merch> merchandise = new TreeSet<>(Comparator.comparing(Merch::getArtikelnr));

	public Collection<Merch> getMerch() {
		return merchandise;
	}
	public boolean add(Merch e) {
		return merchandise.add(e);
	}

	public boolean remove(Merch o) {
		return merchandise.remove(o);
	}
}

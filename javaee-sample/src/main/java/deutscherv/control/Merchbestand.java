package deutscherv.control;

import java.util.Collection;
import java.util.LinkedList;

import deutscherv.entity.Merch;

public class Merchbestand {

	private static final Merchbestand theInstance = new Merchbestand();
	
	private final Collection<Merch> merch = new LinkedList<>();

	// nur 1 Bestand in der Anwendung -> Singleton

	private Merchbestand() {
		merch.add(new Merch(1,"Banner 4x4",true));
		merch.add(new Merch(2,"LTD Tourbox",false));
		merch.add(new Merch(3,"Shirt 'No Solace'",true));
	}

	public Collection<Merch> getMerch() {
		return merch;
	}

	public boolean add(Merch e) {
		return merch.add(e);
	}

	public boolean remove(Merch o) {
		return merch.remove(o);
	}

	public static Merchbestand getInstance() {
		return theInstance;
	}
}
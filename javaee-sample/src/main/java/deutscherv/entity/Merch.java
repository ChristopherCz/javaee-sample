package deutscherv.entity;

import java.io.Serializable;

public class Merch implements Serializable {
	
	private static final long serialVersionUID = 1L;
	private int artikelnr;
	private String name;
	private boolean lieferbar;
	
	
	public Merch() {
		super();
	}
	public Merch( int artikelnr, String name, boolean lieferbar) {
		super();
		this.artikelnr=artikelnr;
		this.name=name;
		this.lieferbar=lieferbar;
	}
	
	public int getArtikelnr() {
		return artikelnr;
	}
	public void setArtikelnr(int artikelnr) {
		this.artikelnr = artikelnr;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public boolean isLieferbar() {
		return lieferbar;
	}
	public void setLieferbar(boolean lieferbar) {
		this.lieferbar = lieferbar;
	}
	
	
}

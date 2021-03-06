package deutscherv.entity;

import java.io.Serializable;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class Merch implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	
	@Min(1)
	private int artikelnr;
	@Size(min = 4)
	@NotNull
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

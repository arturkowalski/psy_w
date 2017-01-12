package kolejki;

import java.util.LinkedList;
import smo.Zgloszenie;

public final class KolejkaLifoOgrNpr implements KolejkaI {
	private final LinkedList<Zgloszenie> bufor;
	private int dlugosc;
	
	public KolejkaLifoOgrNpr(final int dlugosc) {
		if (dlugosc <= 0) {
			throw new IllegalArgumentException("\nDlugosc mniejsza niz 1");
		}
		
		bufor = new LinkedList<>();
		this.dlugosc = dlugosc;
	}
	
	public int dlugosc() {
		return dlugosc;
	}
	
	public boolean kolejkaPelna() {
		return bufor.size() == dlugosc;
	}
	
	public boolean kolejkaPusta() {
		return bufor.isEmpty();
	}
	
	public int stan() {
		return bufor.size();
	}
	
	public void wstaw(final Zgloszenie zgloszenie) throws KolejkaPelnaWyj {
		if (kolejkaPelna()) {
			throw new KolejkaPelnaWyj(dlugosc, zgloszenie);
		}
		
		bufor.add(zgloszenie);
	}
	
	public Zgloszenie nastepne() throws KolejkaPustaWyj {
		if (kolejkaPusta()) {
			throw new KolejkaPustaWyj();
		}
		
		return bufor.getLast();
	}
	
	public Zgloszenie usun() throws KolejkaPustaWyj {
		if (kolejkaPusta()) {
			throw new KolejkaPustaWyj();
		}
		
		return bufor.removeLast();
	}
	
	public void usunWybrane(final Zgloszenie zgloszenie) throws KolejkaPustaWyj {
		if (kolejkaPusta()) {
			throw new KolejkaPustaWyj();
		}
		
		bufor.remove(zgloszenie);
	}
}

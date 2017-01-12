package kolejki;

import java.util.LinkedList;
import smo.Zgloszenie;

public final class KolejkaLifoNogrNpr implements KolejkaI {
	private final LinkedList<Zgloszenie> bufor;
	
	public KolejkaLifoNogrNpr() {
		bufor = new LinkedList<>();
	}
	
	public boolean kolejkaPusta() {
		return bufor.isEmpty();
	}
	
	public int stan() {
		return bufor.size();
	}
	
	public void wstaw(final Zgloszenie zgloszenie) throws KolejkaPelnaWyj {
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

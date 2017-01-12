package kolejki;

import java.util.LinkedList;
import smo.Zgloszenie;

public final class KolejkaFifoNogrNpr implements KolejkaI {
	private final LinkedList<Zgloszenie> bufor;
	
	public KolejkaFifoNogrNpr() {
		bufor = new LinkedList<>();
	}
	
	public KolejkaFifoNogrNpr(int dlugoscPoczatkowa) {
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
		
		return bufor.getFirst();
	}
	
	public Zgloszenie usun() throws KolejkaPustaWyj {
		if (kolejkaPusta()) {
			throw new KolejkaPustaWyj();
		}
		
		return bufor.removeFirst();
	}
	
	public void usunWybrane(final Zgloszenie zgloszenie) throws KolejkaPustaWyj {
		if (kolejkaPusta()) {
			throw new KolejkaPustaWyj();
		}
		
		bufor.remove(zgloszenie);
	}
}

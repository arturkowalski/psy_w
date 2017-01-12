package kolejki;

import java.util.PriorityQueue;
import java.util.Comparator;
import smo.Zgloszenie;

public class KolejkaFifoNogrPr implements KolejkaI {
	private final PriorityQueue<Zgloszenie> bufor;
	private final Comparator<Zgloszenie> komparator;
	
	public KolejkaFifoNogrPr() {
		komparator = Zgloszenie.komparatorFifo();
		bufor = new PriorityQueue<>(komparator);
	}
	
	public boolean kolejkaPusta() {
		return bufor.isEmpty();
	}
	
	public int stan() {
		return bufor.size();
	}
	
	public void wstaw(final Zgloszenie zgloszenie) {
		bufor.add(zgloszenie);
	}
	
	public Zgloszenie nastepne() throws KolejkaPustaWyj {
		if (kolejkaPusta()) {
			throw new KolejkaPustaWyj();
		}
		
		return bufor.peek();
	}
	
	public Zgloszenie usun() throws KolejkaPustaWyj {
		if (kolejkaPusta()) {
			throw new KolejkaPustaWyj();
		}
		
		return bufor.poll();
	}
	
	public void usunWybrane(final Zgloszenie zgloszenie) throws KolejkaPustaWyj {
		if (kolejkaPusta()) {
			throw new KolejkaPustaWyj();
		}
		
		bufor.remove(zgloszenie);
	}
}

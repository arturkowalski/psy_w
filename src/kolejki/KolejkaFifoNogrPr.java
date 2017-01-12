package kolejki;

import java.util.PriorityQueue;
import java.util.Comparator;
import smo.Zgloszenie;

public class KolejkaFifoNogrPr implements KolejkaI {
	private final PriorityQueue<Zgloszenie> bufor;
	private static final Comparator<Zgloszenie> komparator;
	
	static {
		komparator = Zgloszenie.komparatorFifo();
	}
	
	public KolejkaFifoNogrPr() {
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
	
	public Zgloszenie nastepne() {
		if (kolejkaPusta()) {
			throw new IllegalStateException("\nKolejka pusta");
		}
		
		return bufor.peek();
	}
	
	public Zgloszenie usun() {
		if (kolejkaPusta()) {
			throw new IllegalStateException("\nKolejka pusta");
		}
		
		return bufor.poll();
	}
	
	public void usunWybrane(final Zgloszenie zgloszenie) {
		if (kolejkaPusta()) {
			throw new IllegalStateException("\nKolejka pusta");
		}
		
		bufor.remove(zgloszenie);
	}
}

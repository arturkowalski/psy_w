import java.util.PriorityQueue;
import java.util.Comparator;

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
			throw new IllegalStateException("\nKolejkaFifoNogrPr - kolejka pusta");
		}
		
		return bufor.peek();
	}
	
	public Zgloszenie usun() {
		if (kolejkaPusta()) {
			throw new IllegalStateException("\nKolejkaFifoNogrPr - kolejka pusta");
		}
		
		return bufor.poll();
	}
	
	public void usunWybrane(final Zgloszenie zgloszenie) {
		if (kolejkaPusta()) {
			throw new IllegalStateException("\nKolejkaFifoNogrPr - kolejka pusta");
		}
		
		bufor.remove(zgloszenie);
	}
}

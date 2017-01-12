import java.util.PriorityQueue;
import java.util.Comparator;

public class KolejkaFifoOgrPr implements KolejkaI {
	private final PriorityQueue<Zgloszenie> bufor;
	private static final Comparator<Zgloszenie> komparator;
	private int dlugosc;
	
	static {
		komparator = Zgloszenie.komparatorFifo();
	}
	
	public KolejkaFifoOgrPr(final int dlugosc) {
		if (dlugosc <= 0) {
			throw new IllegalArgumentException("\nKolejkaFifoOgrPr - dlugosc mniejsza niz 1");
		}
		
		bufor = new PriorityQueue<>(dlugosc, komparator);
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
	
	public void wstaw(final Zgloszenie zgloszenie) {
		if (kolejkaPelna()) {
			throw new IllegalStateException("\nKolejkaFifoOgrPr - kolejka pelna");
		}
		
		bufor.add(zgloszenie);
	}
	
	public Zgloszenie nastepne() {
		if (kolejkaPusta()) {
			throw new IllegalStateException("\nKolejkaFifoOgrPr - kolejka pusta");
		}
		
		return bufor.peek();
	}
	
	public Zgloszenie usun() {
		if (kolejkaPusta()) {
			throw new IllegalStateException("\nKolejkaFifoOgrPr - kolejka pusta");
		}
		
		return bufor.poll();
	}
	
	public void usunWybrane(final Zgloszenie zgloszenie) {
		if (kolejkaPusta()) {
			throw new IllegalStateException("\nKolejkaFifoOgrPr - kolejka pusta");
		}
		
		bufor.remove(zgloszenie);
	}
}

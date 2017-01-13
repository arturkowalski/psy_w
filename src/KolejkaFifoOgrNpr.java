import java.util.LinkedList;

public final class KolejkaFifoOgrNpr implements KolejkaI {
	private final LinkedList<Zgloszenie> bufor;
	private int dlugosc;
	
	public KolejkaFifoOgrNpr(final int dlugosc) {
		if (dlugosc <= 0) {
			throw new IllegalArgumentException("KolejkaFifoOgrNpr - dlugosc mniejsza niz 1");
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
	
	public void wstaw(final Zgloszenie zgloszenie) {
		if (kolejkaPelna()) {
			throw new IllegalStateException("KolejkaFifoOgrNpr - kolejka pelna");
		}
		
		bufor.add(zgloszenie);
	}
	
	public Zgloszenie nastepne() {
		if (kolejkaPusta()) {
			throw new IllegalStateException("KolejkaFifoOgrNpr - kolejka pusta");
		}
		
		return bufor.getFirst();
	}
	
	public Zgloszenie usun() {
		if (kolejkaPusta()) {
			throw new IllegalStateException("KolejkaFifoOgrNpr - kolejka pusta");
		}
		
		return bufor.removeFirst();
	}
	
	public void usunWybrane(final Zgloszenie zgloszenie) {
		if (kolejkaPusta()) {
			throw new IllegalStateException("KolejkaFifoOgrNpr - kolejka pusta");
		}
		
		bufor.remove(zgloszenie);
	}
}

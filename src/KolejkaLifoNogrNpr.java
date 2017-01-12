import java.util.LinkedList;

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
	
	public void wstaw(final Zgloszenie zgloszenie) {
		bufor.add(zgloszenie);
	}
	
	public Zgloszenie nastepne() {
		if (kolejkaPusta()) {
			throw new IllegalStateException("\nKolejka pusta");
		}
		
		return bufor.getLast();
	}
	
	public Zgloszenie usun() {
		if (kolejkaPusta()) {
			throw new IllegalStateException("\nKolejka pusta");
		}
		
		return bufor.removeLast();
	}
	
	public void usunWybrane(final Zgloszenie zgloszenie) {
		if (kolejkaPusta()) {
			throw new IllegalStateException("\nKolejka pusta");
		}
		
		bufor.remove(zgloszenie);
	}
}

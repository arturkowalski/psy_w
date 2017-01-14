import java.util.LinkedList;

final class KolejkaLifoNogrNpr implements KolejkaI {
	private final LinkedList<Zgloszenie> bufor;
	
	KolejkaLifoNogrNpr() {
		bufor = new LinkedList<>();
	}
	
	public String typ() {
		return "KOLEJKA_LIFO_NOGR_NPR";
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
			throw new IllegalStateException("Kolejka pusta");
		}
		
		return bufor.getLast();
	}
	
	public Zgloszenie usun() {
		if (kolejkaPusta()) {
			throw new IllegalStateException("Kolejka pusta");
		}
		
		return bufor.removeLast();
	}
	
	public void usunWybrane(final Zgloszenie zgloszenie) {
		if (kolejkaPusta()) {
			throw new IllegalStateException("Kolejka pusta");
		}
		
		bufor.remove(zgloszenie);
	}
}

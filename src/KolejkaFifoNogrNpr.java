import java.util.LinkedList;

final class KolejkaFifoNogrNpr implements KolejkaI {
	private final LinkedList<Zgloszenie> bufor;
	
	KolejkaFifoNogrNpr() {
		bufor = new LinkedList<>();
	}
	
	public String typ() {
		return "KOLEJKA_FIFO_NOGR_NPR";
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
		
		return bufor.getFirst();
	}
	
	public Zgloszenie usun() {
		if (kolejkaPusta()) {
			throw new IllegalStateException("Kolejka pusta");
		}
		
		return bufor.removeFirst();
	}
	
	public void usunWybrane(final Zgloszenie zgloszenie) {
		if (kolejkaPusta()) {
			throw new IllegalStateException("Kolejka pusta");
		}
		
		bufor.remove(zgloszenie);
	}
}

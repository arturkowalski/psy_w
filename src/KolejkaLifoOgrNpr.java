import java.util.LinkedList;

public final class KolejkaLifoOgrNpr implements KolejkaI {
	private final LinkedList<Zgloszenie> bufor;
	private int dlugosc;
	
	public KolejkaLifoOgrNpr(final int dlugosc) {
		if (dlugosc <= 0) {
			throw new IllegalArgumentException("\nKolejkaLifoOgrNpr - dlugosc mniejsza niz 1");
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
			throw new IllegalStateException("\nKolejkaLifoOgrNpr - kolejka pelna");
		}
		
		bufor.add(zgloszenie);
	}
	
	public Zgloszenie nastepne() {
		if (kolejkaPusta()) {
			throw new IllegalStateException("\nKolejkaLifoOgrNpr - kolejka pusta");
		}
		
		return bufor.getLast();
	}
	
	public Zgloszenie usun() {
		if (kolejkaPusta()) {
			throw new IllegalStateException("\nKolejkaLifoOgrNpr - kolejka pusta");
		}
		
		return bufor.removeLast();
	}
	
	public void usunWybrane(final Zgloszenie zgloszenie) {
		if (kolejkaPusta()) {
			throw new IllegalStateException("\nKolejkaLifoOgrNpr - kolejka pusta");
		}
		
		bufor.remove(zgloszenie);
	}
}

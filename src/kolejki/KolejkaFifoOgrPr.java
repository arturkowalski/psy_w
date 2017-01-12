package kolejki;

import java.util.PriorityQueue;
import java.util.Comparator;
import smo.Zgloszenie;

public class KolejkaFifoOgrPr implements KolejkaI {
	private final PriorityQueue<Zgloszenie> bufor;
	private final Comparator<Zgloszenie> komparator;
	private int dlugosc;
	
	public KolejkaFifoOgrPr(final int dlugosc) {
		if (dlugosc <= 0) {
			throw new IllegalArgumentException("\nDlugosc mniejsza niz 1");
		}
		
		komparator = Zgloszenie.komparatorFifo();
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
	
	public void wstaw(final Zgloszenie zgloszenie) throws KolejkaPelnaWyj {
		if (kolejkaPelna()) {
			throw new KolejkaPelnaWyj(dlugosc, zgloszenie);
		}
		
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

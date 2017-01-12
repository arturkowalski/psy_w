package kolejki;

import smo.Zgloszenie;

public interface KolejkaI {
	default int dlugosc() {
		throw new UnsupportedOperationException("\nDlugosc bufora niedostepna");
	}
	
	default boolean kolejkaPelna() {
		throw new UnsupportedOperationException("\nKolejka nie moze byc pelna");
	}
	
	boolean kolejkaPusta();
	
	int stan();
	
	void wstaw(final Zgloszenie zgloszenie) throws KolejkaPelnaWyj;
	
	Zgloszenie nastepne() throws KolejkaPustaWyj;
	Zgloszenie usun() throws KolejkaPustaWyj;
	
	void usunWybrane(Zgloszenie zgloszenie) throws KolejkaPustaWyj;
}

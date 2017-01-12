public interface KolejkaI {
	default int dlugosc() {
		throw new UnsupportedOperationException("\nKolejkaI - metoda dlugosc() niedostepna");
	}
	
	default boolean kolejkaPelna() {
		throw new UnsupportedOperationException("\nKolejkaI - metoda kolejkaPelna niedostepna");
	}
	
	boolean kolejkaPusta();
	
	int stan();
	
	void wstaw(final Zgloszenie zgloszenie);
	
	Zgloszenie nastepne();
	
	Zgloszenie usun();
	
	void usunWybrane(final Zgloszenie zgloszenie);
}

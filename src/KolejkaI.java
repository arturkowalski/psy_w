public interface KolejkaI {
	default int dlugosc() {
		throw new UnsupportedOperationException("\nKolejkaI - metoda dlugosc() niedostepna");
	}
	
	default boolean kolejkaPelna() {
		return false;
	}
	
	boolean kolejkaPusta();
	
	int stan();
	
	void wstaw(final Zgloszenie zgloszenie);
	
	Zgloszenie nastepne();
	
	Zgloszenie usun();
	
	void usunWybrane(final Zgloszenie zgloszenie);
}

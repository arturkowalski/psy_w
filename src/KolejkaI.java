interface KolejkaI {
	default int dlugosc() {
		throw new UnsupportedOperationException("Metoda dlugosc() niedostepna");
	}
	
	default boolean kolejkaPelna() {
		return false;
	}
	
	String typ();
	
	boolean kolejkaPusta();
	
	int stan();
	
	void wstaw(final Zgloszenie zgloszenie);
	
	Zgloszenie nastepne();
	
	Zgloszenie usun();
	
	void usunWybrane(final Zgloszenie zgloszenie);
}

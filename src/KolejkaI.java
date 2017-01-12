public interface KolejkaI {
	default int dlugosc() {
		throw new UnsupportedOperationException("\nDlugosc bufora niedostepna");
	}
	
	default boolean kolejkaPelna() {
		throw new UnsupportedOperationException("\nDlugosc kolejki nieograniczona");
	}
	
	boolean kolejkaPusta();
	
	int stan();
	
	void wstaw(final Zgloszenie zgloszenie);
	
	Zgloszenie nastepne();
	
	Zgloszenie usun();
	
	void usunWybrane(final Zgloszenie zgloszenie);
}

public interface KolejkaI {
	default int dlugosc() {
		throw new UnsupportedOperationException("\nDlugosc bufora ukryta");
	}
	
	default boolean kolejkaPelna() {
		throw new UnsupportedOperationException("\nKolejka nie moze byc pelna");
	}
	
	boolean kolejkaPusta();
	
	int stan();
	
	void wstaw(final Zgloszenie zgloszenie);
	
	Zgloszenie nastepne();
	
	Zgloszenie usun();
	
	void usunWybrane(Zgloszenie zgloszenie);
}

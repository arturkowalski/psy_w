import dissimlab.simcore.BasicSimObj;
import dissimlab.simcore.SimControlException;
import dissimlab.broker.IPublisher;
import dissimlab.broker.INotificationEvent;

final class Smo extends BasicSimObj {
	private static final String[] typyKolejek;
	private final KolejkaI kolejka;
	private boolean gniazdoWolne;
	ObslugaPoczatek obslugaPoczatek;
	ObslugaKoniec obslugaKoniec;
	Utylizator utylizator;
	
	static {
		Kolejka[] kolejki = Kolejka.values();
		typyKolejek = new String[kolejki.length];
		
		for (int i = 0; i < typyKolejek.length; ++i) {
			typyKolejek[i] = kolejki[i].name();
		}
	}
	
	Smo(String typKolejki) throws SimControlException {
		if (typKolejki == null) {
			throw new IllegalArgumentException("Typ kolejki rowny null");
		}
		
		int i = 0;
		
		for ( ; i < typyKolejek.length; ++i) {
			if (typKolejki.equals(typyKolejek[i])) {
				break;
			}
		}
		
		if (i == typyKolejek.length) {
			throw new IllegalArgumentException("Typ kolejki bledny");
		}
		
		kolejka = Kolejka.stworz(typKolejki);
		gniazdoWolne = true;
		utylizator = new Utylizator();
	}
	
	Smo(String typKolejki, int dlugosc) throws SimControlException {
		if (typKolejki == null) {
			throw new IllegalArgumentException("Typ kolejki rowny null");
		}
		
		if (dlugosc <= 0) {
			throw new IllegalArgumentException("Dlugosc mniejsza niz 1");
		}
		
		kolejka = Kolejka.stworz(typKolejki, dlugosc);
		gniazdoWolne = true;
		utylizator = new Utylizator();
	}
	
	public boolean filter(IPublisher publisher, INotificationEvent event) {
		return false;
	}
	
	public void reflect(IPublisher publisher, INotificationEvent event) {}
	
	boolean gniazdoWolne() {
		return gniazdoWolne;
	}
	
	void zwolnijZablokuj(boolean zablokujZwolnij) {
		this.gniazdoWolne = zablokujZwolnij;
	}
	
	boolean kolejkaPelna() {
		return kolejka.kolejkaPelna();
	}
	
	int stan() {
		return kolejka.stan();
	}
	
	void wstaw(Zgloszenie zgloszenie) {
		kolejka.wstaw(zgloszenie);
	}
	
	Zgloszenie usun() {
		return kolejka.usun();
	}
	
	void usunWybrane(Zgloszenie zgloszenie) {
		kolejka.usunWybrane(zgloszenie);
		utylizator.zapamietaj();
	}
	
	int odrzucone() {
		return utylizator.odrzucone();
	}
}

import dissimlab.simcore.BasicSimObj;
import dissimlab.simcore.SimControlException;
import dissimlab.broker.IPublisher;
import dissimlab.broker.INotificationEvent;

public final class Smo extends BasicSimObj {
	private static final String[] typyKolejek;
	private final KolejkaI kolejka;
	private boolean gniazdoWolne;
	ObslugaPoczatek obslugaPoczatek;
	ObslugaKoniec obslugaKoniec;
	private Utylizator utylizator;
	
	static {
		Kolejka[] kolejki = Kolejka.values();
		typyKolejek = new String[kolejki.length];
		
		for (int i = 0; i < typyKolejek.length; ++i) {
			typyKolejek[i] = kolejki[i].name();
		}
	}
	
	public Smo(String typKolejki) throws SimControlException {
		if (typKolejki == null) {
			throw new IllegalArgumentException("Smo - typ kolejki rowny null");
		}
		
		int i = 0;
		
		for ( ; i < typyKolejek.length; ++i) {
			if (typKolejki.equals(typyKolejek[i])) {
				break;
			}
		}
		
		if (i == typyKolejek.length) {
			throw new IllegalArgumentException("Smo - typ kolejki bledny");
		}
		
		kolejka = Kolejka.stworz(typKolejki);
		gniazdoWolne = true;
		utylizator = new Utylizator();
	}
	
	public Smo(String typKolejki, int dlugosc) throws SimControlException {
		if (typKolejki == null) {
			throw new IllegalArgumentException("Smo - typ kolejki rowny null");
		}
		
		if (dlugosc <= 0) {
			throw new IllegalArgumentException("Smo - dlugosc mniejsza niz 1");
		}
		
		kolejka = Kolejka.stworz(typKolejki, dlugosc);
		gniazdoWolne = true;
		utylizator = new Utylizator();
	}
	
	public boolean filter(IPublisher publisher, INotificationEvent event) {
		return false;
	}
	
	public void reflect(IPublisher publisher, INotificationEvent event) {}
	
	public boolean gniazdoWolne() {
		return gniazdoWolne;
	}
	
	public void zwolnijZablokuj(boolean zablokujZwolnij) {
		this.gniazdoWolne = zablokujZwolnij;
	}
	
	public boolean kolejkaPelna() {
		return kolejka.kolejkaPelna();
	}
	
	public int stan() {
		return kolejka.stan();
	}
	
	public void wstaw(Zgloszenie zgloszenie) {
		kolejka.wstaw(zgloszenie);
	}
	
	public Zgloszenie usun() {
		return kolejka.usun();
	}
	
	public void usunWybrane(Zgloszenie zgloszenie) {
		kolejka.usunWybrane(zgloszenie);
		utylizator.zapamietaj();
	}
	
	public int odrzucone() {
		return utylizator.odrzucone();
	}
}

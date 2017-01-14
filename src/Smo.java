import dissimlab.simcore.BasicSimObj;
import dissimlab.simcore.SimControlException;
import dissimlab.broker.IPublisher;
import dissimlab.broker.INotificationEvent;
import dissimlab.monitors.MonitoredVar;

final class Smo extends BasicSimObj {
	private static final String[] typyKolejek;
	private final KolejkaI kolejka;
	private boolean gniazdoWolne;
	ObslugaPoczatek obslugaPoczatek;
	ObslugaKoniec obslugaKoniec;
	MonitoredVar czasOczekiwania, dlugoscKolejki;
	double prawdopodobienstwo;
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
			throw new IllegalArgumentException("Typ kolejki nierozpoznany");
		}
		
		kolejka = Kolejka.stworz(typKolejki);
		gniazdoWolne = true;
		czasOczekiwania = new MonitoredVar();
		dlugoscKolejki = new MonitoredVar();
		utylizator = new Utylizator();
	}
	
	Smo(String typKolejki, int dlugosc) throws SimControlException {
		if (dlugosc <= 0) {
			throw new IllegalArgumentException("Dlugosc mniejsza niz 1");
		}
		
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
			throw new IllegalArgumentException("Typ kolejki nierozpoznany");
		}
		
		kolejka = Kolejka.stworz(typKolejki, dlugosc);
		gniazdoWolne = true;
		czasOczekiwania = new MonitoredVar();
		dlugoscKolejki = new MonitoredVar();
		utylizator = new Utylizator();
	}
	
	Smo(String typKolejki, int dlugosc, double prawdopodobienstwo) throws SimControlException {
		if (dlugosc <= 0) {
			throw new IllegalArgumentException("Dlugosc mniejsza niz 1");
		}
		
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
			throw new IllegalArgumentException("Typ kolejki nierozpoznany");
		}
		
		kolejka = Kolejka.stworz(typKolejki, dlugosc);
		gniazdoWolne = true;
		czasOczekiwania = new MonitoredVar();
		dlugoscKolejki = new MonitoredVar();
		this.prawdopodobienstwo = prawdopodobienstwo;
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
	
	int dlugosc() {
		return kolejka.dlugosc();
	}
	
	String typ() {
		return kolejka.typ();
	}
	
	boolean kolejkaPelna() {
		return kolejka.kolejkaPelna();
	}
	
	int stan() {
		return kolejka.stan();
	}
	
	void wstaw(Zgloszenie zgloszenie) {
		kolejka.wstaw(zgloszenie);
		dlugoscKolejki.setValue(kolejka.stan(), simTime());
	}
	
	Zgloszenie usun() {
		Zgloszenie z = kolejka.usun();
		dlugoscKolejki.setValue(kolejka.stan(), simTime());
		return z;
	}
	
	void usunWybrane(Zgloszenie zgloszenie) {
		kolejka.usunWybrane(zgloszenie);
		dlugoscKolejki.setValue(kolejka.stan(), simTime());
		utylizator.zapamietaj();
	}
	
	int odrzucone() {
		return utylizator.odrzucone();
	}
}

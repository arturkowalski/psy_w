package smo;

import dissimlab.simcore.BasicSimObj;
import dissimlab.simcore.SimControlException;
import dissimlab.broker.IPublisher;
import dissimlab.broker.INotificationEvent;
import kolejki.KolejkaI;
import kolejki.Kolejka;

public final class Smo extends BasicSimObj {
	private final KolejkaI kolejka;
	private boolean gniazdoWolne;
	ObslugaPoczatek obslugaPoczatek;
	ObslugaKoniec obslugaKoniec;
	private Utylizator utylizator;
	
	public Smo(String typKolejki) throws SimControlException {
		kolejka = Kolejka.stworz(typKolejki);
		gniazdoWolne = true;
		utylizator = new Utylizator();
	}
	
	public Smo(String typKolejki, int dlugosc) throws SimControlException {
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
	
	public int stan() {
		return kolejka.stan();
	}
	
	public int odrzucone() {
		return utylizator.odrzucone();
	}
}

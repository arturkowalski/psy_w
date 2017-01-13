import dissimlab.simcore.BasicSimEvent;
import dissimlab.simcore.SimControlException;

final class OkresNiecierpliwieniaKoniec extends BasicSimEvent<Zgloszenie, Object> {
	private Zgloszenie zgloszenieMatka;
	
	OkresNiecierpliwieniaKoniec(Zgloszenie zgloszenieMatka, double odstep) throws SimControlException {
		super(zgloszenieMatka, odstep);
		this.zgloszenieMatka = zgloszenieMatka;
	}
	
	OkresNiecierpliwieniaKoniec(Zgloszenie zgloszenieMatka) throws SimControlException {
		super(zgloszenieMatka);
		this.zgloszenieMatka = zgloszenieMatka;
	}
	
	protected void stateChange() throws SimControlException {
		System.out.printf("%017.9f: Koniec okresu niecierpliwosci zgloszenia numer %d (priorytet rowny %d)\n",
			simTime(), zgloszenieMatka.numer(), zgloszenieMatka.priorytet());
		
		zgloszenieMatka.smo.usunWybrane(zgloszenieMatka);
		System.out.printf("%017.9f: Zgloszenie numer %d usuniete\n", simTime(), zgloszenieMatka.numer());
	}
	
	protected void onInterruption() throws SimControlException {
		System.out.printf("%017.9f: Zgloszenie numer %d poza okresem niecierpliwosci\n",
			simTime(), zgloszenieMatka.numer());
	}
	
	public Object getEventParams() {
		return null;
	}
	
	protected void onTermination() throws SimControlException {}
}

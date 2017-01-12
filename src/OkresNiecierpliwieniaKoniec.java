import dissimlab.simcore.BasicSimEvent;
import dissimlab.simcore.SimControlException;

public final class OkresNiecierpliwieniaKoniec extends BasicSimEvent<Zgloszenie, Object> {
	private Zgloszenie zgloszenieMatka;
	
	public OkresNiecierpliwieniaKoniec(Zgloszenie zgloszenieMatka, double odstep) throws SimControlException {
		super(zgloszenieMatka, odstep);
		this.zgloszenieMatka = zgloszenieMatka;
	}
	
	public OkresNiecierpliwieniaKoniec(Zgloszenie zgloszenieMatka) throws SimControlException {
		super(zgloszenieMatka);
		this.zgloszenieMatka = zgloszenieMatka;
	}
	
	protected void stateChange() throws SimControlException {
		System.out.printf("%016.9f: koniec okresu niecierpliwienia zgloszenia numer %d (priorytet rowny %d)\n",
			simTime(), zgloszenieMatka.numer(), zgloszenieMatka.priorytet());
		
		zgloszenieMatka.smo.usunWybrane(zgloszenieMatka);
		System.out.printf("%016.9f: zgloszenie numer %d usuniete\n", simTime(), zgloszenieMatka.numer());
	}
	
	protected void onInterruption() throws SimControlException {
		System.out.printf("%016.9f: zgloszenie numer %d poza okresem niecierpliwienia\n",
			simTime(), zgloszenieMatka.numer());
	}
	
	public Object getEventParams() {
		return null;
	}
	
	protected void onTermination() throws SimControlException {}
}
import dissimlab.simcore.BasicSimEvent;
import dissimlab.simcore.SimEventSemaphore;
import dissimlab.simcore.SimControlException;

public final class ObslugaKoniec extends BasicSimEvent<Smo, Zgloszenie> {
	private final Smo smoMatka;
	
	public ObslugaKoniec(Smo parent, double odstep, Zgloszenie zgloszenie) throws SimControlException {
		super(parent, odstep, zgloszenie);
		this.smoMatka = parent;
	}
	
	public ObslugaKoniec(Smo smo, SimEventSemaphore semafor, Zgloszenie zgloszenie) throws SimControlException {
		super(smo, semafor, zgloszenie);
		this.smoMatka = smo;
	}
	
	protected void stateChange() throws SimControlException {
		smoMatka.zwolnijZablokuj(true);
		System.out.printf("%016.9f: Obsluga zgloszenia numer %d zakonczona\n", simTime(), transitionParams.numer());
		
		if (smoMatka.stan() > 0) {
			smoMatka.obslugaPoczatek = new ObslugaPoczatek(smoMatka);
		}
	}
	
	public Object getEventParams() {
		return null;
	}
	
	protected void onInterruption() throws SimControlException {}
	
	protected void onTermination() throws SimControlException {}
}

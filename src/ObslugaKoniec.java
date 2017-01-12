import dissimlab.simcore.BasicSimEvent;
import dissimlab.simcore.SimEventSemaphore;
import dissimlab.simcore.SimControlException;

public final class ObslugaKoniec extends BasicSimEvent<Smo, Zgloszenie> {
	private final Smo smoMatka;
	
	public ObslugaKoniec(Smo parent, double delay, Zgloszenie zgl) throws SimControlException {
		super(parent, delay, zgl);
		this.smoMatka = parent;
	}
	
	public ObslugaKoniec(Smo parent, SimEventSemaphore semafor, Zgloszenie zgl) throws SimControlException {
		super(parent, semafor, zgl);
		this.smoMatka = parent;
	}
	
	protected void stateChange() throws SimControlException {
		smoMatka.zwolnijZablokuj(true);
		System.out.printf("%016.9f: obsluga zgloszenia numer %d zakonczona\n", simTime(), transitionParams.numer());
		
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

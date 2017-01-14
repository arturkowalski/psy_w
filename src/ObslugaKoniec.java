import dissimlab.simcore.BasicSimEvent;
import dissimlab.simcore.SimEventSemaphore;
import dissimlab.simcore.SimControlException;

final class ObslugaKoniec extends BasicSimEvent<Smo, Zgloszenie> {
	private final Smo smoMatka;
	
	ObslugaKoniec(Smo parent, double odstep, Zgloszenie zgloszenie) throws SimControlException {
		super(parent, odstep, zgloszenie);
		this.smoMatka = parent;
	}
	
	ObslugaKoniec(Smo smo, SimEventSemaphore semafor, Zgloszenie zgloszenie) throws SimControlException {
		super(smo, semafor, zgloszenie);
		this.smoMatka = smo;
	}
	
	protected void stateChange() throws SimControlException {
		smoMatka.zwolnijZablokuj(true);
		System.out.printf("%017.9f: Obsluga zgloszenia numer %d zakonczona\n", simTime(), transitionParams.numer());
		
		double t = Math.random();
		
		if (t >= smoMatka.prawdopodobienstwo) {
			Zgloszenie z = new Zgloszenie(transitionParams.numer(), simTime(), transitionParams.priorytet(),
				smoMatka);
			
			smoMatka.wstaw(z);
			System.out.printf("%017.9f: Powrot zgloszenia %d na koniec kolejki\n\n", simTime(), transitionParams.numer());
		}
		
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

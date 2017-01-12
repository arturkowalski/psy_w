import dissimlab.simcore.BasicSimEvent;
import dissimlab.simcore.SimControlException;
import dissimlab.random.SimGenerator;

public class ObslugaPoczatek extends BasicSimEvent<Smo, Zgloszenie> {
	private final Smo smoMatka;
	private final SimGenerator generator;
	
	public ObslugaPoczatek(Smo smoMatka, double odstep) throws SimControlException {
		super(smoMatka, odstep);
		this.smoMatka = smoMatka;
		generator = new SimGenerator();
	}
	
	public ObslugaPoczatek(Smo smoMatka) throws SimControlException {
		super(smoMatka);
		this.smoMatka = smoMatka;
		generator = new SimGenerator();
	}
	
	protected void stateChange() throws SimControlException {
		if (smoMatka.stan() > 0) {
			smoMatka.zwolnijZablokuj(false);
			Zgloszenie z = smoMatka.usun();
			z.okresNiecierpliwieniaKoniec.interrupt();
			double czasObslugi = generator.normal(9.0, 1.0);
			System.out.printf("%016.9f: obsluga zgloszenia numer %d rozpoczeta (priorytet rowny %d)\n",
				simTime(), z.numer(), z.priorytet());
			
			smoMatka.obslugaKoniec = new ObslugaKoniec(smoMatka, czasObslugi, z);
		}
	}
	
	public Object getEventParams() {
		return null;
	}
	
	protected void onInterruption() throws SimControlException {}
	
	protected void onTermination() throws SimControlException {}
}

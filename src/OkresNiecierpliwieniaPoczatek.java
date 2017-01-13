import dissimlab.simcore.BasicSimEvent;
import dissimlab.simcore.SimControlException;
import dissimlab.random.SimGenerator;

public final class OkresNiecierpliwieniaPoczatek extends BasicSimEvent<Zgloszenie, Object> {
	private Zgloszenie zgloszenieMatka;
	private SimGenerator generator;
	
	public OkresNiecierpliwieniaPoczatek(Zgloszenie zgloszenieMatka, double odstep) throws SimControlException {
		super(zgloszenieMatka, odstep);
		this.zgloszenieMatka = zgloszenieMatka;
		generator = new SimGenerator();
	}
	
	public OkresNiecierpliwieniaPoczatek(Zgloszenie zgloszenieMatka) throws SimControlException {
		super(zgloszenieMatka);
		this.zgloszenieMatka = zgloszenieMatka;
		generator = new SimGenerator();
	}
	
	protected void stateChange() throws SimControlException {
		System.out.printf("%016.9f: Zgloszenie numer %d w okresie niecierpliwosci (priorytet rowny %d)\n",
			simTime(), zgloszenieMatka.numer(), zgloszenieMatka.priorytet());
		
		zgloszenieMatka.okresNiecierpliwieniaKoniec = new OkresNiecierpliwieniaKoniec(zgloszenieMatka, generator.normal(15.0, 1.0));
	}
	
	public Object getEventParams() {
		return null;
	}
	
	protected void onInterruption() throws SimControlException {}
	
	protected void onTermination() throws SimControlException {}
}

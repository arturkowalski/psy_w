import dissimlab.simcore.BasicSimEvent;
import dissimlab.simcore.SimControlException;
import dissimlab.random.SimGenerator;
import java.util.Random;

public class GeneratorZgloszen extends BasicSimEvent<Otoczenie, Object> {
	private final Sekwencja numery;
	private final Random generatorPriorytetow;
	private final SimGenerator simGenerator;
	private Otoczenie otoczenieMatka;
	
	public GeneratorZgloszen(Otoczenie otoczenieMatka, double odstep) throws SimControlException {
		super(otoczenieMatka, odstep);
		numery = new Sekwencja();
		generatorPriorytetow = new Random();
		simGenerator = new SimGenerator();
	}
	
	public GeneratorZgloszen(Otoczenie otoczenieMatka) throws SimControlException {
		super(otoczenieMatka);
		numery = new Sekwencja();
		generatorPriorytetow = new Random();
		simGenerator = new SimGenerator();
	}
	
	protected void stateChange() throws SimControlException {
		otoczenieMatka = getSimObj();
		
		if (otoczenieMatka.smo.kolejkaPelna()) {
			System.out.printf("\nKolejka pelna - nowowygenerowane zgloszenie odrzucone\n");
			
			return;
		}
		
		Zgloszenie z = new Zgloszenie(numery.nastepny(), simTime(), generatorPriorytetow.nextInt(10) + 1,
			otoczenieMatka.smo);
		
		otoczenieMatka.smo.wstaw(z);
		System.out.printf("%017.9f: Zgloszenie numer %d dodane (priorytet rowny %d)\n",
			simTime(), z.numer(), z.priorytet());
		
		if (otoczenieMatka.smo.stan() == 1 && otoczenieMatka.smo.gniazdoWolne()) {
			otoczenieMatka.smo.obslugaPoczatek = new ObslugaPoczatek(otoczenieMatka.smo);
		}
		
		double odstep = simGenerator.normal(5.0, 1.0);
		setRepetitionPeriod(odstep);
	}
	
	public Object getEventParams() {
		return null;
	}
	
	protected void onInterruption() throws SimControlException {}
	
	protected void onTermination() throws SimControlException {}
}

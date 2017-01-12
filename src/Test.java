import dissimlab.simcore.SimManager;
import dissimlab.simcore.SimControlEvent;
import dissimlab.simcore.SimParameters.SimControlStatus;
import dissimlab.simcore.SimControlException;

public class Test {
	public static void main(String[] args) {
		try {
			SimManager model = SimManager.getInstance();
			Smo smo = new Smo("KOLEJKA_FIFO");
			Otoczenie otoczenie = new Otoczenie(smo);
			SimControlEvent stop = new SimControlEvent(100.0, SimControlStatus.STOPSIMULATION);
			model.startSimulation();
			System.out.println("Liczba straconych zgloszen: " + smo.odrzucone());
		}
		catch (SimControlException wyj) {
			System.out.println(wyj.toString());
		}
	}
}

import dissimlab.simcore.SimManager;
import dissimlab.simcore.SimControlEvent;
import dissimlab.simcore.SimParameters.SimControlStatus;
import dissimlab.simcore.SimControlException;
import smo.Otoczenie;
import smo.Smo;

public class Test {
	public static void main(String[] args) {
		try {
			SimManager model = SimManager.getInstance();
			Smo smo = new Smo("KOLEJKA_LIFO_NOGR_PR");
			Otoczenie otoczenie = new Otoczenie(smo);
			
			//model.setEndSimTime(30);
			SimControlEvent stop = new SimControlEvent(30., SimControlStatus.STOPSIMULATION);
			model.startSimulation();
			System.out.println("Liczba straconych zgloszen: " + smo.odrzucone());
		}
		catch (SimControlException wyj) {
			System.out.println(wyj.toString());
		}
	}
}

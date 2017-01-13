import dissimlab.simcore.SimManager;
import dissimlab.simcore.SimControlEvent;
import dissimlab.simcore.SimParameters.SimControlStatus;
import dissimlab.simcore.SimControlException;

class Lab2a {
	public static void main(String[] args) {
		if (args.length != 2 && args.length != 3) {
			System.out.println("java -cp dissimlab;. Lab2a {typ} [dlugosc] {czas}\n");
			System.out.println("- dissimlab - sciezka do pliku dissimlab.jar\n");
			System.out.println("- typ - typ kolejki (KOLEJKA_FIFO_OGR_NPR, KOLEJKA_FIFO_NOGR_NPR, " +
				"KOLEJKA_LIFO_OGR_NPR, KOLEJKA_LIFO_NOGR_NPR,\n  KOLEJKA_FIFO_OGR_PR, " +
				"KOLEJKA_FIFO_NOGR_PR, KOLEJKA_LIFO_OGR_PR albo KOLEJKA_LIFO_NOGR_PR)\n");
			
			System.out.println("- dlugosc - dlugosc kolejki (tylko dla kolejek ograniczonych\n");
			System.out.println("- czas - czas trwania symulacji");
		}
		
		else if (args.length == 2) {
			try {
				SimManager model = SimManager.getInstance();
				Smo smo = new Smo(args[0]);
				Otoczenie otoczenie = new Otoczenie(smo);
				SimControlEvent stop = new SimControlEvent(Double.parseDouble(args[1]),
					SimControlStatus.STOPSIMULATION);
				
				model.startSimulation();
				System.out.println("Liczba straconych zgloszen: " + smo.odrzucone());
			}
			catch (SimControlException wyj) {
				System.out.println(wyj.toString());
			}
		}
		else {
			try {
				SimManager model = SimManager.getInstance();
				Smo smo = new Smo(args[0], Integer.parseInt(args[1]));
				Otoczenie otoczenie = new Otoczenie(smo);
				SimControlEvent stop = new SimControlEvent(Double.parseDouble(args[2]),
					SimControlStatus.STOPSIMULATION);
				
				model.startSimulation();
				System.out.println("Liczba straconych zgloszen: " + smo.odrzucone());
			}
			catch (SimControlException wyj) {
				System.out.println(wyj.toString());
			}
		}
	}
}

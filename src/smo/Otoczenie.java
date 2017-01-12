package smo;

import dissimlab.simcore.BasicSimObj;
import dissimlab.simcore.SimControlException;
import dissimlab.broker.IPublisher;
import dissimlab.broker.INotificationEvent;

public final class Otoczenie extends BasicSimObj {
	GeneratorZgloszen generator;
	Smo smo;
	
	public Otoczenie(Smo smo) throws SimControlException {
		generator = new GeneratorZgloszen(this, 0.0);
		this.smo = smo;
	}
	
	public boolean filter(IPublisher ip, INotificationEvent ine) {
		return false;
	}
	
	public void reflect(IPublisher ip, INotificationEvent ine) {}
}

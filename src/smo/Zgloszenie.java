package smo;

import dissimlab.simcore.BasicSimObj;
import dissimlab.simcore.SimControlException;
import dissimlab.broker.IPublisher;
import dissimlab.broker.INotificationEvent;
import java.util.Comparator;

public final class Zgloszenie extends BasicSimObj {
	private final int numer;
	private final double czasNadejscia;
	private final int priorytet;
	private final OkresNiecierpliwieniaPoczatek okresNiecierpliwieniaPoczatek;
	OkresNiecierpliwieniaKoniec okresNiecierpliwieniaKoniec;
	final Smo smo;
	
	public Zgloszenie(final int numer, final double czasNadejscia, final int priorytet, final Smo smo) throws SimControlException {
		if (czasNadejscia < 0.0) {
			throw new IllegalArgumentException("\nCzas nadejscia mniejszy niz 0");
		}
		
		if (priorytet < 1 || priorytet > 10) {
			throw new IllegalArgumentException("\nPriorytet spoza zakresu");
		}
		
		this.numer = numer;
		this.czasNadejscia = czasNadejscia;
		this.priorytet = priorytet;
		okresNiecierpliwieniaPoczatek = new OkresNiecierpliwieniaPoczatek(this);
		this.smo = smo;
	}
	
	public static Comparator<Zgloszenie> komparatorFifo() {
		return (z1, z2) -> {
			if (z1.priorytet < z2.priorytet || z1.priorytet == z2.priorytet && z1.numer > z2.numer) {
				return +1;
			}
			else if (z1.priorytet == z2.priorytet && z1.numer == z2.numer) {
				return 0;
			}
			else {
				return -1;
			}
		};
	}
	
	public static Comparator<Zgloszenie> komparatorLifo() {
		return (z1, z2) -> {
			if (z1.priorytet < z2.priorytet || z1.priorytet == z2.priorytet && z1.numer < z2.numer) {
				return +1;
			}
			else if (z1.priorytet == z2.priorytet && z1.numer == z2.numer) {
				return 0;
			}
			else {
				return -1;
			}
		};
	}
	
	public String toString() {
		return "Zgloszenie " + numer + "/" + czasNadejscia + "/" + priorytet;
	}
	
	public boolean filter(IPublisher ip, INotificationEvent ine) {
		return false;
	}
	
	public void reflect(IPublisher ip, INotificationEvent ine) {}
	
	public int numer() {
		return numer;
	}
	
	public double czasNadejscia() {
		return czasNadejscia;
	}
	
	public int priorytet() {
		return priorytet;
	}
}

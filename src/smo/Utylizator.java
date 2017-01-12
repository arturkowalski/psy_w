package smo;

public final class Utylizator {
	private int odrzucone;
	
	public Utylizator() {}
	
	public void zapamietaj() {
		++odrzucone;
	}
	
	public int odrzucone() {
		return odrzucone;
	}
}

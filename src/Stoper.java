final class Stoper {
	private final long start;
	
	Stoper() {
		start = System.currentTimeMillis();
	}
	
	double czas() {
		return (System.currentTimeMillis() - start) / 1000.0;
	}
}

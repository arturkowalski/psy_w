enum Kolejka {
	KOLEJKA_FIFO_OGR_NPR {
		KolejkaFifoOgrNpr stworz() {
			throw new UnsupportedOperationException("Nieznana dlugosc");
		}
		
		KolejkaFifoOgrNpr stworz(int dlugosc) {
			return new KolejkaFifoOgrNpr(dlugosc);
		}
	},
	
	KOLEJKA_FIFO_NOGR_NPR {
		KolejkaFifoNogrNpr stworz() {
			return new KolejkaFifoNogrNpr();
		}
		
		KolejkaFifoNogrNpr stworz(int dlugosc) {
			throw new UnsupportedOperationException("Dlugosc zbedna");
		}
	},
	
	KOLEJKA_LIFO_OGR_NPR {
		KolejkaLifoOgrNpr stworz() {
			throw new UnsupportedOperationException("Nieznana dlugosc");
		}
		
		KolejkaLifoOgrNpr stworz(int dlugosc) {
			return new KolejkaLifoOgrNpr(dlugosc);
		}
	},
	
	KOLEJKA_LIFO_NOGR_NPR {
		KolejkaLifoNogrNpr stworz() {
			return new KolejkaLifoNogrNpr();
		}
		
		KolejkaLifoNogrNpr stworz(int dlugosc) {
			throw new UnsupportedOperationException("Dlugosc zbedna");
		}
	},
	
	KOLEJKA_FIFO_OGR_PR {
		KolejkaFifoOgrPr stworz() {
			throw new UnsupportedOperationException("Nieznana dlugosc");
		}
		
		KolejkaFifoOgrPr stworz(int dlugosc) {
			return new KolejkaFifoOgrPr(dlugosc);
		}
	},
	
	KOLEJKA_FIFO_NOGR_PR {
		KolejkaFifoNogrPr stworz() {
			return new KolejkaFifoNogrPr();
		}
		
		KolejkaFifoNogrPr stworz(int dlugosc) {
			throw new UnsupportedOperationException("Dlugosc zbedna");
		}
	},
	
	KOLEJKA_LIFO_OGR_PR {
		KolejkaLifoOgrPr stworz() {
			throw new UnsupportedOperationException("Nieznana dlugosc");
		}
		
		KolejkaLifoOgrPr stworz(int dlugosc) {
			return new KolejkaLifoOgrPr(dlugosc);
		}
	},
	
	KOLEJKA_LIFO_NOGR_PR {
		KolejkaLifoNogrPr stworz() {
			return new KolejkaLifoNogrPr();
		}
		
		KolejkaLifoNogrPr stworz(int dlugosc) {
			throw new UnsupportedOperationException("Dlugosc zbedna");
		}
	};
	
	abstract KolejkaI stworz();
	
	abstract KolejkaI stworz(int dlugosc);
	
	static KolejkaI stworz(final String typKolejki) {
		return Kolejka.valueOf(typKolejki).stworz();
	}
	
	static KolejkaI stworz(final String typKolejki, final int dlugosc) {
		return Kolejka.valueOf(typKolejki).stworz(dlugosc);
	}
}

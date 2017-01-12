public enum Kolejka {
	KOLEJKA_FIFO_OGR_NPR {
		KolejkaFifoOgrNpr stworz() {
			throw new UnsupportedOperationException("\nDlugosc nieokreslona");
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
			throw new UnsupportedOperationException("\nPojecie dlugosci nie ma zastsowania");
		}
	},
	
	KOLEJKA_LIFO_OGR_NPR {
		KolejkaLifoOgrNpr stworz() {
			throw new UnsupportedOperationException("\nDlugosc nieokreslona");
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
			throw new UnsupportedOperationException("\nPojecie dlugosci nie ma zastsowania");
		}
	},
	
	KOLEJKA_FIFO_OGR_PR {
		KolejkaFifoOgrPr stworz() {
			throw new UnsupportedOperationException("\nDlugosc nieokreslona");
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
			throw new UnsupportedOperationException("\nPojecie dlugosci nie ma zastsowania");
		}
	},
	
	KOLEJKA_LIFO_OGR_PR {
		KolejkaLifoOgrPr stworz() {
			throw new UnsupportedOperationException("\nDlugosc nieokreslona");
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
			throw new UnsupportedOperationException("\nPojecie dlugosci nie ma zastsowania");
		}
	};
	
	abstract KolejkaI stworz();
	abstract KolejkaI stworz(int dlugosc);
	
	public static KolejkaI stworz(final String typKolejki) {
		return Kolejka.valueOf(typKolejki).stworz();
	}
	
	public static KolejkaI stworz(final String typKolejki, final int dlugosc) {
		return Kolejka.valueOf(typKolejki).stworz();
	}
}

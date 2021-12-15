package celula;

public class CelulaMinada extends Celula {

	public CelulaMinada() {
		super();
		setMina(false);
	}
	
	public void abrirCelula() {
		if(getVazia()) {
			setFechada(false);
		}
	}

	public int numeroDeMinasVizinhas() {
		int n = 0;
		for (Celula vizinho : campo) {
			if (vizinho.getMina()) {
				n++;
			}
		}
		return n;
	}

	public String toString() {
		if (getFechada()) {
			if (getMarcada()) {
				return "B";
			}
			return "[]";
		} else if (getMina()) {
			return "X";
		} else {
			return "" + numeroDeMinasVizinhas();
			}
		}

	public void adicionarVizinhas(Celula v) {
		campo.add(v);
	}

	public boolean minar() {
		if (!getMina()) {
			setMina(true);
			setVazia(false);
			return true;
		} else {
			return false;
		}
	}

}

package celula;

public class CelulaVazia extends Celula {

	public CelulaVazia() {
		super();
		setVazia(true);
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
			setMarcada(false);
			return true;
		} else {
			return false;
		}
	}
	
}

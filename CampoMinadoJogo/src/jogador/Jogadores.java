package jogador;

public class Jogadores extends InteracaoComUsuario{
	
	int tempo;
	
	public Jogadores(String nomeDoJogador, String nivelDificuldade, int tempo) {
		this.nomeDoJogador =  nomeDoJogador;
		this.dificuldadeDoJogo = nivelDificuldade;
		this.tempo = tempo;
		
	}
	
	public int getTempo() {
	    return tempo;
	}

	
}

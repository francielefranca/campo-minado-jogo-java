package jogador;

public class Jogadores extends InteracaoComUsuario{
	
	int tempo;
	
	public Jogadores(String nomeDoJogador, String nivelDificuldade, int tempo) { //informacoes dos jogadores que serao gravadas no ranking
		this.nomeDoJogador =  nomeDoJogador;
		this.dificuldadeDoJogo = nivelDificuldade;
		this.tempo = tempo;
		
	}
	
	public int getTempo() {
	    return tempo;
	}

	
}

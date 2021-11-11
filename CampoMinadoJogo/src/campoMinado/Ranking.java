package campoMinado;

//import java.util.Arrays;
import java.io.File;
import java.io.FileReader;
//import java.io.FileWriter;
import java.io.BufferedReader;
import java.io.IOException;

public class Ranking  {

	Jogo jogo = new Jogo();
	Menu menu = new Menu();
	
	String nome;
	int nivel;
	int pontuacao;

	static String[] Nomes = new String[11];
	static int[] pontuacaoDosJogadores = new int[10];
	static int[] niveisDosJogadores = new int[10];
	static float[] tempoDosJogadores = new float[10];
	
	public Ranking(int pontosTotais){//para receber a pontuacao, nome e nivel do jogador
		this.pontuacao = pontosTotais;
	}
	
	public static void rankigZerado() {
		
	}

	public static void dadosJogador() {
		
	}

	public static void rankingOrdem() {
		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < i; j++) {//ou for(int j = 0; j < 11; j++)
				if(pontuacaoDosJogadores[i]>pontuacaoDosJogadores[j]) {
					int ordem = pontuacaoDosJogadores[i];
					pontuacaoDosJogadores[i] = pontuacaoDosJogadores [j];
					pontuacaoDosJogadores[j] = ordem;
					ordem = niveisDosJogadores[i];
					niveisDosJogadores[i] = niveisDosJogadores [j];
					niveisDosJogadores[j] = ordem;
				}
			}
		}
	}

	public static void imprimirRanking() {
		System.out.println("NOME |\t DIFICULDADE |\t PONTOS |\t TEMPO");
		for(int i = 0; i < 10; i++) {
			System.out.printf("%s |\t\t %i |\t %i |\t %i",Nomes[i] , niveisDosJogadores[i], pontuacaoDosJogadores[i], tempoDosJogadores[i]);
		}
	}

	public static void lerRanking() {
		
		File arquivoRanking = new File("arquivoRanking.txt");
		
		if(arquivoRanking.exists()) {
			try {
				FileReader fr = new FileReader(arquivoRanking);
				BufferedReader br = new BufferedReader(fr);
				
				System.out.println();
				while(br.ready()) {
					String linha = br.readLine();
					System.out.println(linha);
				}
				System.out.println();
				
				br.close();
				fr.close();
			}catch(IOException e) {
				throw new RuntimeException("Erro ao ler o arquivo.");
			}
		}
		
	}

	public static void salvarRanking() {
		for(int i=0; i<10; i++) {

		}
	}
}

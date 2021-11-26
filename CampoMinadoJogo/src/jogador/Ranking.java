package jogador;

import campoMinado.Jogo;
import campoMinado.Menu;

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
	
	public Ranking(int pontosTotais){//para receber o nome, pontuacao e nivel do jogador
		this.pontuacao = pontosTotais;
	}
	
	public static void rankigZerado() {//quando nao tiver nenhum jogador no ranking, o ranking sera zerado
		
	}

	public static void dadosJogador() {//informacoes do jogador como nome, nivel, tempo, pontuacao
		
	}

	public static void rankingOrdem() {//dados do jogador em ordem, top 10
		
	}

	public static void imprimirRanking() {//mostrar na tela os top 10
		System.out.println("NOME |\t DIFICULDADE |\t PONTOS |\t TEMPO");
		for(int i = 0; i < 10; i++) {
			System.out.printf("%s |\t\t %i |\t %i |\t %i",Nomes[i] , niveisDosJogadores[i], pontuacaoDosJogadores[i], tempoDosJogadores[i]);
		}
	}

	public static void lerRanking() {//leitura do arquivo .txt do ranking
		
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

	public static void salvarRanking() {//salvamento do arquivo .txt do ranking
		
	}
}

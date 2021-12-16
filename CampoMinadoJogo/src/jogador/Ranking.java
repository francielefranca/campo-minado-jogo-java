package jogador;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;;

public class Ranking  {

	private String nivelDificuldade;
	
	private ArrayList<Jogadores> jogadores;
	
	private static final String highscorefile = "Ranking.dat";
	
	ObjectOutputStream output = null;
	ObjectInputStream input = null;
	
	public Ranking() {
		jogadores = new ArrayList<Jogadores>();
	}
	
	public void addJogadores(Jogadores j) {
		jogadores.add(j);
	}
	
	public ArrayList<Jogadores> getJogadores() {
	    loadScoreFile();
	    sortedArray();
	    return jogadores;
	}
	
	public ArrayList<Jogadores> sortedArray(){
		Collections.sort(jogadores, new Comparator<Jogadores>()
		{
			public int compare(Jogadores jogador1, Jogadores jogador2) {
				return Integer.valueOf(jogador1.tempo).compareTo(jogador2.tempo);
			}
		});
		
		for(int i =0; i<jogadores.size(); i++) {
			System.out.println("Jogador:" + jogadores.get(i).nomeDoJogador + " Tempo: " + jogadores.get(i).tempo );
		}
		
		return jogadores;
	}
	
	public void addScore(String nomeDoJogador, int tempo) {
		loadScoreFile();
		jogadores.add(new Jogadores(nomeDoJogador, nivelDificuldade, tempo));
		atualizarScoreFile();
	}

	public void loadScoreFile() {
	    try {
	        input = new ObjectInputStream(new FileInputStream(highscorefile));
	        jogadores = (ArrayList<Jogadores>) input.readObject();
	    } catch (FileNotFoundException e) {
	        System.out.println("[Laad] FNF Error: " + e.getMessage());
	    } catch (IOException e) {
	        System.out.println("[Laad] IO Error: " + e.getMessage());
	    } catch (ClassNotFoundException e) {
	        System.out.println("[Laad] CNF Error: " + e.getMessage());
	    } finally {
	        try {
	            if (output != null) {
	                output.flush();
	                output.close();
	            }
	        } catch (IOException e) {
	            System.out.println("[Laad] IO Error: " + e.getMessage());
	        }
	    }
	}
	public void atualizarScoreFile() {
	    try {
	        output = new ObjectOutputStream(new FileOutputStream(highscorefile));
	        output.writeObject(jogadores);
	    } catch (FileNotFoundException e) {
	        System.out.println("[Update] FNF Error: " + e.getMessage() + ",sera criado um novo arquivo.");
	    } catch (IOException e) {
	        System.out.println("[Update] IO Error: " + e.getMessage());
	    } finally {
	        try {
	            if (output != null) {
	                output.flush();
	                output.close();
	            }
	        } catch (IOException e) {
	            System.out.println("[Update] Error: " + e.getMessage());
	        }
	    }
	}
	public String getHighscoreString() {
	    String highscoreString = "";
	       int max = 10;

	    ArrayList<Jogadores> jogadores;
	    jogadores = getJogadores();

	    int i = 0;
	    int x = jogadores.size();
	    if (x > max) {
	        x = max;
	    }
	    while (i < x) {
	        highscoreString += (i + 1) + ".\t" + jogadores.get(i).getNome() + "\t\t" + jogadores.get(i).getTempo() + "\n";
	        i++;
	    }
	    return highscoreString;
	}

	
	public String gerarDescricaoDificuldade(String nivelDificuldade) {
		if(nivelDificuldade.equals("1")) {
			return "Nivel Facil";
		}else if(nivelDificuldade.equals("2")) {
			return "Nivel medio";
		}else if(nivelDificuldade.equals("3")) {
			return "Nivel dificil";
		}else {
			return "Nivel maluco";
		}
	}

	public void salvarRanking(boolean vitoria, String nivelDificuldade, Duration tempoDecorrido, String nomeDoJogador) {
		try {
			File arquivoRanking = new File("arquivoRanking.txt");

			if (!arquivoRanking.exists()) {
				arquivoRanking.createNewFile();
			}

			FileWriter fw = new FileWriter(arquivoRanking, true);
			BufferedWriter bw = new BufferedWriter(fw);

			String data = LocalDate.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
			String nivel = gerarDescricaoDificuldade(nivelDificuldade);
			String duracao = "Duracao " + tempoDecorrido.toHours() + ":" + tempoDecorrido.toMinutes() + ":" + tempoDecorrido.toSeconds();
			String resultado = vitoria ? "Ganhou" : "Perdeu ";
			String nome = nomeDoJogador;

			bw.write(nome + " | " + nivel + " | " + duracao + " | " + resultado + " | " + data);
			bw.newLine();

			bw.close();
			fw.close();
		}catch(IOException e) {
			e.printStackTrace();
			throw new RuntimeException("Erro ao salvar o arquivo do ranking");
		}
	}

	public void lerRanking() {

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
			}catch(Exception e) {
				throw new RuntimeException("Erro ao ler o arquivo do ranking.");
			}
		}
	}

	public void apagarRanking() {
		File arquivoRanking = new File("arquivoRanking.txt");

		if(arquivoRanking.exists()) {
			try {
				FileWriter fw = new FileWriter(arquivoRanking, false);

				fw.write("");
				fw.close();
			}catch(IOException e) {
				e.printStackTrace();
				throw new RuntimeException("Erro ao apagar o arquivo do ranking.");
			}
		}
		System.out.println("\n Arquivo do Ranking apagado com sucesso. \n");
	}
}

package jogador;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import campoMinado.Jogo;

public class Ranking  {

	private int nivelDificuldade;
	//double [] tempo = new double[10];
	//String [] nome = new String[10];

	public Ranking(){
	}

	/*public void Sort(String nomeJogador) { //sort manual ---> tetse
		double time1;
		String nomes2;

		for(int i = 0; i<tempo.length -1; i++) {
			for(int j = 0; j<tempo.length -1; j++) {
				System.out.println(i + " " + j);
				if(tempo[j]>tempo[j+1]) {
					time1 = tempo[j];
					tempo[j] = tempo[j+1];
					tempo[j+1] = time1;
					nomes2 = nome[j];
					nome[j] = nome[j+1];
					nome[j+1] = nomes2;
				}
			}
		}

		for(int k = 0; k < 10; k++) {
			System.out.println(nome[k] + " " + tempo[k]);
		}
	}*/

	public String gerarDescricaoDificuldade(int nivelDificuldade) {
		if(nivelDificuldade == 1) {
			return "Nivel Facil";
		}else if(nivelDificuldade == 2) {
			return "Nivel medio";
		}else if(nivelDificuldade == 3) {
			return "Nivel dificil";
		}else {
			return "Nivel maluco";
		}
	}

	public void salvarRanking(boolean vitoria, int nivelDificuldade, Duration tempoDecorrido) {
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

			bw.write(data + "|" + nivel + "|" + duracao + "|" + resultado);
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

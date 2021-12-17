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

public class Ranking  {

	private String nivelDificuldade;
	
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
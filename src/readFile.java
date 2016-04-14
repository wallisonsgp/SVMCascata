import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class readFile {
	private ArrayList<String> listaLinha;
	private int numArquivoDiretorio;

	public void setListaLinha(ArrayList<String> lista) {
		this.listaLinha = lista;
	}

	public ArrayList<String> getListaLinha() {
		return this.listaLinha;
	}

	public void setNumArquivoDiretorio(int num) {
		this.numArquivoDiretorio = num;
	}

	public int getNumArquivoDiretorio() {
		return this.numArquivoDiretorio;
	}
	
	public void lerArquivo(String nomeArquivo) {
		/*
		 * Scanner ler = new Scanner(System.in);
		 * System.out.printf(
		 * "Informe o nome de arquivo texto:\n"); 
		 * String nome = ler.nextLine();
		 * System.out.printf("\nConteúdo do arquivo texto:\n");
		 */

		this.listaLinha = new ArrayList<String>();
		int cont = 0;
		try {
			FileReader arq = new FileReader(nomeArquivo);
			BufferedReader lerArq = new BufferedReader(arq);
			String linha = lerArq.readLine();

			/*
			 * lê a primeira linha a variável "linha" recebe o valor "null"
			 * quando o processo de repetição atingir o final do arquivo texto
			 */
			while (linha != null) {
				linha = lerArq.readLine(); // lê da segunda até a última linha
				/*
				 * Na estrutura de decisão abaixo, é utilizada para saltar as 11
				 * primeiras linhas do arquivo lido, em outras palavras é por
				 * ela que é lido somente os suporte vetores
				 */
				if (cont > 9) {
					if (linha != null) {
						listaLinha.add(linha);
						System.out.printf("Read | %s\n", linha);
					} else {
						System.out.printf("Not Read | %s\n", linha);
					}

				} else {
					System.out.printf("Not Read | %s\n", linha);
				}
				cont++;
			}
			arq.close();
		} catch (IOException e) {
			System.err.printf("Erro na abertura do arquivo: %s.\n", e.getMessage());
		}

		System.out.println();
	}

	public void contarArquivoDiretorio(String diretorio){
		File file=new File(diretorio);//	aqui vc coloca o seu diretório
		File list[] = file.listFiles();
		int numArquivo = list.length;
		setNumArquivoDiretorio(numArquivo);
	}
	
}

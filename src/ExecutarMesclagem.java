import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

public class ExecutarMesclagem {
	public static void main(String[] args) throws IOException {
		String diretorioRaiz = "D:\\Testes\\";
		int iteracao = 3;
		mesclarArquivos(diretorioRaiz, iteracao);

	}

	public static void mesclarArquivos(String diretorioRaiz, int iteracao) throws IOException {
		readFile rF = new readFile();
		ArrayList<String> listaSV1;
		ArrayList<String> listaSV2;
		int iterador = 1 + iteracao;
		String ArquivoOutput = "train\\iteracao" + iterador + "\\";
		String SubdiretorioInput = "output\\iteracao" + iteracao + "\\";
		int j = 0;
		writeFile wF = new writeFile();
		rF.contarArquivoDiretorio(diretorioRaiz + SubdiretorioInput);
		int tamanho = rF.getNumArquivoDiretorio();
		int indiceMeclagem = tamanho + 1;

		if (tamanho % 2 == 0) {
			System.out.println("Numero de arquivos no diretorio par!");
			int i = 1, t;
			listaSV1 = new ArrayList<>();
			listaSV2 = new ArrayList<>();
			t = 1; // indice da iteracao de mesclagem, para salvar o arquivo
			while (i <= tamanho) {

				String ArquivoInput = "output\\iteracao" + iteracao + "\\output" + i;
				rF.lerArquivo(diretorioRaiz + ArquivoInput);
				listaSV1 = rF.getListaLinha();
				i++;
				String ArquivoInput2 = "output\\iteracao" + iteracao + "\\output" + i;
				rF.lerArquivo(diretorioRaiz + ArquivoInput2);
				listaSV2 = rF.getListaLinha();
				System.out.println("Arquivo: " + ArquivoInput + " e " + ArquivoInput2 + " - Carregados com Sucesso");
				i++;
				Iterator k;
				k = listaSV2.iterator();
				// Adiciona o segundo arquivo na Lista do primeiro para poder
				// salvar o arquivo de saida
				while (k.hasNext()) {
					String linha = (String) k.next();
					listaSV1.add(linha);
				}
				// criar uma variavel global para salvar o indiceMesclagem, no
				// qual vai incrementar sempre o numero do train
				wF.escreverArquivo(listaSV1, diretorioRaiz + ArquivoOutput + "train" + t);
				t++;
				indiceMeclagem++;
			}

		} else {
			System.out.println("Numero de arquivos no diretorio impar!");

		}

	}
}

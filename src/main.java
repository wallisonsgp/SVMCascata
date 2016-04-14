import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

public class main {
	public static int i, j=1;

	public static void main(String[] args) throws IOException {
		readFile rF = new readFile();
		writeFile wF = new writeFile();
		svm SVM = new svm();
		String diretorioRaiz = "D:\\Testes\\";
		String SubdiretorioModel = "model\\iteracao";
		String SubdiretorioOutput = "output\\iteracao";
		String SubdiretorioTrain = "train\\iteracao";
		int tamanho;
		int iteracao;
		iteracao = 1;
		/*
		 * Faço a contagem do numero de arquivos presentes no diretorio
		 * declarado na variavel DIRETORIO
		 */

		rF.contarArquivoDiretorio(diretorioRaiz + SubdiretorioTrain + iteracao + "\\");
		tamanho = rF.getNumArquivoDiretorio();
		System.out.println(tamanho);
		SVM.setDiretorioRaiz(diretorioRaiz);
		SVM.setDiretorioInput(SubdiretorioTrain + iteracao);
		SVM.setDiretorioOutput(SubdiretorioModel + iteracao);
		i = 1;
		//while (j <= (tamanho / 2)) {
		j=1;
		rF.contarArquivoDiretorio(diretorioRaiz + SubdiretorioTrain + iteracao + "\\");
		tamanho = rF.getNumArquivoDiretorio();
		
			while (i <= tamanho) {
				SVM.executarSVMLearn2("D:\\Testes\\train\\iteracao" + j + "\\train" + i + " D:\\Testes\\model\\iteracao"
					+ j + "\\model" + i);

				/*
				 * Executar a transformação para todos os arquivo model
				 * presentes no diretorio da iteracao
				 */
				// for (i = 1; i <= tamanho; i++) {
				String ArquivoInput = "model\\iteracao" + j + "\\model" + i;
				String ArquivoOutput = "output\\iteracao" + j + "\\output" + i;
				rF.lerArquivo(diretorioRaiz + ArquivoInput);
				wF.escreverArquivoTratando(rF.getListaLinha(), diretorioRaiz + ArquivoOutput);
				System.out.println("Arquivo: " + ArquivoInput + " - Concluído com Sucesso");
				i++;
			}

			mesclarArquivos(diretorioRaiz, j);

			// Chamar SVM para eles
			j++;
		}
	//}

	public static void mesclarArquivos(String diretorioRaiz, int iteracao) throws IOException {
		readFile rF = new readFile();
		ArrayList<String> listaSV1;
		ArrayList<String> listaSV2;
		String ArquivoOutput = "train\\iteracao" + iteracao + "\\";
		String SubdiretorioInput = "output\\iteracao" + iteracao + "\\";
		int j = 0;
		writeFile wF = new writeFile();
		rF.contarArquivoDiretorio(diretorioRaiz + SubdiretorioInput);
		int tamanho = rF.getNumArquivoDiretorio();
		int indiceMeclagem = tamanho + 1;

		if (tamanho % 2 == 0) {
			System.out.println("Numero de arquivos no diretorio par!");
			int i = 1;
			listaSV1 = new ArrayList<>();
			listaSV2 = new ArrayList<>();

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
				wF.escreverArquivo(listaSV1, diretorioRaiz + ArquivoOutput + "train" + indiceMeclagem);
				indiceMeclagem++;
			}

		} else {
			System.out.println("Numero de arquivos no diretorio impar!");

		}

	}

}

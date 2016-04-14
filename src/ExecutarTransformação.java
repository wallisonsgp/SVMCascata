import java.io.IOException;

public class ExecutarTransformação {
	public static void main(String[] args) throws IOException {
		readFile rF = new readFile();
		writeFile wF = new writeFile();
		svm SVM = new svm();
		String diretorioRaiz = "D:\\Testes\\";
		String SubdiretorioModel = "model\\iteracao";
		String SubdiretorioOutput = "output\\iteracao";
		String SubdiretorioTrain = "train\\iteracao";
		int tamanho, i;
		int iteracao;
		iteracao = 3;
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
		rF.contarArquivoDiretorio(diretorioRaiz + SubdiretorioTrain + iteracao + "\\");
		tamanho = rF.getNumArquivoDiretorio();

		/*
		 * Executar a transformação para todos os arquivo model presentes no
		 * diretorio da iteracao
		 */

		while (i <= tamanho) {

			String ArquivoInput = "model\\iteracao" + iteracao + "\\model" + i;
			String ArquivoOutput = "output\\iteracao" + iteracao + "\\output" + i;
			rF.lerArquivo(diretorioRaiz + ArquivoInput);
			wF.escreverArquivoTratando(rF.getListaLinha(), diretorioRaiz + ArquivoOutput);
			System.out.println("Arquivo: " + ArquivoInput + " - Concluído com Sucesso");
			i++;
		}
	}
}

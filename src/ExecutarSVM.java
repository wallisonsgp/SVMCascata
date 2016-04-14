import java.io.IOException;

public class ExecutarSVM {
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
		iteracao = 4;
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

		while (i <= tamanho) {
			SVM.executarSVMLearn2("D:\\Testes\\train\\iteracao" + iteracao + "\\train" + i + " D:\\Testes\\model\\iteracao" + iteracao
					+ "\\model" + i);
			i++;

		}
	}
}

import java.io.IOException;

public class svm {
	private String diretorioRaiz;
	private String diretorioInput;
	private String diretorioOutput;
	private String nomeArquivoInput;
	private String nomeArquivoOutput;

	public void setDiretorioInput(String input) {
		this.diretorioInput = input;
	}
	
	public void setNomeArquivoInput(String input) {
		this.nomeArquivoInput = input;
	}
	public void setNomeArquivoOutput(String output) {
		this.nomeArquivoOutput = output;
	}
	
	public void setDiretorioRaiz(String raiz) {
		this.diretorioRaiz = raiz;
	} 
	public void setDiretorioOutput(String output) {
		this.diretorioOutput = output;
	}

	public void executarSVMLearn() {
		try {
			Runtime.getRuntime().exec(diretorioRaiz + "svm_learn -t 2 -g 0.0004882125 -c 8 -l -a alfa.dat " + diretorioInput
					+"\\"+ nomeArquivoInput+" "+diretorioOutput+"\\"+nomeArquivoOutput+"");
		} catch (IOException iOException) {
			iOException.printStackTrace();
		}
	}
	
	public void executarSVMLearn2(String diretorios) {
		try {
			Runtime.getRuntime().exec("D:\\Testes\\svm_learn -t 2 -g 0.0004882125 -c 8 -l naoRotulado.dat -a D:\\Testes\\alfa.dat " + diretorios);
		} catch (IOException iOException) {
			iOException.printStackTrace();
		}
	}
}

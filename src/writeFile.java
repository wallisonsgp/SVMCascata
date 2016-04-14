import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

public class writeFile {
	public void escreverArquivoTratando(ArrayList lista, String nomearquivo) throws IOException {
		BufferedWriter buffWrite = new BufferedWriter(new FileWriter(nomearquivo));

		Iterator j = lista.iterator();
		while (j.hasNext()) {
			String linhaRead = (String) j.next();
			linhaRead = tratamentoLabelFile(linhaRead);
			buffWrite.append(linhaRead + "\n");

		}
		buffWrite.close();
	}
	
	public void escreverArquivo(ArrayList lista, String nomearquivo) throws IOException {
		BufferedWriter buffWrite = new BufferedWriter(new FileWriter(nomearquivo));

		Iterator j = lista.iterator();
		while (j.hasNext()) {
			String linhaRead = (String) j.next();
			buffWrite.append(linhaRead + "\n");

		}
		buffWrite.close();
	}
	
	
/*Faz o tratamento dos label do arquivo lido, caso o label for maior que 0 recebe o label de +1, caso
 * contratio -1*/
	public static String tratamentoLabelFile(String texto) {
		String[] frases = texto.split(" ");
		String palavras = "";
		for (int i = 0; i < frases.length; i++) {
			if (frases[i].contains(":")) {

				
			} else if (frases[i].contains("#")) {
				System.out.println("Removido caractere #.");
				frases[i] = "";
			} else {
				String anterior;
				if (Float.parseFloat(frases[i]) >= 0.0) {
					anterior = frases[i];
					frases[i] = "+1 ";
				} else {
					anterior = frases[i];
					frases[i] = "-1 ";
				}
				System.out.println("Alteracao | De " + anterior + " para " + frases[i] + "");
				//System.out.println("Palavra NAO alterada!");
			}
		}

		/* Faz a junção da lista de strings em uma única string */
		int i;
		palavras = frases[0];
		for (i = 1; i < frases.length; i++) {
			palavras = palavras + " " + frases[i];
		}

		return palavras;
	}
}

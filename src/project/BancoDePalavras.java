package project;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class BancoDePalavras {
    private List<String> palavras = new ArrayList<>();
    private static int contador = 0;
    
    public BancoDePalavras() {
        consumirArquivo();
    }

    private void consumirArquivo() {
        String palavra;
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader("palavras"));

            while((palavra = bufferedReader.readLine()) != null) {
                palavras.add(palavra);
            }
            bufferedReader.close();
        } catch(IOException e) {
            e.printStackTrace();
        } 
    }

    public String palavraAleatoria() {
        String palavra = palavras.get(contador);
        contador++;
        return palavra;
    }

}

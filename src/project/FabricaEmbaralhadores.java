package project;

public class FabricaEmbaralhadores implements Embaralhador {
    protected BancoDePalavras bancoDePalavras;
    protected String palavraDesembaralhada;
    protected String palavraEmbaralhada;

    public FabricaEmbaralhadores() {
        bancoDePalavras = new BancoDePalavras();
    }

    public String embaralhaPalavra() {
        StringBuffer palavraRecebida = new StringBuffer(bancoDePalavras.palavraAleatoria());
        palavraDesembaralhada = palavraRecebida.toString();

        char x[] = palavraRecebida.reverse().toString().toCharArray();
        char doMeio = x[x.length/2];
        x[x.length/2] = x[0];
        x[0] = doMeio;
        
        StringBuffer sb = new StringBuffer();
        sb.append(x);
        palavraEmbaralhada = sb.toString();
        return palavraEmbaralhada;
    }

    public String palavraDesembaralhada() {
        return palavraDesembaralhada;
    }
}

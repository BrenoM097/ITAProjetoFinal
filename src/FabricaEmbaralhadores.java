
public class FabricaEmbaralhadores implements Embaralhador {
    protected BancoDePalavras bancoDePalavras;
    protected String palavraDesembaralhada;
    protected String palavraEmbaralhada;

    public FabricaEmbaralhadores() {
        bancoDePalavras = new BancoDePalavras();
    }

    public String embaralhaPalavra() {
        StringBuffer palavraRecebida = new StringBuffer(bancoDePalavras.palavraAleatoria());

        char x[] = palavraRecebida.reverse().toString().toCharArray();
        x[x.length/2] = x[0];
        x[0] = x[x.length/2];
        
        StringBuffer palavraEmbaralhada = new StringBuffer(x.toString());
        palavraDesembaralhada = palavraRecebida.toString();
        this.palavraEmbaralhada = palavraEmbaralhada.toString();
        return this.palavraDesembaralhada;
    }

    public String palavraDesembaralhada() {
        return palavraDesembaralhada;
    }
}

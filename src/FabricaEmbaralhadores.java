
public class FabricaEmbaralhadores implements Embaralhador {
    private BancoDePalavras bancoDePalavras;

    public FabricaEmbaralhadores() {
        bancoDePalavras = new BancoDePalavras();
    }

    public String embaralhaPalavra() {
        StringBuffer palavraRecebida = new StringBuffer(bancoDePalavras.palavraAleatoria());

        char x[] = palavraRecebida.reverse().toString().toCharArray();
        x[x.length/2] = x[0];
        x[0] = x[x.length/2];
        
        StringBuffer palavraEmbaralhada = new StringBuffer(x.toString());
        return palavraEmbaralhada.toString();
    }
}

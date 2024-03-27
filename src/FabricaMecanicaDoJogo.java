import java.util.Scanner;

public class FabricaMecanicaDoJogo implements MecanicaDoJogo{
    FabricaEmbaralhadores palavraNormal = new FabricaEmbaralhadores();
    FabricaEmbaralhadoresHard paralavraDificil = new FabricaEmbaralhadoresHard();
    private static int totalVidas = 5;
    private static int totalPontos = 0;
    private static String palavraEmbaralhada;
    private static int contaPalavras = 0;
    private Scanner in = new Scanner(System.in);

    @Override
    public void computaPontos(String palavraEmbaralhada) {
        System.out.println("Palavra a ser desembaralhada: " +palavraEmbaralhada);

        while(totalVidas > 0 && contaPalavras < 10) {
            if(palavraNormal.palavraDesembaralhada.equals(in.nextLine())) {
                totalPontos += palavraEmbaralhada.length();
                System.out.println("Acertou, parabens! Você ganhou " +palavraEmbaralhada.length()+" pontos, partindo para a proxima palavra.");
                contaPalavras++;
                if(contaPalavras < 5) {
                    computaPontos(pegaNovaPalavra());
                }
                //Passou da quinta palavra começa a ficar mais dificil
                computaPontos(pegaNovaPalavraDificil());
                
            } else {
                totalVidas--;
                System.out.println("Puts, passou perto, tente novamente, você ainda pode tentar " +totalVidas+" vezes!");
            }
        }
        if (totalVidas == 0) {
            System.out.println("Suas vidas acabaram, GAME OVER! :(");
            encerrarJogo();
        } else if(contaPalavras == 10) {
            System.out.println("Parabens, você acertou todas as palavras, zerou o jogo!");
            encerrarJogo();
        }
        
    }

    private String pegaNovaPalavra() {
        return palavraNormal.embaralhaPalavra(); 
    }

    private String pegaNovaPalavraDificil() {
        return paralavraDificil.embaralhaPalavra();
    }

    @Override
    public int getTotalPontos() {
        return totalPontos;
    }

    @Override
    public void iniciaJogo() {
        palavraEmbaralhada = pegaNovaPalavra();
        System.out.println("Jogo iniciado, boa sorte!");
        computaPontos(palavraEmbaralhada);
    }

    @Override
    public void encerrarJogo() {
        in.close();
    }
    
}

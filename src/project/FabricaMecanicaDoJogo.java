package project;
import java.util.Scanner;

public class FabricaMecanicaDoJogo implements MecanicaDoJogo{
    private FabricaEmbaralhadores palavraNormal = new FabricaEmbaralhadores();
    private FabricaEmbaralhadoresHard paralavraDificil = new FabricaEmbaralhadoresHard();
    private static int totalVidas = 5;
    private static int totalPontos = 0;
    private String palavraEmbaralhada;
    private int contaPalavras = 0;
    private Scanner in = new Scanner(System.in);
    private String palavraDesembaralhada;
    private boolean jogoGanho = false;
    private boolean jogoPerdido = false;

    @Override
    public void computaPontos(String palavraEmbaralhada) {
        System.out.println("Palavra a ser desembaralhada: " +palavraEmbaralhada);

        while(totalVidas > 0 && contaPalavras < 10) {

            if(palavraDesembaralhada.equals(in.nextLine())) {
                totalPontos += palavraEmbaralhada.length();
                System.out.println("Acertou, parabens! Você ganhou " +palavraEmbaralhada.length()+" pontos, partindo para a proxima palavra.");
                contaPalavras++;
                if(contaPalavras < 5) {
                    computaPontos(pegaNovaPalavra());
                } else if(contaPalavras < 10) {
                    //Passou da quinta palavra começa a ficar mais dificil
                    computaPontos(pegaNovaPalavraDificil());
            }
            } else {
                totalVidas--;
                System.out.println("Puts, passou perto, tente novamente, você ainda pode tentar " +totalVidas+" vezes!");
            }
        }
        if (totalVidas == 0 && !jogoPerdido) {
            jogoGanho = true;
            System.out.println("Suas vidas acabaram, GAME OVER! :(, sua pontuação foi: "+totalPontos);
            encerrarJogo();
        } else if(contaPalavras == 10 && !jogoGanho) {
            jogoGanho = true;
            System.out.println("Parabens, você acertou todas as palavras, zerou o jogo! Sua pontuação foi: " + totalPontos);
            encerrarJogo();
        }
    }

    private String pegaNovaPalavra() {
        this.palavraEmbaralhada = palavraNormal.embaralhaPalavra();
        this.palavraDesembaralhada = palavraNormal.palavraDesembaralhada();
        return palavraEmbaralhada;
    }

    private String pegaNovaPalavraDificil() {
        this.palavraEmbaralhada = paralavraDificil.embaralhaPalavra();
        this.palavraDesembaralhada = paralavraDificil.getPalavraDesembaralhada();
        return palavraEmbaralhada;
    }

    @Override
    public void iniciaJogo() {
        palavraEmbaralhada = pegaNovaPalavra();
        System.out.println("Jogo iniciado, boa sorte!");
        computaPontos(palavraEmbaralhada);
    }

    private void encerrarJogo() {
        in.close();
    }
    
}

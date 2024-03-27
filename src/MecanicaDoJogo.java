
public interface MecanicaDoJogo {
    public static int totalVidas = 5;
    public static int totalPontos = 0;
    public void computaPontos(String s);
    public int getTotalPontos();
    public void iniciaJogo();
    public void encerrarJogo();
}

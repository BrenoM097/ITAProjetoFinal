package project;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class FabricaEmbaralhadoresHard extends FabricaEmbaralhadores {
    private String palavraDesembaralhada;

    @Override
    public String embaralhaPalavra() {
    String s = bancoDePalavras.palavraAleatoria();
    this.palavraDesembaralhada = s;
    List<Character> letters = s.chars().boxed().map(c -> (char) c.intValue()).collect(Collectors.toList());
    Collections.shuffle(letters);
    StringBuilder t = new StringBuilder(s.length());
    letters.forEach(t::append);
    return t.toString();
    }

    public String getPalavraDesembaralhada() {
        return this.palavraDesembaralhada;
    }
}

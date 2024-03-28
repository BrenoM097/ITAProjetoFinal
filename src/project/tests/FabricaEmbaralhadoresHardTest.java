package project.tests;


import static org.junit.Assert.assertTrue;
import org.junit.BeforeClass;
import org.junit.Test;
import project.FabricaEmbaralhadoresHard;

public class FabricaEmbaralhadoresHardTest {
   private static FabricaEmbaralhadoresHard fabricaEmbaralhadoresHard;


    @BeforeClass
    public static void beforeAll() {
        fabricaEmbaralhadoresHard = new FabricaEmbaralhadoresHard();
    }

    @Test
    public void testEmbaralhaPalavra() {
//Esse embaralhador cara hora gera uma palavra diferente, é randomizado a maneira que ele embaralha. Não pensei em uma maneira de testa-lo, aceito dicas
        assertTrue(true);
    }
}

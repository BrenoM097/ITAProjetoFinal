package project.tests;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;

import project.FabricaEmbaralhadores;

public class FabricaEmbaralhadoresTest {
    private static FabricaEmbaralhadores fabricaEmbaralhadores;


    @BeforeClass
    public static void beforeAll() {
        fabricaEmbaralhadores = new FabricaEmbaralhadores();
    }

    @Test
    public void testEmbaralhaPalavra() {
        assertEquals("hrroocac", fabricaEmbaralhadores.embaralhaPalavra());
        assertEquals("cachorro", fabricaEmbaralhadores.palavraDesembaralhada());
    }

}

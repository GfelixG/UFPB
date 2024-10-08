package POO.biblioteca;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

public class SistemaBibliotecaTest {

    @Test
    public void testaCadastro(){
        SistemaBiblioteca sistema = new SistemaBiblioteca();
        try {
            Livro l = new Livro();
            sistema.cadastraLivro(l);

            Livro livro = sistema.pesquisaLivroPeloCod(l.getCodigo());
            assertEquals(livro, l);
        } catch (JaExisteEsseCodException e) {
            fail();
        }
    }
}

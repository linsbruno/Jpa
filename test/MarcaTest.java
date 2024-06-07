import dao.IMarcaDAO;
import dao.MarcaDAO;
import domain.Carro;
import domain.Marca;
import org.junit.Test;

import static org.junit.Assert.assertNotNull;

public class MarcaTest {
    private IMarcaDAO marcaDAO;
    public MarcaTest() {
        marcaDAO = new MarcaDAO();
    }
    @Test
    public void cadastrar_marca() {
        Marca marca = new Marca();
        marca.setCodigo("C1");
        marca.setNome_marca("VW");
        marca = marcaDAO.cadastrar(marca);

        assertNotNull(marca);
        assertNotNull(marca.getId());
    }
}
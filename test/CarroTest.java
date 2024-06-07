import dao.*;
import domain.Acessorio;
import domain.Carro;
import domain.Marca;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;


public class CarroTest {
    private ICarroDAO carroDAO;
    private IMarcaDAO marcaDAO;
    private IAcessorioDAO acessorioDAO;
    public CarroTest() {
        carroDAO = new CarroDAO();
        marcaDAO = new MarcaDAO();
        acessorioDAO = new AcessorioDAO();
    }
    private Marca criarMarca(String codigo){
        Marca marca = new Marca();
        marca.setCodigo(codigo);
        marca.setNome_marca("VW");
        return marcaDAO.cadastrar(marca);
    }
    @Test
    public void cadastrar_carro() {
        Marca marca = criarMarca("C1");
        Acessorio acessorio = criarAcessorio("C1");

        Carro carro = new Carro();
        carro.setCodigo("C1");
        carro.setModelo("Gol 1.0 2020");
        carro.setValor(54000d);
        carro.setMarca(marca);
        carro.setAcessorio(acessorio);
        acessorio.setCarro(carro);
        carro = carroDAO.cadastrar(carro);

        assertNotNull(carro);
        assertNotNull(carro.getId());
    }

    private Acessorio criarAcessorio(String codigo) {
        Acessorio acessorio = new Acessorio();
        acessorio.setCodigo(codigo);
        acessorio.setNome("Roda 17");
        return acessorioDAO.cadastrar(acessorio);
    }
}
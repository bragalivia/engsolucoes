import dao.InsumoRepository;
import dao.impl.InsumoRepositoryImpl;
import model.Insumo;

/**
 * Created by Livia on 12/06/2016.
 */
public class Principal {
    public static void main(String[] args) {
        InsumoRepository insumoRepository = new InsumoRepositoryImpl();

        Insumo insumo = new Insumo();
        insumo.setCodigo(20);
        insumo.setDescricao("Blah");
        insumo.setOrigem("Sinapi");

        boolean result = insumoRepository.create(insumo);

        System.out.print(result);
    }
}

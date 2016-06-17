package business.impl;

import business.InsumoService;
import dao.InsumoRepository;
import rest.model.Insumo;
import org.springframework.beans.factory.annotation.Autowired;
/**
 * Created by Livia on 12/06/2016.
 */
public class InsumoServiceImpl implements InsumoService {
    @Autowired
    private InsumoRepository insumoRepository;

    public boolean create(final Insumo insumo) {
        return insumoRepository.create(insumo);
    }

    public Insumo update(final Insumo insumo) {
        return insumoRepository.update(insumo);
    }

    public Insumo read(final Insumo insumo) {
        return insumoRepository.read(insumo);
    }

    public int delete(final int codigo, final String origem) {
        return insumoRepository.delete(codigo, origem);
    }
}

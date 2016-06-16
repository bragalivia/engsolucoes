package main.java.business;

import main.java.rest.model.Insumo;

/**
 * Created by Livia on 12/06/2016.
 */
public interface InsumoService {
    boolean create(final Insumo insumo);
    Insumo update(final Insumo insumo);
    Insumo read(final Insumo insumo);
    int delete(final int codigo, final String origem);
}

package dao;

import model.Insumo;

/**
 * Created by Livia on 12/06/2016.
 */
public interface InsumoRepository {
    boolean create(final Insumo insumo);
    Insumo update(final Insumo insumo);
    Insumo read(final Insumo insumo);
    int delete(final int codigo, final String origem);
}

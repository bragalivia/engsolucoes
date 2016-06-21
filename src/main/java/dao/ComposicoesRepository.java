package dao;

import rest.model.Composicao;

/**
 * Created by Livia on 12/06/2016.
 */
public interface ComposicoesRepository {
    boolean create(final Composicao composicao);
    Composicao update(final Composicao composicao);
    Composicao read(final Composicao composicao);
    int delete(final int codigo, final String origem);
}

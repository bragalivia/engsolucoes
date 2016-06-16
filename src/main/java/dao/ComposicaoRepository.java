package main.java.dao;

import main.java.rest.model.Composicao;

/**
 * Created by Livia on 12/06/2016.
 */
public interface ComposicaoRepository {
    boolean create(final Composicao composicao);
    Composicao update(final Composicao composicao);
    Composicao read(final Composicao composicao);
    int delete(final int codigo, final String origem);
}

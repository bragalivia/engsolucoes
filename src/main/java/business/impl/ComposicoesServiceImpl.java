package business.impl;

import business.ComposicoesService;
import dao.ComposicoesRepository;
import rest.model.Composicao;

/**
 * Created by Livia on 16/06/2016.
 */
public class ComposicoesServiceImpl implements ComposicoesService {
    private ComposicoesRepository composicoesRepository;

    public boolean create(final Composicao composicao) {
        return composicoesRepository.create(composicao);
    }

    public Composicao update(final Composicao composicao) {
        return composicoesRepository.update(composicao);
    }

    public Composicao read(final Composicao composicao) {
        return composicoesRepository.read(composicao);
    }

    public int delete(final int codigo, final String origem) {
        return composicoesRepository.delete(codigo, origem);
    }
}

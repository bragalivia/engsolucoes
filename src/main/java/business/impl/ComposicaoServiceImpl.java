package business.impl;

import business.ComposicaoService;
import dao.ComposicaoRepository;
import rest.model.Composicao;

import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by Livia on 12/06/2016.
 */
public class ComposicaoServiceImpl implements ComposicaoService {
    @Autowired
    private ComposicaoRepository composicaoRepository;

    public boolean create(final Composicao composicao) {
        return composicaoRepository.create(composicao);
    }

    public Composicao update(final Composicao composicao) {
        return composicaoRepository.update(composicao);
    }

    public Composicao read(final Composicao composicao) {
        return composicaoRepository.read(composicao);
    }

    public int delete(final int codigo, final String origem) {
        return composicaoRepository.delete(codigo, origem);
    }
}

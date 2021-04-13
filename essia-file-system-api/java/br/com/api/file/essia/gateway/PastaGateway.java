package br.com.api.file.essia.gateway;

import br.com.api.file.essia.domain.Pasta;
import br.com.api.file.essia.domain.RespostaPaginacao;
import br.com.api.file.essia.exception.DocumentAlreadyExistsException;

public interface PastaGateway {
    Pasta saveOrUpdate(Pasta pasta) throws DocumentAlreadyExistsException;

    RespostaPaginacao<Pasta> findAll(Integer page, Integer size, Integer pai, String nome, Long id);

    void delete(Long id);
}

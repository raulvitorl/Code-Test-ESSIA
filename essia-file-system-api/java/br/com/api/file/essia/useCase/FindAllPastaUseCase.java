package br.com.api.file.essia.useCase;

import br.com.api.file.essia.domain.Pasta;
import br.com.api.file.essia.domain.RespostaPaginacao;

public interface FindAllPastaUseCase {
    RespostaPaginacao<Pasta> execute(Integer page, Integer size,Integer pai, String nome, Long id);
}

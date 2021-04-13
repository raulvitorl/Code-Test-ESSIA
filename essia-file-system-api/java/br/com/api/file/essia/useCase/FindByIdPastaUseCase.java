package br.com.api.file.essia.useCase;

import br.com.api.file.essia.domain.Pasta;

public interface FindByIdPastaUseCase {
    Pasta execute(Long pk);
}

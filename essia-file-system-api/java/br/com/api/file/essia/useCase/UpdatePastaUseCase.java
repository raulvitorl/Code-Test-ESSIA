package br.com.api.file.essia.useCase;

import br.com.api.file.essia.domain.Pasta;
import br.com.api.file.essia.exception.DocumentAlreadyExistsException;

public interface UpdatePastaUseCase {
    
	void execute(Pasta pasta) throws DocumentAlreadyExistsException;
	
}

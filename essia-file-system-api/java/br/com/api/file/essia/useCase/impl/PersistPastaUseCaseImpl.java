package br.com.api.file.essia.useCase.impl;

import org.springframework.stereotype.Service;

import br.com.api.file.essia.domain.Pasta;
import br.com.api.file.essia.exception.DocumentAlreadyExistsException;
import br.com.api.file.essia.gateway.PastaGateway;
import br.com.api.file.essia.useCase.PersistPastaUseCase;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PersistPastaUseCaseImpl implements PersistPastaUseCase {
	
    private final PastaGateway pastaGateway;

    @Override
    public Pasta execute(Pasta pasta) throws DocumentAlreadyExistsException {
		return pastaGateway.saveOrUpdate(pasta); 				
    }

}

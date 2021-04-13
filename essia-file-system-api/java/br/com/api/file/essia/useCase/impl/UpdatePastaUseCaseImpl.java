package br.com.api.file.essia.useCase.impl;

import org.springframework.stereotype.Service;

import br.com.api.file.essia.domain.Pasta;
import br.com.api.file.essia.exception.DocumentAlreadyExistsException;
import br.com.api.file.essia.gateway.PastaGateway;
import br.com.api.file.essia.useCase.UpdatePastaUseCase;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UpdatePastaUseCaseImpl implements UpdatePastaUseCase {
	
    private final PastaGateway pastaGateway;
	
	@Override
	public void execute(Pasta pasta) throws DocumentAlreadyExistsException {
		pastaGateway.saveOrUpdate(pasta);
	}
}

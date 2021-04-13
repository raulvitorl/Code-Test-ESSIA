package br.com.api.file.essia.useCase.impl;

import org.springframework.stereotype.Service;

import br.com.api.file.essia.gateway.PastaGateway;
import br.com.api.file.essia.useCase.DeletePastaUseCase;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class DeletePastaUseCaseImpl implements DeletePastaUseCase {
	
    private final PastaGateway pastaGateway;
  
    @Override
    public void execute(Long id) {
		pastaGateway.delete(id);		
    }
}

package br.com.api.file.essia.useCase.impl;

import org.springframework.stereotype.Service;

import br.com.api.file.essia.domain.Pasta;
import br.com.api.file.essia.domain.RespostaPaginacao;
import br.com.api.file.essia.gateway.PastaGateway;
import br.com.api.file.essia.useCase.FindAllPastaUseCase;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class FindAllPastaUseCaseImpl implements FindAllPastaUseCase {

    private final PastaGateway pastaGateway;

    @Override
    public RespostaPaginacao<Pasta> execute(Integer page, Integer size,Integer pai, String nome, Long id) {
        return pastaGateway.findAll(page,size,pai,nome,id);
    }

}

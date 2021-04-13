package br.com.api.file.essia.repository.converter;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import br.com.api.file.essia.domain.Pasta;
import br.com.api.file.essia.repository.entities.PastaEntity;
import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class PastaEntityConverter {
    private final ModelMapper mapper;

    public Pasta converter(PastaEntity PastaEntity) {
        return mapper.map(PastaEntity, Pasta.class);
    }

    public PastaEntity converter(Pasta pasta) {
        return mapper.map(pasta, PastaEntity.class);
    }
}

package br.com.api.file.essia.controller.converter;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import br.com.api.file.essia.controller.resource.PastaResource;
import br.com.api.file.essia.domain.Pasta;
import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class PastaResourceConverter {
    
	private final ModelMapper mapper;

    public Pasta converter(PastaResource pastaResource) {
        return mapper.map(pastaResource, Pasta.class);
    }

    public PastaResource converter(Pasta client) {
        return mapper.map(client, PastaResource.class);
    }

}

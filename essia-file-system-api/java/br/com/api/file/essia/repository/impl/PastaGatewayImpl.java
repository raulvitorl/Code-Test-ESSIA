package br.com.api.file.essia.repository.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.criteria.Predicate;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import br.com.api.file.essia.domain.Pasta;
import br.com.api.file.essia.domain.RespostaPaginacao;
import br.com.api.file.essia.exception.DocumentAlreadyExistsException;
import br.com.api.file.essia.gateway.PastaGateway;
import br.com.api.file.essia.repository.PastaRepository;
import br.com.api.file.essia.repository.converter.PastaEntityConverter;
import lombok.AllArgsConstructor;

@Component
@AllArgsConstructor
public class PastaGatewayImpl implements PastaGateway {

    private final PastaRepository pastaRepository;
    private final PastaEntityConverter pastaEntityConverter;

    @Override
    public RespostaPaginacao<Pasta> findAll(Integer page, Integer size, Integer pai, String nome, Long id) {    	
    	
    	Pageable pageable = PageRequest.of(page,size);
    	
    	Specification<Pasta> especificacao = (root, query, criteriaBuilder) -> {
    		List<Predicate> predicates = new ArrayList<>();
    		
    		if(!(pai==0))
    			predicates.add(criteriaBuilder.equal(root.get("pai"),pai ));
    		if(!(nome.length()==0))
    			predicates.add(criteriaBuilder.equal(root.get("nomePasta"),nome ));
    		if(!(id==0))
    			predicates.add(criteriaBuilder.equal(root.get("id"),id ));
    		
    		
    		return criteriaBuilder.and(predicates.toArray(new Predicate[predicates.size()]));
    	};
    	
    	List<Pasta> response =  pastaRepository.findAll(especificacao,pageable)
				.stream()
				.map(pastaEntityConverter::converter)
				.collect(Collectors.toList());    
    	return new RespostaPaginacao<Pasta>(response.size(), response);
    	
    	
    }


    @Override
    public void delete(Long id) {
        final var pasta = pastaRepository.findById(id);
        if (pasta.isEmpty()) throw new java.util.NoSuchElementException("Nenhum valor informado!");
         pastaRepository.delete(pasta.get());
         
    }

    @Override
    @Transactional
    public Pasta saveOrUpdate(Pasta pasta) throws DocumentAlreadyExistsException {
        if (pasta == null) throw new java.util.NoSuchElementException("Nenhum valor informado!");
        
        if((pastaRepository.findByNomePastaAndPai(pasta.getNomePasta(), pasta.getPai())==null) && !(pasta.getId()==null))
        	throw new DocumentAlreadyExistsException("Ja existe uma pasta com este nome no diretório de destino!");
        
        return pastaEntityConverter.converter(pastaRepository.save(pastaEntityConverter.converter(pasta)));
        
    }

}

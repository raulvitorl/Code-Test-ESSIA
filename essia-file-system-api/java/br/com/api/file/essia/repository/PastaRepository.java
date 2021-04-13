package br.com.api.file.essia.repository;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;

import br.com.api.file.essia.domain.Pasta;
import br.com.api.file.essia.repository.entities.PastaEntity;

public interface PastaRepository extends JpaRepository<PastaEntity, Long> {

	List<PastaEntity> findAll(Specification<Pasta> especificacao, Pageable pageable);
	
	PastaEntity findByNomePastaAndPai(String nomePasta, PastaEntity pai);

}

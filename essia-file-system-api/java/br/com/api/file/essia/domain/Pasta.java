package br.com.api.file.essia.domain;

import java.util.Set;

import br.com.api.file.essia.repository.entities.PastaEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.With;

@Data
@AllArgsConstructor
@NoArgsConstructor
@With
@Builder
public class Pasta {
   
	private Long id;	
	private String nomePasta;	
	private PastaEntity pai;
	private Set<PastaEntity> filhos;
    
}

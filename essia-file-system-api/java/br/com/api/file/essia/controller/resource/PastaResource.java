package br.com.api.file.essia.controller.resource;

import java.util.Set;

import javax.validation.constraints.NotNull;

import br.com.api.file.essia.repository.entities.PastaEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.With;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@With
public class PastaResource {	
	
	private Long id;	
	@NotNull
	private String nomePasta;	
	private PastaEntity pai;
	private Set<PastaEntity> filhos;

}

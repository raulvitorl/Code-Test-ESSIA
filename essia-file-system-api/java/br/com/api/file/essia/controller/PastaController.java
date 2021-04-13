package br.com.api.file.essia.controller;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.NO_CONTENT;
import static org.springframework.http.HttpStatus.OK;

import javax.transaction.Transactional;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.api.file.essia.controller.converter.PastaResourceConverter;
import br.com.api.file.essia.controller.resource.PastaResource;
import br.com.api.file.essia.domain.Pasta;
import br.com.api.file.essia.domain.RespostaPaginacao;
import br.com.api.file.essia.exception.DocumentAlreadyExistsException;
import br.com.api.file.essia.useCase.DeletePastaUseCase;
import br.com.api.file.essia.useCase.FindAllPastaUseCase;
import br.com.api.file.essia.useCase.PersistPastaUseCase;
import br.com.api.file.essia.useCase.UpdatePastaUseCase;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/v1/pastas")
public class PastaController {
	
	private final FindAllPastaUseCase findAllPastaUseCase;
	private final PersistPastaUseCase persistPastaUseCase;
	private final UpdatePastaUseCase updatePastaUseCase;
	private final DeletePastaUseCase deletePastaUseCase;
	private final PastaResourceConverter pastaResourceConverter;
	
	@GetMapping
	@ResponseStatus(OK)
	public RespostaPaginacao<Pasta> listAll(
		@RequestParam(defaultValue = "0") Integer page,
		@RequestParam(defaultValue = "5") Integer size,
		@RequestParam(defaultValue = "0") Integer pai,
		@RequestParam(defaultValue = "") String nome,
		@RequestParam(defaultValue = "0") Long id) {
		log.info("Find all pasta started!");
		
		
		return findAllPastaUseCase.execute(page,size,pai,nome,id);
	}

	
	@PostMapping
	@ResponseStatus(CREATED)
	@Transactional
	public Pasta persist(@RequestBody final PastaResource pastaResource) throws DocumentAlreadyExistsException{
		log.info("Persist pasta started!");
		log.info(String.format("Body: %s", pastaResource));		
		return persistPastaUseCase.execute(pastaResourceConverter.converter(pastaResource));
	}
	
	@PutMapping
	@ResponseStatus(NO_CONTENT)
	@Transactional
	public void update(@RequestBody final PastaResource pastaResource) throws DocumentAlreadyExistsException {
		log.info("Update pasta by id started!");
		log.info(String.format("Body: %s", pastaResource));		
		updatePastaUseCase.execute(pastaResourceConverter.converter(pastaResource));
		
	}
		
	@DeleteMapping
	@ResponseStatus(NO_CONTENT)
	@Transactional
	public void delete(@RequestParam final Long id) {
		log.info("Delete pasta by id started!");
		log.info(String.format("Path Variable: %s", id));
		
		deletePastaUseCase.execute(id);
	}
}

package br.com.api.file.essia.controller;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import br.com.api.file.essia.controller.converter.PastaResourceConverter;
import br.com.api.file.essia.domain.Pasta;
import br.com.api.file.essia.exception.DocumentAlreadyExistsException;
import br.com.api.file.essia.exception.DocumentNotFoundException;
import br.com.api.file.essia.useCase.DeletePastaUseCase;
import br.com.api.file.essia.useCase.PersistPastaUseCase;
import br.com.api.file.essia.useCase.UpdatePastaUseCase;

public class PastaControllerTest {  

    @Test
    public void shouldInsertPasta() throws DocumentAlreadyExistsException {
        final var pasta = Pasta
                .builder()
                .id((long) 1)
                .nomePasta("Filmes")
                .build();
        
        final var response =  when(Mockito.mock(PersistPastaUseCase.class).execute(Mockito.any(Pasta.class))).thenReturn(new Pasta().withId(pasta.getId()));

        assertNotNull(response);
        
    }

    @Test
    public void shouldUpdatePasta() throws DocumentAlreadyExistsException, DocumentNotFoundException {

        doNothing().when(Mockito.mock(UpdatePastaUseCase.class)).execute(Mockito.any(Pasta.class));

        Mockito.mock(PastaController.class).update(Mockito.mock(PastaResourceConverter.class).converter(Mockito.any(Pasta.class)));
    }



    @Test
    public void shouldDeletePasta() throws DocumentNotFoundException, DocumentAlreadyExistsException {
    
        doNothing().when(Mockito.mock(DeletePastaUseCase.class)).execute(Mockito.anyLong());

        Mockito.mock(PastaController.class).delete((long) 1);

    }

}

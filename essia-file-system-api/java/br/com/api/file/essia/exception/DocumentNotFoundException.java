package br.com.api.file.essia.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;


@ResponseStatus(code = HttpStatus.NOT_FOUND, reason = "Document Not Found")
public class DocumentNotFoundException extends Exception {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public DocumentNotFoundException() {

    }
    public DocumentNotFoundException(String msg) {
        super(msg);
    }
}

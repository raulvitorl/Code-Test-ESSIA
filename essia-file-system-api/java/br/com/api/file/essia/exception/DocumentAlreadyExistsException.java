/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.api.file.essia.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * @author Jadson Jhuan
 */
@ResponseStatus(code = HttpStatus.CONFLICT, reason = "Document Alread Exist")
public class DocumentAlreadyExistsException extends Exception {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public DocumentAlreadyExistsException(String message) {
        super(message);
    }
}

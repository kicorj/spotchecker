package br.com.projuris.challenge.spotchecker;

import javax.ws.rs.ProcessingException;

/**
 * InvalidMatrixFormatException Class
 * @author kico
 *
 */
public class InvalidMatrixFormatException extends ProcessingException {
	
	private static final long serialVersionUID = -5822510486928210251L;
	
	//The message is dedefined on Exception Mapper Class
	public InvalidMatrixFormatException() {
		super("");
	}
}

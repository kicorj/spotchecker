package br.com.projuris.challenge;

import javax.ws.rs.ProcessingException;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

/**
 * BadRequestExceptionHandler Class
 * @author kico
 *
 */
@Provider
public class BadRequestExceptionHandler implements ExceptionMapper<ProcessingException> {

	private static final String MESSAGE = "Invalid Matrix Format"; 
	
	@Override
	public Response toResponse(final ProcessingException exception) {
		return Response.status(Response.Status.BAD_REQUEST)
				.entity(prepareMessage(exception))
                .type("text/plain")
                .build();
		}

	private String prepareMessage(ProcessingException exception) {
       String msg = MESSAGE;
       return msg;
	}
  
  
}
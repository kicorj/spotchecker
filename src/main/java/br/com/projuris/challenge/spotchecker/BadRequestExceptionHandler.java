package br.com.projuris.challenge.spotchecker;

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
				.entity(MESSAGE)
                .type("text/plain")
                .build();
		}
}
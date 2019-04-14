package br.com.projuris.challenge.spotchecker;

import javax.ws.rs.NotAllowedException;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

/**
 * MehodNotAllowedExceptionHandler Class
 * @author kico
 *
 */
@Provider
public class MehodNotAllowedExceptionHandler implements ExceptionMapper<NotAllowedException> {

	private static final String MESSAGE = "Invalid Method"; 
	
	@Override
	public Response toResponse(final NotAllowedException exception) {
		return Response.status(Response.Status.METHOD_NOT_ALLOWED)
				.entity(prepareMessage(exception))
                .type("text/plain")
                .build();
		}

	private String prepareMessage(NotAllowedException exception) {
       return MESSAGE;
	}
  
}
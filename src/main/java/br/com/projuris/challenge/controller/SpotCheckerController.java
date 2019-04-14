package br.com.projuris.challenge.controller;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.ProcessingException;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import br.com.projuris.challenge.InvalidMatrixFormatException;
import br.com.projuris.challenge.SpotChecker;
import br.com.projuris.challenge.SpotCheckerResult;

/**
 * SpotCheckerController Class
 * @author kico
 *
 */
@Path("/")
public class SpotCheckerController {

	@POST
	@Path("spot_check")
    @Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
    public Response spotCheck(int[][] param) throws ProcessingException {
    	
    	SpotChecker checker;
    	
    	try {
			checker = new SpotChecker(param);
		} catch (InvalidMatrixFormatException e) {
			throw new ProcessingException("");
		}
    	
    	SpotCheckerResult result = checker.calculate();
    	
    	return Response
    		      .status(Response.Status.OK)
    		      .entity(result)
    		      .build();
    }
	
}

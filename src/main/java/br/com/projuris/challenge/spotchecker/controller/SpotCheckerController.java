package br.com.projuris.challenge.spotchecker.controller;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import br.com.projuris.challenge.spotchecker.checker.SpotCheckBuilder;
import br.com.projuris.challenge.spotchecker.checker.SpotCheckerResult;
import br.com.projuris.challenge.spotchecker.checker.action.AverageAreaAction;
import br.com.projuris.challenge.spotchecker.checker.action.BiggestSpotAreaAction;
import br.com.projuris.challenge.spotchecker.checker.action.TotalAreaAction;
import br.com.projuris.challenge.spotchecker.checker.action.NumberOfSpotsAction;

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
    public Response spotCheck(int[][] shape) {
    	
    	SpotCheckBuilder builder = new SpotCheckBuilder(shape);
    	builder.addAction(new TotalAreaAction());
    	builder.addAction(new NumberOfSpotsAction());
    	builder.addAction(new AverageAreaAction());
    	builder.addAction(new BiggestSpotAreaAction());
    	SpotCheckerResult result = builder.build();
    	
    	return Response
    		      .status(Response.Status.OK)
    		      .entity(result)
    		      .build();
    }
	
}

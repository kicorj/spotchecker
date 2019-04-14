package br.com.projuris.challenge.spotchecker.checker;

import static org.junit.Assert.assertTrue;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import br.com.projuris.challenge.spotchecker.InvalidMatrixFormatException;
import br.com.projuris.challenge.spotchecker.checker.action.AverageAreaAction;
import br.com.projuris.challenge.spotchecker.checker.action.BiggestSpotAreaAction;
import br.com.projuris.challenge.spotchecker.checker.action.TotalAreaAction;
import br.com.projuris.challenge.spotchecker.checker.action.NumberOfSpotsAction;

public class SpotCheckerResultTest {
	
	@Rule
	public ExpectedException exception = ExpectedException.none();

	@Test
	public void passShapeWithAllZeroValuesShouldReturnAllZero() {

		int[][] shape = {
    			{0,0,0,0},
    			{0,0,0,0},
    			{0,0,0,0},
    			{0,0,0,0},
    			};
		
		SpotCheckBuilder builder = new SpotCheckBuilder(shape);
    	builder.addAction(new TotalAreaAction());
    	builder.addAction(new NumberOfSpotsAction());
    	builder.addAction(new AverageAreaAction());
    	builder.addAction(new BiggestSpotAreaAction());
    	SpotCheckerResult result = builder.build();
    	
    	assertTrue(result.getBiggestSpotArea() == 0
    			&& result.getNumberOfSpots() == 0
    			&& result.getSpotsAverageArea() == 0d
    			&& result.getTotalArea() == 0);
	}
	
	@Test
	public void passShapeWithAllOneValuesShouldReturnOneSpotAndMaximumArea() {

		int[][] shape = {
    			{1,1,1,1},
    			{1,1,1,1},
    			{1,1,1,1},
    			{1,1,1,1},
    			};
		
		SpotCheckBuilder builder = new SpotCheckBuilder(shape);
    	builder.addAction(new TotalAreaAction());
    	builder.addAction(new NumberOfSpotsAction());
    	builder.addAction(new AverageAreaAction());
    	builder.addAction(new BiggestSpotAreaAction());
    	SpotCheckerResult result = builder.build();
    	
    	assertTrue(result.getBiggestSpotArea() == 16
    			&& result.getNumberOfSpots() == 1
    			&& result.getSpotsAverageArea() == 16d
    			&& result.getTotalArea() == 16);
	}
	
	@Test
	public void passShapeWithInvalidFormatShouldThrowsInvalidMatrixFormatException() {

		exception.expect(InvalidMatrixFormatException.class);
		
		int[][] shape = {
    			{1,1,1,1},
    			{1,1,1,1},
    			{1,1,1,1},
    			{1,1,1,11},
    			};
		
		SpotCheckBuilder builder = new SpotCheckBuilder(shape);
    	builder.addAction(new TotalAreaAction());
    	builder.addAction(new NumberOfSpotsAction());
    	builder.addAction(new AverageAreaAction());
    	builder.addAction(new BiggestSpotAreaAction());
    	builder.build();
	}

}

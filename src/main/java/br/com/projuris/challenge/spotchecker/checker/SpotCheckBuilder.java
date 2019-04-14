package br.com.projuris.challenge.spotchecker.checker;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.ProcessingException;

import br.com.projuris.challenge.spotchecker.InvalidMatrixFormatException;
import br.com.projuris.challenge.spotchecker.checker.action.SpotCheckerAction;

public class SpotCheckBuilder {

	private List<SpotCheckerAction> actions;
	private int[][] shape;

	public SpotCheckBuilder(int[][] shape) {
		this.actions = new ArrayList<>();
		this.shape = shape;
	}
	
	public void addAction(SpotCheckerAction action) {
		this.actions.add(action);
	}
	
	public SpotCheckerResult build() {
		
		SpotChecker spotChecker;
		
		try {
			spotChecker = new SpotChecker(shape);
		} catch (InvalidMatrixFormatException e) {
			throw new ProcessingException("");
		}

		//Obtain the list of spots
		spotChecker.calculateSpotList();
		
		//Loop through the list of actions to be calculated after obtaining the list of spots
		for(SpotCheckerAction action : actions) {
			action.execute(spotChecker);
        }
		
		return new SpotCheckerResult(spotChecker.getTotalArea(), 
				spotChecker.getTotalSpots(),
				spotChecker.getSpotsAverageArea(),
				spotChecker.getBiggestSpotArea());
		
	}
	
}

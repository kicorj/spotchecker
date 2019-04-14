package br.com.projuris.challenge.spotchecker.checker.action;

import br.com.projuris.challenge.spotchecker.checker.SpotChecker;

/**
 * This class is responsible for calculating the average of spots of the total area
 * @author kico
 *
 */
public class AverageAreaAction implements SpotCheckerAction {

	@Override
	public void execute(SpotChecker spotChecker) {
		
		double averageArea = spotChecker.getTotalSpots() == 0 
								? 0 
								: (double) spotChecker.getTotalArea() / spotChecker.getTotalSpots();
		
		spotChecker.setSpotsAverageArea(averageArea);
	}

}

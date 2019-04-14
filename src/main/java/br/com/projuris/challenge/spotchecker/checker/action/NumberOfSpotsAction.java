package br.com.projuris.challenge.spotchecker.checker.action;

import br.com.projuris.challenge.spotchecker.checker.SpotChecker;

/**
 * This class is responsible for calculating the number of spots of the total area
 * @author kico
 *
 */
public class NumberOfSpotsAction implements SpotCheckerAction {

	@Override
	public void execute(SpotChecker spotChecker) {
		
		int totalSpots = spotChecker.getSpotList() == null ? 0 : spotChecker.getSpotList().size();
		spotChecker.setTotalSpots(totalSpots);
	}

}

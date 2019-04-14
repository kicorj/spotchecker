package br.com.projuris.challenge.spotchecker.checker.action;

import br.com.projuris.challenge.spotchecker.checker.SpotChecker;

/**
 * This class is responsible for calculating the total area of the shape
 * @author kico
 *
 */
public class TotalAreaAction implements SpotCheckerAction {

	@Override
	public void execute(SpotChecker spotChecker) {
		
		int totalArea = spotChecker.getSpotList() == null 
						? 0 
						: spotChecker.getSpotList().stream().mapToInt(i -> i.intValue()).sum();

		spotChecker.setTotalArea(totalArea);
	}

}

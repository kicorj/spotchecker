package br.com.projuris.challenge.spotchecker.checker.action;

import br.com.projuris.challenge.spotchecker.checker.SpotChecker;

public class TotalSpotsAction implements SpotCheckerAction {

	@Override
	public void execute(SpotChecker spotChecker) {
		
		int totalSpots = spotChecker.getSpotList() == null ? 0 : spotChecker.getSpotList().size();
		spotChecker.setTotalSpots(totalSpots);
	}

}

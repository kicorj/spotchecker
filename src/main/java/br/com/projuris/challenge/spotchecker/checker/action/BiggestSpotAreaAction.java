package br.com.projuris.challenge.spotchecker.checker.action;

import br.com.projuris.challenge.spotchecker.checker.SpotChecker;

public class BiggestSpotAreaAction implements SpotCheckerAction {

	@Override
	public void execute(SpotChecker spotChecker) {
		
		int biggestSpotArea = spotChecker.getSpotList() == null 
						? 0 
						: spotChecker.getSpotList().stream().mapToInt(i -> i.intValue()).max().orElse(0);
		
		spotChecker.setBiggestSpotArea(biggestSpotArea);
	}

}

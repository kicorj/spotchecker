package br.com.projuris.challenge.spotchecker.checker.action;

import br.com.projuris.challenge.spotchecker.checker.SpotChecker;

public class TotalAreaAction implements SpotCheckerAction {

	@Override
	public void execute(SpotChecker spotChecker) {
		
		int totalArea = spotChecker.getSpotList() == null 
						? 0 
						: spotChecker.getSpotList().stream().mapToInt(i -> i.intValue()).sum();
		
		spotChecker.setTotalArea(totalArea);
	}

}

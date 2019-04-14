package br.com.projuris.challenge.spotchecker.checker;

import javax.json.bind.annotation.JsonbProperty;

/**
 * SpotCheckerResult Class
 * @author kico
 *
 */
public class SpotCheckerResult {

	@JsonbProperty("total_area")
	private final int totalArea;
	@JsonbProperty("number_of_spots")
	private final int numberOfSpots;
	@JsonbProperty("spots_average_area")
	private final double spotsAverageArea;
	@JsonbProperty("biggest_spot_area")
	private final int biggestSpotArea;
	
	public SpotCheckerResult(int totalArea, int numberOfSpots, double spotsAverageArea, int biggestSpotArea) {
		super();
		this.totalArea = totalArea;
		this.numberOfSpots = numberOfSpots;
		this.spotsAverageArea = spotsAverageArea;
		this.biggestSpotArea = biggestSpotArea;
	}

	public int getTotalArea() {
		return totalArea;
	}

	public int getNumberOfSpots() {
		return numberOfSpots;
	}

	public double getSpotsAverageArea() {
		return spotsAverageArea;
	}

	public int getBiggestSpotArea() {
		return biggestSpotArea;
	}
}

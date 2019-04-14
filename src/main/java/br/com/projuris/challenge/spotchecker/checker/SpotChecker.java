package br.com.projuris.challenge.spotchecker.checker;

import java.util.ArrayList;
import java.util.List;

import br.com.projuris.challenge.spotchecker.InvalidMatrixFormatException;

/**
 * SpotChecker Class
 * @author kico
 * 
 */
public class SpotChecker {

	private static final int CLEAN_PIXEL = 0;
	private static final int SPOTTED_PIXEL = 1;
	private static final int SHAPE_SIZE = 4;
	private int [][] shape;
	
	private List<Integer> spotList = new ArrayList<>();
	private int totalArea = 0;
	private int totalSpots = 0;
	private double spotsAverageArea = 0d;
	private int biggestSpotArea = 0;
	
	public SpotChecker(int[][] shape) {
		super();
		this.shape = shape;
		
		if (!this.isValidShape())
			throw new InvalidMatrixFormatException();
	}
	
	/**
	 * This method verify if the array dimension and format is correct.
	 * If bidemensional array have the correct size and each element have a valid value (0 or 1) then returns true
	 * 
	 * @return is valid shape or not
	 */
	private boolean isValidShape() {
		if (shape.length != SHAPE_SIZE) {
    		return false;
    	}
		
		for (int i=0; i < shape.length; i++) {
        	if (shape[i].length != SHAPE_SIZE) {
        		return false;
        	}
        	for (int j=0; j < shape[i].length; j++) {
        		if (shape[i][j] != CLEAN_PIXEL && shape[i][j] != SPOTTED_PIXEL) {
            		return false;
            	}
        	}
        }
		
		return true;
	}
	
	/**
	 * Recursive method that travels the array in search of spots
	 * @param array
	 * @param x
	 * @param y
	 * @param islandList
	 * @param index
	 */
	private void findSpot(int[][] array, int x, int y, int index) {
		
		// First test invalid coordinates
		if(x < 0) {
			return;
		}
		if(y < 0) {
			return;
		}
		if(x == array.length) {
			return;
		}
		if(y == array[x].length) {
			return;
		}
		
		//Search North, South, East and West directions
        if (array[x][y] == 1) {
        	//Mark spoted pixel as 0 to not be counted again
            array[x][y] = 0;
            int sum = spotList.get(index) + 1;
            spotList.set(index, sum);
            findSpot(array, x - 1, y, index);
            findSpot(array, x + 1, y, index);
            findSpot(array, x, y + 1, index);
            findSpot(array, x, y - 1, index);
        }
    }
	
	public void calculateSpotList() {
		int sumSpots = 0;
 		for(int i=0; i < shape.length; i++){
             for(int j=0; j < shape[i].length; j++){
                 if(shape[i][j] == 1){
                     spotList.add(0);
                     sumSpots++;
                     findSpot(shape,i,j, sumSpots - 1);
                 }
             }
         }
	}

	public List<Integer> getSpotList() {
		return spotList;
	}

	public int getTotalArea() {
		return totalArea;
	}

	public void setTotalArea(int totalArea) {
		this.totalArea = totalArea;
	}

	public int getTotalSpots() {
		return totalSpots;
	}

	public void setTotalSpots(int totalSpots) {
		this.totalSpots = totalSpots;
	}

	public double getSpotsAverageArea() {
		return spotsAverageArea;
	}

	public void setSpotsAverageArea(double spotsAverageArea) {
		this.spotsAverageArea = spotsAverageArea;
	}

	public int getBiggestSpotArea() {
		return biggestSpotArea;
	}

	public void setBiggestSpotArea(int biggestSpotArea) {
		this.biggestSpotArea = biggestSpotArea;
	}
	
}

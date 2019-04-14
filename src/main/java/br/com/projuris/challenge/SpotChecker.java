package br.com.projuris.challenge;

import java.util.ArrayList;
import java.util.List;

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
	int totalSpots = 0;
	private List<Integer> islandList = new ArrayList<Integer>();
	
	public SpotChecker(int[][] shape) throws InvalidMatrixFormatException {
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
	private void findSpot(int[][] array, int x, int y, List<Integer> islandList, int index) {
		
		// First test invalid coordinates
		if(x < 0) return;
		if(y < 0) return;
		if(x == array.length) return;
		if(y == array[x].length) return;
		
		//Search North, South, East and West directions
        if (array[x][y] == 1) {
        	//Mark spoted pixel as 0 to not be counted again
            array[x][y] = 0;
            int sum = islandList.get(index) + 1;
            islandList.set(index, sum);
            findSpot(array, x - 1, y, islandList, index);
            findSpot(array, x + 1, y, islandList, index);
            findSpot(array, x, y + 1, islandList, index);
            findSpot(array, x, y - 1, islandList, index);
        }
    }
	
	private int calculateTotalArea() {
		return islandList.stream().mapToInt(i -> i.intValue()).sum();
	}
	
	private int calculateBiggestSpotArea() {
		return islandList.stream().mapToInt(i -> i.intValue()).max().orElse(0);
	}
	
	private double calculateAverageArea(int totalArea) {
		return totalSpots == 0 ? 0 : (double) totalArea/totalSpots;
	}
	
	public SpotCheckerResult calculate() {

		totalSpots = 0;
 		for(int i=0; i < shape.length; i++){
             for(int j=0; j < shape[i].length; j++){
                 if(shape[i][j] == 1){
                	 totalSpots ++;
                     islandList.add(0);
                     findSpot(shape,i,j, islandList, totalSpots - 1);
                 }
  
             }
         }
 		
 		int totalArea = calculateTotalArea();
 		double spotsAverageArea = calculateAverageArea(totalArea);
 		int max = calculateBiggestSpotArea();
 		
 		SpotCheckerResult result = new SpotCheckerResult(totalArea,totalSpots,spotsAverageArea, max);

 		return result;
	}
	
}

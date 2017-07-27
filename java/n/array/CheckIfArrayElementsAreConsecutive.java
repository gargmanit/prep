package n.array;

import java.util.Arrays;

/*http://www.geeksforgeeks.org/check-if-array-elements-are-consecutive*/
	

public class CheckIfArrayElementsAreConsecutive {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

        int input[] = {76,78,75,80,73,74};
        CheckIfArrayElementsAreConsecutive cia = new CheckIfArrayElementsAreConsecutive();
        System.out.println(cia.areConsecutive(input));
        System.out.println(cia.areConsecutiveWithoutSort(input));
    
	}

	private boolean areConsecutive(int[] input) {
	if((input.length<1))
	return true;
	Arrays.sort(input);
	for(int i=1;i<input.length;i++){
		if(input[i]-input[i-1]!=1)
			return false;
	}
		
		return true;
	}
	
	private boolean areConsecutiveWithoutSort(int[] input) {
		if((input.length<1))
		return true;
	int min =input[0];
	int max =input[0];
	int  arraySum=0;
		for(int i=0;i<input.length;i++){
			arraySum+=input[i];
			if(input[i]<min)
				min=input[i];
			if(input[i]>max)
				max=input[i];
		}
		
		int consecutiveSum = ((min-1)*input.length)+input.length*(input.length+1)/2;
			
			return consecutiveSum==arraySum;
		}

}

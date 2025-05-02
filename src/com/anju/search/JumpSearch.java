package com.anju.search;
/*
 * Jump Search: Similar to Binary Search, but instead of jumping forward and backwards we only jump forwards in Jump Search
 * Prerequisite: Sorted Array
 * Logic: In Jump Search, we jump in the interval sqrt(arraylength) ahead until we reach an element greater than 
 * 			search element or end of the array. If we encounter an element greater than search element, we run a Linear Search between 
 * 			the previous step and the current step.
 * */
public class JumpSearch {
	public static void jumpSearch(int[] arr, int searchFor) {
		int jumpSteps = (int) Math.sqrt(arr.length);		
		int index = 0;
		while(index < arr.length && arr[index] < searchFor) {
			index = index + jumpSteps;
		}
		int foundAt = -1;
		for(int i=Math.max(0, (index-jumpSteps)); i<= Math.min(arr.length-1, index); i++) {			
			 if(arr[i] == searchFor) {
				 foundAt = i;
				 break;
			 }
		}
		if(foundAt >= 0) System.out.println("Found "+ searchFor + " at "+foundAt);
		else System.out.println("Cannot locate "+searchFor);
	}
	public static void main(String[] args) {
		int[] arr = {3, 14, 17, 18, 20, 23, 27, 38, 41, 44, 72, 89, 90, 97};
		int searchFor = 17;
		jumpSearch(arr, searchFor);
	}

}

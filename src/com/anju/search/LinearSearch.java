package com.anju.search;

/*
Loop and search till found in Unsorted Array

Pros: Easy to implement and understand, does not require sorted data.
Cons: Inefficient for large data sets, as it has a worst-case time complexity of O(n).
 * */
public class LinearSearch {

	public static void main(String[] args) {
		int[] arr = {5, 7, 9, 12, 17, 3, 6};
		int searchFor = 12; boolean hasFound = false;
		for(int i=0; i<arr.length; i++) {
			if(arr[i] == searchFor) {
				System.out.println("Found "+ searchFor + " at position "+i);
				hasFound = true;
				break;
			}
		}
		if(! hasFound) System.out.println("No Found "+ searchFor);
	}

}

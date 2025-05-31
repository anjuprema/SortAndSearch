package com.anju.search;
/**
 * Interpolation Search: Use when data is sorted and evenly distributed. 
 *  	Use interpolation formula to guess the best possible location of element
 * Pre-requisite: Sorted Array, Data is evenly distributed, large data set
 * Logic: Guess best possible location of element using Interpolation formula 
 * 		int position = startIndex + (((lastIndex-startIndex)/(integers[lastIndex]-integers[startIndex]))*(elementToSearch - integers[startIndex]));
 * Pros: The best case time complexity for this algorithm is O(log log N) but in the worst case, 
 * 		i.e. when the elements are not uniformly distributed, it is comparable to linear search time complexity which is O(N)
 * Cons: Performs best when data is large, otherwise performs like Linear search
 * */
public class InterpolationSearch {
	private boolean interpolationSearch(Integer[] arr, int itemToSearch) {
		int startIndex = 0;
		int lastIndex = arr.length-1;
		int length = lastIndex - startIndex;
		
		//till start position <= end position & searchItem >= item at start & searchItem <= item at end
		while((startIndex <= lastIndex) && (itemToSearch >= arr[startIndex]) && (itemToSearch <= lastIndex)) {
			int position = startIndex + ((length/(arr[lastIndex]-arr[startIndex])) * (itemToSearch - arr[startIndex]));
			
			if(arr[position] == itemToSearch) {
				return true;
			} else if(itemToSearch < arr[position]) {
				lastIndex = position;
			} else {
				startIndex = position;
			}
		}
		return false;		
	}
	public static void main(String[] args) {
		InterpolationSearch is = new InterpolationSearch();
		Integer[] intArr = {12, 15, 20, 29, 43, 45, 62, 81, 93, 107, 110};
		int itemToSearch = 108;
		
		boolean isPresent = is.interpolationSearch(intArr, itemToSearch);
		if(isPresent) System.out.println(itemToSearch + " is present in array");
		else System.out.println(itemToSearch + " is not present in array");
	}

}

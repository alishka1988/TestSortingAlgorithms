import java.util.Arrays;
import java.lang.reflect.Array;

public class SortingAlgorithms <E extends Comparable> {
	
	E [] unsorted_array;
	E [] sorted_array;
	int running_time=0;
	String sort_type="";
			
		
	public SortingAlgorithms() {}
	
	

	public SortingAlgorithms(E [] arr, String Sort_type) {
		
        Double [] numeric_elements_to_sort=new Double [arr.length];
		boolean isNumeric=true;
		String sort_type=Sort_type;
        
		if(sort_type=="numeric") { //if sort type is numeric, check that array is numeric
		//if isNumeric stays true, then entire array is numeric
        for (int i=0; i<arr.length; i++) {	
        	try {
        		
        		Double elem=Double.parseDouble(arr[i].toString());
        		numeric_elements_to_sort[i]=elem;
        		
        	}catch (Exception e) {
        		
        		isNumeric=false;
        	}
        	
        }}
     
		
		 
		 if( sort_type == "alphanumeric") {
			 unsorted_array=(E [])arr;
			 sorted_array=(E [])arr;
         }else if (isNumeric==true && sort_type == "numeric") {
        	 unsorted_array=(E [])numeric_elements_to_sort;
        	 sorted_array=(E [])numeric_elements_to_sort;

         }else {
        	 System.out.println("Cannot sort alphanumeric array in numeric order. Exiting...");
        	 System.exit(0);
         }
         
		 
        }
	
public E [] getUnsortedArray(){
		
		return unsorted_array;
	}
		
	public void print() {
		System.out.print("Sorted array: ");
		for(int i=0; i<sorted_array.length; i++)		
			System.out.print(sorted_array[i]+" ");
			System.out.println("");
	}
	
public void mergeSort() {
		
		int arr_length=unsorted_array.length;
		E [] temp_array=unsorted_array;
		mergeSortFunction(temp_array, 0, arr_length-1);
		 sorted_array=temp_array;
		
		
}
public void mergeSortFunction(E [] temp_array, int start, int stop) {

	if (start < stop) {
		running_time++;
		int middle=(start+stop)/2;
		//divide array into 2 parts and mergeSort each part
		mergeSortFunction(temp_array, start, middle);
		mergeSortFunction(temp_array, middle+1, stop);
		//merge sorted parts
        merge(temp_array, start, middle, middle+1,stop);
		
	
	}
}
@SuppressWarnings("unchecked") // Safe, because of Array.newInstance
	  
	public  void merge( E [] temp_array,int start1, int stop1, int start2, int stop2) {

 int array1_size=stop1-start1+1;
 int array2_size=stop2-start2+1;
	
	E [] first_half_array=(E[]) new Comparable[array1_size];
	E [] second_half_array=(E[]) new Comparable[array2_size];
	
	//array 1: 0 thru middle
	for(int i=0; i<array1_size; i++)
		first_half_array[i]=temp_array[start1+i];
	//array 2: middle + 1 throu last index of array
	for(int i=0; i<array2_size; i++)
		second_half_array[i]=temp_array[start2+i];
	

   int arr1_ind=0;
   int arr2_ind=0; 
   int temp_array_start_index=start1;
   running_time++;
    while (arr1_ind < array1_size && arr2_ind < array2_size) 
    { 
    	
    	running_time++;
    	//loop thru array1 and array2
    	//compare current element of array1 to current element of array2
    	//take the smaller element and update the temp array
        if (compare(first_half_array[arr1_ind], second_half_array[arr2_ind])>0) 
        { 
            temp_array[temp_array_start_index] = second_half_array[arr2_ind];
            arr2_ind++;
        } 
        else
        { 
            temp_array[temp_array_start_index] =first_half_array[arr1_ind]; 
        arr1_ind++;
        } 
        temp_array_start_index++;
        
    } 

    //if first array is bigger than second array
    //loop through first array and update temp array with current element
    while (arr1_ind < array1_size) 
    { 
    	running_time++;
        temp_array[temp_array_start_index] =first_half_array[arr1_ind]; 
        temp_array_start_index++;
        arr1_ind++;
    } 

//if second array is bigger than first array
//loop through second array and update temp array with current element

    while (arr2_ind < array2_size) 
    { 
    	running_time++;
    	temp_array[temp_array_start_index] =second_half_array[arr2_ind]; 
        temp_array_start_index++;
        arr2_ind++; 
    } 
} 


	
	public void quickSort(int low, int high) {
		
		int pivot_idx=0; 
		
		if (low < high)
	    {
			running_time++;
	        pivot_idx = partition( low, high);
	        quickSort( low, pivot_idx - 1);  // quicksort partition to the left of pivot
	        quickSort( pivot_idx + 1, high); // quicksort partition to the right of pivot
	    }
		
	}
	
	public int partition (int low, int high)
	{
		//initially the pivot is the element in the last position
	    E pivot = sorted_array[high];  
	    //initialize LEFT starting point
	    int left = (low - 1);
	    
	 //initially, RIGHT starting point equals LEFT starting point
	 //keep moving RIGHT starting point to the right until we get to the end of the array 
	    for (int right = low; right <= high; right++)
	    {
	    	running_time++;
	        // If elem at RIGHT starting point < pivot, exchange RIGHT and LEFT elems
	        if (compare(sorted_array[right],pivot)<0)
	        {
	            left++;    // increment LEFT starting point
	            swapElements(left,right); //keep adding elements smaller than the pivot to the right of the last element smaller than the pivot
	    }
	    }
	    //when we get to the end of the array, swap pivot with the element directly to the right of the last added element smaller than the pivot
	    swapElements( left+ 1,high); 
	  //all elements to the LEFT of (left+1) are <  pivot, we can exchange the elemnt to the right of the last element < pivot with the pivot
		   running_time++;
	    return left+1; //element at left+1 is now in place
	}
	
	public void insertionSort() {
		int i = 1;
		//start at index=1 and perform successive swaps until all elements to the left are sorted
		//increment index and then re-sort elements to the left with the same swapping method
		//keep going until we get to the end of the array
		while (i < sorted_array.length) {
		   int j = i;
		   running_time++;
		    while (j > 0 && compare(sorted_array[j-1],sorted_array[j])>0) {
		    	
		    	swapElements(j,j-1); 
		        j--;
		}
		    i++;
		    
	}
		running_time++;
	}
		
		
	
	public int compare(E element1, E element2) 
	  { 
		
		  return ((Comparable<E>) element1).compareTo(element2);
	  } 
		
	public void swapElements(int index1, int index2) {
		  
		E temp=sorted_array[index1];
		sorted_array[index1]=sorted_array[index2];
		sorted_array[index2]=temp;
		  
		  
	  }
	public int getRunningTime() {
		
		return running_time;
	}
	public E [] getSortedArray() {
		
		return sorted_array;
	}
	public void reset() {
		
		running_time=0;
		sorted_array=unsorted_array;
	}
	
	public static void main(String[] args) {
		
		String numbers_comma_delim="10,3,0,1.3,40,5,8.3,10,0.3";
		String sort_type="numeric";
	
	     String [] elements_to_sort=numbers_comma_delim.split(",");
        
         
      
         SortingAlgorithms test=new SortingAlgorithms(elements_to_sort,sort_type);
         
         
     	int arr_size=elements_to_sort.length;

         System.out.println("Testing quicksort...");
     	test.reset();
     	test.quickSort(0,arr_size-1);
     	test.print();
     	System.out.println("quicksort Best: "+"O("+arr_size*Math.log(arr_size)/Math.log(2)+")");
     	System.out.println("quicksort Average: "+"O("+arr_size*Math.log(arr_size)/Math.log(2)+")");
     	System.out.println("quicksort Worst: "+"O("+Math.pow(arr_size, 2)+")");
     	System.out.println("quicksort Actual: "+test.getRunningTime());

    System.out.println("Testing insertion sort...");
 	test.reset();
	test.insertionSort();
	test.print();
	System.out.println("Insertion sort Best: "+"O("+arr_size+")");
	System.out.println("Insertion sort Average: "+"O("+Math.pow(arr_size,2)+")");
	System.out.println("Insertion sort Worst: "+"O("+Math.pow(arr_size, 2)+")");
	System.out.println("Insertion sort Actual: "+test.getRunningTime());
	
	System.out.println("Testing merge sort...");
 	test.reset();
 	
	test.mergeSort();
	test.print();
	System.out.println("Merge sort Best: "+"O("+arr_size+")");
	System.out.println("Merge sort Average: "+"O("+Math.pow(arr_size,2)+")");
	System.out.println("Merge sort Worst: "+"O("+Math.pow(arr_size, 2)+")");
	System.out.println("Merge sort Actual: "+test.getRunningTime());
	
	
	
}
}

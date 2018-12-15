import org.junit.*;
import java.util.Random;
import static org.junit.Assert.assertEquals;


public class TestRunner <E extends Comparable>{
	
	
	@Test
	public void testInsertionSortOnDouble() {
		
		int size_of_array=50;
		
		Comparable [] test_array=new Comparable [size_of_array];
		
		
		for(int i=0; i<test_array.length; i++)
			test_array[i] = Math.random()*25;
		
		//test insertion sort on a random array of doubles
		SortingAlgorithms sa = new SortingAlgorithms(test_array,"numeric");
		sa.insertionSort();
		sa.print();
		boolean sorted=true;
		Comparable prev=0;
		Comparable [] output_array=sa.getSortedArray();
		for(int i=1; i<output_array.length; i++)
		{
			Comparable cur=output_array[i];
			prev=output_array[i-1];
			if(cur.compareTo(prev) <0) {	
				sorted=false;
				break;
			}
			prev=cur;
			
		}
		
		assertEquals(sorted,true);

	}

	@Test
	public void testInsertionSortOnString() {
		
		int size_of_array=50;
		
		Comparable [] test_array=new Comparable [size_of_array];
		
		
		for(int i=0; i<test_array.length; i++)
			test_array[i] = Double.toString(Math.random()*25);
		
		//test insertion sort on a random array of doubles
		SortingAlgorithms sa = new SortingAlgorithms(test_array,"alphanumeric");
		sa.insertionSort();
		sa.print();
		boolean sorted=true;
		Comparable prev=0;
		Comparable [] output_array=sa.getSortedArray();
		for(int i=1; i<output_array.length; i++)
		{
			Comparable cur=output_array[i];
			prev=output_array[i-1];
			if(cur.compareTo(prev) <0) {	
				sorted=false;
				break;
			}
			prev=cur;
			
		}
		
		assertEquals(sorted,true);

	}
	@Test
	public void testquickSortOnDouble() {
		
		int size_of_array=50;
		
		Comparable [] test_array=new Comparable [size_of_array];
		
		
		for(int i=0; i<test_array.length; i++)
			test_array[i] = Math.random()*25;
		
		//test quick sort on a random array of doubles 
		SortingAlgorithms sa = new SortingAlgorithms(test_array,"numeric");
		sa.quickSort(0,test_array.length-1);
		sa.print();
		boolean sorted=true;
		Comparable prev=0;
		Comparable [] output_array=sa.getSortedArray();
		for(int i=1; i<output_array.length; i++)
		{
			Comparable cur=output_array[i];
			prev=output_array[i-1];
			if(cur.compareTo(prev) <0) {	
				sorted=false;
				break;
			}
			prev=cur;
			
		}
		
		assertEquals(sorted,true);

	}

	@Test
	public void testquickSortOnString() {
		
		int size_of_array=50;
		
		Comparable [] test_array=new Comparable [size_of_array];
		
		
		for(int i=0; i<test_array.length; i++)
			test_array[i] = Double.toString(Math.random()*25);
		
		//test quick sort on a random array of doubles converted to Strings
		SortingAlgorithms sa = new SortingAlgorithms(test_array,"alphanumeric");
		sa.quickSort(0,test_array.length-1);
		sa.print();
		boolean sorted=true;
		Comparable prev=0;
		Comparable [] output_array=sa.getSortedArray();
		for(int i=1; i<output_array.length; i++)
		{
			Comparable cur=output_array[i];
			prev=output_array[i-1];
			if(cur.compareTo(prev) <0) {	
				sorted=false;
				break;
			}
			prev=cur;
			
		}
		
		assertEquals(sorted,true);

	}
	@Test
	public void testmergeSortOnDouble() {
		
		int size_of_array=50;
		
		Comparable [] test_array=new Comparable [size_of_array];
		
		
		for(int i=0; i<test_array.length; i++)
			test_array[i] = Math.random()*25;
		
		//test merge sort on a random array of doubles 
		SortingAlgorithms sa = new SortingAlgorithms(test_array,"numeric");
		sa.mergeSort();
		sa.print();
		boolean sorted=true;
		Comparable prev=0;
		Comparable [] output_array=sa.getSortedArray();
		for(int i=1; i<output_array.length; i++)
		{
			Comparable cur=output_array[i];
			prev=output_array[i-1];
			if(cur.compareTo(prev) <0) {	
				sorted=false;
				break;
			}
			prev=cur;
			
		}
		
		assertEquals(sorted,true);

	}

	@Test
	public void testmergeSortOnString() {
		
		int size_of_array=50;
		
		Comparable [] test_array=new Comparable [size_of_array];
		
		
		for(int i=0; i<test_array.length; i++)
			test_array[i] = Double.toString(Math.random()*25);
		
		//test merge sort on a random array of doubles converted to Strings
		SortingAlgorithms sa = new SortingAlgorithms(test_array,"alphanumeric");
		sa.mergeSort();
		sa.print();
		boolean sorted=true;
		Comparable prev=0;
		Comparable [] output_array=sa.getSortedArray();
		for(int i=1; i<output_array.length; i++)
		{
			Comparable cur=output_array[i];
			prev=output_array[i-1];
			if(cur.compareTo(prev) <0) {	
				sorted=false;
				break;
			}
			prev=cur;
			
		}
		
		assertEquals(sorted,true);

	}

}

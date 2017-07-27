package n.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;


/**
 * Given a list of lists. Each element in the list is sorted. Sort the 
 * entire list.
 * Test cases
 * One or more lists are empty
 * All elements in one list are smaller than all elements in another list
 */

public class ChunkMerge {

	public static void main(String[] args) {

        Integer arr1[] = {1,5,6,9,21};
        Integer arr2[] = {4,6,11,14};
        Integer arr3[] = {-1,0,7};
        Integer arr4[] = {-4,-2,11,14,18};
        Integer arr5[] = {-100,0,2,6,100,200,600};
        Integer arr6[] = {-5,-2,1,5,7,11,14};
        Integer arr7[] = {-6,-1,0,15,17,22,24};
        
        List<Integer> list1 = Arrays.asList(arr1);
        List<Integer> list2 = Arrays.asList(arr2);
        List<Integer> list3 = Arrays.asList(arr3);
        List<Integer> list4 = Arrays.asList(arr4);
        List<Integer> list5 = Arrays.asList(arr5);
        List<Integer> list6 = Arrays.asList(arr6);
        List<Integer> list7 = Arrays.asList(arr7);
        
        
        List<List<Integer>> chunks = new ArrayList<List<Integer>>();
        chunks.add(list1);
        chunks.add(list2);
        chunks.add(list3);
        chunks.add(list4);
        chunks.add(list5);
        chunks.add(list6);
        chunks.add(list7);
        
        ChunkMerge cm = new ChunkMerge();
        List<Integer> result = cm.mergeChunksOfDifferentSize(chunks);
        System.out.println(result.size());
        for(Integer r : result){
            System.out.print(r + " ");
        }
        
   Object[]   result2 = cm.mergeChunksOfDifferentSizeWithHeap(chunks);
        System.out.println();
        for(Object r : result2){
            System.out.print((int)r + " ");
        }
    

	}

	private List<Integer> mergeChunksOfDifferentSize(List<List<Integer>> chunks) {
		// TODO Auto-generated method stub
		if(chunks.size()<2)
			return chunks.get(0);
		ArrayList<Integer> mergedList = new ArrayList<Integer>();
		List<Integer> list = chunks.get(0);
		mergedList.addAll(list);
		for(int i=1; i<chunks.size();i++){
			list = chunks.get(i);
			int index =0;
			for (Integer integer : list) {
				
				while(index<mergedList.size()&&mergedList.get(index)<integer){
					index++;	
				}
				mergedList.add(index, integer);
			}
			
		}
		
		
		return mergedList;
	}

	private Object[] mergeChunksOfDifferentSizeWithHeap(List<List<Integer>> chunks) {
		//ArrayList<Integer> mergedList = new ArrayList<Integer>();
		PriorityQueue<Integer> mergedList = new PriorityQueue<Integer>(new Comparator<Integer>(){
			public int compare(Integer o1, Integer o2){
				if(o1.compareTo(o2)>0)
				return 1;
				if(o1.compareTo(o2)<0)
					return -1;
				return 0;
			}
		});
		for(int i =0;i<chunks.size();i++){
			List<Integer> list = chunks.get(i);
			for(Integer i1:list){
				mergedList.add(i1);
			}
		}
		
		return mergedList.toArray();
	}
	
	
}

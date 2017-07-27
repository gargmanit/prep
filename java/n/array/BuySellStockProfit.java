package n.array;


/**
 * Date 07/26/2017
 * @author N Garg
 *
 * Best time to buy and sell stocks.
 * 1) Only 1 transaction is allowed
 * 2) Infinite number transactions are allowed
 *
 * Time complexity O(n)
 * Space complexity O(1)
 *
 * https://leetcode.com/problems/best-time-to-buy-and-sell-stock/
 * https://leetcode.com/problems/best-time-to-buy-and-sell-stock-ii/
 */

public class BuySellStockProfit {

	public static void main(String[] args) {
		// 
        int arr[] = {7,10,15,5,11,2,7,9,3};
        int arr1[] = {6,4,1,3,5,7,3,1,3,4,7,9,2,5,6,0,1,2};
        BuySellStockProfit bss = new BuySellStockProfit();
        System.out.println(bss.oneProfit(arr));
       System.out.print(bss.allTimeProfit(arr1));
        
    

	}

	private int allTimeProfit(int[] arr1) {
	int allTimeProfit = 0;
	for(int i=1;i<arr1.length;i++){
		if((arr1[i]-arr1[i-1])>0){
			allTimeProfit+=arr1[i]-arr1[i-1];
		}
	}
		
		return allTimeProfit;
	}

	private int oneProfit(int[] arr1) {

		int min = arr1[1];
		int profit=0;
		
		for (int i : arr1) {
			if(i<=min){
				min=i;
			}else{
				if((i-min)>profit){
					profit=i-min;
				}
			}
			
		}
		
		return profit;
	
	}

}

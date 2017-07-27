	package n.array;
	
	import java.util.ArrayList;
	import java.util.Collection;
	import java.util.Collections;
	
	/**
	 * Date 07/26/2017
	 * @author N Garg
	 *
	 * A group of two or more people wants to meet and minimize the total travel distance.
	 * You are given a 2D grid of values 0 or 1, where each 1 marks the home of someone in the group.
	 * The distance is calculated using Manhattan Distance, where distance(p1, p2) = |p2.x - p1.x| + |p2.y - p1.y|.
	 * Find the total distance that needs to be travelled to reach this meeting point.
	 *
	 * Time complexity O(m*n)
	 * Space complexity O(m + n)
	 *
	 * https://leetcode.com/problems/best-meeting-point/
	 */
	public class BestMeetingPoint {
	
		public static void main(String args[]) {
			BestMeetingPoint bmp = new BestMeetingPoint();
			int[][] grid = {{1, 0, 0, 0, 1}, {0, 0, 0, 0, 0},{0, 0, 1, 0, 0}};
			System.out.print(bmp.minTotalDistance(grid));
		}
	
		private double minTotalDistance(int[][] grid) {
			// TODO Auto-generated method stub
			ArrayList<Integer> xAxis = new ArrayList<Integer>();
			ArrayList<Integer> yAxis = new ArrayList<Integer>();
			int m =  grid.length;
			int n =  grid[0].length;
			double distanceSum=0;
			for (int i =0;i<m;i++){
				for (int j=0;j<n;j++){
					if(grid[i][j]==1){
						xAxis.add(i);
						yAxis.add(j);
					}
				}
			}
	
			Collections.sort(xAxis);
			Collections.sort(yAxis);
			int xAxisSize = xAxis.size();
			int yAxisSize = yAxis.size();
	for(int i =0; i<xAxis.size();i++){
		distanceSum +=Math.abs(xAxis.get(i)-xAxis.get(xAxisSize/2));
	}
	for(int i =0; i<yAxisSize;i++){
		distanceSum +=Math.abs(yAxis.get(i)-yAxis.get(yAxisSize/2));
	}
			return distanceSum;
		}
	}

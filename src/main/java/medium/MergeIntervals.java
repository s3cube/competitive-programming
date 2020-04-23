package medium;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Stack;

public class MergeIntervals {

    public static void main(String[] args) {
        int input[][] = {
                {1,4},
                {2,3}
        };

        new MergeIntervals().merge(input);
    }

    public int[][] merge(int[][] intervals) {

        if(intervals.length == 0){
            return intervals;
        }

        int mergedIntervals[][];

        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if(o1[0] < o2[0]){
                    return -1;
                }else if(o1[0] == o2[0]){
                    return 0;
                }else {
                    return 1;
                }
            }
        });


        Stack<int[]> stack = new Stack<>();

        stack.push(intervals[0]);

        for (int i = 1; i < intervals.length; i++){

            int[] pairAtTop = stack.peek();
            int currentPair[] = intervals[i];

            if(pairAtTop[1] >= currentPair[0]){
                pairAtTop[1] = Math.max(pairAtTop[1], currentPair[1]);
            }else{
                stack.push(currentPair);
            }
        }

        int stackSize = stack.size();

        mergedIntervals = new int[stackSize][2];


        for (int i = 0; i < stackSize; i++){
            mergedIntervals[i] = stack.pop();
        }

        return mergedIntervals;

    }

}

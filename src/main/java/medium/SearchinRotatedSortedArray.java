package medium;

public class SearchinRotatedSortedArray {

    public static void main(String[] args) {
//        int input[] = {4,5,6,7,0,1,2};
        int input[] = {3,1};
        int target = 1;
        int output = new SearchinRotatedSortedArray().search(input, target);
        System.out.println(output);
    }

    public int search(int[] nums, int target) {
        int response = 1;

        int start = 0, end = nums.length - 1;

        while (start <= end){

            int mid = (start + end)/2;

            if(nums[mid] == target){
                return mid;
            }

            //LHS of the Array from the start to the mid is sorted
            if(nums[mid] >= nums[start]){

                if(target >= nums[start] && target <= nums[mid]){
                    end = mid -1;
                }else{
                    start = mid + 1;
                }

            }else{
            // RHS of the Array from mid to end is sorted
                if(target >= nums[mid] && target <= nums[end]){
                    start = mid +1;
                }else{
                    end = mid - 1;
                }
            }

        }

        return -1;
    }

}

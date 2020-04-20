package medium;

public class FindFirstandLastPositionofElementinSortedArray {

    public static void main(String[] args) {
        int input[] = {7,7,7,7,8,9,9,9,10};
        int target = 9;
        int output[] = new FindFirstandLastPositionofElementinSortedArray().searchRange(input, target);
    }

    public int[] searchRange(int[] nums, int target) {
        int response[] = {-1,-1};

        response[0] = findFirstPosition(nums, target);
        response[1] = findLastPosition(nums, target);


        return response;
    }

    private int findFirstPosition(int[] nums, int target) {
        int start = 0, end = nums.length - 1;

        while (start <= end){
            int mid = (start + end)/2;

            if(nums[mid] == target){
                end = mid - 1;
            }

            if(target > nums[mid]){
                start = mid + 1;
            }

            if(target < nums[mid]){
                end = mid - 1;
            }

        }

        if(start > nums.length - 1 || nums[start] != target){
            return -1;
        }

        return start;
    }

    private int findLastPosition(int[] nums, int target) {
        int start = 0, end = nums.length - 1;

        while (start <= end){
            int mid = (start + end)/2;

            if(nums[mid] == target){
                start = mid + 1;
            }

            if(target > nums[mid]){
                start = mid + 1;
            }

            if(target < nums[mid]){
                end = mid - 1;
            }

        }

        if(end < 0 || nums[end] != target){
            return -1;
        }


        return end;
    }


}

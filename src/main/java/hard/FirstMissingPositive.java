package hard;

public class FirstMissingPositive {

    public static void main(String[] args) {
//        int input[] = {1,2,0};
        int input[] = {};
        new  FirstMissingPositive().firstMissingPositive(input);
    }

    public int firstMissingPositive(int[] nums) {

        int firstMissing = -1;
        int numsLength = nums.length;
        int missingNumber[] = new int[nums.length];

        for (int i =0; i < numsLength; i++){
            if(nums[i] <= 0 || nums[i] > numsLength){
                nums[i] = 0;
            }else{
              missingNumber[nums[i] - 1] = 1;
            }
        }

        int i = 0;
        for (i = 0; i < numsLength; i++){
            if(missingNumber[i]==0){
                firstMissing = i+1;
                break;
            }
        }

        if(i == numsLength){
            firstMissing = numsLength + 1;
        }

        return firstMissing;
    }
}

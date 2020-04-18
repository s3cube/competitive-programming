package medium;


import java.util.Arrays;

public class ProductofArrayExceptSelf {

    public static void main(String[] args) {
        int input[]= {1,2,3,4};
        int expectedOutput[]= {24,12,8,6};
        int output[] = new ProductofArrayExceptSelf().productExceptSelf(input);

        System.out.println(Arrays.equals(expectedOutput,output));

    }

    public int[] productExceptSelf(int[] nums) {

        /*
        int[] productESelf =  new int[nums.length];

        int[] leftProduct = new int[nums.length];
        int[] rightProduct = new int[nums.length];

        leftProduct[0] = 1;
        rightProduct[0] = 1;

        for (int i = 1; i < nums.length; i++){
            leftProduct[i] = nums[i-1]*leftProduct[i-1];
        }


        int numsReverse[] = new int[nums.length];

        for(int i = nums.length-1; i >= 0 ; i--){
            numsReverse[nums.length - i -1] = nums[i];
        }

        for (int i = 1; i < numsReverse.length; i++){
            rightProduct[i] = numsReverse[i-1]*rightProduct[i-1];
        }


        for(int i = nums.length-1; i >= 0 ; i--){
            productESelf[nums.length - i -1] = leftProduct[nums.length - i -1] * rightProduct[i];
        }


        return productESelf;
        */

        int[] result =  new int[nums.length];


        for(int i = 0, temp = 1; i < nums.length; i++){
            result[i] = temp;
            temp *= nums[i];
        }

        for(int i = nums.length -1, temp = 1; i >= 0; i--){
            result[i] *= temp;
            temp *= nums[i];
        }

        return result;
    }


}

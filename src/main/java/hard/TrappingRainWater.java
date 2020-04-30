package hard;

public class TrappingRainWater {

    public static void main(String[] args) {
        int heights[] = {0,1,0,2,1,0,1,3,2,1,2,1};
        new TrappingRainWater().trap(heights);
    }

    public int trap(int[] height) {

        int totalWaterTrapped = 0;
        int leftMaxArray[] = new int[height.length];
        int rightMaxArray[] = new int[height.length];

        for (int i = 1; i < leftMaxArray.length; i++){
            leftMaxArray[i] = Math.max(leftMaxArray[i-1], height[i-1]);
        }

        for (int i =  rightMaxArray.length - 2; i >= 0; i--){
            rightMaxArray[i] = Math.max(rightMaxArray[i+1], height[i+1]);
        }

        for (int i = 0; i < height.length; i ++){

            int waterThatCanBeTrapped = Math.min(leftMaxArray[i], rightMaxArray[i]);
            int waterActuallyTrapped = Math.max(0,waterThatCanBeTrapped - height[i]);

            totalWaterTrapped+= waterActuallyTrapped;
        }

        return totalWaterTrapped;

    }

}

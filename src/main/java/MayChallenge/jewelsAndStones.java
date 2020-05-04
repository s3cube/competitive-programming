package MayChallenge;

public class jewelsAndStones {

    public static void main(String[] args) {
        String J = "aA";
        String S = "aAAbbbb";

        new jewelsAndStones().numJewelsInStones(J,S);
    }

    public int numJewelsInStones(String J, String S) {

        int count = 0;

        int alpha[] = new int[128];

        for (int i = 0; i < J.length(); i++){
            alpha[J.charAt(i)]++;
        }

        for (int i = 0; i < S.length(); i++){
            if(alpha[S.charAt(i)] > 0){
                count++;
            }
        }

        return count;
    }
}

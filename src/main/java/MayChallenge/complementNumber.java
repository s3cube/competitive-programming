package MayChallenge;

public class complementNumber {

    public static void main(String[] args) {
        new complementNumber().findComplement(5);
    }

    public int findComplement(int num) {
        String binaryForm = Integer.toBinaryString(num);
        System.out.println(binaryForm);
        char binArray[] = binaryForm.toCharArray();
        for (int i = 0; i < binArray.length; i++){
            if(binArray[i] == '0'){
                binArray[i] = '1';
            }else{
                binArray[i] = '0';
            }
        }

        String inverted = new String(binArray);



        int inv =  Integer.parseInt(inverted, 2);
        return inv;
    }
}

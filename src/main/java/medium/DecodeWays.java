package medium;

public class DecodeWays {
    public static void main(String[] args) {

        String s = "101";

        new DecodeWays().numDecodings(s);


    }

    char alphabetMap[] = new char[27];

    public int numDecodings(String s) {



        int i = 1;
        for (char c = 'A'; c <= 'Z'; ++c)
            alphabetMap[i++] = c;


        traverseString(s, 0, 0, s.length());

        return globalCount;

    }

    int globalCount = 0;

    public void traverseString(String word, int startPos, int endPos, int wordLength){
        if(endPos == wordLength){
            globalCount++;
            return;
        }

        if(endPos + 1 <= wordLength && isValidWord((word.substring(startPos, endPos+1)))){
            traverseString(word, startPos+1, endPos+1, wordLength);
        }

        if(endPos + 2 <= wordLength && isValidWord((word.substring(startPos, endPos+2)))){
            traverseString(word, startPos+2, endPos+2, wordLength);
        }
    }

    public boolean isValidWord(String word){

        if(word.charAt(0) == '0'){
            return false;
        }

        int numbers = Integer.parseInt(word);
        if(numbers >= 1 && numbers <= 26){
            return true;
        }else {
            return false;
        }
    }
}

package medium;

import com.sun.tools.javah.Gen;

import java.util.ArrayList;
import java.util.List;

public class GenerateParentheses {
    List<String> masterList = new ArrayList<>();
    int globalN = 0;

    public static void main(String[] args) {
        int n = 3;
        new GenerateParentheses().generateParenthesis(n);
    }

    public List<String> generateParenthesis(int n) {

        globalN = n * 2;
        generateResponses("", n, n);

        return masterList;
    }

    public void generateResponses(String word, int left, int right){

        if(word.length() == globalN && left == 0 && right == 0){
            masterList.add(word);
            return;
        }
        if(left <= right && left >= 0 ){
            generateResponses(word + "(", left-1, right);
            generateResponses(word + ")", left, right - 1);
        }else{
            return;
        }

    }
}
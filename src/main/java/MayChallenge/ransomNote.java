package MayChallenge;

public class ransomNote {

    public static void main(String[] args) {
        new ransomNote().canConstruct("aa", "ab");
    }

    public boolean canConstruct(String ransomNote, String magazine) {


        int counter = ransomNote.length();

        int magazineLetters[] = new int[26];

        for (int i = 0; i < magazine.length(); i++){
            magazineLetters[magazine.charAt(i) - 97]++;
        }

        for (int i = 0; i < ransomNote.length();i++){
            if(magazineLetters[ransomNote.charAt(i)- 97] > 0){
                magazineLetters[ransomNote.charAt(i)- 97]--;
                counter--;
            }
        }

        return counter == 0;
    }
}

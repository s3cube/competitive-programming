package MayChallenge;

public class firstBadVersion {

    public static void main(String[] args) {
        int n = 5;
        new firstBadVersion().firstBadVersion(n);
    }


    public int firstBadVersion(int n) {

        int start = 1, end = n;
        int midVersion = (start + end)/2;
        while(start <= end){
            midVersion = (start + end)/2;

            if(isBadVersion(midVersion) && !isBadVersion(midVersion - 1)){
                break;
            }

            if(isBadVersion(midVersion)){
                end = midVersion - 1;
            }else if(!isBadVersion(midVersion)){
                start = midVersion + 1;
            }


        }

        return midVersion;
    }

    public boolean isBadVersion(int version){
        if(version >= 4){
            return true;
        }
        return false;
    }
}

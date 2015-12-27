public class Solution {
    public int countPrimes(int n) {
        if(n<=2)    return 0;
        int count=0;
        Boolean[] isP = new Boolean[n];
        Arrays.fill(isP,true);
        isP[0]=false;
        isP[1]=false;
        for(int i=2;i*i<n;i++){
            if(!isP[i]){
                continue;
            }
            for(int j=i*i;j<n;j=j+i){
                isP[j]=false;
            }
        }
        for(int i=2;i<n;i++){
            if(isP[i])
                count +=1;
        }
        return count;
    }
}
public class Solution {
    public String fractionToDecimal(int numerator, int denominator) {
        if(denominator == 0) return null;
        if(numerator == 0)    return "0";
        StringBuffer stb = new StringBuffer();

        // positive + or negative -
        if((denominator > 0 && numerator < 0) || (denominator < 0 && numerator > 0)) {
            stb.append("-");
        }

        // avoid negative and overflow
        long num = Math.abs((long)numerator);
        long den = Math.abs((long)denominator);

        // integral partial, check if it can be divided evenly
        stb.append(num / den);
        if(num % den == 0)      return stb.toString();

        // fractianal part
        stb.append(".");
        num = num % den;
        Map<Long, Integer> fracDigits = new HashMap<>();
        fracDigits.put(num,stb.length());
        while(num != 0) {
            num = num * 10;
            stb.append(num / den);
            num = num % den;
            if(!fracDigits.containsKey(num)) {

                // put remainder into map or put current digit into map
                fracDigits.put(num / den, stb.length());
            } else {
                int id = fracDigits.get(num);
                stb.insert(id, "(");
                stb.append(")");
                break;
            }
        }
        return stb.toString();
    }
}

public class Solution {
    public int compareVersion(String version1, String version2) {
        String[] ver1 = version1.split("\\.");
        String[] ver2 = version2.split("\\.");
        int len = ver1.length >= ver2.length ? ver2.length : ver1.length;
        for(int i = 0; i < len; i++) {
            if(Integer.parseInt(ver1[i]) > Integer.parseInt(ver2[i]))
                return 1;
            if(Integer.parseInt(ver1[i]) < Integer.parseInt(ver2[i]))
                return -1;
        }
        if(ver1.length > len) {
            for(int i = len; i < ver1.length; i++) {
                if(Integer.parseInt(ver1[i]) != 0)  return 1;
            }
            return 0;
        } else if(ver2.length > len) {
            for(int i = len; i < ver2.length; i++) {
                if(Integer.parseInt(ver2[i]) != 0)  return -1;
            }
            return 0;
        } else
            return 0;
    }
}

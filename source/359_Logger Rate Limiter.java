public class Logger {

    Map<String, Integer> loggerMap;
    
    /** Initialize your data structure here. */
    public Logger() {
        loggerMap = new HashMap<>();
    }
    
    /** Returns true if the message should be printed in the given timestamp, otherwise returns false.
        If this method returns false, the message will not be printed.
        The timestamp is in seconds granularity. */
    public boolean shouldPrintMessage(int timestamp, String message) {
        if(!loggerMap.containsKey(message)) {
            loggerMap.put(message, timestamp);
            return true;
        } else {
            int lastTime = loggerMap.get(message);
            if(timestamp - lastTime >= 10) {
                loggerMap.put(message, timestamp);
                return true;
            } else {
                return false;
            }
        }
    }
}

/**
 * Your Logger object will be instantiated and called as such:
 * Logger obj = new Logger();
 * boolean param_1 = obj.shouldPrintMessage(timestamp,message);
 */
 
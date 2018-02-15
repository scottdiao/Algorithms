package leetcode;

import java.util.HashMap;
import java.util.Map;

/**
*
* @author Scott
*/
public class LoggerRateLimiter{
    private Map<String, Integer> ok = new HashMap<>();

    public boolean shouldPrintMessage(int timestamp, String message) {
        if (timestamp < ok.getOrDefault(message, 0))
            return false;
        ok.put(message, timestamp + 10);
        return true;
    }
}

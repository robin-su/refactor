package sjmszm.pattern.proxy;

import java.util.Map;

public interface StatViewer {
    void output(Map<String, RequestStat> requestStats, long startTimeInMillis, long endTimeInMillis);
}

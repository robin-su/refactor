package sjmszm.metric;

import java.util.*;

/**
 * 负责根据原始数据计算统计数据。
 * 3.根据原始数据，计算得到统计数据；
 *
 * 负责各种统计数据的计算，比如响应时间的最大值、最小值、平均值、百分位值、接口访问次数、tps。
 */
public class Aggregator {

    /**
     * 函数存在的问题：
     * 当要添加新的统计功能的时候，我们需要修改 aggregate() 函数代码。
     * 一旦越来越多的统计功能添加进来之后，这个函数的代码量会持续增加，可读性、可维护性就变差了。
     *
     * @param requestInfos
     * @param durationInMillis
     * @return
     */
    public static RequestStat aggregate(List<RequestInfo> requestInfos,long durationInMillis) {
        double maxRespTime = Double.MIN_VALUE;
        double minRespTime = Double.MAX_VALUE;
        double avgRespTime = -1;
        double p999RespTime = -1;
        double p99RespTime = -1;
        double sumRespTime = 0;
        long count = 0;

        for (RequestInfo requestInfo : requestInfos) {
            ++ count;
            double respTime = requestInfo.getResponseTime();
            if(maxRespTime < respTime) {
                maxRespTime = respTime;
            }

            if(minRespTime > respTime) {
                minRespTime = respTime;
            }
            sumRespTime += respTime;
        }

        if (count != 0) { avgRespTime = sumRespTime / count; }

        long tps = (long) (count / durationInMillis * 1000);
        Collections.sort(requestInfos, new Comparator<RequestInfo>() {
            @Override
            public int compare(RequestInfo o1, RequestInfo o2) {
                double diff = o1.getResponseTime() - o2.getResponseTime();
                if(diff < 0.0) {
                    return -1;
                } else if(diff > 0.0) {
                    return 1;
                } else {
                    return 0;
                }
            }
        });

        int idx999 = (int)(count * 0.999);
        int idx99 = (int)(count * 0.99);
        if(count != 0) {
            p999RespTime = requestInfos.get(idx999).getResponseTime();
            p99RespTime = requestInfos.get(idx99).getResponseTime();
        }

        RequestStat requestStat = new RequestStat();
        requestStat.setMaxResponseTime(maxRespTime);
        requestStat.setMinResponseTime(minRespTime);
        requestStat.setAvgResponseTime(avgRespTime);
        requestStat.setP99ResponseTime(p999RespTime);
        requestStat.setP99ResponseTime(p99RespTime);
        requestStat.setCount(count);
        requestStat.setTps(tps);
        return requestStat;
    }


}

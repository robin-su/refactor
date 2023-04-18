package sjmszm.pattern.proxy;

import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 */
public class Aggregator {

    public Map<String, RequestStat> aggregate(long durationInMillis, Map<String, List<RequestInfo>> requestInfos) {
        HashMap<String, RequestStat> stats = new HashMap<>();
        for (Map.Entry<String, List<RequestInfo>> entry : requestInfos.entrySet()) {
            String apiName = entry.getKey();
            List<RequestInfo> requestInfoPerApi = entry.getValue();
            RequestStat requestStat = doAggregate(requestInfoPerApi, durationInMillis);
            stats.put(apiName,requestStat);
        }
        return stats;
    }

    /**
     * 函数存在的问题：
     * 当要添加新的统计功能的时候，我们需要修改 aggregate() 函数代码。
     * 一旦越来越多的统计功能添加进来之后，这个函数的代码量会持续增加，可读性、可维护性就变差了。
     *
     * @param requestInfos
     * @param durationInMillis
     * @return
     */
    private RequestStat doAggregate(List<RequestInfo> requestInfos, long durationInMillis) {
        List<Double> respTimes = requestInfos.stream()
                .map(RequestInfo::getResponseTime)
                .collect(Collectors.toList());

        RequestStat requestStat = new RequestStat();
        requestStat.setMaxResponseTime(max(respTimes));
        requestStat.setMinResponseTime(min(respTimes));
        requestStat.setAvgResponseTime(avg(respTimes));
        requestStat.setP99ResponseTime(percentile999(respTimes));
        requestStat.setP99ResponseTime(percentile99(respTimes));
        requestStat.setCount(respTimes.size());
        requestStat.setTps(tps(respTimes.size(),durationInMillis/1000));
        return requestStat;
    }

    private double max(List<Double> dataset) {
        return dataset.stream()
                .max(Comparator.comparing(x -> x))
                .get();
    }

    private double min(List<Double> dataset) {
        return dataset.stream()
                .min(Comparator.comparing(x -> x))
                .get();
    }

    private double avg(List<Double> dataset) {
        return dataset.stream()
                .mapToDouble(Double::valueOf)
                .average()
                .getAsDouble();
    }

    private double percentile999(List<Double> dataset) {
       int idx999 = (int)percentile(dataset,0.999);
       return dataset.get(idx999);
    }

    private double percentile99(List<Double> dataset) {
        int idx99 = (int)percentile(dataset,0.99);
        return dataset.get(idx99);
    }

    private double percentile(List<Double> dataset,double ratio) {
        return dataset.size() * ratio;
    }

    private long tps(int count,double duration) {
        return (long) (count / duration);
    }

}

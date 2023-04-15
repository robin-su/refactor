package sjmszm.metric;

import org.apache.commons.lang3.StringUtils;

/**
 * 类负责提供 API，来采集接口请求的原始数据。
 * 负责打点采集原始数据，包括记录每次接口请求的响应时间和请求时间戳，
 * 并调用 MetricsStorage 提供的接口来存储这些原始数据。
 *
 */
public class MetricsCollector {
    private MetricsStorage metricsStorage; // 基于接口而非实现编程

    public MetricsCollector(MetricsStorage metricsStorage) {
        this.metricsStorage = metricsStorage;
    }

    public void recordRequest(RequestInfo requestInfo) {
        if(requestInfo == null || StringUtils.isBlank(requestInfo.getApiName())) {
            return;
        }
        metricsStorage.saveRequestInfo(requestInfo);
    }

}

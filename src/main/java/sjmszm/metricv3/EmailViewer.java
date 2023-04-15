package sjmszm.metricv3;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class EmailViewer implements StatViewer {

    private EmailSender emailSender;
    private List<String> toAddress = new ArrayList<>();

    /**
     * 兼顾代码的易用性，新增一个封装了默认依赖的构造函数
     * @param toAddress
     */
    public EmailViewer(List<String> toAddress) {
        this.toAddress = toAddress;
    }

    // 兼顾灵活性和代码的可测试性，这个构造函数继续保留
    public EmailViewer(EmailSender emailSender) {
        this.emailSender = emailSender;
    }

    public EmailViewer() {
        this.emailSender = new EmailSender();
    }

    public void addToAddress(String address) {
        toAddress.add(address);
    }

    @Override
    public void output(Map<String, RequestStat> requestStats, long startTimeInMillis, long endTimeInMillis) {
        // format the requestStats to HTML style.
        // send it to email toAddresses.
    }
}

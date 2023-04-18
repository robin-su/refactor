package sjmszm.pattern.bridge;

import java.util.ArrayList;
import java.util.List;

class Alert {

    private List<AlertHandler> alertHandlers = new ArrayList<>();

    public void addAlert(AlertHandler alertHandler) {
        this.alertHandlers.add(alertHandler);
    }

    public void check(ApiStatInfo apiStatInfo) {
        for (AlertHandler alertHandler : alertHandlers) {
            alertHandler.check(apiStatInfo);
        }
    }

}

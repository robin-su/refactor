package refactoringtopatterns.build.command.rfc;

import java.util.Map;

/**
 * 2.提炼类
 */
public class NewWorkshopHandler extends Handler {

    /*private CatalogApp catalogApp;

    public NewWorkshopHandler(CatalogApp catalogApp) {
        this.catalogApp = catalogApp;
    }*/
    public NewWorkshopHandler(CatalogApp catalogApp) {
        super(catalogApp);
    }

    //2.1 将方法提炼到这里
    @Override
    public HandlerResponse execute(Map parameters) {
        //3.1 组合方法重构
        createNewWorkshop(parameters);
        return catalogApp.executeActionAndGetResponse(CatalogApp.ALL_WORKSHOPS, parameters);
    }

    private void createNewWorkshop(Map parameters) {
        String netWorkshopId = workshopManager().getNetWorkshopId();
        //3.2 组合方法重构
        /*StringBuffer netWorkshopContents =
                workshopManager().createNewFileFromTemplate(
                        netWorkshopId,
                        workshopManager().getWorkshopDir(),
                        workshopManager().getWorkshopTemplate()
                );*/
        StringBuffer netWorkshopContents = getNextWorkshopId(netWorkshopId);
        workshopManager().addWorkshop(netWorkshopContents);
        parameters.put("id",netWorkshopId);
    }

    private StringBuffer getNextWorkshopId(String netWorkshopId) {
        StringBuffer netWorkshopContents =
                workshopManager().createNewFileFromTemplate(
                        netWorkshopId,
                        workshopManager().getWorkshopDir(),
                        workshopManager().getWorkshopTemplate()
                );
        return netWorkshopContents;
    }

    private WorkshopManager workshopManager() {
        return catalogApp.getWorkshopManager();
    }

}

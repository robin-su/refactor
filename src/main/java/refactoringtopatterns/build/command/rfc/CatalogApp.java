package refactoringtopatterns.build.command.rfc;

import java.util.HashMap;
import java.util.Map;

public class CatalogApp {

    final static String NEW_WORKSHOP = "NEW_WORKSHOP";
    final static String ALL_WORKSHOPS = "ALL_WORKSHOPS";
    final static String ALL_WORKSHOPS_STYLESHEET = "ALL_WORKSHOPS_STYLESHEET";

    private WorkshopManager workshopManager;
    private String netWorkshopId;
    private String workshopDir;
    private String workshopTemplate;

    private Map<String, Handler> handlers;
    public CatalogApp() {
        createHandlers();
    }

    public void createHandlers() {
        handlers = new HashMap<>();
        handlers.put(NEW_WORKSHOP,new NewWorkshopHandler(this));
        handlers.put(ALL_WORKSHOPS, new AllWorkshopHandler(this));
    }

    private Handler lookupHandlerBy(String handlerName) {
        return handlers.get(handlerName);
    }


    //1.提炼方法
    protected HandlerResponse executeActionAndGetResponse(String actionName, Map parameters) {
        /*if(actionName.equals(NEW_WORKSHOP)) {
            return new NewWorkshopHandler(this).execute(parameters);
        } else if (actionName.equals(ALL_WORKSHOPS)) {
            return new AllWorkshopHandler(this).execute(parameters);
        }*/
        Handler handler = lookupHandlerBy(actionName);
        return handler.execute(parameters);
    }

    //1.1 提炼方法
    /*private HandlerResponse getAllWorkshopResponse() {
        XMLBuilder allWorkshopXml = new XMLBuilder("workshops");
        WorkshopRepository repository = workshopManager.getWorkshopRepository();
        Iterator<Workshop> ids = repository.keyIterator();
        while(ids.hasNext()) {
            Workshop workshop = (Workshop)ids.next();
            allWorkshopXml.addBelowParent("workshop");
            allWorkshopXml.addAttribute("id",workshop.getId());
            allWorkshopXml.addAttribute("name",workshop.getName());
            allWorkshopXml.addAttribute("status", workshop.getStatus());
            allWorkshopXml.addAttribute("duration", workshop.getDurationAsString());
        }
        String formattedXml = getFormattedData(allWorkshopXml.toString());
        return new HandlerResponse(
                new StringBuffer(formattedXml)
                , ALL_WORKSHOPS_STYLESHEET
        );
    }*/

    //1.2 提炼方法
    /*private HandlerResponse getNewWorkshopResponse(Map parameters) {
        String netWorkshopId = workshopManager.getNetWorkshopId();
        StringBuffer netWorkshopContents =
                workshopManager.createNewFileFromTemplate(
                    netWorkshopId,
                    workshopManager.getWorkshopDir(),
                    workshopManager.getWorkshopTemplate()
                );
        workshopManager.addWorkshop(netWorkshopContents);
        parameters.put("id",netWorkshopId);
        return executeActionAndGetResponse(ALL_WORKSHOPS, parameters);
    }*/

    /*protected String getFormattedData(String string) {
        return "";
    }*/

    public WorkshopManager getWorkshopManager() {
        return workshopManager;
    }
}

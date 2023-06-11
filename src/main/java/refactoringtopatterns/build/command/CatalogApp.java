package refactoringtopatterns.build.command;

import java.util.Iterator;
import java.util.Map;

public class CatalogApp {

    private final static String NEW_WORKSHOP = "NEW_WORKSHOP";
    private final static String ALL_WORKSHOPS = "ALL_WORKSHOPS";
    private final static String ALL_WORKSHOPS_STYLESHEET = "ALL_WORKSHOPS_STYLESHEET";

    private WorkshopManager workshopManager;
    private String netWorkshopId;
    private String workshopDir;
    private String workshopTemplate;


    private HandlerResponse executeActionAndGetResponse(String actionName, Map parameters) {
        if(actionName.equals(NEW_WORKSHOP)) {
            String netWorkshopId = workshopManager.getNetWorkshopId();
            StringBuffer netWorkshopContents =
                    workshopManager.createNewFileFromTemplate(
                        netWorkshopId,
                        workshopManager.getWorkshopDir(),
                        workshopManager.getWorkshopTemplate()
                    );
            workshopManager.addWorkshop(netWorkshopContents);
            parameters.put("id",netWorkshopId);
            executeActionAndGetResponse(NEW_WORKSHOP, parameters);
        } else if (actionName.equals(ALL_WORKSHOPS)) {
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
                    ,ALL_WORKSHOPS_STYLESHEET
            );
        }
        return new HandlerResponse();
    }

    private String getFormattedData(String string) {
        return "";
    }

}

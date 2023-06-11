package refactoringtopatterns.build.command.rfc;

import java.util.Iterator;
import java.util.Map;

public class AllWorkshopHandler extends Handler {

   /* private CatalogApp catalogApp;

    public AllWorkshopHandler(CatalogApp catalogApp) {
        this.catalogApp = catalogApp;
    }*/

    public AllWorkshopHandler(CatalogApp catalogApp) {
        super(catalogApp);
    }

    @Override
    public HandlerResponse execute(Map parameters) {
        return new HandlerResponse(
                new StringBuffer(allWorkshopData())
                , CatalogApp.ALL_WORKSHOPS_STYLESHEET
        );
    }

    private String allWorkshopData() {
        XMLBuilder allWorkshopXml = new XMLBuilder("workshops");
        WorkshopRepository repository = catalogApp.getWorkshopManager().getWorkshopRepository();
        Iterator<Workshop> ids = repository.keyIterator();
        while(ids.hasNext()) {
            Workshop workshop = ids.next();
            allWorkshopXml.addBelowParent("workshop");
            allWorkshopXml.addAttribute("id",workshop.getId());
            allWorkshopXml.addAttribute("name",workshop.getName());
            allWorkshopXml.addAttribute("status", workshop.getStatus());
            allWorkshopXml.addAttribute("duration", workshop.getDurationAsString());
        }
        return getFormattedData(allWorkshopXml.toString());
    }

    protected String getFormattedData(String string) {
        return "";
    }
}

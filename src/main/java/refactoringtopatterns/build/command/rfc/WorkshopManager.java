package refactoringtopatterns.build.command.rfc;

import java.util.List;

public class WorkshopManager {

    private String netWorkshopId;
    private String workshopDir;
    private String workshopTemplate;
    private WorkshopRepository workshopRepository;

    private List<StringBuffer> newWorkshopContents;

    public WorkshopManager(String netWorkshopId, String workshopDir, String workshopTemplate) {
        this.netWorkshopId = netWorkshopId;
        this.workshopDir = workshopDir;
        this.workshopTemplate = workshopTemplate;
    }

    public StringBuffer createNewFileFromTemplate(String netWorkshopId, String workshopDir, String workshopTemplate) {
        return new StringBuffer();
    }

    public void addWorkshop(StringBuffer newWorkshopContent) {
        this.newWorkshopContents.add(newWorkshopContent);
    }

    public String getNetWorkshopId() {
        return netWorkshopId;
    }

    public String getWorkshopDir() {
        return workshopDir;
    }

    public String getWorkshopTemplate() {
        return workshopTemplate;
    }

    public WorkshopRepository getWorkshopRepository() {
        return workshopRepository;
    }
}

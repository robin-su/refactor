package refactoringtopatterns.build.command.rfc;

public class HandlerResponse {

    private StringBuffer netWorkshopContents;
    private String workshop;

    public HandlerResponse() {
    }

    public HandlerResponse(StringBuffer netWorkshopContents, String workshop) {
        this.netWorkshopContents = netWorkshopContents;
        this.workshop = workshop;
    }
}

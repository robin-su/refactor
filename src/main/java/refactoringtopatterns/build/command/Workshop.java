package refactoringtopatterns.build.command;

public class Workshop {

    private String id;
    private String name;
    private String status;
    private String duration;

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getStatus() {
        return status;
    }

    public String getDurationAsString() {
        return this.duration;
    }

}

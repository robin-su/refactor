package refactoringtopatterns.build.command.rfc;

import java.util.Iterator;
import java.util.List;

public class WorkshopRepository {

    private List<Workshop> workshopList;

    public Iterator<Workshop> keyIterator() {
        return workshopList.iterator();
    }

}

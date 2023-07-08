package refactoringtopatterns.build.mutiVersionAdapter;

import refactoringtopatterns.build.mutiVersionAdapter.exception.QueryException;

public class Client {

    private Query query;

    public void loginToDatabase(String db, String user, String password) {
        query = new Query();
        try {
            if(usingSDVersion52()) {
                query.login(db, user, getSD52ConfigFileName()); // Login to SD 5.2
            } else {
                query.login(db, user, password); // Login to SD 5.1
            }
        } catch (QueryException e) {
            throw new RuntimeException(e);
        }
    }

    private boolean usingSDVersion52() {
        return true;
    }

    private String getSD52ConfigFileName() {
        return "hello";
    }

}

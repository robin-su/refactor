package refactoringtopatterns.build.mutiVersionAdapter.rfc;

import refactoringtopatterns.build.mutiVersionAdapter.exception.QueryException;

/**
 * 2. 找出所有调用 Query 构造器的客户端代码，把其中适当的代码修改为调用 QuerySD51构造函数
 */
public class Client {

    private Query query;

    public void loginToDatabase(String db, String user, String password) {

        try {
            if(usingSDVersion52()) {
                //2.1
                query = new QuerySD52(getSD52ConfigFileName());
//                query.login(db, user, password); // Login to SD 5.2
            } else {
                //2.2
                query = new QuerySD51();

            }
            query.login(db, user, password); // Login to SD 5.1
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

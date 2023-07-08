package refactoringtopatterns.build.mutiVersionAdapter.rfc;

import refactoringtopatterns.build.mutiVersionAdapter.exception.QueryException;

public interface Query {

    void login(String server, String user, String password) throws QueryException;

    void doQuery() throws QueryException;

}

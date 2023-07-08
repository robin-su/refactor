package refactoringtopatterns.build.mutiVersionAdapter.rfc;

import refactoringtopatterns.build.mutiVersionAdapter.exception.SDLoginFailedException;
import refactoringtopatterns.build.mutiVersionAdapter.exception.SDNotFuntionException;
import refactoringtopatterns.build.mutiVersionAdapter.exception.SDSocketInitFailedException;

public class SDLoginSession {
    public SDLoginSession(String sdConfigFileName, boolean b) {
    }

    public void loginSession(String server, String user, String passwrod) throws SDLoginFailedException,
            SDSocketInitFailedException, SDNotFuntionException
    {

    }

    public SDQuery createQuery(String openForQuery) {
        return null;
    }
}

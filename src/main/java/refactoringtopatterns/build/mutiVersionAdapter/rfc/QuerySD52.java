package refactoringtopatterns.build.mutiVersionAdapter.rfc;

import refactoringtopatterns.build.mutiVersionAdapter.exception.QueryException;
import refactoringtopatterns.build.mutiVersionAdapter.exception.SDLoginFailedException;
import refactoringtopatterns.build.mutiVersionAdapter.exception.SDNotFuntionException;
import refactoringtopatterns.build.mutiVersionAdapter.exception.SDSocketInitFailedException;

public class QuerySD52 extends AbstractQuery {

    private SDLoginSession sdLoginSession;

    private String sdConfigFileName;

    public QuerySD52(String sdConfigFileName) {
        super();
        this.sdConfigFileName = sdConfigFileName;
    }

    public void login(String server, String user, String passwrod) throws QueryException {
        sdLoginSession = new SDLoginSession(sdConfigFileName, false);
        try {
            sdLoginSession.loginSession(server, user, passwrod);
        } catch (SDLoginFailedException lfe) {
            throw new QueryException(QueryException.LOGIN_FAILED, "Login failure\n" + lfe, lfe);
        } catch (SDSocketInitFailedException ife) {
            throw new QueryException(QueryException.LOGIN_FAILED, "Socket fail\n" + ife, ife);
        } catch (SDNotFuntionException nfe) {
            throw new QueryException(QueryException.LOGIN_FAILED, "Not found exception\n" + nfe, nfe);
        }
    }


    @Override
    public SDQuery createQuery() {
        return sdLoginSession.createQuery(SDQuery.OPEN_FOR_QUERY);
    }

    //    public void doQuery() throws QueryException {
//        if(sdQuery != null) {
//            sdQuery.clearResult();
//        }
////        if(sd52) {
//        sdQuery = sdLoginSession.createQuery(SDQuery.OPEN_FOR_QUERY);
////        } else {
////            sdQuery = sdSession.createQuery(SDQuery.OPEN_FOR_QUERY);
////        }
//        executeQuery();
//    }

}

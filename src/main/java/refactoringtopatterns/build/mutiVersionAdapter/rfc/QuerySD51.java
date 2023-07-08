package refactoringtopatterns.build.mutiVersionAdapter.rfc;

import refactoringtopatterns.build.mutiVersionAdapter.exception.QueryException;
import refactoringtopatterns.build.mutiVersionAdapter.exception.SDLoginFailedException;
import refactoringtopatterns.build.mutiVersionAdapter.exception.SDSocketInitFailedException;

//1. 因为 Query 还没有子类,所以决定应用提炼子类重构，把处理5.1版SuperDatabase查询的代码隔离出来。
public class QuerySD51 extends AbstractQuery {

    // 3.2
    private SDLogin sdLogin; // needed for SD version 5.1
    private SDSession sdSession; // needed for SD version 5.1

    private SDLoginSession sdLoginSession;

    public QuerySD51() {
        super();
    }

    // 3.3
    public void login(String server, String user, String password) throws QueryException {
        try {
            sdSession = sdLogin.loginSession(server, user, password);
        } catch (SDLoginFailedException lfe) {
            throw new QueryException(QueryException.LOGIN_FAILED,"Login failure \n" + lfe,lfe);
        } catch (SDSocketInitFailedException ife) {
            throw new QueryException(QueryException.LOGIN_FAILED, "Socket fail\n" + ife,ife);
        }
    }

    @Override
    public SDQuery createQuery() {
        return sdSession.createQuery(SDQuery.OPEN_FOR_QUERY);
    }


    //    public void doQuery() throws QueryException {
//        if(sdQuery != null) {
//            sdQuery.clearResult();
//        }
////        if(sd52) {
////            sdQuery = sdLoginSession.createQuery(SDQuery.OPEN_FOR_QUERY);
////        } else {
//        sdQuery = sdSession.createQuery(SDQuery.OPEN_FOR_QUERY);
////        }
//        executeQuery();
//    }


}

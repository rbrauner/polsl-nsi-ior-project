/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package hiberApp;

import util.HiberUtil;
import org.hibernate.SessionFactory;

/*
 @author LabHiber RaU7
 */
public final class MainApp {

    private static final SessionFactory SESSION_FACTORY = HiberUtil.getSessionFactory(HiberUtil.Mapping.ANN);

    public static void main(String[] args) {

//        final DataLoad dataLoad = new DataLoad();
//        dataLoad.createData(SESSION_FACTORY);

        final DataQueries dataQueries = new DataQueries();
        dataQueries.query1(SESSION_FACTORY);
        dataQueries.query2(SESSION_FACTORY);
        dataQueries.query3(SESSION_FACTORY);

    }
}

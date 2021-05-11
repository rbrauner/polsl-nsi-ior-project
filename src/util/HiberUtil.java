/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.io.File;

/**
 *
 * @author LabHiber RaU7
 */

public final class HiberUtil {

//     static Logger log = LoggerFactory.getLogger(HiberUtil.class);
    /**
     * choose type of mapping definition XML or annotations
     */
    public enum Mapping {
       /**
        * use xml defined mappings for configuration
        */
       XML,
       /**
        * use annotation defined mappings for confuguration
        */
       ANN;
    }
    /**
     *
     * @param mapping
     * @return SessionFactory
     */
    public static SessionFactory getSessionFactory(Mapping mapping) {

        switch(mapping){
            case XML:
                return(getXMLSessionFactory());
            case ANN:
                return(getANNSessionFactory());
            default:
               return(getXMLSessionFactory());
        }
    }

    public static SessionFactory getXMLSessionFactory() {
        try {
            File mappingDir = new File("src\\xmlMaps");
            Configuration config = new Configuration().configure();

//            config.setProperty("hibernate.show_sql", "false");
            config.addDirectory(mappingDir);
            SessionFactory sf = config.buildSessionFactory();

//            log.trace("Session Factory created "+java.time.LocalDate.now());

            return (sf);
        }
        catch (Throwable ex) {

            System.err.println("Initial SessionFactory creation failed." + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }

 public static SessionFactory getANNSessionFactory() {
        try {
            Configuration config = new Configuration().configure();
            config.setProperty("hibernate.show_sql", "true");

//            config.addAnnotatedClass(Address.class)
//            .addAnnotatedClass(Department.class)
//            .addAnnotatedClass(Child.class)
//            .addAnnotatedClass(Manager.class)
//            .addAnnotatedClass(Person.class)
//            .addAnnotatedClass(Employee.class)
//            .addAnnotatedClass(Project.class);
            SessionFactory sf = config.buildSessionFactory();

            return (sf);
        }
        catch (Throwable ex) {

            System.err.println("Initial SessionFactory creation failed." + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }

}

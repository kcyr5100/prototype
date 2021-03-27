package repository;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;

public class MysqlDataSource implements DataSource {
    public static final String DB_USER = "jhipster";
    public static final String DB_PASSWORD = "passer";
    public static final String NOM_BASE = "jee_project_ged";

    public static final String IP = "localhost";
    public static final String PORT = "3308";

    public Connection createConnection(){
        try {
            Class c = Class.forName("com.mysql.cj.jdbc.Driver");
            Driver pilot = (Driver) c.newInstance();
            DriverManager.registerDriver(pilot);
            String protocol = "jdbc:mysql:";
            String ip = IP;
            String port = PORT;
            String nomBase = NOM_BASE;
            String chainDeConnexion = protocol + "//" + ip + ":" + port + "/" + nomBase;
            String dbUser = DB_USER;
            String dbPassword = DB_PASSWORD;
            return DriverManager.getConnection(chainDeConnexion, dbUser, dbPassword);
        }
        catch (Exception ex){
            System.err.println("An error occurred during connection: ");
            System.err.println(ex.getMessage());
            return null;
        }
    }
}

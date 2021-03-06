import java.sql.Connection;
import java.sql.DriverManager;

public class Main {

    public static void main(String[] args)  throws ClassNotFoundException {

        Class.forName("org.sqlite.JDBC");

        Connection connection = null;
        try {
            connection = DriverManager.getConnection("jdbc:sqlite:fake.db");
        } catch ( Exception e ) {
            printExcepion(e);
        }
        System.out.println("Opened database successfully");


        DBManager dbManager = DBManager.getInstance();
        dbManager.setoutConnection(connection);

        System.out.println("服务器启动...\n");

        Runnable doWorkRunnable = new Runnable() {
            public void run() {
                Server server = new Server();
            }
        };

        MainForm form = new MainForm();
    }

    public static void printExcepion (Exception e) {
        System.err.println( e.getClass().getName() + ": " + e.getMessage() );
        System.exit(0);
    }

}

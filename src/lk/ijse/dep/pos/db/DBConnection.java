package lk.ijse.dep.pos.db;

import javafx.scene.control.Alert;
import lk.ijse.dep.crypto.DEPCrypt;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Properties;

public class DBConnection {
    private static DBConnection dbConnection;
    private Connection connection;

    public static String host;
    public static String port;
    public static String db;
    public static String  user;
    public static String password;


    private DBConnection() {
        try {
            Class.forName("com.mysql.jdbc.Driver");

            Properties properties = new Properties();
            File file = new File("resources/application.properties");
            FileInputStream fis = new FileInputStream(file);
            properties.load(fis);
            fis.close();

            String ip = properties.getProperty("pos.ip");
            DBConnection.host = ip;
            String port = properties.getProperty("pos.port");
            DBConnection.port = port;
            String db = properties.getProperty("pos.db");
            DBConnection.db = db;
            String user = DEPCrypt.decode(properties.getProperty("pos.user"),"123");
            DBConnection.user = user;
            String password = DEPCrypt.decode(properties.getProperty("pos.password"),"123");
            DBConnection.password = password;

            /* Reading a file
            File file = new File("resources/application.properties");
            FileInputStream fis = new FileInputStream(file);        // Byte stream
            InputStreamReader isr = new InputStreamReader(fis);     // Char stream
            BufferedReader br = new BufferedReader(isr);            // String

            String out = "";
            String line = null;
            while( (line = br.readLine())!=null ){
                out += line;
            }
            System.out.println(out);
             */

            connection = DriverManager.getConnection("jdbc:mysql://" + ip + ":" + port + "/" + db + "?createDatabaseIfNotExist=true&allowMultiQueries=true", user, password);
            PreparedStatement pstm = connection.prepareStatement("SHOW TABLES");
            ResultSet resultSet = pstm.executeQuery();
            if (!resultSet.next()) {
                File dbScriptFile = new File("db-script.sql");
                if (!dbScriptFile.exists()){
                    new Alert(Alert.AlertType.ERROR,"File eka naaa, Call deppo");
                    throw  new RuntimeException("Unable to read DB Script");
                }
                StringBuilder sb= new StringBuilder();
                BufferedReader brScript = new BufferedReader(new InputStreamReader(new FileInputStream(dbScriptFile)));
                brScript.lines().forEach(s -> sb.append(s));
                brScript.close();
                System.out.println(sb.toString());
                pstm = connection.prepareStatement(sb.toString());
                pstm.execute();
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static DBConnection getInstance() {
        return (dbConnection == null) ? (dbConnection = new DBConnection()) : dbConnection;
    }

    public Connection getConnection() {
        return connection;
    }

}

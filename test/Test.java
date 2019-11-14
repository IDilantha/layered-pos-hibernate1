import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class Test {

    public static void main(String[] args) throws IOException, InterruptedException {
        Process exec = Runtime.getRuntime().exec(new String[]{"mysqldump","-h","localhost","-u","root","-pmysql","JDBC","-r","~/Desktop/abc.sql"});
        int i = exec.waitFor();
        System.out.println(i);
        InputStream errorStream = exec.getErrorStream();
        InputStreamReader reader = new InputStreamReader(errorStream);
        BufferedReader br = new BufferedReader(reader);
        String output = "";

        String line = null;
        while ((line = br.readLine())!= null){
            output +=line;
        }

        System.out.println(output);
    }

}

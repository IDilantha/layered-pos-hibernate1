package lk.ijse.dep.pos;


import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.stage.Stage;
import lk.ijse.dep.pos.db.HibernateUtil;

import java.net.URL;
import java.util.logging.*;

public class AppInitializer extends Application {

    public static void main(String[] args) {
        launch(args);
        HibernateUtil.getSessionFactory().close();
        System.out.println("Shutting down the connection");
    }

    @Override
    public void start(Stage primaryStage)  {
        try {

            // Let's setup the root logger
            Logger rootLogger = Logger.getLogger("");
            FileHandler fileHandler = new FileHandler("error.log", true);
            fileHandler.setFormatter(new SimpleFormatter());
            fileHandler.setLevel(Level.INFO);
            rootLogger.addHandler(fileHandler);

            URL resource = this.getClass().getResource("/lk/ijse/dep/pos/view/MainForm.fxml");
            Parent root = FXMLLoader.load(resource);
            Scene mainScene = new Scene(root);
            primaryStage.setScene(mainScene);
            primaryStage.setTitle("JDBC POS - 2019");
            primaryStage.centerOnScreen();
            primaryStage.setResizable(false);
            primaryStage.centerOnScreen();
            primaryStage.show();

        }catch (Exception e){
            new Alert(Alert.AlertType.ERROR,"Something went wrong, please contact DEPPO").show();
            Logger.getLogger("lk.ijse.dep.pos").log(Level.SEVERE, null,e);
        }
    }
}

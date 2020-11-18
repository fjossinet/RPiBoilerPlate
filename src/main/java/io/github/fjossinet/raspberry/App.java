package io.github.fjossinet.raspberry;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * Hello world!
 *
 */
public class App extends Application {

    @Override
    public void start(Stage stage) {
        Platform.setImplicitExit(true);

        var scene = new Scene(new FXScreen(), 640,480);
        stage.setScene(scene);
        stage.show();

        new Test().print();

        stage.setOnCloseRequest( t -> {
            Platform.exit();
            System.exit(0);
        });


    }

    public static void main(String[] args) {
        launch();
    }

}

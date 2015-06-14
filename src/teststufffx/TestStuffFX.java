/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package teststufffx;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 *
 * @author MartinStern
 */
public class TestStuffFX extends Application {

    int nbr = 1;

    @Override
    public void start(Stage primaryStage) {
        Button btn = new Button();
        btn.setText("Say 'Hello World'");
        btn.setDefaultButton(true);
        btn.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                System.out.println("Hello World! #" + nbr++);
            }
        });

        Button btn2 = new Button();
        btn2.setText("Say 'Hello World' V2");
        btn2.setDefaultButton(false);
        btn2.setOnAction(e -> {
            System.out.println("Hello World(V2)! #" + nbr++);
        });

        Button btn3 = new Button("show Window");
        btn3.setOnAction(e -> {
            String answer = WindowTwo.display("Second Window", "Give me some advice:");
            System.out.println("Answer from second window: " + answer);
        });
//        StackPane root = new StackPane();
        VBox root = new VBox(20);
        root.setAlignment(Pos.CENTER);
        root.getChildren().addAll(btn,btn2,btn3);
//        root.getChildren().add(btn2);

        Scene scene = new Scene(root, 300, 250);

        primaryStage.setTitle("Hello World!");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * The main() method is ignored in correctly deployed JavaFX application. main() serves only as fallback in case the application can not be launched through
     * deployment artifacts, e.g., in IDEs with limited FX support. NetBeans ignores main().
     *
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

}

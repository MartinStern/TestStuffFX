/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package teststufffx;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 *
 * @author Martin
 */
public class WindowTwo {

    // die Variable muss hier und static definiert werden, weil sonst die Lambda Expression mault
    static String answer;

    public static String display(String title, String message) {
        // da answer static sein muss und der Wert auch beim Schlieesen des Windows mit dem "Schliessen" Kreuz zurueckgegeen wrid
        // muss dies hier jedesmal initialiesiert werden, das sonst der Wert der letzten Entscheidung verwendet wuerde bei einem Folgeaufruf und Schliessen mit Kreuz
        answer = "not shure";
        Stage windowTowStage = new Stage();
        windowTowStage.initModality(Modality.APPLICATION_MODAL);
        windowTowStage.setTitle(title);
        windowTowStage.setWidth(300);
        windowTowStage.setHeight(300);
        Label label = new Label(message);

        Button btn1 = new Button("just say yes");
        btn1.setOnAction(e -> {
            answer = "Yes";
            windowTowStage.close();
        });
        Button btn2 = new Button("never ever");
        btn2.setOnAction(e -> {
            answer = "No";
            windowTowStage.close();
        });

        VBox layout = new VBox(20);
        layout.setAlignment(Pos.CENTER);
        layout.getChildren().addAll(label,btn1, btn2);
        Scene scene = new Scene(layout);
        windowTowStage.setScene(scene);
        windowTowStage.showAndWait();       // hier wird auf den Close gewartet
        return answer;                      // wird daher erst zurueckgegeben, wenn das Window geschlossen wird
    }
}

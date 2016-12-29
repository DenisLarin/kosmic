package sample.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;

/**
 * Created by denis on 28.12.16.
 */
public class DialogController {
    @FXML
    private TextArea txtabout;
    @FXML
    private Label label;

    public void setAbout (String string){
        txtabout.setWrapText(true);
        txtabout.setText(string);
        txtabout.setEditable(false);
    }
    public void setLabel (String string){
        this.label.setText(this.label.getText() + " " + string);
    }
    public void clean(){
        this.label.setText("Описание");
    }
}

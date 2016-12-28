package sample.controllers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import sample.logical.CollectionKosmikServises;

import java.io.IOException;
import java.net.MalformedURLException;

/**
 * Created by denis on 28.12.16.
 */
public class MainController {
    @FXML
    private HBox item1;
    @FXML
    private HBox item2;
    @FXML
    private HBox item3;
    @FXML
    private ComboBox<String> serviceType;
    @FXML
    private ComboBox<String> sex;
    @FXML
    private TextField txtcoast;
    @FXML
    private Button submit;
    @FXML
    private Button reset;
    @FXML
    private Button butitem1;
    @FXML
    private Button butitem2;
    @FXML
    private Button butitem3;
    @FXML
    private ImageView imgitem1;
    @FXML
    private ImageView imgitem2;
    @FXML
    private ImageView imgitem3;
    @FXML
    private TextArea textitem1;
    @FXML
    private TextArea textitem2;
    @FXML
    private TextArea textitem3;

    private FXMLLoader fxmlLoader = new FXMLLoader();
    private DialogController dialogController;
    private Stage dialogStage;
    private Parent fxmlDialog;
    private ObservableList<String> list = FXCollections.observableArrayList("Бровь", "Макияж", "Ногти", "Волосы");
    private ObservableList<String> sexlist = FXCollections.observableArrayList("М", "Ж");
    private CollectionKosmikServises collectionKosmikServises;

    @FXML
    public void initialize() {
        filldata();
        initComponents();
        initLoader();
    }

    private void initComponents() {
        serviceType.setItems(list);
        sex.setItems(sexlist);
        txtcoast.setText("Введите стоимость");
        textitem1.setWrapText(true);
        textitem2.setWrapText(true);
        textitem3.setWrapText(true);
    }

    private void initLoader() {
        try {
            fxmlLoader.setLocation(getClass().getResource("../fxml/modal.fxml"));
            fxmlDialog = fxmlLoader.load();
            dialogController = fxmlLoader.getController();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void filldata() {
        collectionKosmikServises = new CollectionKosmikServises();
    }


    public void show_dialog(ActionEvent actionEvent) {
        Button clickB = (Button) actionEvent.getSource();
        switch (clickB.getId()) {
            case "butitem1":

                break;

        }
    }

    public void mainShow(ActionEvent actionEvent) throws MalformedURLException {
        item1.setVisible(true);
        imgitem1.setImage(collectionKosmikServises.getKosmikServisesArrayList().get(0).getImage());

        textitem1.setText("Название услуги: " + collectionKosmikServises.getKosmikServisesArrayList().get(0).getName() + "\n" +
                "Стоимость услуги: " + collectionKosmikServises.getKosmikServisesArrayList().get(0).getCoast());
    }

    public void mainreset(ActionEvent actionEvent) {
        txtcoast.setText("введите стоимость");
        serviceType.setValue("Тип услуги");
        sex.setValue("Пол");
    }
}

package sample.controllers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.stage.Modality;
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
    private int[] elements = {-1, -1, -1};
    private Stage mainWindow;

    public void setMainWindow(Stage mainWindow) {
        this.mainWindow = mainWindow;
    }

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
        int position;
        switch (clickB.getId()) {
            case "butitem1":
                position = elements[0];
                show(position);
                break;
            case "butitem2":
                position = elements[1];
                show(position);
                break;
            case "butitem3":
                position = elements[2];
                show(position);
                break;

        }
    }

    private void show(int position) {
        if(dialogStage == null){
            dialogStage = new Stage();
            dialogStage.setResizable(false);
            dialogStage.setScene(new Scene(fxmlDialog));
            dialogStage.initModality(Modality.WINDOW_MODAL);
            dialogStage.initOwner(mainWindow);
        }
        dialogStage.setTitle("Описние услуги " + collectionKosmikServises.getKosmikServisesArrayList().get(position).getName());
        dialogStage.showAndWait();
    }

    public void mainShow(ActionEvent actionEvent) throws MalformedURLException {
        if (txtcoast.getText().equals("Введите стоимость")) return;
        if (serviceType.getValue() == null) return;
        if (sex.getValue() == null) return;
        int coast = Integer.parseInt(txtcoast.getText());
        String type = serviceType.getValue();
        String sexL = sex.getValue();
        serviceType.setDisable(true);
        txtcoast.setDisable(true);
        sex.setDisable(true);
        for (int i = 0; i < collectionKosmikServises.getKosmikServisesArrayList().size(); i++) {
            if (Integer.parseInt(collectionKosmikServises.getKosmikServisesArrayList().get(i).getCoast()) <= coast && type.equals(collectionKosmikServises.getKosmikServisesArrayList().get(i).getType()) && sexL.equals(collectionKosmikServises.getKosmikServisesArrayList().get(i).getSex())) {
                if (!item1.isVisible()) {
                    item1.setVisible(true);
                    imgitem1.setImage(collectionKosmikServises.getKosmikServisesArrayList().get(i).getImage());
                    textitem1.setText("Название услуги: " + collectionKosmikServises.getKosmikServisesArrayList().get(i).getName() + "\n" +
                            "Стоимость услуги: " + collectionKosmikServises.getKosmikServisesArrayList().get(i).getCoast());
                    elements[0] = i;
                    continue;
                } else if (!item2.isVisible()) {
                    item2.setVisible(true);
                    imgitem2.setImage(collectionKosmikServises.getKosmikServisesArrayList().get(i).getImage());
                    textitem2.setText("Название услуги: " + collectionKosmikServises.getKosmikServisesArrayList().get(i).getName() + "\n" +
                            "Стоимость услуги: " + collectionKosmikServises.getKosmikServisesArrayList().get(i).getCoast());
                    elements[1] = i;
                    continue;
                } else if (!item3.isVisible()) {
                    item3.setVisible(true);
                    imgitem3.setImage(collectionKosmikServises.getKosmikServisesArrayList().get(i).getImage());
                    textitem3.setText("Название услуги: " + collectionKosmikServises.getKosmikServisesArrayList().get(i).getName() + "\n" +
                            "Стоимость услуги: " + collectionKosmikServises.getKosmikServisesArrayList().get(i).getCoast());
                    elements[2] = i;
                    continue;
                }
            }
        }
        if (elements[0] == -1) {
            item1.setVisible(true);
            imgitem1.setVisible(false);
            butitem1.setVisible(false);
            textitem1.setText("Не найдено услуг");
        }
    }

    public void mainreset(ActionEvent actionEvent) {
        txtcoast.setText("Введите стоимость");
        serviceType.setValue("тип услуги");
        sex.setValue("пол");
        if (item1.isVisible()) {
            item1.setVisible(false);
            imgitem1.setImage(null);
            textitem1.setText("");
        }
        if (item2.isVisible()) {
            item2.setVisible(false);
            imgitem2.setImage(null);
            textitem2.setText("");
        }
        if (item3.isVisible()) {
            item3.setVisible(false);
            imgitem3.setImage(null);
            textitem3.setText("");
        }
        for (int i = 0; i < elements.length; i++) {
            elements[i] = -1;
        }
        sex.setDisable(false);
        serviceType.setDisable(false);
        imgitem1.setVisible(true);
        butitem1.setVisible(true);
        txtcoast.setDisable(false);
    }
}

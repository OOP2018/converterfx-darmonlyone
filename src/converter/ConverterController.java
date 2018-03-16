package converter;

import javafx.fxml.FXML;
import javafx.event.ActionEvent;
import javafx.scene.control.*;

/**
 * Controller of Converter application
 * @author Manusporn Fukkham
 */
public class ConverterController {

    @FXML
    TextField leftText;

    @FXML
    TextField rightText;

    @FXML
    Button convertButton;

    @FXML
    Button clearButton;

    @FXML
    ComboBox<Unit> choiceChoose;

    @FXML
    ComboBox<Unit> choiceConvert;

    @FXML
    MenuBar unitType;
    @FXML
    MenuItem length;

    @FXML
    MenuItem temperature;

    @FXML
    MenuItem volume;

    @FXML
    MenuItem weight;

    @FXML
    MenuItem currency;

    @FXML
    MenuItem speed;

    /** left textfield check to convert*/
    private boolean leftCheck = true;

    /**
     * Initialize the FXML
     * set ComboBox of application
     */
    @FXML
    public void initialize(){
        choiceChoose.getItems().clear();
        choiceConvert.getItems().clear();
        if (choiceChoose != null){
            choiceChoose.getItems().addAll(Length.values());
            choiceChoose.getSelectionModel().select(0);
        }
        if (choiceConvert != null){
            choiceConvert.getItems().addAll(Length.values());
            choiceConvert.getSelectionModel().select(1);
        }
    }

    @FXML
    public void exit(ActionEvent actionEvent){
        System.exit(0);
    }
    @FXML
    public void setLength(ActionEvent actionEvent){
        choiceChoose.getItems().clear();
        choiceConvert.getItems().clear();
        if (choiceChoose != null){
            choiceChoose.getItems().addAll(Length.values());
            choiceChoose.getSelectionModel().select(0);
        }
        if (choiceConvert != null){
            choiceConvert.getItems().addAll(Length.values());
            choiceConvert.getSelectionModel().select(1);
        }
    }

    @FXML
    public void setVolume(ActionEvent actionEvent) {
        choiceChoose.getItems().clear();
        choiceConvert.getItems().clear();
        if (choiceChoose != null){
            choiceChoose.getItems().addAll(Volume.values());
            choiceChoose.getSelectionModel().select(0);
        }
        if (choiceConvert != null){
            choiceConvert.getItems().addAll(Volume.values());
            choiceConvert.getSelectionModel().select(1);
        }
    }

    @FXML
    public void setWeight(ActionEvent actionEvent) {
        choiceChoose.getItems().clear();
        choiceConvert.getItems().clear();
        if (choiceChoose != null){
            choiceChoose.getItems().addAll(Weight.values());
            choiceChoose.getSelectionModel().select(0);
        }
        if (choiceConvert != null){
            choiceConvert.getItems().addAll(Weight.values());
            choiceConvert.getSelectionModel().select(1);
        }
    }

    @FXML
    public void setTemperature(ActionEvent actionEvent) {
        choiceChoose.getItems().clear();
        choiceConvert.getItems().clear();
        if (choiceChoose != null){
            choiceChoose.getItems().addAll(Temperature.values());
            choiceChoose.getSelectionModel().select(0);
        }
        if (choiceConvert != null){
            choiceConvert.getItems().addAll(Temperature.values());
            choiceConvert.getSelectionModel().select(1);
        }
    }

    @FXML
    public void setCurrency(ActionEvent actionEvent) {
        choiceChoose.getItems().clear();
        choiceConvert.getItems().clear();
        if (choiceChoose != null){
            choiceChoose.getItems().addAll(Currency.values());
            choiceChoose.getSelectionModel().select(0);
        }
        if (choiceConvert != null){
            choiceConvert.getItems().addAll(Currency.values());
            choiceConvert.getSelectionModel().select(1);
        }
    }

    @FXML
    public void setSpeed(ActionEvent actionEvent){
        choiceChoose.getItems().clear();
        choiceConvert.getItems().clear();
        if (choiceChoose != null){
            choiceChoose.getItems().addAll(Speed.values());
            choiceChoose.getSelectionModel().select(0);
        }
        if (choiceConvert != null){
            choiceConvert.getItems().addAll(Speed.values());
            choiceConvert.getSelectionModel().select(1);
        }
    }

    /**
     * Convert a distance form one unit to another
     */
    @FXML
    public void handleCovert(ActionEvent activeEvent){
        if (leftCheck)
            rightText.setText("");
        else leftText.setText("");
        String textInput = (!leftText.getText().equals("")) ? leftText.getText().trim() : rightText.getText().trim();
        double inputDouble;
        try {
            inputDouble = parseDouble(textInput);
        }catch (IllegalArgumentException e){
            Alert alert = new Alert(Alert.AlertType.ERROR,"Please in put value");
            alert.show();
            rightText.setText("");
            leftText.setText("");
            return;
        }

        double outputDouble = inputDouble;

        Unit toChange = (!leftText.getText().equals(""))? choiceChoose.getValue() : choiceConvert.getValue();
        Unit changed = (!leftText.getText().equals("")) ? choiceConvert.getValue(): choiceChoose.getValue();

        outputDouble *= toChange.convert(changed);
//            outputDouble *= toChange.getValue();
//            outputDouble /= changed.getValue();

        if (!leftText.getText().isEmpty()) {
            rightText.setText(String.format("%.6g", outputDouble));
        }else {
            leftText.setText(String.format("%.6g", outputDouble));
        }
    }

    /**
     * clear the textfield of application
     */
    @FXML
    public void handleClear(ActionEvent actionEvent){
        leftCheck = true;
        leftText.setText("");
        rightText.setText("");
    }

    /**
     * Action event of right textfield Press Enter
     */
    @FXML
    public void onEnterRight(ActionEvent actionEvent){
        leftCheck = false;
        leftText.setText("");
        handleCovert(actionEvent);
    }

    /**
     *Action event of left textfield Press Enter
     */
    @FXML
    public void onEnterLeft(ActionEvent actionEvent){
        leftCheck = true;
        rightText.setText("");
        handleCovert(actionEvent);
    }

    /**
     * To parse String to double
     * @param covert to convert
     * @return double to parse
     */
    public double parseDouble(String covert){
        try {
            return Double.parseDouble(covert);
        }catch (Exception e){
            System.err.println("This value is not Double");
            throw new IllegalArgumentException();
        }
    }
}

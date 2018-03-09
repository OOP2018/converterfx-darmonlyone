package converter;

import javafx.fxml.FXML;
import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;

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
    ComboBox<Length> choiceChoose;

    @FXML
    ComboBox<Length> choiceConvert;

    /** left textfield check to convert*/
    private boolean leftCheck = true;
    /** right textfield check to convert*/
    private boolean rightCheck = false;

    /**
     * Initialize the FXML
     * set ComboBox of application
     */
    @FXML
    public void initialize(){
        if (choiceChoose != null){
            choiceChoose.getItems().addAll(Length.values());
            choiceChoose.getSelectionModel().select(0);
        }
        if (choiceConvert != null){
            choiceConvert.getItems().addAll(Length.values());
            choiceConvert.getSelectionModel().select(1);
        }

    }
    /**
     * Convert a distance form one unit to another
     */
    @FXML
    public void handleCovert(ActionEvent activeEvent){
        if (leftCheck && !rightCheck)
            rightText.setText("");
        else leftText.setText("");
        String textInput = (!leftText.getText().equals("")) ? leftText.getText().trim() : rightText.getText().trim();
        double inputDouble = parseDouble(textInput);
        if (inputDouble == 0){
            Alert alert = new Alert(Alert.AlertType.ERROR,"Please in put value");
            alert.show();
            rightText.setText("");
            leftText.setText("");
            return;
        }

        double outputDouble = inputDouble;

        Length toChange = (!leftText.getText().equals(""))? choiceChoose.getValue() : choiceConvert.getValue();
        Length changed = (!leftText.getText().equals("")) ? choiceConvert.getValue(): choiceChoose.getValue();

            outputDouble *= toChange.getValue();
            outputDouble /= changed.getValue();

        if (!leftText.getText().isEmpty()) {
            rightText.setText(String.format("%.4g", outputDouble));
        }else {
            leftText.setText(String.format("%.4g", outputDouble));
        }
    }

    /**
     * clear the textfield of application
     */
    @FXML
    public void handleClear(ActionEvent actionEvent){
        leftCheck = true;
        rightCheck = false;
        leftText.setText("");
        rightText.setText("");
    }

    /**
     * Action event of right textfield Press Enter
     */
    @FXML
    public void onEnterRight(ActionEvent actionEvent){
        leftCheck = false;
        rightCheck = true;
        leftText.setText("");
        handleCovert(actionEvent);
    }

    /**
     *Action event of left textfield Press Enter
     */
    @FXML
    public void onEnterLeft(ActionEvent actionEvent){
        leftCheck = true;
        rightCheck = false;
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
            return 0;
        }
    }
}

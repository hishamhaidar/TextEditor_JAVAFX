package controller;

import javafx.application.Platform;
import javafx.beans.binding.Bindings;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;
import model.EditorModel;

import javax.swing.*;


public class EditorController {
    @FXML
    private TextArea editor;
    @FXML
    private EditorModel model;

    @FXML
    public void initialize(){
        model = new EditorModel();
        Bindings.bindBidirectional(editor.textProperty(),model.contentProperty());

//        Platform.runLater(()->{
//            ((Stage) editor.getScene().getWindow()).titleProperty().bind(
//
//            );
//        });
    }
}

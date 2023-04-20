package model;

import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.fxml.FXML;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class EditorModel {

    private final StringProperty filePath = new SimpleStringProperty(null);
    private final StringProperty content = new SimpleStringProperty("");
    private final BooleanProperty modified = new SimpleBooleanProperty(false);

    public String getFilePath() {
        return filePath.get();
    }

    public StringProperty filePathProperty() {
        return filePath;
    }

    public String getContent() {
        return content.get();
    }

    public StringProperty contentProperty() {
        return content;
    }

    public boolean isModified() {
        return modified.get();
    }

    public BooleanProperty modifiedProperty() {
        return modified;
    }

    public EditorModel(){
        content.addListener((observable,oldValue,newValue)->{
            modified.set(true);
        });
    }

    public void reset(){
        filePath.set(null);
        content.set("");
        modified.set(false);
    }
    public void open(String filePath) throws IOException {
        var s = Files.readString(Path.of(filePath));
        this.filePath.set(filePath);
        content.set(s);
        modified.set(false);
    }
    public void save() throws IOException {
        if(filePath.get()==null)
            throw new IllegalStateException();
        saveAs(filePath.get());
    }
    public void saveAs(String filepath) throws IOException {
        Files.writeString(Path.of(filepath),content.get());
        this.filePath.set(filepath);
        this.modified.set(false);
    }
}

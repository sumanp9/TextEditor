package sample;

import javafx.scene.control.*;
import javafx.stage.FileChooser;

import java.io.File;

public class Editor {

    public TextArea txtArea;
    public Button  btnBold, btnItalic, btnUnderline;
    public MenuBar menuBar;
    public MenuItem open = new MenuItem("Open File"),
            save =  new MenuItem("Save File") ,
            close = new MenuItem("Exit");
    public Menu file =  new Menu("File"),
            Edit = new Menu("Edit"),
            About = new Menu ("About");


    public void initialize(){
        createMenus();

        open.setOnAction(e -> {
            openFiles();
        });

    }

    private void openFiles() {

        FileChooser fileChooser =  new FileChooser();
        fileChooser.setTitle("Open File");
        fileChooser.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter("Text Files", "*.txt","*.rtf")
        );
        // needs work check previous projects .

    }

    private void createMenus() {
        file.getItems().addAll(open,save,close);
        menuBar.getMenus().addAll(file,Edit,About);
    }


}

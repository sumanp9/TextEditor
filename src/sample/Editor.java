package sample;

import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.*;

public class Editor {

    public TextArea txtArea;
    public Button  btnBold, btnItalic, btnUnderline;
    public MenuBar menuBar;
    private Stage stage;
    public AnchorPane anchorPane;


    public MenuItem open = new MenuItem("Open File"),
            save =  new MenuItem("Save File") ,
            close = new MenuItem("Exit");
    public Menu file =  new Menu("File"),
            Edit = new Menu("Edit"),
            About = new Menu ("About");


    public void initialize(){
        createMenus();

        open.setOnAction(e -> {
            try {
                openFiles();
            } catch (IOException e1) {
                e1.printStackTrace();
                System.out.println("Cannot opeen the file that u were trying to.");
            }
        });

        close.setOnAction(event -> {
            closeWindow();
        });

    }

    private void closeWindow() {
        stage = (Stage)anchorPane.getScene().getWindow();
        stage.close();
    }

    private void openFiles() throws IOException {

        FileChooser fileChooser =  new FileChooser();
        fileChooser.setTitle("Open File");

        stage = (Stage)anchorPane.getScene().getWindow();

        fileChooser.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter("Text Files  *.txt, *.rtf", "*.txt","*.rtf")
        );
        File file  = fileChooser.showOpenDialog(stage);

        readFile(file);


        /*if (file != null){
            stage.display(file);
        }*/
        // needs work check previous projects .

    }

    private void readFile(File file) throws IOException {

        BufferedReader buffer =  new BufferedReader(new FileReader(file));
        txtArea.clear();
        String string, lines = "";

        while((string =  buffer.readLine())!=null){
            //System.out.println(string);
            lines+=string+"\n";
        }

        txtArea.setText(lines);
    }

    private void createMenus() {
        file.getItems().addAll(open,save,close);
        menuBar.getMenus().addAll(file,Edit,About);
    }


}

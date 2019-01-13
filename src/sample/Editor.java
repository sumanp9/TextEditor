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

    public boolean savedFile = false,unedited = false;


    public MenuItem
            newFile =  new MenuItem("New File"),
            open = new MenuItem("Open File"),
            save =  new MenuItem("Save File") ,
            close = new MenuItem("Exit");
    public Menu file =  new Menu("File"),
            About = new Menu ("About");


    public void initialize(){
        createMenus();

        newFile.setOnAction(event -> {
            createNewFile();
        });

        open.setOnAction(e -> {
            try {
                openFiles();
                unedited =  true;
            } catch (IOException e1) {
               // e1.printStackTrace();
                System.out.println("Cannot open the file that u were trying to.");
            }
        });

        save.setOnAction(event -> {
            saveFile();
        });

        close.setOnAction(event -> {
            closeWindow();
        });

    }
//
    private void createNewFile() {
        if(!(txtArea.getText().isEmpty())){
            if(unedited == false || savedFile == false){
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setTitle("Please Save ur file");
                alert.setContentText("Please saved the file first");
                alert.showAndWait();

                saveFile();

                txtArea.clear();
            }
            else{
                txtArea.clear();
            }

        }

        System.out.println(savedFile);
        System.out.println(txtArea.getText().isEmpty());

    }




    private void saveFile() {
        stage = (Stage)anchorPane.getScene().getWindow();

        FileChooser fileChooser =  new FileChooser();
        fileChooser.setTitle("Save File");

        fileChooser.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter("Text Files  *.txt, *.rtf", "*.txt","*.rtf")

        );

        File saveFile = fileChooser.showSaveDialog(stage);
        try{
            PrintWriter writer;
            writer =  new PrintWriter(saveFile);
            writer.println(txtArea.getText());
            writer.close();
            savedFile =  true;

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }


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
        file.getItems().addAll(newFile,open,save,close);
        menuBar.getMenus().addAll(file,About);
    }


}

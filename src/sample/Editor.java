package sample;

import javafx.scene.control.*;

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
            System.out.println("Menu Item 1 Selected");
        });

    }

    private void createMenus() {
        file.getItems().addAll(open,save,close);
        menuBar.getMenus().addAll(file,Edit,About);
    }


}

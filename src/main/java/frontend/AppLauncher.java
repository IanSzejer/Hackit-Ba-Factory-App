package frontend;


import backend.App;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;


public class AppLauncher extends Application{
    public static void main(String[] args) {
        launch(args);
    }
    @Override
    public void start(Stage stage) throws Exception {
        App app = new App();
        stage.setTitle("App");
        Button codeButton=new Button();

        codeButton.setLayoutX(75);
        codeButton.setLayoutY(100);
        codeButton.setText("get code");
        TextArea textArea = new TextArea("");
        textArea.setEditable(false);
        textArea.setWrapText(true);
        GridPane gridPane = new GridPane();
        gridPane.setMaxWidth(Double.MAX_VALUE);
        gridPane.add(textArea, 0, 0);

        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Stuff");
        alert.getDialogPane().setContent(gridPane);
        codeButton.setOnAction(actionEvent -> {textArea.setText("your code is " + app.getCode());
        alert.showAndWait();});
        TextField seedInput= new TextField();
        seedInput.setLayoutX(130);
        seedInput.setLayoutY(200);
        Label seedChangeLabel = new Label("change seed if necesary");
        seedChangeLabel.setLayoutX(0);
        seedChangeLabel.setLayoutY(200);
        Button seedChangeButton=new Button();
        seedChangeButton.setLayoutX(135);
        seedChangeButton.setLayoutY(240);
        seedChangeButton.setText("change seed");
        seedChangeButton.setOnAction(actionEvent -> {
            if (seedInput.getCharacters().isEmpty())
                seedChangeLabel.setText("insert seed first");
            else {app.changeSeed(seedInput.getCharacters().toString());
                seedChangeLabel.setText("seed changed");
                }
        });



        Pane layout=new Pane(seedChangeButton,seedInput,seedChangeLabel,codeButton);
        Scene scene= new Scene(layout,350,350);
        stage.setScene(scene);
        stage.show();




    }
}


import javafx.application.Application;
import javafx.event.Event;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class View extends Application {

    private Dictionary dictionary;

    @Override
    public void init() throws Exception {
        // 1. Create the dictionary that the application uses
        this.dictionary = new Dictionary();
    }

    @Override
    public void start(Stage window) throws Exception {
        Button next = new Button("next");
        Button back = new Button("back");
        Button check = new Button("check");
        Text totranslate = new Text(dictionary.getRandomWord());
        TextField translationcheck = new TextField();
        Button save = new Button("save");
        TextField word = new TextField("word");
        TextField translation = new TextField("translate");

        VBox savepoint = new VBox();
        savepoint.getChildren().addAll(word, translation, save, next);

        VBox translationpoint = new VBox();
        translationpoint.getChildren().addAll(totranslate, translationcheck, check, back);

        BorderPane layoutsave = new BorderPane();
        BorderPane layouttranslate = new BorderPane();
        layoutsave.setCenter(savepoint);
        layouttranslate.setCenter(translationpoint);

        Scene scenefirst = new Scene(layoutsave);
        Scene scenesecond = new Scene(layouttranslate);

        next.setOnAction((event) -> {
            window.setScene(scenesecond);
        });

        back.setOnAction((event) -> {
            window.setScene(scenefirst);
        });

        save.setOnAction((event) -> {
            dictionary.add(word.getText(), translation.getText());
            word.clear();
            translation.clear();
        });

        check.setOnAction((event) -> {
            if(translationcheck.getText().trim().equals(dictionary.get(totranslate.getText()))){
                translationcheck.setText("correct");
            }else{
                translationcheck.setText("incorrect");
            }
            totranslate.setText(dictionary.getRandomWord());
        });

        window.setScene(scenefirst);
        window.show();
    }

    public static void main(String[] args) {
        

        launch(View.class);
    }
    
}

package extra;

import java.util.Arrays;

import javafx.application.Application;
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

public class Test extends Application {

    @Override
    public void start(Stage window) {
        Parameters params = getParameters();
        String title = params.getNamed().get("organization");
        String extra = params.getNamed().get("course");



        Text letters = new Text("Letters:");
        Text words = new Text("Words:");
        Text lonword = new Text("Longest word:");
        TextField leftText =new TextField("");

        HBox traker = new HBox();
        traker.setSpacing(10);
        traker.getChildren().addAll(letters, words, lonword);

        BorderPane layout = new BorderPane();
        layout.setCenter(new TextField(" "));
        layout.setBottom(traker);

        leftText.textProperty().addListener((change, oldValue, newValue) -> {
            int characters = newValue.length();
            String[] parts = newValue.split(" ");
            int word = parts.length;
            String longest = Arrays.stream(parts)
                .sorted((s1, s2) -> s2.length() - s1.length())
                .findFirst()
                .get();
            letters.setText("Letters:"+characters);
            words.setText("Words:"+word);
            lonword.setText("Longest word:"+longest);
        
            // set values of text elements
        });

        Scene view = new Scene(layout);

        window.setTitle(title +" "+ extra);
        window.setScene(view);
        window.show();
    }

    public static void main(String[] args) {
        

        launch(Test.class, "--organization=Once upon a time",
        "--course=Title");
    }
}
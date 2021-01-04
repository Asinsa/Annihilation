package Annihilation;

// All the libraries that are required
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.control.ChoiceBox;
import javafx.scene.paint.Color;

/**
 * @author Asinsa
 */

public class Options {
    
    private Stage OptionsStage = new Stage();
    public static String KeyMoveChoice = "Arrow Keys";
    public static String KeyShootChoice = "Left Mouse Click";
    
    public void showOptionsScreen(){
        
        GridPane grid = new GridPane();
        
        Label messages = new Label();
        messages.setText("");
        messages.setFont(new Font ("Stencil", 30));
        messages.setTextFill(Color.RED);
        
        //Name of screen
        Label Options = new Label();
        Options.setText("   Options");
        Options.setFont(new Font ("Stencil", 130));
        Options.setTextFill(Color.CYAN);
       
        //What button preference to move
        Label MoveMessage = new Label();
        MoveMessage.setText("What keys do you want to use to move your tank?");
        MoveMessage.setFont(new Font ("Stencil", 30));
        MoveMessage.setTextFill(Color.CYAN);
        ChoiceBox<String> KeysToMove = new ChoiceBox<>();
        KeysToMove.getItems().addAll("W A S D", "Arrow Keys");
        
        //What button preference to shoot
        Label ShootMessage = new Label();
        ShootMessage.setText("What keys do you want to use to shoot enemies?");
        ShootMessage.setFont(new Font ("Stencil", 30));
        ShootMessage.setTextFill(Color.CYAN);
        ChoiceBox<String> KeysToShoot = new ChoiceBox<>();
        KeysToShoot.getItems().addAll("Left Mouse Click", "Right Mouse Click");
        
        //Save button
        Button SaveButton = new Button();
        SaveButton.setText("Save");
        SaveButton.setFont(new Font("Stencil",40));
        SaveButton.setStyle("-fx-background-color: #2dba1e; ");
        SaveButton.setAlignment(Pos.CENTER);
        SaveButton.setOnAction(new EventHandler<ActionEvent>() {
            
            @Override
            public void handle(ActionEvent event) {
                    if (KeysToMove.getValue() != null && KeysToShoot.getValue() != null){
                        KeyMoveChoice = KeysToMove.getValue();
                        KeyShootChoice = KeysToShoot.getValue();
                        messages.setTextFill(Color.GREEN);
                        messages.setText("Preferences Saved");
                    }
                    else{
                        messages.setText("Please complete all fields to proceed!");
                    }
                }
        });
        
        //Back button
        Button BackButton = new Button();
        BackButton.setText("Back");
        BackButton.setFont(new Font("Stencil",40));
        BackButton.setStyle("-fx-background-color: #2dba1e; ");
        BackButton.setAlignment(Pos.CENTER);
        BackButton.setOnAction(new EventHandler<ActionEvent>() {
            
            @Override
            public void handle(ActionEvent event) {
                //New instance of the class TitleScreen is created
                TitleScreen back = new TitleScreen();
                back.start(new Stage());
                OptionsStage.close();
            }
        });
       
        //Layout of buttons + the title of the game
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setAlignment(Pos.TOP_CENTER);
        grid.add(Options,2,1);
        grid.add(MoveMessage,2,2);
        grid.add(KeysToMove,2,3);
        grid.add(ShootMessage,2,5);
        grid.add(KeysToShoot,2,6);
        grid.add(BackButton,1,13);
        grid.add(SaveButton,3,13);
        grid.add(messages,2,13);
        
        grid.setStyle("-fx-background-color: #000000;");
       
        Scene scene = new Scene (grid, 1364, 699);
       
        OptionsStage.setTitle("Options");
        OptionsStage.setScene(scene);
        OptionsStage.show();
       
   }
}

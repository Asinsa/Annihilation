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
import javafx.scene.paint.Color;

/**
 * @author Asinsa
 */

public class Missions {
    
    private Stage MissionsStage = new Stage();
    public static String Rank = "";
    
    public void showMissionsScreen(){
       
       GridPane grid = new GridPane();
       
       //Name of screen
        Label Mission = new Label();
        Mission.setText("Mission:");
        Mission.setFont(new Font ("Stencil", 130));
        Mission.setTextFill(Color.CYAN);
        
        //Mission instructions for that particular level       
        Label MissionInstructions = new Label();
        MissionInstructions.setFont(new Font ("Stencil", 130));
        MissionInstructions.setTextFill(Color.CYAN);
        MissionLoader.LoadMission(UserData.Level);
        MissionInstructions.setText(MissionLoader.MissionInfo);
        MissionInstructions.setFont(new Font ("Stencil", 40));
       
        //Play button
        Button PlayButton = new Button();
        PlayButton.setText("Play");
        PlayButton.setFont(new Font("Stencil",40));
        PlayButton.setStyle("-fx-background-color: #2dba1e; ");
        PlayButton.setAlignment(Pos.CENTER);
        PlayButton.setOnAction(new EventHandler<ActionEvent>() {
            
            @Override
            public void handle(ActionEvent event) {
                if (UserData.Level.equals(1)){
                    Rank = "(I) Private " + UserData.PlayerName;
                }
                if (UserData.Level.equals(2)){
                    Rank = "(II) Corporal " + UserData.PlayerName;
                }
                MissionsStage.close();
                new Game();
            }
        });
       
        //(horizontal, vertical, horizontal span, vertical span)
        //Layout of buttons + title of the screen
        grid.setHgap(6);
        grid.setVgap(10);
        grid.setAlignment(Pos.TOP_CENTER);
        grid.add(Mission,1,1,3,2);
        grid.add(MissionInstructions,1,3);
        grid.add(PlayButton,1,13);
        
        grid.setStyle("-fx-background-color: #000000;");
       
        Scene scene = new Scene (grid, 1364, 699);
       
        MissionsStage.setTitle("Missions");
        MissionsStage.setScene(scene);
        MissionsStage.show();
   }
}

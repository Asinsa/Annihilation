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

public class Help {
    
    private Stage HelpStage = new Stage();
    
    public void showHelpScreen(){
       
        GridPane grid = new GridPane();
       
        //Name of screen
        Label Instructions = new Label();
        Instructions.setText("Instructions");
        Instructions.setFont(new Font ("Stencil", 120));
        Instructions.setTextFill(Color.CYAN);
        
        //All instructions
        Label Instuction = new Label();
        Instuction.setText("> Press the arrow keys to move.\n\n"
                + "> Left mouse click in the direction you want to shoot\n\n"
                + "> If you want to use W A S D to move or Right mouse click\n"
                + "in the direction you want to shoot, please click on Options\n"
                + "in the title screen\n\n"
                + "> The aim is to complete the mission shown when you\n\n"
                + "> If you touch the enemy ghosts, your health decreases (health\n"
                + "bar indicated as green bar on bottom left)\n\n"
                + "> Be awaire that you have limited (ammo left indicated as a\n"
                + "yellow bar on the bottom left)");
        Instuction.setFont(new Font ("Stencil", 23));
        Instuction.setTextFill(Color.CYAN);
       
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
                HelpStage.close();
            }
        });
       
        //Layout of buttons + title of the screen
        grid.setVgap(5);
        grid.setVisible(true);
        grid.setAlignment(Pos.TOP_CENTER);
        grid.add(Instructions,2,1);
        grid.add(Instuction,1,2,3,1);
        grid.add(BackButton,1,3,3,1);

        //Background
        grid.setStyle("-fx-background-color: #000000;");
       
        Scene scene = new Scene (grid, 1364, 699);
       
        HelpStage.setTitle("Help");
        HelpStage.setScene(scene);
        HelpStage.show();
       
   }
}

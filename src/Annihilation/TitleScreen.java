package Annihilation;

// All the libraries that are required
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

/**
 * @author Asinsa
 */

public class TitleScreen extends Application {
    
    //Objects required
    @Override
    public void start(Stage TitleScreenStage) {
        
        //Name of game
        Label Title = new Label();
        Title.setText("Annihilation");
        Title.setFont(new Font("Stencil",130));
        Title.setTextFill(Color.WHITE);
        
        //New game button
        Button newGameButton = new Button();
        newGameButton.setText("New Game");
        newGameButton.setFont(new Font("Stencil",40));
        newGameButton.setStyle("-fx-background-color: #2dba1e; ");
        newGameButton.setAlignment(Pos.CENTER);
        newGameButton.setOnAction(new EventHandler<ActionEvent>() {
            
            @Override
            public void handle(ActionEvent event) {
                //New instance of the class NewGame is created
                NewGame newGame = new NewGame();
                newGame.showNewGameScreen();
                TitleScreenStage.close();
            }
        });
        
        //Load game button
        Button loadGameButton = new Button();
        loadGameButton.setText("Load Game");
        loadGameButton.setFont(new Font("Stencil",40));
        loadGameButton.setStyle("-fx-background-color: #2dba1e; ");
        loadGameButton.setAlignment(Pos.CENTER);
        loadGameButton.setOnAction(new EventHandler<ActionEvent>() {
            
            @Override
            public void handle(ActionEvent event) {
                //New instance of the class Login is created
                Login login = new Login();
                login.showLoginScreen();
                TitleScreenStage.close();
            }
        });
        
        //Options button
        Button optionsButton = new Button();
        optionsButton.setText("Options");
        optionsButton.setFont(new Font("Stencil",40));
        optionsButton.setStyle("-fx-background-color: #2dba1e; ");
        optionsButton.setAlignment(Pos.CENTER);
        optionsButton.setOnAction(new EventHandler<ActionEvent>() {
            
            @Override
            public void handle(ActionEvent event) {
                //New instance of the class Options is created
                Options options = new Options();
                options.showOptionsScreen();
                TitleScreenStage.hide();
            }
        });
        
        //Help button
        Button helpButton = new Button();
        helpButton.setText("Help");
        helpButton.setFont(new Font("Stencil",40));
        helpButton.setStyle("-fx-background-color: #2dba1e; ");
        helpButton.setAlignment(Pos.CENTER);
        helpButton.setOnAction(new EventHandler<ActionEvent>() {
            
            @Override
            public void handle(ActionEvent event) {
                //New instance of the class Help is created
                Help help = new Help();
                help.showHelpScreen();
                TitleScreenStage.close();
            }
        });
        
        Label blank = new Label();
        blank.setText("");
        Label blank2 = new Label();
        blank2.setText("");
        Label blank3 = new Label();
        blank3.setText("");
        Label blank4 = new Label();
        blank4.setText("");
        
        //Layout of buttons + the title of the game
        GridPane grid = new GridPane();
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setAlignment(Pos.TOP_CENTER);
        grid.add(Title,2,1);
        grid.setHalignment(newGameButton,HPos.CENTER);
        grid.add(newGameButton,2,2);
        grid.add(blank,2,3);
        grid.setHalignment(loadGameButton,HPos.CENTER);
        grid.add(loadGameButton,2,4);
        grid.add(blank2,2,5);
        grid.setHalignment(optionsButton,HPos.CENTER);
        grid.add(optionsButton,2,6);
        grid.add(blank3,2,7);
        grid.setHalignment(helpButton,HPos.CENTER);
        grid.add(helpButton,2,8);
        grid.add(blank4,2,9);
        
        //Background
        Image background = new Image("TitleScreenBackground.jpg");
        
        BackgroundImage tankPic = new BackgroundImage(background,
                BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT,
                BackgroundPosition.CENTER, BackgroundSize.DEFAULT);
        Background tankBackground = new Background(tankPic);
        grid.setBackground(tankBackground);
        
        //Stage aka the game window
        Scene scene = new Scene(grid, 1364, 699);
        
        TitleScreenStage.setTitle("Annihilation");
        TitleScreenStage.setScene(scene);
        TitleScreenStage.show();
    }
    
    public static void main(String[] args) {
        launch(args);
    }
}
    
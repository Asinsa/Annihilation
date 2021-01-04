package Annihilation;

// All the libraries that are required
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.PasswordField;
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

public class NewGame {
    
    private Stage NewGameStage = new Stage();
    
    //Objects required
    public void showNewGameScreen(){
        
        GridPane grid = new GridPane();
        
        Label blank = new Label();
        blank.setText("");
        Label messages = new Label();
        messages.setText("");
        messages.setFont(new Font ("Stencil", 30));
        messages.setTextFill(Color.RED);
        
        //Name of screen
        Label Login = new Label();
        Login.setText(" New Account");
        Login.setFont(new Font ("Stencil", 130));
        Login.setTextFill(Color.CYAN);
        
        //Username
        Label Username = new Label();
        Username.setText("Username: ");
        Username.setFont(new Font ("Stencil", 40));
        Username.setTextFill(Color.CYAN);
        TextField UsernameField = new TextField();
        UsernameField.setFont(new Font ("Calibiri", 30));
        UsernameField.setPromptText("Enter Username");
        
        //Password
        Label Password = new Label();
        Password.setText("Password: ");
        Password.setFont(new Font ("Stencil", 40));
        Password.setTextFill(Color.CYAN);
        PasswordField PasswordField = new PasswordField();
        PasswordField.setFont(new Font ("Calibiri", 30));
        PasswordField.setPromptText("Enter Password");
        
        //Confirm password
        Label ConfirmPassword = new Label();
        ConfirmPassword.setText("Confirm Password: ");
        ConfirmPassword.setFont(new Font ("Stencil", 40));
        ConfirmPassword.setTextFill(Color.CYAN);
        PasswordField ConfirmPasswordField = new PasswordField();
        ConfirmPasswordField.setFont(new Font ("Calibiri", 30));
        ConfirmPasswordField.setPromptText("Confirm Password");
        
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
                NewGameStage.close();
                MissionLoader.LoadMission(UserData.Level);
            }
        });
        
        //Create account & play button
        Button CreateNewUserButton = new Button();
        CreateNewUserButton.setText("Create Account & Play");
        CreateNewUserButton.setFont(new Font("Stencil",40));
        CreateNewUserButton.setStyle("-fx-background-color: #2dba1e; ");
        CreateNewUserButton.setAlignment(Pos.CENTER);
        //New instance of the class UserData is created
        UserData userData = new UserData();
        CreateNewUserButton.setOnAction(new EventHandler<ActionEvent>() {
     
            @Override
            public void handle(ActionEvent event) {
                //If fields left empty
                if (UsernameField.getText().isEmpty()){
                    messages.setText("Please complete all fields to proceed!");
                }
                
                //If username field and password fields match
                else if (PasswordField.getText().equals(ConfirmPasswordField.getText())) {
                    //Calls CreateUserData method in userData class
                    userData.CreateUserData(UsernameField.getText(), 
                            PasswordField.getText(), UserData.Level);
                    messages.setTextFill(Color.GREEN);
                    messages.setText("Success!");
                    UserData.tempLevel = "1";
                    //New instance of the class Missions is created
                    Missions missions = new Missions();
                    missions.showMissionsScreen();
                    NewGameStage.close();
                }
                
                //Otherwise
                else {
                    messages.setText("Password and confirm password does not match!");
                }
            }
        });
        
        //Layout of buttons + title of the screen
        //(horizontal, vertical, horizontal span, vertical span)
        grid.setHgap(6);
        grid.setVgap(10);
        grid.setAlignment(Pos.TOP_CENTER);
        grid.add(Login,1,1,3,2);
        grid.add(blank,1,2,3,3);
        grid.add(Username,1,5);
        grid.add(UsernameField,2,5);
        grid.add(Password,1,6);
        grid.add(PasswordField,2,6);
        grid.add(ConfirmPassword,1,7);
        grid.add(ConfirmPasswordField,2,7);
        grid.add(messages,1,8,3,5);
        grid.add(CreateNewUserButton,2,13);
        grid.add(BackButton,1,13);
        
        //Background
        grid.setStyle("-fx-background-color: #000000;");
        
        //Stage aka the game window
        Scene scene = new Scene (grid, 1364, 699);
        
        NewGameStage.setTitle("New Game");
        NewGameStage.setScene(scene);
        NewGameStage.show();
    };
}

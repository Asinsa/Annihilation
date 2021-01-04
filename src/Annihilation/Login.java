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

public class Login {
    
    private Stage LoginStage = new Stage();
    
    public void showLoginScreen(){
       
       GridPane grid = new GridPane();
        
        Label blank = new Label();
        blank.setText("");
        Label messages = new Label();
        messages.setText("");
        messages.setFont(new Font ("Stencil", 30));
        messages.setTextFill(Color.RED);
        
        //Name of screen
        Label Login = new Label();
        Login.setText("   Login");
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
                LoginStage.close();
            }
        });
        
        //Play button
        Button PlayButton = new Button();
        PlayButton.setText("Play");
        PlayButton.setFont(new Font("Stencil",40));
        PlayButton.setStyle("-fx-background-color: #2dba1e; ");
        PlayButton.setAlignment(Pos.CENTER);
        //New instance of the class UserData is created
        UserData UserData = new UserData();
        PlayButton.setOnAction(new EventHandler<ActionEvent>() {
     
            @Override
            public void handle(ActionEvent event) {
                if (UsernameField.getText().isEmpty()){
                    messages.setText("Please complete all fields to proceed!");
                }
                else {
                    //Calls VerifyLogin method in userData class
                    UserData.VerifyLogin(UsernameField.getText(), 
                            PasswordField.getText());
                    if (UserData.found == true){
                        messages.setTextFill(Color.GREEN);
                        messages.setText("Success!");
                        //Calls GetUserData method in userData class
                        UserData.GetUserData(UsernameField.getText());
                        //New instance of the class Missions is created
                        Missions missions = new Missions();
                        missions.showMissionsScreen();
                        LoginStage.close();
                    }
                    else if (UserData.found == false) {
                        messages.setText("Incorrect login details!");
                    }
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
        grid.add(messages,1,8,3,5);
        grid.add(PlayButton,2,13);
        grid.add(BackButton,1,13);
       
        //Background
        grid.setStyle("-fx-background-color: #000000;");
       
        //Stage aka the game window
        Scene scene = new Scene (grid, 1364, 699);
       
        LoginStage.setTitle("Login");
        LoginStage.setScene(scene);
        LoginStage.show();
   }
}

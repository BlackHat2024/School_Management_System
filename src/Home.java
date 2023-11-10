import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.layout.*;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.scene.text.Font; 
import javafx.scene.text.FontPosture; 
import javafx.scene.text.FontWeight; 
import javafx.scene.text.Text; 

public class Home extends Application  {
	Stage window;
	Scene s1,s2;
	Button button,button1,button2,button3;
	
	public static void main(String[] args){
		launch(args);		
	}

	@Override
	public void start(Stage home) throws Exception {
		window=home;
		//title
		window.setTitle("BlackHat");
		
		Text text = new Text(); 
	    text.setFont(Font.font("arial-narrow", FontWeight.BOLD, FontPosture.REGULAR, 40));         
	    text.setText("BlackHat"); 
	    Text text1 = new Text(); 
	    text1.setFont(Font.font("arial-narrow", FontWeight.BOLD, FontPosture.REGULAR, 40));           
	    text1.setText("University"); 
		
		//button
		button = new Button();
		button1 = new Button();
		button2 = new Button();
		button3 = new Button();
		//button  txt
		button.setText("Admin");
		button1.setText("Teacher");
		button2.setText("Student");
		button3.setText("Close");
		//button action
		button.setOnAction(e->admin.adminlogin());
		button1.setOnAction(e->tlogin.ttlogin());
		button2.setOnAction(e->studentpart.sp());
		button3.setOnAction(e->window.close());
		//window plan
		VBox homepage = new VBox();
		homepage.setAlignment(Pos.CENTER);
		homepage.setSpacing(24);
		homepage.getChildren().addAll(text,text1,button,button1,button2,button3);
		//page scene
		s1 = new Scene(homepage,400,400);
		
		

		window.setScene(s1);
		window.show();
	}
	
	

}

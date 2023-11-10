import java.io.IOException;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class admin1 extends admin {

	
	static Scene s1,s2,s3,s4,s5;
	static Button adds,addt,addsub,shows,showt,showsub,mm;
	public static void adminpart() {
		Stage admp1=new Stage();
		admp1.setTitle("Options");
		
		Text text = new Text(); 
	    text.setFont(Font.font("arial-narrow", FontWeight.BOLD, FontPosture.REGULAR, 20)); 
	    text.setX(50); 
	    text.setY(130);          
	    text.setText("Admin Actions"); 
	//creating buttons
		adds = new Button();
		addt = new Button();
		addsub = new Button();
		shows = new Button();
		showt = new Button();
		showsub = new Button();
		mm = new Button();
//setting name to buttons
		adds.setText("Add Student");
		addt.setText("Add Teacher");
		addsub.setText("Add Subject");
		shows.setText("Students info");
		showt.setText("Teachers info");
		showsub.setText("Subject info");
		mm.setText("Main Menu");
		//button action
		adds.setOnAction(e->addstudent.adds());
		addt.setOnAction(e->addteacher.addt());
		addsub.setOnAction(e->addsubject.addsub());
		shows.setOnAction(e->{showstudent.dis();});
		showt.setOnAction(e->showteacher.dis());
		showsub.setOnAction(e->showsubject.dis());
		mm.setOnAction(e->admp1.close());
		//window plan
		VBox admpart = new VBox();
		admpart.setAlignment(Pos.CENTER);
		admpart.setSpacing(24);
		admpart.getChildren().addAll(text,adds,addt,addsub,shows,showt,showsub,mm);
		//page scene
		s1 = new Scene(admpart,400,400);		

		admp1.setScene(s1);
		admp1.show();
	}

}

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

public class teacherpart extends tlogin {

	public static void tp(String checkUser) {
		Stage tpart=new Stage();
		tpart.setTitle("Teacher");
		Text text = new Text(); 
	    text.setFont(Font.font("arial-narrow", FontWeight.BOLD, FontPosture.REGULAR, 20)); 
	    text.setText("Teacher Options"); 
	   
	   
		Button t1=new Button("Add grade");
		Button t2=new Button("See grade");
		t1.setOnAction(e->addgrade.addg(checkUser));
		t2.setOnAction(e->tegsh.dis(checkUser));
		VBox tepart = new VBox();
		tepart.setAlignment(Pos.CENTER);
		tepart.setSpacing(24);
		tepart.getChildren().addAll(text,t1,t2);
		//page scene
		Scene s1 = new Scene(tepart,300,300);		

		tpart.setScene(s1);
		tpart.show();
	}

}

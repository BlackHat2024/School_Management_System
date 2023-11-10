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

public class studentpart extends Home{

	public static void sp() {
		Stage tpart=new Stage();
		tpart.setTitle("Student");
		Text text = new Text(); 
	    text.setFont(Font.font("arial-narrow", FontWeight.BOLD, FontPosture.REGULAR, 20)); 
	    text.setText("Student Options"); 
	   
	   
		Button t2=new Button("See grade");
		t2.setOnAction(e->stgsh.dis());
		VBox tepart = new VBox();
		tepart.setAlignment(Pos.CENTER);
		tepart.setSpacing(24);
		tepart.getChildren().addAll(text,t2);
		//page scene
		Scene s1 = new Scene(tepart,300,300);		

		tpart.setScene(s1);
		tpart.show();
	}

}

import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.scene.*;
import javafx.scene.layout.*;
import javafx.scene.control.*;
import javafx.geometry.*;

public class ab1 extends tlogin  {
	
	public static void display(String title,String msg) {
		Stage window1 = new Stage();
		window1.initModality(Modality.APPLICATION_MODAL);
		//alert box title
		window1.setTitle(title);
		
		Label alert1 =new Label();
		//alert box showing message
		alert1.setText(msg);
		//close button for alert box
		Button closebutton =new Button("Close");
		closebutton.setOnAction(e->window1.close());
		
		VBox alert1leyout = new VBox();
		alert1leyout.getChildren().addAll(alert1,closebutton);
		alert1leyout.setAlignment(Pos.CENTER);
		alert1leyout.setSpacing(20);
		
		Scene alert1scene = new Scene(alert1leyout,260,100);
		window1.setScene(alert1scene);
		window1.showAndWait();
		
	}

}

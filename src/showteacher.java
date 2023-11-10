import java.io.BufferedReader;
import java.io.FileReader;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class showteacher extends admin1{
	static String i1,i2,i3,i4,i5,i6;
	//table declare
	 private static TableView<Teacher> tt = new TableView();
	static void dis()
	 {
		Stage showt = new Stage();
		Scene sss = new Scene(new Group(), 360 , 400);
		showt.setTitle("Teacher Information");
		
		final Label label = new Label("Teacher Information");
        label.setFont(new Font("Arial", 20));
 
        tt.setEditable(true);
        //table columns creation
        TableColumn<Teacher , String> id = new TableColumn<Teacher, String>("ID");
        id.setCellValueFactory(new PropertyValueFactory<>("id"));
        
        TableColumn<Teacher , String> name = new TableColumn<Teacher, String>("Name");
        name.setCellValueFactory(new PropertyValueFactory<>("name"));
        
        TableColumn<Teacher , String> surname = new TableColumn<Teacher, String>("Surname");
        surname.setCellValueFactory(new PropertyValueFactory<>("surname"));
        
        TableColumn<Teacher , String> age = new TableColumn<Teacher, String>("Age");
        age.setCellValueFactory(new PropertyValueFactory<>("age"));
        
        
        TableColumn<Teacher , String> wage = new TableColumn<Teacher, String>("Wage $");
        wage.setCellValueFactory(new PropertyValueFactory<>("wage"));

        
        TableColumn<Teacher , String> pass = new TableColumn<Teacher, String>("Password");
        pass.setCellValueFactory(new PropertyValueFactory<>("pass"));

        tt.getColumns().addAll(id, name,surname,age,wage,pass);
        tt.getItems().clear();
        
        //reading database
	  try
	  {
	  BufferedReader br=new BufferedReader(new FileReader("database/TeacherDatabase.txt"));
	  String s="";

	   while( (s=br.readLine()) !=null )
	   {
	    String data[]=new String[6];
	    data=s.split(",");
	    for(int i=0;i<6;i++)
	    {
	    	if(i==0)	
		    i1=data[i];
	    	if(i==1)
	    		i2=data[i];
	    	if(i==2)
	    		i3=data[i];
	    	if(i==3)
	    		i4=data[i];
	    	if(i==4)
	    		i5=data[i];
	    	if(i==5)
	    		i6=data[i];
	    
	    }
	  //adding to table 
		tt.getItems().add(new Teacher(i1,i2,i3,i4,i5,i6));
	   }
	  }
	  
	  catch(Exception e){}
	  
	  tt.setPrefSize(330, 300);
	  final VBox vbox = new VBox();
      vbox.setSpacing(5);
      vbox.setPadding(new Insets(10, 0, 0, 10));
	  StackPane pane = new StackPane();
	  pane.getChildren().add(tt) ;
      ((Group) sss.getRoot()).getChildren().addAll(vbox);

      vbox.getChildren().addAll(label, pane);
      showt.setScene(sss);
      showt.show();

	 }
	
}

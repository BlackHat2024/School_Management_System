import java.io.*;

import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class showsubject extends admin1 {
	static String i1,i2,i3;
	//table declare
	 private static TableView<Subject> tss = new TableView();
	 static void dis()
	 {
		 
		 Stage showt = new Stage();
			Scene sss = new Scene(new Group() , 360 , 400);
			showt.setTitle("Subject Information");
			
			final Label label = new Label("Subject Information");
	        label.setFont(new Font("Arial", 20));
	 
	        tss.setEditable(true);
	      //table columns creation
	        TableColumn<Subject , String> id = new TableColumn<Subject, String>("ID");
	        id.setCellValueFactory(new PropertyValueFactory<>("id"));
	        
	        TableColumn<Subject , String> name = new TableColumn<Subject, String>("Name");
	        name.setCellValueFactory(new PropertyValueFactory<>("name"));
	        
	        TableColumn<Subject , String> tid = new TableColumn<Subject, String>("Teacher id");
	        tid.setCellValueFactory(new PropertyValueFactory<>("tid"));
	        //table head
	        tss.getColumns().addAll(id, name,tid);
	      //clearing table
	        tss.getItems().clear();
	      //reading database
	  try
	  {
	  BufferedReader br=new BufferedReader(new FileReader("database/SubjectDatabase.txt"));
	  String s="";
	   while( (s=br.readLine()) !=null )
	   {
	    String data[]=new String[3];
	    data=s.split(",");
	    for(int i=0;i<3;i++)
	    {
	    	if(i==0)	
			    i1=data[i];
		    	if(i==1)
		    		i2=data[i];
		    	if(i==2)
		    		i3=data[i];

	    }
	  //adding to table 
	    tss.getItems().add(new Subject(i1,i2,i3));
	   }
	  }
	  catch(Exception e){}
	  tss.setPrefSize(220, 300);
	  final VBox svb = new VBox();
      svb.setSpacing(5);
      svb.setPadding(new Insets(10, 0, 0, 10));
	  StackPane pane = new StackPane();
	  pane.getChildren().add(tss) ;
	  
      svb.getChildren().addAll(label, pane);
     ((Group) sss.getRoot()).getChildren().addAll(svb);

      showt.setScene(sss);
      showt.show();
	  
	 }
}
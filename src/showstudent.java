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

public class showstudent extends admin1{
	static String i1,i2,i3,i4,i5,i6;
	//table declare
	 private static TableView<Student> ts = new TableView();
	 static void dis()
	 {
		 
		 Stage showt = new Stage();
			Scene sss = new Scene(new Group() , 360 , 400);
			showt.setTitle("Student Information");
			
			final Label label = new Label("Student Information");
	        label.setFont(new Font("Arial", 20));
	 
	        ts.setEditable(true);
	        //table columns creation
	        TableColumn<Student , String> id = new TableColumn<Student, String>("ID");
	        id.setCellValueFactory(new PropertyValueFactory<>("id"));
	        
	        TableColumn<Student , String> name = new TableColumn<Student, String>("Name");
	        name.setCellValueFactory(new PropertyValueFactory<>("name"));
	        
	        TableColumn<Student , String> surname = new TableColumn<Student, String>("Surname");
	        surname.setCellValueFactory(new PropertyValueFactory<>("surname"));
	        
	        TableColumn<Student , String> year = new TableColumn<Student, String>("Year");
	        year.setCellValueFactory(new PropertyValueFactory<>("year"));
	        
	        
	        TableColumn<Student , String> age = new TableColumn<Student, String>("Age");
	        age.setCellValueFactory(new PropertyValueFactory<>("age"));
	        //table head
	        ts.getColumns().addAll(id, name,surname,year,age);
	        //clearing table
	        ts.getItems().clear();
	        //reading database
	  try
	  {
	  BufferedReader br=new BufferedReader(new FileReader("database/StudentDatabase.txt"));
	  String s="";
	  
	  while( (s=br.readLine()) !=null )
	   {
	    String data[]=new String[5];
	    data=s.split(",");
	    for(int i=0;i<5;i++)
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
	    	
	    
	    }
	    //adding to table 
		ts.getItems().add(new Student(i1,i2,i3,i4,i5));
	  
	   }
	  }
	
	  catch(Exception e){}
	  
	  ts.setPrefSize(269, 300);
	  final VBox svb = new VBox();
      svb.setSpacing(5);
      svb.setPadding(new Insets(10, 0, 0, 10));
	  StackPane pane = new StackPane();
	  pane.getChildren().add(ts) ;
	  
      svb.getChildren().addAll(label, pane);
     ((Group) sss.getRoot()).getChildren().addAll(svb);

      showt.setScene(sss);
      showt.show();
	  
	 }
}
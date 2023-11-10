import java.io.*;
import java.text.DecimalFormat;

import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class tegsh extends teacherpart{
	static String i1,i2,i3,i4,i5,i6,l1,l2,l3,a,b,c;
	static double avg=0;
	static int t=0;
	static double g;
	private static DecimalFormat df = new DecimalFormat("0.00");
	 private static TableView<Tgc> tg = new TableView();
	 private static TableView<Student> ts = new TableView();
	 static void dis(String checkUser)
	 {
		 
		 Stage showt = new Stage();
			
			showt.setTitle("Student Grade");
			
			TextField stuid = new TextField();
	        Label stuidlab=new Label("Student ID");

			final Label label = new Label("Student Information");
	        label.setFont(new Font("Arial", 20));
	 
	        tg.setEditable(true);
	 
	        TableColumn<Tgc , String> subid = new TableColumn<Tgc, String>("Subject ID");
	        subid.setCellValueFactory(new PropertyValueFactory<>("subid"));
	        
	        TableColumn<Tgc , String> grade = new TableColumn<Tgc, String>("Grade");
	        grade.setCellValueFactory(new PropertyValueFactory<>("grade"));
	        
	        TableColumn<Tgc , String> cla = new TableColumn<Tgc, String>("Class");
	        cla.setCellValueFactory(new PropertyValueFactory<>("cla"));
	        
	        tg.getColumns().addAll(subid,grade,cla);
	        
	        Label label1 = new Label("Select Desired Course:");
	        Font font = Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 12);
	        label1.setFont(font);
	        //Creating a combo box
	        ComboBox<String> combo = new ComboBox<String>();
	        //Setting the prompt text of the combo box
	        combo.setPromptText("Select Course");
	        //Getting the observable list of the combo box
	        ObservableList<String> list = combo.getItems();
	        
	        ts.setEditable(true);
	   	 
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
	        ts.getColumns().addAll(id, name,surname,year,age);
	        ts.getItems().clear();
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
		ts.getItems().add(new Student(i1,i2,i3,i4,i5));
	  
	   }
	  }
	
	  catch(Exception e){}
	  
	  ts.setPrefSize(269, 300);
	        
	        
	        ComboBox<String> combo2 = new ComboBox<String>();
	        //Setting the prompt text of the combo box
	        combo2.setPromptText("Class");
	        //Getting the observable list of the combo box
	        ObservableList<String> list2 = combo2.getItems();
	        list2.add("All");
	        list2.add("1");
	        list2.add("2");
	        list2.add("3");
	        list2.add("4");
	        list2.add("5");
	        Text text = new Text(); 
	        text.setFont(Font.font("arial-narrow", FontWeight.BOLD, FontPosture.REGULAR, 12)); 
	        text.setText("Your subjects id:"); 
	        Button b1=new Button("Show");
	        
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
	      		   l1=data[i];
	      	    	if(i==1)
	      	    		l2=data[i];
	      	    	if(i==2)
	      	    		l3=data[i];

	          }
	          if(l3.equals(checkUser)) {
	          	list.add(l1);
	          }
	         }
	        }
	        catch(Exception e){}
	       
	        Text text2 = new Text(); 
		    text2.setFont(Font.font("arial-narrow", FontWeight.BOLD, FontPosture.REGULAR, 20)); 
	        
	        b1.setOnAction(e->{
	        	tg.getItems().clear();
	        	stuid.getText();combo.getValue();
	        a=combo.getValue();
	        b=stuid.getText();
	        c=combo2.getValue();
	        avg=0;
	        t=0;
	        try
	  	  {
	  	  BufferedReader br=new BufferedReader(new FileReader("students/"+b+".txt"));
	  	  String s="";
	  	  
	  	  while( (s=br.readLine()) !=null )
	  	   {
	  	    String data[]=new String[5];
	  	    data=s.split(",");
	  	    for(int i=0;i<5;i++)
	  	    {
	  	    	if(i==0)	
	  			    i4=data[i];
	  		    	if(i==1)
	  		    		i5=data[i];
	  	    	if(i==2)	
	  		    i1=data[i];
	  	    	if(i==3)
	  	    		i2=data[i];
	  	    	if(i==4)
	  	    		i3=data[i];
	  	    	
	  	    
	  	    }
	  	  if(a.equals(i1)&&(c.equals(i3)||c.equals("All"))) {
	  		  
	  		tg.getItems().add(new Tgc(i1,i2,i3));
	  		g = Double.parseDouble(i2);
	  		avg=avg+g;
	  		  t++;
	  	  }
	  	  
	  		}
	  	  
	  	
	  	text2.setText("Average is:"+df.format(avg/t)); 
	  	  }
	  	
	  	  catch(Exception e2){}
	        
	        });
	       
	  
	  
	  tg.setPrefSize(269, 300);
	  final VBox svb = new VBox();
      svb.setSpacing(5);
      svb.setPadding(new Insets(10, 0, 0, 10));
	  StackPane pane = new StackPane();
	  pane.getChildren().add(tg) ;
	  
      svb.getChildren().addAll(label,ts,stuidlab,stuid,label1,combo,combo2,b1, pane,text2);
      ScrollPane s1 = new ScrollPane(svb);
      Scene sss = new Scene(s1 , 360 , 600);
      showt.setScene(sss);
      showt.show();
	  
	 }
}
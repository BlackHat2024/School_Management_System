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

public class stgsh extends studentpart{
	static String i1,i2,i3,i4,i5,i6,l1,l2,l3,a,b,c;
	static double avg=0,t=0,g;
	private static DecimalFormat df = new DecimalFormat("0.00");
	 private static TableView<Sgc> ts = new TableView();
	 private static TableView<Sub> tss = new TableView();
	 static void dis()
	 {
		 
		 Stage showt = new Stage();
			
			showt.setTitle("Student Grade");
			
			TextField stuid1 = new TextField();
	        Label stuidlab=new Label("Student ID");

			final Label label = new Label("Student Information");
	        label.setFont(new Font("Arial", 20));
	 
	        ts.setEditable(true);
	 
	        TableColumn<Sgc , String> stuid = new TableColumn<Sgc, String>("Student ID");
	        stuid.setCellValueFactory(new PropertyValueFactory<>("stuid"));
	        TableColumn<Sgc , String> teaid = new TableColumn<Sgc, String>("Teacher ID");
	        teaid.setCellValueFactory(new PropertyValueFactory<>("teaid"));
	        TableColumn<Sgc , String> subid = new TableColumn<Sgc, String>("Subject ID");
	        subid.setCellValueFactory(new PropertyValueFactory<>("subid"));
	        
	        TableColumn<Sgc , String> grade = new TableColumn<Sgc, String>("Grade");
	        grade.setCellValueFactory(new PropertyValueFactory<>("grade"));
	        
	        TableColumn<Sgc , String> cla = new TableColumn<Sgc, String>("Class");
	        cla.setCellValueFactory(new PropertyValueFactory<>("cla"));
	        
	        ts.getColumns().addAll(stuid,teaid,subid,grade,cla);
	        
	        
	        Label label1 = new Label("Select Desired Course:");
	        Font font = Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 12);
	        label1.setFont(font);
	        ComboBox<String> combo = new ComboBox<String>();
	        combo.setPromptText("Select Course");
	        ObservableList<String> list = combo.getItems();
	        list.add("All");
	        ComboBox<String> combo2 = new ComboBox<String>();
	        combo2.setPromptText("Class");
	        
	        
	        
	        tss.setEditable(true);
	   	 
	        TableColumn<Sub , String> id = new TableColumn<Sub, String>("ID");
	        id.setCellValueFactory(new PropertyValueFactory<>("id"));
	        
	        TableColumn<Sub , String> name = new TableColumn<Sub, String>("Name");
	        name.setCellValueFactory(new PropertyValueFactory<>("name"));
	       
	        tss.getColumns().addAll(id, name);
	        tss.getItems().clear();
		 
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
	    tss.getItems().add(new Sub(i1,i2));
	   }
	  }
	  catch(Exception e){}
	  tss.setPrefSize(10, 200);
	  StackPane pa = new StackPane();
	  pa.getChildren().add(tss) ;
	        
	        
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
	         
	          	list.add(l1);
	          
	         }
	        }
	        catch(Exception e){}
	        Text text2 = new Text(); 
		    text2.setFont(Font.font("arial-narrow", FontWeight.BOLD, FontPosture.REGULAR, 20)); 
	       
	        Button b1=new Button("Show");
	        b1.setOnAction(e->{
	        	 ts.getItems().clear();
	        	b=stuid1.getText();
	        	a=combo.getValue();
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
	       	    if((i3.equals(a)||a.equals("All"))&&(i5.equals(c)||c.equals("All"))) {
	       	    	//adding to table
	       		ts.getItems().add(new Sgc(i1,i2,i3,i4,i5));
	       		//converting string into double
	       		g = Double.parseDouble(i4);
	       		//summing grades
		  		avg=avg+g;
		  		//counting
		  		  t++;}
	       	    
	       	    }
	       	  //printing average with 2 floating point precision
	       	text2.setText("Average is:"+df.format(avg/t)); 
	       	  }
	       	
	       	  catch(Exception e2){}
	        });
	 
	  
	  ts.setPrefSize(400, 300);
	  final VBox svb = new VBox();
      svb.setSpacing(5);
      svb.setPadding(new Insets(10, 0, 0, 10));
	  StackPane pane = new StackPane();
	  pane.getChildren().add(ts) ;
	  
      svb.getChildren().addAll(label,pa,stuidlab,stuid1,combo,combo2,b1, pane,text2);
     ScrollPane s1 = new ScrollPane(svb);
     Scene sss = new Scene(s1 , 450 , 500);
      showt.setScene(sss);
      showt.show();
	  
	 }
}
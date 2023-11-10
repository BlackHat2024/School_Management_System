import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.ScrollBar;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import java.io.*;
import java.lang.*;
import java.text.Format.Field;
import java.util.*;

public class addgrade extends teacherpart{
	static String a;
	static String i1,i2,i3,i4,i5,i6,l1,l2,l3;	
	
	 //declaration of table view
	 private static TableView<Student> ts = new TableView();

	static void in(String sid,Object tid,String ssid,String gr,String cl) throws FileNotFoundException, IOException
    {
		String a;
		a=sid;
		//writing into file function
		 try
		  {
		   File f=new File("students/"+a+".txt");
		   PrintWriter pw=new PrintWriter(new FileOutputStream(f,true));
		   pw.append(sid+","+tid+","+ssid+","+gr+","+cl+"\n");
		   pw.close();
		  }
		  catch(Exception e){}
    
 
}
	
	//function to perform the add grade at teacher part
	public static void addg(String checkUser)  {

		Stage addg = new Stage();
		addg.setTitle("Teacher Part");
		
		
		addg.setTitle("Add Grade");
		
		final Label label = new Label("Student Information");
        label.setFont(new Font("Arial", 20));
 
        ts.setEditable(true);
        //constructing the table    
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
        //clear the tabele
        ts.getItems().clear();
  //reading information from student database      
  try
  {
  BufferedReader br=new BufferedReader(new FileReader("database/StudentDatabase.txt"));
  String s="";
  
  //while loop to read all lines of the text file 
  while( (s=br.readLine()) !=null )
   {
    String data[]=new String[5];
    data=s.split(",");
    //for loop for reading each data in line 
    for(int i=0;i<5;i++)
    {
    	//if are used to store data from file in variables
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
    //putting informations taken in the table
	ts.getItems().add(new Student(i1,i2,i3,i4,i5));
  
   }
  }

  catch(Exception e){}
		
//table size
  ts.setPrefSize(269, 300);
  
  Label label1 = new Label("Select Desired Course:");
  Font font = Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 12);
  label1.setFont(font);
  //Creating a combo box
  ComboBox<String> combo = new ComboBox<String>();
  //Setting the prompt text of the combo box
  combo.setPromptText("Select Course");
  //Getting the observable list of the combo box
  ObservableList<String> list = combo.getItems();
  //Adding items to the combo box
  
  
  Text text = new Text(); 
  text.setFont(Font.font("arial-narrow", FontWeight.BOLD, FontPosture.REGULAR, 12)); 
  text.setText("Your subjects id:"); 
  //reading information from subject database    
  try
  {
  BufferedReader br=new BufferedReader(new FileReader("database/SubjectDatabase.txt"));
  String s="";
  //loop to read lines and data. storing them in variables and passing them in combo box
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
  catch(Exception e2){}
  
  //converting object to string
        String q=checkUser.toString();
        //crating text fields
        TextField tid = new TextField();
        Label tidlab=new Label("Teacher ID");
		TextField sid = new TextField();
		Label sidlab=new Label("Student ID");
		TextField ssid = new TextField();
		Label ssidlab=new Label("Subject ID");
        final TextField gr = new TextField();
        Label grlab=new Label("Grade");
        //combo box
        ComboBox<String> combo2 = new ComboBox<String>();
        combo2.setPromptText("Class");
        ObservableList<String> list2 = combo2.getItems();
        list2.add("1");
        list2.add("2");
        list2.add("3");
        list2.add("4");
        list2.add("5");
        Label cllab=new Label("Class");
		Button save=new Button("Save");
		//giving instructions to the button
		save.setOnAction(e->{
			try {
				//checking for empty fields
				if(sid.getText().isEmpty()||combo.getValue().isEmpty()||gr.getText().isEmpty()||combo2.getValue().isEmpty()) {
					ab1.display("Warning","You have unfilled box!");
				}
				else {
					//getting text from fields and storing it in text file
				in(sid.getText(),q,combo.getValue(),gr.getText(),combo2.getValue());
				addg.close();}
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		addg.close();});
		 StackPane pane = new StackPane();
		  pane.getChildren().add(ts) ;
		VBox st = new VBox();
		st.setAlignment(Pos.CENTER);
		st.setSpacing(24);

        st.setSpacing(8);
        st.setPadding(new Insets(10,10,10,10));
        //adding labels in vbox to be shown
        st.getChildren().addAll(label,pane,text,sidlab,sid,ssidlab,combo,grlab,gr,cllab,combo2,save);
        //creating a sroll bar
        ScrollPane s1 = new ScrollPane(st);
       
        s1.setPrefSize(320, 600);
        s1.setContent(st);
        Scene ss1 = new Scene(s1);
     
		

		addg.setScene(ss1);
		addg.show();


	}	


}

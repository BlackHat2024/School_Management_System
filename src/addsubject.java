import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import java.io.*;
import java.lang.*;
import java.util.*;

public class addsubject extends admin1{
	static String a1;
	static void in(String id,String name,String tid) throws FileNotFoundException, IOException
    {
		//writing into file function
		 try
		  {
		   File f=new File("database/SubjectDatabase.txt");
		   PrintWriter pw=new PrintWriter(new FileOutputStream(f,true));
		   pw.append(id+","+name+","+tid+","+"\n");
		   pw.close();
		  }
		  catch(Exception e){}
    
 
}
	
	
	public static void addsub()  {

		Stage adds = new Stage();
		adds.setTitle("Subject registration");
		//tab text information create
		Text text = new Text(); 
	    text.setFont(Font.font("arial-narrow", FontWeight.BOLD, FontPosture.REGULAR, 20)); 
	    text.setText("Subject Registration"); 
	    Text text1 = new Text(); 
	    text1.setFont(Font.font("arial-narrow", FontWeight.BOLD, FontPosture.REGULAR, 20));          
	    text1.setText("Information"); 
	    Text text2 = new Text(); 
	    text2.setFont(Font.font("arial-narrow",FontPosture.REGULAR, 12));
	  //reading from student database and storing the last subject id for later usage
	    try
		  {
		  BufferedReader br=new BufferedReader(new FileReader("database/SubjectDatabase.txt"));
		  String s="";
		   while( (s=br.readLine()) !=null )
		   {
		    String data[]=new String[2];
		    data=s.split(",");
		    for(int i=0;i<1;i++)
		    {
		     a1=data[i];
		    }
		    
		   }
		  }
		  catch(Exception e){}
	    text2.setText("Previous Subject Id : "+a1);
	    //creating text fields to get info
		Label idlab=new Label("Subject ID");
		final TextField id = new TextField();
		Label namelab=new Label("Subject Name");
        final TextField name = new TextField();
        Label tidlab=new Label("Teacher id");
        final TextField tid = new TextField();
		Button save=new Button("Save");
		//setting instruction to button
		save.setOnAction(e->{
			try {
				//checking for empty fields
				if(id.getText().isEmpty()||name.getText().isEmpty()||tid.getText().isEmpty()) {
					ab1.display("Warning","You have unfilled box!");
				}
				else {
					//getting text from fields and storing it in text file
				in(id.getText(),name.getText(),tid.getText());
				adds.close();}
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		});
		
		VBox st = new VBox();
		st.setAlignment(Pos.CENTER);
		st.setSpacing(24);

        st.setSpacing(8);
        st.setPadding(new Insets(10,10,10,10));
        st.getChildren().addAll(text,text1,text2,idlab,id,namelab,name,tidlab,tid,save);
        Scene ss1 = new Scene(st,300,400);
     
		

		adds.setScene(ss1);
		adds.show();


	}	


}

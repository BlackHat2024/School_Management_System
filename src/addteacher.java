import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
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

public class addteacher extends admin1{

	static String a1;
	static void tin(String id,String name,String surname,String age,String wage,String pass) throws FileNotFoundException, IOException
    {
		//writing into file function
		 try
		  {
		   File f=new File("database/TeacherDatabase.txt");
		   PrintWriter pw=new PrintWriter(new FileOutputStream(f,true));
		   pw.append(id+","+name+","+surname+","+age+","+wage+","+pass+"\n");
		   pw.close();
		  }
		  catch(Exception e){}
 
}
	
	public static void addt()  {

		Stage addt = new Stage();
		addt.setTitle("Teacher registration");
		//tab text information create
		Text text = new Text(); 
	    text.setFont(Font.font("arial-narrow", FontWeight.BOLD, FontPosture.REGULAR, 20)); 
	    text.setX(50); 
	    text.setY(130);          
	    text.setText("Teacher Registration"); 
	    Text text1 = new Text(); 
	    text1.setFont(Font.font("arial-narrow", FontWeight.BOLD, FontPosture.REGULAR, 20)); 
	    text1.setX(50); 
	    text1.setY(130);          
	    text1.setText("Information"); 
	    Text text2 = new Text(); 
	    text2.setFont(Font.font("arial-narrow",FontPosture.REGULAR, 12));
	    //reading from student database and storing the last student id for later usage
	    try
		  {
		  BufferedReader br=new BufferedReader(new FileReader("database/TeacherDatabase.txt"));
		  String s="";
		   while( (s=br.readLine()) !=null )
		   {
		    String data[]=new String[5];
		    data=s.split(",");
		    for(int i=0;i<1;i++)
		    {
		     a1=data[i];
		    }
		    
		   }
		  }
		  catch(Exception e){}
	    text2.setText("Previous Teacher Id : "+a1);

	  //creating text fields to get info
		Label tidlab=new Label("Teacher ID");
		final TextField tid = new TextField();
		Label tnamelab=new Label("Teacher Name");
        final TextField tname = new TextField();
        Label tsurlab=new Label("Teacher Surname");
        final TextField tsurname = new TextField();
        Label tagelab=new Label("Age");
        final TextField tage = new TextField();
        Label twagelab=new Label("Wage");
        final TextField twage = new TextField();
        Label tpasslab=new Label("Password");
        final PasswordField tpass = new PasswordField();
		Button save=new Button("Save");
		save.setOnAction(e->{
			try {
				//checking for empty fields
				if(tid.getText().isEmpty()||tname.getText().isEmpty()||tsurname.getText().isEmpty()||tage.getText().isEmpty()||twage.getText().isEmpty()||tpass.getText().isEmpty()) {
					ab1.display("Warning","You have unfilled box!");
				}
				else {
					//getting text from fields and storing it in text file
				tin(tid.getText(),tname.getText(),tsurname.getText(),tage.getText(),twage.getText(),tpass.getText());
				addt.close();}
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
        st.getChildren().addAll(text,text1,text2,tidlab,tid,tnamelab,tname,tsurlab,tsurname,tagelab,tage,twagelab,twage,tpasslab,tpass,save);
        Scene ss1 = new Scene(st,300,480);
		
		

		addt.setScene(ss1);
		addt.show();


	}	

}

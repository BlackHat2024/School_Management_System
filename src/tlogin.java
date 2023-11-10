import java.io.BufferedReader;
import java.io.FileReader;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.effect.DropShadow;
import javafx.scene.effect.Reflection;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class tlogin extends Home {
	
	static String user ;
	static String pw;
	static String checkUser;
	static String checkPw;
	//compare function for strings
	public static int stringCompare(String str1, String str2) 
    { 
  
        int l1 = str1.length(); 
        int l2 = str2.length(); 
        int lmin = Math.min(l1, l2); 
  
        for (int i = 0; i < lmin; i++) { 
            int str1_ch = (int)str1.charAt(i); 
            int str2_ch = (int)str2.charAt(i); 
  
            if (str1_ch != str2_ch) { 
                return str1_ch - str2_ch; 
            } 
        } 
        if (l1 != l2) { 
            return l1 - l2; 
        } 
        else { 
            return 0; 
        } 
    } 
	
	public static void ttlogin() {
		Stage adm = new Stage();
		 adm.setTitle("Teacher Login");
	        
	        BorderPane bp = new BorderPane();
	        bp.setPadding(new Insets(10,50,50,50));
	        
	        //Adding HBox
	        HBox hb = new HBox();
	        hb.setPadding(new Insets(20,20,20,30));
	        
	        //Adding GridPane
	        GridPane gridPane = new GridPane();
	        gridPane.setPadding(new Insets(20,20,20,20));
	        gridPane.setHgap(5);
	        gridPane.setVgap(5);
	        
	       //Implementing Nodes for GridPane
	        Label lblUserName = new Label("Username");
	        final TextField txtUserName = new TextField();
	        Label lblPassword = new Label("Password");
	        final PasswordField pf = new PasswordField();
	        CheckBox cb1 = new CheckBox("Agree");
	      
	        Button btnLogin = new Button("Login");
	        final Label lblMessage = new Label();
	        
	        //Adding Nodes to GridPane layout
	        gridPane.add(lblUserName, 0, 0);
	        gridPane.add(txtUserName, 1, 0);
	        gridPane.add(lblPassword, 0, 1);
	        gridPane.add(pf, 1, 1);
	        gridPane.add(cb1, 2, 0);
	        gridPane.add(btnLogin, 2, 1);
	        gridPane.add(lblMessage, 1, 2);
	        
	        //Reflection for gridPane
	        Reflection r = new Reflection();
	        r.setFraction(0.7f);
	        gridPane.setEffect(r);
	        
	        //DropShadow effect 
	        DropShadow dropShadow = new DropShadow();
	        dropShadow.setOffsetX(5);
	        dropShadow.setOffsetY(5);
	        
	        //Adding text and DropShadow effect to it
	        Text text = new Text("Teacher Login");
	        text.setFont(Font.font ("Verdana", 40));
	        text.setEffect(dropShadow);
	        
	        //Adding text to HBox
	        hb.getChildren().add(text);
	                          
	        //Add ID's to Nodes
	        bp.setId("bp");
	        gridPane.setId("root");
	        btnLogin.setId("btnLogin");
	        text.setId("text");
	      
	  	  //giving instruction to check box
	  	  cb1.setOnAction(e->{if(cb1.isSelected()) { checkUser = txtUserName.getText().toString();
	 		checkPw = pf.getText().toString();
	 		//checking for inputs in database and compare info
	 		  try
		  	  {
	 			 int temp=0;
		  	  BufferedReader br=new BufferedReader(new FileReader("database/TeacherDatabase.txt"));
		  	  String s="";
		  	 while( (s=br.readLine()) !=null && temp!=2)
		  	   {
		  	    String data[]=new String[5];
		  	    data=s.split(",");
		  	    for(int i=0;i<6;i++)
		  	    {
		  	    	if(i==0) {
		  	    		user=data[i];
		  	    		if(stringCompare(user, checkUser)==0) 
		  	    			temp++;
		  	    		}
		  	    	if(i==5) {
		  	    		pw=data[i];
		  	    		if(stringCompare(pw, checkPw)==0) 
		  	    			temp++;
		  	    		}
		  	    	
		  	     //System.out.print(data[i]+" ");
		  	    }
		  	    System.out.println();
		  	   
		  	   }
		  	 btnLogin.setOnAction(e1->{
	     		
	     		if(checkUser.equals(user) && checkPw.equals(pw)){
	     			lblMessage.setText("Congratulations!");
	     			lblMessage.setTextFill(Color.GREEN);
	     			adm.close();
	     			teacherpart.tp(checkUser);

	     		}
	     		else{
	     			cb1.setSelected(false);
	     			lblMessage.setText("Incorrect username or pass!");
	     			lblMessage.setTextFill(Color.RED);
	     		}
	     		txtUserName.setText("");
	     		pf.setText("");
	     	});
		  	  }
		  	  catch(Exception e1){}
	 		
	  	  }
	  		
	  	  });
	  	if(cb1.isSelected()==false) {
	  		btnLogin.setOnAction(e2->ab1.display("Warnig","You haven't check the agreement!" ));
	  	}
	  	  
	        //Action for btnLogin
	    
	       
	        //Add HBox and GridPane layout to BorderPane Layout
	        bp.setTop(hb);
	        bp.setCenter(gridPane);  
	    	Scene scene = new Scene(bp);
	    	adm.setScene(scene);
	    	adm.setResizable(false);
	    	adm.show();
	}

}

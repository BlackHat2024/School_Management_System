//Defining class.  
public class Sgc extends stgsh{

 
	 //defining fields  
       private String Stuid,Teaid,Subid ,Grade,Cla;    // The Persons Nam4
     
        
public Sgc()

        {

        }

         

       public Sgc (String stuid,String teaid,String subid, String grade,String cla)

       {

    	   Stuid=stuid;
    	   Teaid=teaid;
          Subid = subid;

          Grade = grade;

          Cla = cla;
                  

       }
    // Setter
       public void setStuid(String stuid)

       {

          Stuid = stuid; 

       }
       public void setTeaid(String teaid)

       {

          Teaid = teaid; 

       }
       
       public void setSubid(String subid)

       {

          Subid = subid; 

       }

      public void setGrade(String grade)

       {

          Grade = grade; 

       }

      public void setCla(String cla)

      {

         Cla = cla; 

      }
   // Getter
      public String getStuid()

      {

         return Stuid; 

      }
      public String getTeaid()

      {

         return Teaid; 

      }
      public String getSubid()

      {

         return Subid; 

      }

     public String getGrade()

      {

         return Grade ; 

      }

     public String getCla()

     {

        return Cla; 

     }
  

}

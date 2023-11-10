public class Tgc extends tegsh{

 

       private String Subid ,Grade,Cla;    // The Persons Nam4
     
        
public Tgc()

        {

        }

         

       public Tgc (String subid, String grade,String cla)

       {

          Subid = subid;

          Grade = grade;

          Cla = cla;
                  

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

public class Subject extends showsubject{

 

       private String Id ,Name,Tid;
     
        
public Subject()

        {

        }

         

       public Subject (String id, String name, String tid)

       {

          Id = id;

          Name = name;

          Tid = tid;
      

       }
       
       public void setId(String id)

       {

          Id = id; 

       }

      public void setName(String name)

       {

          Name = name; 

       }

      public void setTid(String tid)

      {

         Tid = tid; 

      }

      public String getId()

      {

         return Id; 

      }

     public String getName()

      {

         return Name ; 

      }

     public String getTid()

     {

        return Tid; 

     }
  

}

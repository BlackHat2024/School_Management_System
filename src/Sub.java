public class Sub extends stgsh{

 

       private String Id ,Name;
     
        
public Sub()

        {

        }

         

       public Sub (String id, String name)

       {

          Id = id;

          Name = name;

      

       }
       
       public void setId(String id)

       {

          Id = id; 

       }

      public void setName(String name)

       {

          Name = name; 

       }

      public String getId()

      {

         return Id; 

      }

     public String getName()

      {

         return Name ; 

      }

}

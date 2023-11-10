public class Student extends showstudent{

 

       private String Id ,Name,Surname,Year,Age;    // The Persons Nam4
     
        
public Student()

        {

        }

         

       public Student (String id, String name, String surname,String year,String age)

       {

          Id = id;

          Name = name;

          Surname = surname;
          Year=year;
          Age=age;
         

       }
       
       public void setId(String id)

       {

          Id = id; 

       }

      public void setName(String name)

       {

          Name = name; 

       }

      public void setSurname(String surname)

      {

         Surname = surname; 

      }
      public void setYear(String year)

      {

         Year = year; 

      }

      public void setAge(String age)

      {

         Age = age; 

      }

      public String getId()

      {

         return Id; 

      }

     public String getName()

      {

         return Name ; 

      }

     public String getSurname()

     {

        return Surname; 

     }

     public String getYear()

     {

        return Year; 

     }
     public String getAge()

     {

        return Age; 

     }
  
  

  

}

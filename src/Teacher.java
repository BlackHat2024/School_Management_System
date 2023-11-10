public class Teacher extends showteacher{

 

       private String Id ,Name,Surname,Age,Wage,Pass;    // The Persons Nam4
     
        
public Teacher()

        {

        }

         
	public Teacher (String id, String name, String surname,String age,String wage)

	{

		Id = id;

		Name = name;

		Surname = surname;
		Age=age;
		Wage=wage;

}

       public Teacher (String id, String name, String surname,String age,String wage,String pass)

       {

          Id = id;

          Name = name;

          Surname = surname;
          Age=age;
          Wage=wage;
          Pass=pass;

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

      public void setAge(String age)

      {

         Age = age; 

      }
      public void setWage(String wage)

      {

         Wage = wage; 

      }
      public void setPass(String pass)

      {

         Pass = pass; 

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

     public String getAge()

     {

        return Age; 

     }
     public String getWage()

     {

        return Wage; 

     }
     public String getPass()

     {

        return Pass;

     }

  

}

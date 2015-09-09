package functional;

import java.util.ArrayList;
import java.util.List;

public class Person {
  private String givenName;
  private String surName;
  private int age;
  private Gender gender;
  private String eMail;
  private String phone;
  private String address;

 public Person(String givenName,String surName,int age, Gender gender, String eMail,String phone,String address){
     this.givenName=givenName;
     this.surName=surName;
     this.age=age;
     this.gender=gender;
     this.eMail=eMail;
     this.phone=phone;
     this.address=address;
 }


  public String getSurName(){
    return surName;
  }
  
  public void printName(){    
    System.out.println(
      "Name: " + givenName + " " + surName);
  }

  public static List<Person> createShortList(){
    List<Person> people = new ArrayList<>();
    
    people.add(
      new Person("Bob","Baker",2,Gender.MALE,"bob.baker@example.com","201-121-4678","44 4th St, Smallville, KS 12333"));
    
    people.add(
      new Person("Jane","Doe",25,Gender.FEMALE,"jane.doe@example.com","202-123-4678","33 3rd St, Smallville, KS 12333"));
    
    people.add(
      new Person("John","Doe",25,Gender.MALE,"john.doe@example.com","202-123-4678","33 3rd St, Smallville, KS 12333"));
    
    people.add(
      new Person("James","Johnson",45,Gender.MALE,"james.johnson@example.com","333-456-1233","201 2nd St, New York, NY 12111"));
    
    people.add(
      new Person("Joe","Bailey",67,Gender.MALE,"joebob.bailey@example.com","112-111-1111","111 1st St, Town, CA 11111"));

    people.add(
      new Person("Phil","Smith",55,Gender.MALE,"phil.smith@example.com","222-33-1234","22 2nd St, New Park, CO 222333"));

    return people;
  }

}

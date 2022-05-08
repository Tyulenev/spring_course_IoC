package org.example.spring_introduction.testMain;

import org.example.spring_introduction.Person;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test2 {
    public static void main(String[] args) {
//        Pet pet1 = new Dog();
        ClassPathXmlApplicationContext context =
                new ClassPathXmlApplicationContext("applicationContext.xml");
//        Pet pet1 = context.getBean("myPet1", Pet.class);
        Person pers1 =context.getBean("myPerson1", Person.class);
        pers1.callYourPet();
        System.out.println("Surname - " + pers1.getSurname() + ", age = " + pers1.getAge());

        context.close();
    }
}

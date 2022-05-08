package org.example.spring_introduction.testMain;

import org.example.spring_introduction.MyConfig;
import org.example.spring_introduction.Person;
import org.example.spring_introduction.Pet;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Test6 {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(MyConfig.class);

        Pet cat = context.getBean("catBean", Pet.class);
        Person person = context.getBean("personBean", Person.class);
        person.callYourPet();
        System.out.println("surname: " + person.getSurname() + ", age: " + person.getAge());

        context.close();

    }
}

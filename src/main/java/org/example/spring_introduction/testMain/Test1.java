package org.example.spring_introduction.testMain;

import org.example.spring_introduction.Pet;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.awt.*;

public class Test1 {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context =
                new ClassPathXmlApplicationContext("applicationContext.xml");

        Pet pet1 = context.getBean("myPet1", Pet.class);
        pet1.say();


        context.close();

    }
}

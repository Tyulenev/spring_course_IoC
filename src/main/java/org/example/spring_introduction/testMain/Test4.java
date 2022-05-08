package org.example.spring_introduction.testMain;

import org.example.spring_introduction.Dog;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test4 {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context =
                new ClassPathXmlApplicationContext("applicationContext2.xml");
        Dog myDog = context.getBean("myPet1", Dog.class);

        //Dog yourDog = context.getBean("myPet1", Dog.class);
        Dog yourDog = context.getBean("myPet1", Dog.class);



        context.close();
    }
}

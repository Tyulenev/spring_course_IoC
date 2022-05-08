package org.example.spring_introduction;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

//@Component
@Scope("singleton")
public class Dog implements Pet{
    public Dog() {
        System.out.println("Dog bean is created");
    }





    @Override
    public void say() {
        System.out.println("Bow-Bow");
    }

//
//    public void init() {
//        System.out.println("DOG: init Meth");
//    }
//
//    public void destroy() {
//        System.out.println("DOG: destroy meth");
//    }
}

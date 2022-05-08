package org.example.spring_introduction;

import org.springframework.context.annotation.*;
import org.springframework.stereotype.Component;

@Configuration
@PropertySource("classpath:myApp.properties")
//@ComponentScan("org.example.spring_introduction")
public class MyConfig {

    @Bean
    @Scope("singleton")
    public Pet catBean() {   //catBean - BeanID
        return new Cat();
    }

    @Bean
    public Person personBean() {
        return new Person(catBean());
    }
}

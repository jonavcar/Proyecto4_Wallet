package com.banck.wallet.spring.config;

import com.banck.wallet.infraestructure.repository.MovementCrudRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import com.banck.wallet.aplication.model.MovementRepository;
import com.banck.wallet.infraestructure.repository.PersonCrudRepository;
import com.banck.wallet.aplication.model.PersonRepository;

/**
 *
 * @author jonavcar
 */
@Configuration
public class SpringConfiguration {
    
    @Bean
    public MovementRepository movementRepository() {
        return new MovementCrudRepository();
    }
    
    @Bean
    public PersonRepository personRepository() {
        return new PersonCrudRepository();
    }
}

package com.banck.wallet.spring.config;

import com.banck.wallet.infraestructure.repository.MovementCrudRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import com.banck.wallet.aplication.model.MovementRepository;
import com.banck.wallet.infraestructure.repository.WalletCrudRepository;
import com.banck.wallet.aplication.model.WalletRepository;

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
    public WalletRepository personRepository() {
        return new WalletCrudRepository();
    }
}

package com.banck.wallet.spring.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import com.banck.wallet.infraestructure.repository.WalletCrudRepository;
import com.banck.wallet.aplication.model.WalletRepository;

/**
 *
 * @author jonavcar
 */
@Configuration
public class SpringConfiguration {

    @Bean
    public WalletRepository walletRepository() {
        return new WalletCrudRepository();
    }
}

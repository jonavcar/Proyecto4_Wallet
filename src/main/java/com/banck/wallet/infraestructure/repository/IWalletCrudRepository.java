package com.banck.wallet.infraestructure.repository;

import com.banck.wallet.infraestructure.model.dao.WalletDao;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import reactor.core.publisher.Flux;

/**
 *
 * @author jonavcar
 */
public interface IWalletCrudRepository extends ReactiveCrudRepository<WalletDao, String> {

    Flux<WalletDao> findAllByDocument(String document);
}

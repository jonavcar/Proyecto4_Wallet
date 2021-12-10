package com.banck.wallet.infraestructure.repository;

import com.banck.wallet.infraestructure.model.dao.WalletDebitCardDao;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import reactor.core.publisher.Flux;

/**
 *
 * @author jonavcar
 */
public interface IWalletDebitCardCrudRepository extends ReactiveCrudRepository<WalletDebitCardDao, String> {

    Flux<WalletDebitCardDao> findAllByDebitCard(String debitCard);
}

package com.banck.wallet.infraestructure.repository;

import com.banck.wallet.infraestructure.model.dao.PersonDao;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import reactor.core.publisher.Flux;

/**
 *
 * @author jonavcar
 */
public interface IPersonCrudRepository extends ReactiveCrudRepository<PersonDao, String> {

    Flux<PersonDao> findAllByDocument(String document);
}

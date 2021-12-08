package com.banck.wallet.aplication;

import com.banck.wallet.domain.Movement;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 *
 * @author jonavcar
 */
public interface MovementOperations {

    public Flux<Movement> list();

    public Flux<Movement> listByCustomer(String customer);

    public Flux<Movement> listByProduct(String product);

    public Flux<Movement> listByCustomerAndProduct(String customer, String product);

    public Mono<Movement> get(String movement);

    public Mono<Movement> create(Movement movement);

    public Mono<Movement> update(String id, Movement movement);

    public Mono<Double> mainAccountBalance(String debitCard);

    public void delete(String id);
}
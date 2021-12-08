package com.banck.wallet.aplication.model;

import com.banck.wallet.domain.Person;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 *
 * @author jonavcar
 */
public interface PersonRepository {

    public Flux<Person> list();

    public Flux<Person> listByDocument(String document);

    public Mono<Person> get(String id);

    public Mono<Person> create(Person d);

    public Mono<Person> update(String id, Person d);

    public void delete(String id);
}

package com.banck.wallet.aplication;

import com.banck.wallet.domain.Person;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 *
 * @author jonavcar
 */
public interface PersonOperations {

    public Flux<Person> list();

    public Flux<Person> listByDocument(String document);

    public Mono<Person> get(String person);

    public Mono<Person> create(Person person);

    public Mono<Person> update(String id, Person person);

    public void delete(String id);

}

package com.banck.wallet.aplication.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import com.banck.wallet.domain.Person;
import com.banck.wallet.aplication.PersonOperations;
import com.banck.wallet.aplication.model.PersonRepository;

/**
 *
 * @author jonavcar
 */
@Service
@RequiredArgsConstructor
public class PersonOperationsImpl implements PersonOperations {

    private final PersonRepository personRepository;

    @Override
    public Flux<Person> list() {
        return personRepository.list();
    }

    @Override
    public Mono<Person> get(String debitcardaccount) {
        return personRepository.get(debitcardaccount);
    }

    @Override
    public Mono<Person> create(Person debitcardaccount) {
        return personRepository.create(debitcardaccount);
    }

    @Override
    public Mono<Person> update(String debitcardaccount, Person c) {
        return personRepository.update(debitcardaccount, c);
    }

    @Override
    public void delete(String debitcardaccount) {
        personRepository.delete(debitcardaccount);
    }

    @Override
    public Flux<Person> listByDocument(String document) {
        return personRepository.listByDocument(document);
    }

}

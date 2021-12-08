package com.banck.wallet.infraestructure.repository;

import com.banck.wallet.domain.Person;
import com.banck.wallet.infraestructure.model.dao.PersonDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import com.banck.wallet.aplication.model.PersonRepository;

/**
 *
 * @author jonavcar
 */
@Component
public class PersonCrudRepository implements PersonRepository {

    @Autowired
    IPersonCrudRepository crudRepository;

    @Override
    public Mono<Person> get(String debitcardaccount) {
        return crudRepository.findById(debitcardaccount).map(this::PersonDaoToPerson);
    }

    @Override
    public Flux<Person> list() {
        return crudRepository.findAll().map(this::PersonDaoToPerson);
    }

    @Override
    public Mono<Person> create(Person debitcardaccount) {
        return crudRepository.save(PersonToPersonDao(debitcardaccount)).map(this::PersonDaoToPerson);
    }

    @Override
    public Mono<Person> update(String debitcardaccount, Person c) {
        return crudRepository.save(PersonToPersonDao(c)).map(this::PersonDaoToPerson);
    }

    @Override
    public void delete(String debitcardaccount) {
        crudRepository.deleteById(debitcardaccount).subscribe();
    }

    public Person PersonDaoToPerson(PersonDao md) {
        Person m = new Person();
        m.setPerson(md.getPerson());
        m.setDocument(md.getDocument());
        m.setDocumentType(md.getDocumentType());
        m.setTelephone(md.getTelephone());
        m.setImei(md.getImei());
        m.setMail(md.getMail());
        m.setDate(md.getDate());
        m.setState(md.isState());
        return m;
    }

    public PersonDao PersonToPersonDao(Person p) {
        PersonDao pd = new PersonDao();
        pd.setPerson(p.getPerson());
        pd.setDocument(p.getDocument());
        pd.setDocumentType(p.getDocumentType());
        pd.setTelephone(p.getTelephone());
        pd.setImei(p.getImei());
        pd.setMail(p.getMail());
        pd.setDate(p.getDate());
        pd.setState(p.isState());
        return pd;
    }

    @Override
    public Flux<Person> listByDocument(String document) {
        return crudRepository.findAllByDocument(document).map(this::PersonDaoToPerson);
    }

}

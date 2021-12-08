package com.banck.wallet.infraestructure.rest;

import com.banck.wallet.domain.Person;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Random;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import com.banck.wallet.aplication.PersonOperations;
import org.springframework.http.HttpStatus;

/**
 *
 * @author jonavcar
 */
@RestController
@RequestMapping("/wallet/person")
@RequiredArgsConstructor
public class PersonController {

    Logger logger = LoggerFactory.getLogger(PersonController.class);
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
    DateTimeFormatter formatTime = DateTimeFormatter.ofPattern("HH:mm:ss");
    DateTimeFormatter formatDate = DateTimeFormatter.ofPattern("dd-MM-yyyy");
    LocalDateTime dateTime = LocalDateTime.now(ZoneId.of("America/Bogota"));
    private final PersonOperations operations;

    @GetMapping
    public Flux<Person> listAll() {
        return operations.list();
    }

    @GetMapping("/{id}")
    public Mono<Person> get(@PathVariable("id") String id) {
        return operations.get(id);
    }

    @PostMapping
    public Mono<ResponseEntity> create(@RequestBody Person person) {
        person.setPerson("WL-" + getRandomNumberString());
        person.setDate(dateTime.format(formatDate));
        person.setState(true);
        return operations.create(person).flatMap(pR -> {
            return Mono.just(new ResponseEntity(pR, HttpStatus.OK));
        });
    }

    @PutMapping("/{id}")
    public Mono<Person> update(@PathVariable("id") String id, @RequestBody Person movement) {
        return operations.update(id, movement);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") String id) {
        operations.delete(id);
    }

    public static String getRandomNumberString() {
        Random rnd = new Random();
        int number = rnd.nextInt(999999);
        return String.format("%06d", number);
    }
}

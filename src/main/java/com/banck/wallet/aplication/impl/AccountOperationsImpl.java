/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.banck.wallet.aplication.impl;

import com.banck.wallet.aplication.AccountOperations;
import com.banck.wallet.domain.Account;
import io.netty.channel.ChannelOption;
import io.netty.handler.timeout.ReadTimeoutHandler;
import io.netty.handler.timeout.WriteTimeoutHandler;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.client.reactive.ReactorClientHttpConnector;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;
import reactor.netty.http.client.HttpClient;
import reactor.netty.tcp.TcpClient;

/**
 *
 * @author jonavcar
 */
@Service
@RequiredArgsConstructor
public class AccountOperationsImpl implements AccountOperations {
 
    Logger logger = LoggerFactory.getLogger(AccountOperationsImpl.class);

    @Override
    public Mono<Account> getAccount(String customer) { 
        TcpClient tcpClient = TcpClient.create()
                .option(ChannelOption.CONNECT_TIMEOUT_MILLIS, 3000)
                .doOnConnected(connection
                        -> connection.addHandlerLast(new ReadTimeoutHandler(3))
                        .addHandlerLast(new WriteTimeoutHandler(3)));

        WebClient webClient = WebClient.builder()
                .baseUrl("http://banck-account.southcentralus.azurecontainer.io:8081")
                .defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                .defaultHeader(HttpHeaders.ACCEPT, MediaType.APPLICATION_JSON_VALUE)
                //.clientConnector(new ReactorClientHttpConnector(HttpClient.from(tcpClient))) // timeout
                .build();

        return webClient.get()
                .uri("/banck-account/" + customer)
                .retrieve()
                .bodyToMono(Account.class).flatMap(o -> {
            return Mono.just(o);
        });
    }

}

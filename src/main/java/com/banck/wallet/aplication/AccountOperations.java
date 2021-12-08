/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.banck.wallet.aplication;

import com.banck.wallet.domain.Account;
import reactor.core.publisher.Mono;

/**
 *
 * @author jonavcar
 */
public interface AccountOperations {

    public Mono<Account> getAccount(String account);
}

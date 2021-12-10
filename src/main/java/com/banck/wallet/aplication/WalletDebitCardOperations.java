/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.banck.wallet.aplication;

import com.banck.wallet.domain.WalletDebitCard;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 *
 * @author jnacarra
 */
public interface WalletDebitCardOperations {

    public Flux<WalletDebitCard> list();

    public Flux<WalletDebitCard> listByDebitCard(String debitCard);

    public Mono<WalletDebitCard> get(String id);

    public Mono<WalletDebitCard> create(WalletDebitCard walletDebitCard);

    public Mono<WalletDebitCard> update(String id, WalletDebitCard walletDebitCard);

    public void delete(String id);
}

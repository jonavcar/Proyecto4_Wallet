package com.banck.wallet.aplication.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import com.banck.wallet.domain.WalletDebitCard;
import com.banck.wallet.aplication.WalletDebitCardOperations;
import com.banck.wallet.aplication.model.WalletDebitCardRepository;

/**
 *
 * @author jonavcar
 */
@Service
@RequiredArgsConstructor
public class WalletDebitCardOperationsImpl implements WalletDebitCardOperations {

    private final WalletDebitCardRepository personRepository;

    @Override
    public Flux< WalletDebitCard> list() {
        return personRepository.list();
    }

    @Override
    public Mono< WalletDebitCard> get(String debitcardaccount) {
        return personRepository.get(debitcardaccount);
    }

    @Override
    public Mono< WalletDebitCard> create(WalletDebitCard debitcardaccount) {
        return personRepository.create(debitcardaccount);
    }

    @Override
    public Mono< WalletDebitCard> update(String debitcardaccount, WalletDebitCard c) {
        return personRepository.update(debitcardaccount, c);
    }

    @Override
    public void delete(String debitcardaccount) {
        personRepository.delete(debitcardaccount);
    }

    @Override
    public Flux< WalletDebitCard> listByDebitCard(String debitCard) {
        return personRepository.listByDebitCard(debitCard);
    }

}

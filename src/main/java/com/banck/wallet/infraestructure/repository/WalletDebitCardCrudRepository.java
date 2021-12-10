package com.banck.wallet.infraestructure.repository;

import com.banck.wallet.domain.WalletDebitCard;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import com.banck.wallet.aplication.model.WalletDebitCardRepository;
import com.banck.wallet.infraestructure.model.dao.WalletDebitCardDao;

/**
 *
 * @author jonavcar
 */
@Component
public class WalletDebitCardCrudRepository implements WalletDebitCardRepository {

    @Autowired
    IWalletDebitCardCrudRepository crudRepository;

    @Override
    public Mono<WalletDebitCard> get(String debitcardaccount) {
        return crudRepository.findById(debitcardaccount).map(this::WalletDebitCardDaoToWalletDebitCard);
    }

    @Override
    public Flux<WalletDebitCard> list() {
        return crudRepository.findAll().map(this::WalletDebitCardDaoToWalletDebitCard);
    }

    @Override
    public Mono<WalletDebitCard> create(WalletDebitCard debitcardaccount) {
        return crudRepository.save(WalletDebitCardToWalletDebitCardDao(debitcardaccount)).map(this::WalletDebitCardDaoToWalletDebitCard);
    }

    @Override
    public Mono<WalletDebitCard> update(String debitcardaccount, WalletDebitCard c) {
        return crudRepository.save(WalletDebitCardToWalletDebitCardDao(c)).map(this::WalletDebitCardDaoToWalletDebitCard);
    }

    @Override
    public void delete(String debitcardaccount) {
        crudRepository.deleteById(debitcardaccount).subscribe();
    }

    public WalletDebitCard WalletDebitCardDaoToWalletDebitCard(WalletDebitCardDao md) {
        WalletDebitCard m = new WalletDebitCard();
        m.setDebitCard(md.getDebitCard());
        m.setTelephone(md.getTelephone());
        m.setWallet(md.getWallet());
        return m;
    }

    public WalletDebitCardDao WalletDebitCardToWalletDebitCardDao(WalletDebitCard p) {
        WalletDebitCardDao pd = new WalletDebitCardDao();
        pd.setDebitCard(p.getDebitCard());
        pd.setTelephone(p.getTelephone());
        pd.setWallet(p.getWallet());
        return pd;
    }

    @Override
    public Flux<WalletDebitCard> listByDebitCard(String debitCard) {
        return crudRepository.findAllByDebitCard(debitCard).map(this::WalletDebitCardDaoToWalletDebitCard);
    }

}

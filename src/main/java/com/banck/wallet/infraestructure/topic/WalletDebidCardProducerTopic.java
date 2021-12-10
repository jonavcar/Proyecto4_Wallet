package com.banck.wallet.infraestructure.topic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;
import com.banck.wallet.aplication.model.WalletDebitCardTopic;
import com.banck.wallet.domain.WalletDebitCard;
import org.springframework.kafka.support.SendResult;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.util.concurrent.ListenableFutureCallback;

@Component
public class WalletDebidCardProducerTopic implements WalletDebitCardTopic {

    @Autowired
    private KafkaTemplate<String, WalletDebitCard> kafkaTemplate;
    private final String TOPIC_WALLET_DEBIT_CARD = "topic-wallet-debitcard";

    @Override
    public void create(WalletDebitCard walletDebitCard) {
        this.kafkaTemplate.send(TOPIC_WALLET_DEBIT_CARD, walletDebitCard);

        ListenableFuture<SendResult<String, WalletDebitCard>> future = this.kafkaTemplate.send(TOPIC_WALLET_DEBIT_CARD, walletDebitCard);

        future.addCallback(new ListenableFutureCallback<SendResult<String, WalletDebitCard>>() {

            @Override
            public void onSuccess(SendResult<String, WalletDebitCard> result) {
                System.out.println("Wallet=[" + walletDebitCard
                        + "] con offset=[" + result.getRecordMetadata().offset() + "]");
            }

            @Override
            public void onFailure(Throwable ex) {
                System.out.println("Imposible enviar Wallet message=["
                        + walletDebitCard + "] due to : " + ex.getMessage());
            }
        });
    }

}

package com.banck.wallet.aplication.impl;

import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import com.banck.wallet.aplication.WalletDebitCardTopicOperations;
import com.banck.wallet.aplication.model.WalletDebitCardTopic;
import com.banck.wallet.domain.WalletDebitCard;

@Service
@RequiredArgsConstructor
public class WalletDebitCardTopicOperationsIml implements WalletDebitCardTopicOperations {

    Logger logger = LoggerFactory.getLogger(WalletDebitCardTopicOperationsIml.class);
    private final WalletDebitCardTopic walletDebitCardTopic;

    @Override
    public void create(WalletDebitCard walletDebitCard) {
        walletDebitCardTopic.create(walletDebitCard);
    }
}

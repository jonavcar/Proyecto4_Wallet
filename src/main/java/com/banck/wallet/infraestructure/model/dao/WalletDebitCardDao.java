/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.banck.wallet.infraestructure.model.dao;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 *
 * @author jnacarra
 */
@Data
@Document("walletdebitcard")
public class WalletDebitCardDao {
    
    @Id
    public String wallet;
    public String telephone;
    public String debitCard;
}

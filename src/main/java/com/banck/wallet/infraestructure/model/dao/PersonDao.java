package com.banck.wallet.infraestructure.model.dao;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 *
 * @author jonavcar
 */
@Data
@Document("wallet")
public class PersonDao {

    @Id
    public String person;
    public String document;
    public String documentType;
    public String telephone;
    public String imei;
    public String mail;
    public String date;
    public boolean state;
}

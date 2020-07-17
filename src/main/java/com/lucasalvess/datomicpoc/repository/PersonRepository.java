package com.lucasalvess.datomicpoc.repository;

import com.lucasalvess.datomicpoc.model.Person;
import datomic.Connection;
import datomic.Database;
import org.springframework.stereotype.Repository;

@Repository
public class PersonRepository {


    public Person save(){
        return null;
    }

    public void get(){
        DatomicConnection datomicConnection =  new DatomicConnection("datomic:dev://localhost:4334/poc");
        Connection conn = datomicConnection.getConnection();

        Database bd = conn.db();
    }
}

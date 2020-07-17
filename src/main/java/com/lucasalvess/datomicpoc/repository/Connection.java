package com.lucasalvess.datomicpoc.repository;

import datomic.Peer;
import lombok.extern.slf4j.Slf4j;

@Slf4j
class DatomicConnection {

    private final datomic.Connection connection;
    private String uri;

    public datomic.Connection getConnection() {
        return connection;
    }

    public DatomicConnection(String uri) {
        this.uri = uri;
        log.info("uri: " + this.uri);
        boolean created = Peer.createDatabase(uri);
        if(created) {
            log.info("created db: " + this.uri);
        }
        this.connection = Peer.connect(uri);
    }
}

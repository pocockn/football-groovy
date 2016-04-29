package config

import groovy.sql.Sql

/**
 * Created by pocockn on 29/04/16.
 */
class DbConfig {

    public static final String DEFAULT_DB_HOST = "ec2-174-129-18-170.compute-1.amazonaws.com"
    public static final Integer DEFAULT_DB_PORT = 5432
    public static final String DEFAULT_DB_NAME = "d8feiblol6gqc6"
    public static final String DEFAULT_DB_USER = "radqrnvnqgriuq"
    public static final String DEFAULT_DB_PASSWORD = "0_VzQUUy-VCaw9whDv1eF_9Mql"
    public static final String DBDRIVER   = "org.postgresql.Driver"

    static String getJdbcUrl() {
        "jdbc:postgresql://${DEFAULT_DB_HOST}:${DEFAULT_DB_PORT}/${DEFAULT_DB_NAME}"
    }

    String getConnection() {
        def sql = Sql.newInstance(getJdbcUrl(),DEFAULT_DB_USER,DEFAULT_DB_PASSWORD,DBDRIVER)
    }
}

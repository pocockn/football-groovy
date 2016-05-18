package persistence
import groovy.sql.Sql

/**
 * Created by pocockn on 18/05/16.
 */
class DatabaseConnection {

    String dbUrl
    String dbUser
    String dbPassword
    String dbDriver = "org.postgresql.Driver"

    public databaseConnection() {
        return Sql.newInstance(this.dbUrl,this.dbUser,this.dbPassword,this.dbDriver)
    }

}

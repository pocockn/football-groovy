package postgresImplementation

import groovy.transform.CompileStatic

/**
 * Created by pocockn on 29/04/16.
 */

@CompileStatic
class DbConfig {

    String user
    String password
    String serverName = 'localhost'
    String databaseName
    Integer portNumber = 5432

}


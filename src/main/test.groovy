import config.DbConfig

/**
 * Created by pocockn on 29/04/16.
 */

DbConfig connection = new DbConfig()

def connect = connection.getConnection()

println connect
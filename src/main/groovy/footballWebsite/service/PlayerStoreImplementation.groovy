package footballWebsite.service

import com.fasterxml.jackson.databind.ObjectMapper
import footballWebsite.model.Player
import groovy.sql.Sql
import persistence.DatabaseConnection
import ratpack.exec.Promise

/**
 * Created by pocockn on 13/05/16.
 */
class PlayerStoreImplementation implements PlayerStore{

    def playerArray = []

    Promise<ArrayList> save(Player player) {
        ObjectMapper objectMapper = new ObjectMapper()
        String workingDir = System.getProperty("user.dir")
        def jsonObject = objectMapper.writeValueAsString(player)
        String insertSql = """insert into players (content) values (cast('$jsonObject' as json))"""
        def sql = Sql.newInstance("jdbc:postgresql://localhost/footballGroovy","pocockn","only8deb","org.postgresql.Driver")
        sql.executeInsert(insertSql)
        playerArray.(jsonObject)
        Promise.value(playerArray)
    }

    Promise<Player> get (String uuid) {

    }

    public Promise<List<Player>> list() {

        Promise.value(playerArray.toList())

    }


}

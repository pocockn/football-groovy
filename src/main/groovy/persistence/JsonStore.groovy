package persistence

import com.fasterxml.jackson.databind.ObjectMapper
import com.google.inject.Inject
import groovy.sql.Sql
import groovy.util.logging.Slf4j
import ratpack.exec.Blocking
import ratpack.exec.Promise

import javax.sql.DataSource

/**
 * Created by pocockn on 13/05/16.
 */

@Slf4j
class JsonStore {

    @Inject DataSource dataSource
    @Inject ObjectMapper objectMapper

    public <T> Promise<T> withDataSource(Closure<T> c) {
        assert dataSource, "Datasource appears to be null"

        Blocking.get {
            Sql sql = new Sql(dataSource.getConnection())
            try {
                c.call(sql)
            } catch (Exception e) {
                log.error(e.message)
                throw e
            } finally {
                sql.close()
            }
        }
    }
}

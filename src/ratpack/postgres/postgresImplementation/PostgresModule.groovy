package postgresImplementation

import com.google.inject.Provides
import org.postgresql.ds.PGSimpleDataSource
import ratpack.guice.ConfigurableModule

import javax.sql.DataSource

/*
* Module to create a Datasource instance for our PostgreSQL database
 */

class PostgresModule extends ConfigurableModule<DbConfig> {

    @Override
    protected void configure() {

    }

    /**
     * Create DataSource instance
     *
     * @param config Configuration object with properties for creating DataSource
     * @return Datasource for connecting to Postgres DB
     */

    @Provides
    DataSource dataSource(final DbConfig config) {
        createDataSource(config)
    }

    /**
     * Subclasses can override this method to create other Datasoucres
     * instance eg PGPollingDataSource
     *
     * @param config Configuration object with properties for creating DataSource
     * @return Datasource for connecting to Postgres DB
     */
    protected DataSource createDataSource(final DbConfig config) {
        new PGSimpleDataSource(
                user: config.user,
                password: config.password,
                serverName: config.serverName,
                databaseName: config.databaseName,
                portNumber: config.portNumber
        )

    }


}

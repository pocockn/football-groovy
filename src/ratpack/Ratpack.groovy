import footballWebsite.handlers.AddNewPlayerHandle
import postgresImplementation.DbConfig
import postgresImplementation.PostgresModule
import ratpack.config.ConfigData
import ratpack.config.ConfigDataBuilder
import ratpack.groovy.sql.SqlModule
import ratpack.handlebars.HandlebarsModule

import static ratpack.groovy.Groovy.ratpack
import static ratpack.handlebars.Template.handlebarsTemplate

ratpack {
  bindings {
      module HandlebarsModule
      bind AddNewPlayerHandle
      // Create generic configuration
      final ConfigData configData = ConfigData.of { ConfigDataBuilder builder ->
          /*
          * Set the configuration properties
          * ConfigDataBuilder methods to read config from other sources
           */
          builder.props(
                  ['postgres.user'        : 'pocockn',
                   'postgres.password'    : 'only8deb',
                   'postgrs.portNumber'   :  5432,
                   'postgres.databaseName': 'footballGroovy',
                   'postgres.serverName'  : 'localhost'])
          builder.build()
      }

      // Create instance of DbConfig
      // that is used for the
      // configurable module PostgresModule
      bindInstance DbConfig, configData.get('/postgres',DbConfig)
      // Initialise module to create DataSource.
      module PostgresModule
      // Initialize SqlModule to provide
      // Groovy SQL support in our application.
      module SqlModule
  }

    handlers {
    get {
      render handlebarsTemplate("index.html")
    }

    path "api/add-new-player", AddNewPlayerHandle

    files { dir "public" }
  }
}

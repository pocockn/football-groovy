import footballWebsite.handlers.AddNewPlayerHandle
import ratpack.handlebars.HandlebarsModule

import static ratpack.groovy.Groovy.ratpack
import static ratpack.handlebars.Template.handlebarsTemplate

ratpack {
  bindings {
    module HandlebarsModule
    bind AddNewPlayerHandle
  }

  handlers {
    get {
      render handlebarsTemplate("index.html")
    }

    path "api/add-new-player", AddNewPlayerHandle

    files { dir "public" }
  }
}

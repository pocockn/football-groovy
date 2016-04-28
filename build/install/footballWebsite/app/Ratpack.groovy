import ratpack.groovy.template.MarkupTemplateModule
import ratpack.handlebars.HandlebarsModule
import static ratpack.handlebars.Template.handlebarsTemplate;

import static ratpack.groovy.Groovy.groovyMarkupTemplate
import static ratpack.groovy.Groovy.ratpack

ratpack {
  bindings {
    module HandlebarsModule
  }

  handlers {
    get {
      render handlebarsTemplate("index.html")
    }

    files { dir "public" }
  }
}

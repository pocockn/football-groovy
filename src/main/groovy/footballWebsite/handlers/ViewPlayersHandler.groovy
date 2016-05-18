package footballWebsite.handlers

import footballWebsite.model.Player
import footballWebsite.service.PlayerStoreImplementation
import ratpack.form.Form
import ratpack.handling.Context
import ratpack.handling.Handler

import static ratpack.handlebars.Template.handlebarsTemplate
import static ratpack.handlebars.Template.handlebarsTemplate

/**
 * Created by pocockn on 14/05/16.
 */
class ViewPlayersHandler implements Handler {

    void handle(Context ctx) {
        ctx.byMethod {
            it.get {
                PlayerStoreImplementation playerStoreImplementation = new PlayerStoreImplementation()
                playerStoreImplementation.list()
                ctx.render handlebarsTemplate("list-players.html")
            }
        }

    }

}


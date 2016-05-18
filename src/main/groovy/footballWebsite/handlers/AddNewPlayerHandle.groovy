package footballWebsite.handlers

import com.fasterxml.jackson.databind.ObjectMapper
import footballWebsite.model.Player
import footballWebsite.service.PlayerStoreImplementation
import ratpack.form.Form
import ratpack.handling.Context
import ratpack.handling.Handler
import static ratpack.handlebars.Template.handlebarsTemplate

/**
 * Created by pocockn on 28/04/16.
 */
class AddNewPlayerHandle implements Handler {

    void handle(Context ctx) {
        ctx.byMethod {
            it.get {
                ctx.render handlebarsTemplate("add-new-player.html")
            }
            it.post {
                ctx.parse(Form.class).then { form ->
                    String fname = form.get("fname")
                    String lname = form.get("lname")
                    Integer PlayerAge = form.get("age").toInteger()

                    def playerObject = new Player().with {
                        (fName,lName,age) = [fname,lname,PlayerAge]
                    }

                    // Use Jackson Object Mapper
                    PlayerStoreImplementation playerStoreImplementation = new PlayerStoreImplementation()

                    playerStoreImplementation.save(new Player(fName: fname, lName:lname, age: PlayerAge)).then { array ->
                        ctx.render handlebarsTemplate("view-player.html", model:array)
                    }


                }
            }
        }

    }

}

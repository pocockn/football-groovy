package footballWebsite.service

import footballWebsite.model.Player
import ratpack.exec.Promise

/**
 * Created by pocockn on 29/04/16.
 */
interface PlayerService {

    Promise<List<Player>> getPlayers()

}
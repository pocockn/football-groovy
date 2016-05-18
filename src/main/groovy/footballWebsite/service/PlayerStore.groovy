package footballWebsite.service

import footballWebsite.model.Player
import ratpack.exec.Promise


/**
 * Created by pocockn on 13/05/16.
 */

interface PlayerStore {

        Promise<ArrayList> save(Player player)

        Promise<Player> get (String uuid)

        public Promise<List<Player>> list()


}

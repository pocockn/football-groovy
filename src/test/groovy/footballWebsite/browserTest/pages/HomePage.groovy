package footballWebsite.browserTest.pages

import geb.Page

/**
 * Created by pocockn on 27/04/16.
 */
class HomePage extends Page {

    static url = "/"

    static at = { title == "Yac Club Home Page" }

    static content = {
        h1Header { $("h1",text: "Welcome to the Yac Club").text() }
    }

}

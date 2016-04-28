package footballWebsite.browserTest

import footballWebsite.browserTest.pages.HomePage
import geb.spock.GebSpec
import ratpack.groovy.test.GroovyRatpackMainApplicationUnderTest

/**
 * Created by pocockn on 27/04/16.
 */
class HomePageTest extends GebSpec {

    def aut = new GroovyRatpackMainApplicationUnderTest()

    def setup() {
        URI base = aut.address
        browser.baseUrl = base.toString()
    }

    def "check title on homepage" () {
        given:
            to HomePage
        expect:
            at HomePage
    }

    def "check h1 on homepage"() {
        given:
        to HomePage
        expect:
        h1Header == "Welcome to the Yac Club"

    }
}

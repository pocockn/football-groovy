package footballWebsite.model

import spock.lang.Shared
import spock.lang.Specification
import spock.lang.Unroll

import javax.validation.Validation


/**
 * Created by pocockn on 27/04/16.
 */
class LeagueSpec extends Specification {

    @Shared
    private static validator = Validation.buildDefaultValidatorFactory().validator
    def player = new League('Clapham', 'Mondays')

    def "Test league validation works"() {

        when: "I validate a new player object"
        def errors = validator.validate(League)

        then: "I get no errors"
        errors.size() == 0
    }

    @Unroll
    def "Validation of multiple player data #validatioResults #error"() {
        expect: "Validation expects no unexpected validation failures"

        property == validator.validate(validatioResults)[0].getPropertyPath()[0].name
        message == validator.validate(validatioResults)[0].message

        where:
        validatioResults          | property   | message
        new League('Clapham', '') | "day"      | "may not be empty"
        new League('', 'Mondays') | "location" | "may not be empty"
    }
}

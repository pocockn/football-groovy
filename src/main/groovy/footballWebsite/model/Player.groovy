package footballWebsite.model

import groovy.transform.TupleConstructor
import org.hibernate.validator.constraints.NotBlank

/**
 * Created by pocockn on 27/04/16.
 */
@TupleConstructor
class Player {

    @NotBlank
    String fName

    @NotBlank
    String lName

    Integer age


}

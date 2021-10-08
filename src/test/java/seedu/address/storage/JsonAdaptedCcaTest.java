package seedu.address.storage;

import org.junit.jupiter.api.Test;
import seedu.address.commons.exceptions.IllegalValueException;
import seedu.address.model.cca.Cca;
import seedu.address.model.cca.CcaName;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;
import static seedu.address.storage.JsonAdaptedCca.MISSING_FIELD_MESSAGE_FORMAT;
import static seedu.address.testutil.Assert.assertThrows;
import static seedu.address.testutil.TypicalCcas.NUSSO;

class JsonAdaptedCcaTest {

    private static final String VALID_NAME = NUSSO.getName().toString();

    @Test
    public void toModelType_validCcaDetails_returnsCca() throws Exception {
        JsonAdaptedCca cca = new JsonAdaptedCca(NUSSO);
        assertEquals(NUSSO, cca.toModelType());
    }

    // Problem - JsonAdaptedCca(null) is ambiguous constructor and Java can't tell which constructor to call
    // Not a problem for JsonAdaptedPerson because other arguments are passed in as well and Java can tell which
    // constructor is called
//    @Test
//    public void toModelType_nullName_throwsIllegalValueException() {
//        JsonAdaptedCca cca = new JsonAdaptedCca(null);
//        String expectedMessage = String.format(MISSING_FIELD_MESSAGE_FORMAT, Cca.class.getSimpleName());
//        assertThrows(IllegalValueException.class, expectedMessage, cca::toModelType);
//    }

}

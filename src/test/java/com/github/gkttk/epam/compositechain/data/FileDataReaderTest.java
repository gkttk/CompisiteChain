package com.github.gkttk.epam.compositechain.data;

import com.github.gkttk.epam.compositechain.data.exceptions.DataReaderException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class FileDataReaderTest {

    private static final DataReader DATA_READER = new FileDataReader();
    private static final String FILE_LOCATION = "src\\test\\resources\\test.txt";
    private static final String INCORRECT_FILE_LOCATION = "";

    @Test
    public void testReadFileShouldReturnStringWithAllLinesOfGivenFile() throws DataReaderException {
        //given
        String expectedString = "    Hello, world [5 4 3 + *] bye!\n" +
                "    Second sentence [2 4 *] in the world! File not found exception! [10 10 10 * /].\n" +
                "    Third paragraph [2 4 5 12 - * /] hi. There is a lot of sentences. First q. Second ew. Third abs.";
        //when
        String resultString = DATA_READER.readFile(FILE_LOCATION);
        //then
        Assertions.assertEquals(expectedString, resultString);
    }


    @Test
    public void testReadFileShouldThrowExceptionWhenFileLocationIsIncorrect() {
        //given
        //when
        //then
        Assertions.assertThrows(DataReaderException.class, () -> DATA_READER.readFile(INCORRECT_FILE_LOCATION));
    }


}

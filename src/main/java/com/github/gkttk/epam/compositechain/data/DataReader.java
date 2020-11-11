package com.github.gkttk.epam.compositechain.data;

import com.github.gkttk.epam.compositechain.data.exceptions.DataReaderException;

public interface DataReader {

    String readFile(String fileLocation) throws DataReaderException;


}

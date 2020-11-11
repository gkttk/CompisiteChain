package com.github.gkttk.epam.compositechain.data;

import com.github.gkttk.epam.compositechain.data.exceptions.DataReaderException;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class FileDataReader implements DataReader {

    @Override
    public String readFile(String fileLocation) throws DataReaderException {
        try {
            Files.readAllBytes(Paths.get(fileLocation));
            List<String> strings = Files.readAllLines(Paths.get(fileLocation));
            StringBuilder stringBuilder = new StringBuilder();
            for (String str : strings) {
                stringBuilder.append(str);
                stringBuilder.append("\n");
            }

            stringBuilder.setLength(stringBuilder.length() - 1);
            return stringBuilder.toString();
        } catch (IOException exception) {
            throw new DataReaderException("Can't read the file: " + fileLocation, exception);
        }


    }
}

/*
 *  CSVTestingReader.java
 *  Prediksi-Nilai 
 * 
 *  Created by Agung Pramono on 30/09/2017 
 *  Copyright (c) 2017 Java Development. All rights reserved.
 */
package com.agung.regresi.util;

import com.agung.regresi.entity.Testing;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.slf4j.LoggerFactory;

/**
 *
 * @author agung
 */
public class CSVTestingReader extends AbstractFileReader<Testing> {

    private final org.slf4j.Logger LOGGER = LoggerFactory.getLogger(CSVTestingReader.class);
    private final File sourceFile;

    public CSVTestingReader(File sourceFile) {
        this.sourceFile = sourceFile;
    }

    @Override
    public List<Testing> readFile() throws FileNotFoundException {
        try {
            List<Testing> testing = new ArrayList<>();
            BufferedReader reader = null;
            try (FileReader fileReader = new FileReader(sourceFile)) {
                
                reader = new BufferedReader(new FileReader(sourceFile));
                String data = reader.readLine();
                
                while ((data = reader.readLine()) != null) {
                    String[] element = data.split(",");
                    testing.add(ArrayToObject(element));
                }
                fileReader.close();
            }
            reader.close();
            return testing;
        } catch (IOException ex) {
            LOGGER.error(ex.getMessage());
        }
        return null;
    }

    private Testing ArrayToObject(String[] element) {
        Testing data = new Testing();
        //data.setId(Integer.parseInt(element[0]));
        data.setNilaiUAS(Double.parseDouble(element[1]));
        return data;
    }

    @Override
    public void fileImporter(File sourceFile) throws FileNotFoundException {}
}

package com.enigma.impl;

import com.enigma.dao.FixedReaderDao;
import org.junit.Assert;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import static org.junit.Assert.*;

public class FixedReaderDaoImplTest {

    @Test
    public void read_should_return_file_output() throws IOException {
        BufferedReader bufferedReader = Files.newBufferedReader(Paths.get("C:\\test-final-dkatalist\\file_inputs.txt"));
        FixedReaderDao fixedReaderDao = new FixedReaderDaoImpl();
        String expectedStringResult = fixedReaderDao.read(bufferedReader);
        BufferedReader bufferedReader1 = Files.newBufferedReader(Paths.get("C:\\test-final-dkatalist\\file_output.txt"));
        FixedReaderDao fixedReaderDao1 = new FixedReaderDaoImpl();
        String actualStringResult = fixedReaderDao1.read(bufferedReader1);
        Assert.assertEquals( expectedStringResult, actualStringResult);
    }
}
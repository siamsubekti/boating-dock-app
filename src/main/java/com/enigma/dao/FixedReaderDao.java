package com.enigma.dao;

import java.io.BufferedReader;
import java.io.IOException;

public interface FixedReaderDao {
    String read(BufferedReader bufferedReader) throws IOException;
}

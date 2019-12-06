package com.enigma.dao;

import java.io.IOException;

public interface FixedReaderDao {
    String readFiles(String file) throws IOException;
}

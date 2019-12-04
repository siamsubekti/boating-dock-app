package com.enigma;

import com.enigma.dao.FixedReaderDao;
import com.enigma.impl.FixedReaderDaoImpl;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;

public class MainApplication {
    public static void main(String[] args) throws IOException {
//        File inFile = null;
//        if (0 < args.length) {
//            inFile = new File(args[0]);
//        } else {
//            System.err.println("Invalid");
//            System.exit(0);
//        }
//        Scanner scanner = new Scanner(inFile);
//        System.out.println(scanner.next());

        BufferedReader reader = Files.newBufferedReader(Paths.get("C:\\test-final-dkatalist\\file_inputs.txt"));
        FixedReaderDao fixedReaderDao = new FixedReaderDaoImpl();

        try {
            fixedReaderDao.read(reader);
        }catch (FileNotFoundException fileNotFound) {
            fileNotFound.printStackTrace();
        } catch (IOException io) {
            io.printStackTrace();
        }
    }
}

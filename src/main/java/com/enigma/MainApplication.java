package com.enigma;

import com.enigma.dao.FixedReaderDao;
import com.enigma.impl.FixedReaderDaoImpl;

import java.io.*;
import java.util.Scanner;

public class MainApplication {
    public static void main(String[] args) throws IOException {

        FixedReaderDaoImpl fixedReaderDao = new FixedReaderDaoImpl();
        Scanner scanner = new Scanner(System.in);
        if (args.length == 0) {

            while (true) {
                System.out.print("$");
                String line = scanner.nextLine();
                if (line.equals("exit"))
                    break;
                fixedReaderDao.readCommand(line.trim().split("\\s+"));
            }

        } else {
            String filePath = args[0];
            fixedReaderDao.readFiles(filePath);
        }

//        Scanner scanner = new Scanner(System.in);
//        System.out.println("1. Input File");
//        System.out.println("2. Interactive");
//        int type = scanner.nextInt();
//
//        switch (type) {
//            case 1 :
//                System.out.println("file name path : ");
//                String file = scanner.next();
//                System.out.println(fixedReaderDao.readFiles(file));
//                break;
//            case 2 :
//                System.out.println("enter your commands : ");
//
//        }
//        fixedReaderDao.readLine(filePath);
    }
}

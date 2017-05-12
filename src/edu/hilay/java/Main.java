package edu.hilay.java;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

public class Main {

    public static void main(String[] args) {

        String s = null;
        try {
            s = StreamIO.readWebsite("http://www.ynet.co.il/home/0,7340,L-8,00.html");
        } catch (IOException e) {
            e.printStackTrace();
        }
        StreamIO.write("ynet.txt",s);

        System.out.println(s);
    }
}

package edu.hilay.java;

import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

/**
 * Created by Android2017 on 5/12/2017.
 */
public class StreamIO {
    public static void write(String fileName, String data) {
        try (BufferedWriter writer = new BufferedWriter(
                new FileWriter(fileName))) {
            writer.write(data);
            //write.newLine(); - used for 'for loop' in case of arrayList
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void write(String fileName, String data, Boolean append) {
        try (FileWriter writer = new FileWriter(fileName, append)) {
            writer.write(data);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String read(String fileName) throws IOException {
        StringBuilder data = new StringBuilder();
        try (InputStream in = new FileInputStream(fileName)) {
            return read(in);
        }
    }

    public static void copy(String srcFileName, String destFileName) {
        try (InputStream in = new FileInputStream(srcFileName);
             OutputStream out = new FileOutputStream(destFileName)) {

            byte[] buffer = new byte[8192];
            int length = 0;
            while ((length = in.read(buffer, 0, buffer.length)) != -1) {
                out.write(buffer);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String readWebsite(String address) throws IOException {
        StringBuilder data = new StringBuilder();
        URL url = null;
        try {
            url = new URL(address);
        } catch (MalformedURLException e) {
            throw new IOException("Failed at parsing the URL.", e);
        }
        URLConnection con = url.openConnection();
        InputStream in = con.getInputStream();
        return (read(in));
    }


    public static String read(InputStream in) throws IOException {
        StringBuilder data = new StringBuilder();

        try (BufferedReader reader = new BufferedReader(
                new InputStreamReader(in))) {

            String line;
            while ((line = reader.readLine()) != null) {
                data.append(line).append(System.lineSeparator());
            }
        }
        return data.toString();
    }

}

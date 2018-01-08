package com.ghj.hound.common.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

@Configuration
public class TLProperties {

    public static String TL_APIADDRESS;

    public static String TL_APIKEY;

    static {
        FileInputStream in = null;
        try {
            File file = ResourceUtils.getFile("classpath:file.properties");
            Properties p = new Properties();
            in = new FileInputStream(file);
            p.load(in);
            TL_APIKEY = p.getProperty("mediation.file.inputFile");
            TL_APIADDRESS = p.getProperty("mediation.file.finishedFile");
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            if (in != null) try {
                in.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}

package utilities;

import java.io.FileInputStream;
import java.util.Properties;


public class ConfigReader {
    //Singeltone is used to avoid to have instance of class
    private ConfigReader (){}

    private static Properties properties;

    static {
        String path = "configuration.properties";
        try {
            FileInputStream file = new FileInputStream(path);
            properties = new Properties();
            properties.load(file);
            file.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static String getProperty(String key){
        return properties.getProperty(key);
    }

    public static String getReportConfigPath(){
        String reportConfigPath = properties.getProperty("reportConfigPath");
        if(reportConfigPath!= null) return reportConfigPath;
        else throw new RuntimeException("Report Config Path not specified in the Configuration.properties file for the Key:reportConfigPath");
    }
}

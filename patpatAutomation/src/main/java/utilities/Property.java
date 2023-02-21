package utilities;

import java.io.FileReader;
import java.util.Properties;

public class Property {
    private FileReader propertiesFileReader;
    public Properties propertiesFile;

    /**
     * initializeProperty method implemented to read data from the properties files
     * @param propertyFilePath
     * @throws Exception
     */
    public void initializeProperty(String propertyFilePath) throws Exception {
        propertiesFileReader = new FileReader(propertyFilePath);
        propertiesFile = new Properties();
        propertiesFile.load(propertiesFileReader);
    }
}

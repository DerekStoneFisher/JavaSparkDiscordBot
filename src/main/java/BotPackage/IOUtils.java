package BotPackage;

import org.apache.log4j.Logger;

import java.io.*;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URL;

/**
 * Created by C17050 on 12/21/2017.
 */
public class IOUtils {
    static Logger logger = Logger.getLogger(IOUtils.class);

    public static File getResourceAsFile(String index) {
        try {
            URL url = IOUtils.class.getClassLoader().getResource(index);
            if (url == null)
                url = IOUtils.class.getResource(index);
            if (url == null) {
                File f = new File(index);
                return f;
            }
            return new File(url.toURI());
        } catch (URISyntaxException e) {
            e.printStackTrace();
            throw new RuntimeException("getResourcesAsFile() encountered an error. It might have not found the file " + index + " in the resources folder.");
        }
    }

    public static String getPathOfResource(String resourceFilename) {
        try {
            return IOUtils.class.getClassLoader().getResource(resourceFilename).toURI().getPath();
        } catch (URISyntaxException e) {
            throw new RuntimeException(e);
        }
    }

    public static InputStream getResourceAsStream(String resourceFilename) throws IOException
    {
        // first lets try getting it from class-loader
        InputStream is = IOUtils.class.getResourceAsStream(resourceFilename);
        if (is == null)
        {
            is = IOUtils.class.getClassLoader().getResourceAsStream(resourceFilename);
        }

        if (is == null)
        {
            // lets try opening it as a file
            File resourceFile = new File(resourceFilename);
            if (resourceFile.exists())
            {
                is = new FileInputStream(resourceFile);
            } else
            {
                // it should be a URL
                URL resourceURL;
                try
                {
                    resourceURL = new URL(resourceFilename);
                } catch (MalformedURLException e)
                {
                    throw new FileNotFoundException(resourceFilename);
                }
                is = resourceURL.openStream();
            }
        }
        return is;
    }
}

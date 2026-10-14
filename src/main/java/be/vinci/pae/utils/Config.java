package be.vinci.pae.utils;

import jakarta.ws.rs.WebApplicationException;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.Response.Status;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class Config {

  private static Properties props;

  /**
   * {@inheritDoc} This method loads a file. {@inheritDoc}
   *
   * @param file - String that contains the file name.{@inheritDoc}
   */
  public static void load(String file) {
    props = new Properties();
    try (InputStream input = new FileInputStream(file)) {
      props.load(input);
    } catch (IOException e) {
      throw new WebApplicationException(
          Response.status(Status.INTERNAL_SERVER_ERROR).entity(e.getMessage()).type("text/plain")
              .build());
    }
  }

  /**
   * {@inheritDoc} This method returns property of the file by his key.
   *
   * @param key - String that contains the key.
   * @return String - property of the file.
   */
  public static String getProperty(String key) {
    return props.getProperty(key);
  }

  /**
   * {@inheritDoc} This method returns Integer property of the file by his key.{@inheritDoc}
   *
   * @param key - String that contains the key.
   * @return Integer - property of the file.
   */
  public static Integer getIntProperty(String key) {
    return Integer.parseInt(props.getProperty(key));
  }

  /**
   * {@inheritDoc} This method returns Boolean property of the file by his key.{@inheritDoc}
   *
   * @param key - String that contains the key.
   * @return Integer - property of the file.
   */
  public static boolean getBoolProperty(String key) {
    return Boolean.parseBoolean(props.getProperty(key));
  }

}

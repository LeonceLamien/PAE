package be.vinci.pae.services;

import be.vinci.pae.utils.Config;
import jakarta.ws.rs.WebApplicationException;
import jakarta.ws.rs.core.Response.Status;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import org.apache.commons.dbcp2.BasicDataSource;


public class DalServicesImpl implements DalServices {

  private static final String DB_STRING_CONNECTION = Config.getProperty("url");
  private static final String DB_USERNAME = Config.getProperty("user");
  private static final String DB_PASSWORD = Config.getProperty("password");
  private static final int DB_MINCONNECTION = Config.getIntProperty("minIdle");
  private static final int DB_MAXCONNECTION = Config.getIntProperty("maxIdle");
  private ThreadLocal<Connection> threadLocal = new ThreadLocal<Connection>();
  private BasicDataSource bds;
  
  /**
   * Constructor of the class.
   */
  public DalServicesImpl() {
    bds = new BasicDataSource();
    bds.setUrl(DB_STRING_CONNECTION);
    bds.setUsername(DB_USERNAME);
    bds.setPassword(DB_PASSWORD);
    bds.setMinIdle(DB_MINCONNECTION);
    bds.setMaxIdle(DB_MAXCONNECTION);
  }

  @Override
  public PreparedStatement getPreparedStatement(String query) {
    PreparedStatement ps = null;

    Connection connection = threadLocal.get();
    if (connection == null) {
      try {
        connection = bds.getConnection();
      } catch (SQLException e) {
        // Pas sur que bon status
        throw new WebApplicationException("Ressource not found",
            Status.INTERNAL_SERVER_ERROR);
      }
      threadLocal.set(connection);
    }
    try {
      ps = connection.prepareStatement(query);
    } catch (SQLException e) {
      // Pas sur que bon status
      throw new WebApplicationException("Ressource not found",
          Status.INTERNAL_SERVER_ERROR);
    }

    return ps;
  }

  @Override
  public PreparedStatement getPreparedStatementReturningId(String query) {
    PreparedStatement ps = null;

    Connection connection = threadLocal.get();
    if (connection == null) {
      try {
        connection = bds.getConnection();
      } catch (SQLException e) {
        // Pas sur que bon status
        throw new WebApplicationException("Ressource not found",
            Status.INTERNAL_SERVER_ERROR);
      }
      threadLocal.set(connection);
    }
    try {
      ps = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
    } catch (SQLException e) {
      // Pas sur que bon status
      throw new WebApplicationException("Ressource not found",
          Status.INTERNAL_SERVER_ERROR);

    }

    return ps;
  }


}

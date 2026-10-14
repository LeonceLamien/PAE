package be.vinci.pae.services;

import java.sql.PreparedStatement;

public interface DalServices {

  /**
   * {@inheritDoc} This method takes a query in parameter and return it PreparedStatement.
   *
   * @param query - String, query.
   * @return PreparedStatement.
   */
  PreparedStatement getPreparedStatement(String query);

  /**
   * {@inheritDoc} This method takes a query in parameter and return it PreparedStatement.
   *
   * @param query - String, query.
   * @return PreparedStatement.
   */
  PreparedStatement getPreparedStatementReturningId(String query);

}

package org.naveen.HealthCheck;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import org.eclipse.microprofile.health.HealthCheck;
import org.eclipse.microprofile.health.HealthCheckResponse;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

@ApplicationScoped
@org.eclipse.microprofile.health.Readiness
public class Readiness implements HealthCheck {

  @Inject
  DataSource dataSource;

  @Override
  public HealthCheckResponse call() {
    try (Connection connection = dataSource.getConnection()) {
      if (connection.isValid(1)) {
        return HealthCheckResponse.named("Database is readiness Health").up().build();
      } else {
        return HealthCheckResponse.named("Database is not connected").down().build();
      }
    } catch (SQLException e) {
      return HealthCheckResponse.named("Database is not connected").down().build();
    }
  }
}

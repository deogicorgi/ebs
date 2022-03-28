package com.deogicorgi.orm.config;

import com.deogicorgi.orm.config.properties.DatabaseProperties;
import io.r2dbc.pool.ConnectionPool;
import io.r2dbc.pool.ConnectionPoolConfiguration;
import io.r2dbc.spi.ConnectionFactories;
import io.r2dbc.spi.ConnectionFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.r2dbc.core.R2dbcEntityOperations;
import org.springframework.data.r2dbc.core.R2dbcEntityTemplate;
import org.springframework.data.r2dbc.repository.config.EnableR2dbcRepositories;

import static io.r2dbc.spi.ConnectionFactoryOptions.*;

@Configuration
@EnableR2dbcRepositories
@RequiredArgsConstructor
public class R2dbcConfiguration {

    private final DatabaseProperties databaseProperties;

    @Bean
    @Qualifier("connection")
    public ConnectionFactory connectionFactory() {

        ConnectionFactory connectionFactory = ConnectionFactories.get(
                builder()
                        .option(DRIVER, "pool")
                        .option(PROTOCOL, "mariadb")
                        .option(HOST, databaseProperties.getHost())
                        .option(PORT, databaseProperties.getPort())
                        .option(DATABASE, databaseProperties.getDb())
                        .option(USER, databaseProperties.getUsername())
                        .option(PASSWORD, databaseProperties.getPassword())
                        .build());

        ConnectionPoolConfiguration configuration =
                ConnectionPoolConfiguration
                        .builder(connectionFactory)
                        .maxSize(50)
                        .build();

        return new ConnectionPool(configuration);
    }

    @Primary
    @Bean(name = "mariadbR2dbcTemplate")
    public R2dbcEntityOperations mariadbR2dbcTemplate(@Qualifier("connection") ConnectionFactory connectionFactory) {
        return new R2dbcEntityTemplate(connectionFactory);
    }
}

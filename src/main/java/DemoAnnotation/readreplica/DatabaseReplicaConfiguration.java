package DemoAnnotation.readreplica;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;


/**
 * author: Koushik
 * Date: July 2019
 *
 * Configuration file to configure Replica Datasource
 * Adding Replica and Master datasouece to Route Datasouece
 */

@Configuration
public class DatabaseReplicaConfiguration {
    @Bean(name = "replicaDataSource")
    public DataSource getReplicaDataSource(DatabaseReplicaProperties databaseReplicaProperties) {

        DataSource dataSource = null;
        System.out.println("Started configuration for replica database datasource");
        final HikariConfig hikariConfig = new HikariConfig();

        hikariConfig.setPoolName("ReplicaHickariPool");
        hikariConfig.setJdbcUrl(databaseReplicaProperties.getUrl());
        hikariConfig.setUsername(databaseReplicaProperties.getUsername());
        hikariConfig.setPassword(databaseReplicaProperties.getPassword());
        System.out.println("database url: {}"+ databaseReplicaProperties.getUrl());
        System.out.println("database driver name: {}"+ databaseReplicaProperties.getDriverClassName());


        hikariConfig.setDriverClassName(databaseReplicaProperties.getDriverClassName());

        //hikariConfig.setDataSourceClassName(databaseReplicaProperties.getDriverClassName());
        try {
            dataSource = new HikariDataSource(hikariConfig);
            if (dataSource != null) {
                System.out.println("Replica datasource is not set");
            }
        } catch(Exception e) {
            System.out.println("Error creating replica datasource " + e.getMessage());

        }

        return dataSource;
    }


    @Bean(name = "dataSource")
    public DataSource getMasterDataSource(DataSourceProperties dataSourceProperties) {

        DataSource dataSource = null;
        System.out.println("Started configuration for replica database datasource");
        final HikariConfig hikariConfig = new HikariConfig();

        hikariConfig.setPoolName("ReplicaHickariPool");
        hikariConfig.setJdbcUrl(dataSourceProperties.getUrl());
        hikariConfig.setUsername(dataSourceProperties.getUsername());
        hikariConfig.setPassword(dataSourceProperties.getPassword());
        System.out.println("database url: {}"+ dataSourceProperties.getUrl());
        System.out.println("database driver name: {}"+ dataSourceProperties.getDriverClassName());


        hikariConfig.setDriverClassName(dataSourceProperties.getDriverClassName());

        //hikariConfig.setDataSourceClassName(databaseReplicaProperties.getDriverClassName());
        try {
            dataSource = new HikariDataSource(hikariConfig);
            if (dataSource != null) {
                System.out.println("Replica datasource is not set");
            }
        } catch(Exception e) {
            System.out.println("Error creating replica datasource " + e.getMessage());

        }

        return dataSource;
    }


    /**
     * Method to set master and replica datasource, This is the primary datasource
     * If Service datasource is Primary bean need to remove @Primary from service.
     * @param masterDataSource
     * @param replicaDataSource
     * @return
     */

    @Primary
    @Bean(name = "routingDataSource")
    public DataSource getRoutingDataSource(@Qualifier("dataSource") DataSource masterDataSource, @Qualifier("replicaDataSource") DataSource replicaDataSource) {

        if (masterDataSource == null) {
            System.out.println("Master datasource is not set");
        }


        if(replicaDataSource == null) {
            System.out.println("Replicadatasource not exist, Can't continue with routing logic");
            replicaDataSource = masterDataSource;
        }

        final RoutingDataSource routingDataSource = new RoutingDataSource();

        final Map<Object, Object> targetDataSources = new HashMap<>();
        targetDataSources.put(RoutingDataSource.Route.PRIMARY, masterDataSource);
        targetDataSources.put(RoutingDataSource.Route.REPLICA, replicaDataSource);

        routingDataSource.setTargetDataSources(targetDataSources);
        routingDataSource.setDefaultTargetDataSource(masterDataSource);

        System.out.println("Added master and replica datasource to Routing DataSource");
        return routingDataSource;
    }

}

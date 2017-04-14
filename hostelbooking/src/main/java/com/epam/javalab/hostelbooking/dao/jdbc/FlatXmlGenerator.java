package com.epam.javalab.hostelbooking.dao.jdbc;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.dbunit.DatabaseUnitException;
import org.dbunit.database.DatabaseConnection;
import org.dbunit.database.IDatabaseConnection;
import org.dbunit.dataset.IDataSet;
import org.dbunit.dataset.xml.FlatXmlDataSet;

import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class FlatXmlGenerator {
    private static final Logger logger = LogManager.getLogger();
    private static final String DATABASE_BUNDLE = "properties.db";
    private static final String DATABASE_DRIVER = "jdbc.driverClassName";
    private static final String DATABASE_URL = "jdbc.url";
    private static final String DATABASE_USERNAME = "jdbc.username";
    private static final String DATABASE_PASSWORD = "jdbc.password";
    private static final String DATABASE_SCHEMA = "jdbc.schema";

    public void generateXmlData() {

        ResourceBundle resourceBundle = ResourceBundle.getBundle(DATABASE_BUNDLE);
        try {
            Class.forName(resourceBundle.getString(DATABASE_DRIVER));
            Connection connection = DriverManager.getConnection(resourceBundle.getString(DATABASE_URL),
                    resourceBundle.getString(DATABASE_USERNAME), resourceBundle.getString(DATABASE_PASSWORD));
            IDatabaseConnection databaseConnection = new DatabaseConnection(connection, DATABASE_SCHEMA);


            IDataSet dataSet = databaseConnection.createDataSet();
            FlatXmlDataSet.write(dataSet, new FileOutputStream("full.xml"));
        } catch (SQLException | IOException | ClassNotFoundException | DatabaseUnitException e) {
            logger.error(e);
        }
    }
}

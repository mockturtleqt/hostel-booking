package com.epam.javalab.hostelbooking;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.dbunit.DBTestCase;
import org.dbunit.PropertiesBasedJdbcDatabaseTester;
import org.dbunit.dataset.IDataSet;
import org.dbunit.dataset.xml.FlatXmlDataSet;
import org.dbunit.dataset.xml.FlatXmlDataSetBuilder;

import java.io.FileInputStream;
import java.util.ResourceBundle;

public class SampleDbTest extends DBTestCase {
    private static final Logger logger = LogManager.getLogger();
    private static final String DATABASE_BUNDLE = "testdb";
    private static final String DATABASE_DRIVER = "jdbc.driverClassName";
    private static final String DATABASE_URL = "jdbc.url";
    private static final String DATABASE_USERNAME = "jdbc.username";
    private static final String DATABASE_PASSWORD = "jdbc.password";
    private static final String DATABASE_SCHEMA = "jdbc.schema";

    private final ResourceBundle resourceBundle = ResourceBundle.getBundle(DATABASE_BUNDLE);

    public SampleDbTest(String name) {
        super(name);
        System.setProperty(PropertiesBasedJdbcDatabaseTester.DBUNIT_DRIVER_CLASS, resourceBundle.getString(DATABASE_DRIVER));
        System.setProperty(PropertiesBasedJdbcDatabaseTester.DBUNIT_CONNECTION_URL, DATABASE_URL);
        System.setProperty(PropertiesBasedJdbcDatabaseTester.DBUNIT_USERNAME, DATABASE_USERNAME);
        System.setProperty(PropertiesBasedJdbcDatabaseTester.DBUNIT_PASSWORD, DATABASE_PASSWORD);
        System.setProperty(PropertiesBasedJdbcDatabaseTester.DBUNIT_SCHEMA, DATABASE_SCHEMA);
    }

    @Override
    protected IDataSet getDataSet() throws Exception {
        return new FlatXmlDataSetBuilder().build(new FileInputStream("full.xml"));
    }
}

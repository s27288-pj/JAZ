package com.jaz2.figurines.Dictionary;

import java.sql.Connection;
import java.sql.SQLException;
import javax.sql.DataSource;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;
import org.springframework.beans.factory.annotation.Autowired;

@Component
public class DictionaryValidator implements ConstraintValidator<Dictionary, String>, ApplicationContextAware {

    private static ApplicationContext applicationContext;
    private String dictionaryName;
    Connection sqlConnection;

    @SuppressWarnings("null")
    @Override
    public void setApplicationContext(ApplicationContext applicationContext) {
        DictionaryValidator.applicationContext = applicationContext;
    }

    @Override
    public void initialize(Dictionary constraintAnnotation) {
        this.dictionaryName = constraintAnnotation.value();
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        if (value == null) {
            return true;
        }
        try {
            DataSource dataSource = applicationContext.getBean(DataSource.class);
            sqlConnection = dataSource.getConnection();
            var sqlQuery = sqlConnection.prepareStatement("SELECT VALUE_NAME FROM DICTIONARY_ENTITY WHERE DICTIONARY_NAME = ?");
            sqlQuery.setString(1, dictionaryName);
            var resultSet = sqlQuery.executeQuery();
            while (resultSet.next()) {
                System.out.println(resultSet.getString("VALUE_NAME"));
                if (resultSet.getString("VALUE_NAME").equals(value)) {
                    return true;
                }
            }
            return false;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}

package com.crudmysql.model;

import java.util.Properties;

public class GameDao {
    try {
        Properties props = new Properties();
        props.load(getClass().getClassLoader.getResourceAsStream("db.properties"));
    }
}

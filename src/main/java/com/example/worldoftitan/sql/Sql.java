package com.example.worldoftitan.sql;

import com.example.worldoftitan.Character;
import java.sql.*;
import java.util.LinkedList;

public class Sql {
    private Connection connection;

    public Sql() {
        connection = SqlConnector.getConnection();
    }


    public void createCharacterTableIfNotExist() {
        try {
            tryToCreateCharacterTable();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void tryToCreateCharacterTable() throws SQLException {
        if (!isTableExists("character_info")) {
            String command = "CREATE TABLE character_info (\n" +
                    "  id INT NOT NULL AUTO_INCREMENT,\n" +
                    "  name VARCHAR(45) NOT NULL,\n" +
                    "  height INT NOT NULL,\n" +
                    "  weight INT NOT NULL,\n" +
                    "  strength INT NOT NULL,\n" +
                    "  agility INT NOT NULL,\n" +
                    "  intelligence INT NOT NULL,\n" +
                    "  coordination INT NOT NULL,\n" +
                    "  leadership INT NOT NULL,\n" +
                    "  image VARCHAR(1000) NOT NULL,\n" +
                    "  PRIMARY KEY (id),\n" +
                    "  UNIQUE INDEX name_UNIQUE (name ASC) VISIBLE)";
            Statement statement = connection.createStatement();
            statement.execute(command);
        }
    }

    private boolean isTableExists(String tableName) throws SQLException {
        DatabaseMetaData databaseMetaData = connection.getMetaData();
        ResultSet resultSet = databaseMetaData.getTables(null, null, tableName, new String[] {"TABLE"});
        return resultSet.next();
    }

    public void saveCharacter(Character character) {
        try {
            tryToSaveCharacter(character);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void tryToSaveCharacter(Character character) throws SQLException {
        Statement statement = connection.createStatement();
        String command = String.format("INSERT INTO character_info " +
                        "(name, height, weight, strength, agility, intelligence, coordination, leadership, image)" +
                        "VALUES (\'%s\', %d, %d, %d, %d, %d, %d, %d, \'%s\')", character.getName(), character.getHeight(),
                character.getWeight(), character.getStrength(), character.getAgility(),
                character.getIntelligence(), character.getCoordination(),
                character.getLeadership(), character.getImagePath());
        statement.execute(command);
    }

    public LinkedList<Character> getAllCharacter() {
        LinkedList<Character> characters = new LinkedList<>();
        try {
            tryToGetAllCharacter(characters);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return characters;
    }

    private void tryToGetAllCharacter(LinkedList<Character> characters) throws SQLException {
        Statement statement = connection.createStatement();
        String command = "SELECT * FROM character_info";
        ResultSet resultSet = statement.executeQuery(command);
        while (resultSet.next()) {
            String name = resultSet.getString("name");
            int height = resultSet.getInt("height");
            int weight = resultSet.getInt("weight");
            int strength = resultSet.getInt("strength");
            int agility = resultSet.getInt("agility");
            int intelligence = resultSet.getInt("intelligence");
            int coordination = resultSet.getInt("coordination");
            int leadership = resultSet.getInt("leadership");
            String imagePath = resultSet.getString("image");
            characters.add(new Character(name, height, weight, strength,
                    agility, intelligence, coordination, leadership, imagePath));
        }
    }

    public void removeCharacter(String name) {
        try {
            tryToRemoveCharacter(name);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void tryToRemoveCharacter(String name) throws SQLException {
        Statement statement = connection.createStatement();
        String command = String.format("DELETE FROM character_info WHERE name = \'%s\'", name);
        statement.execute(command);
    }
}

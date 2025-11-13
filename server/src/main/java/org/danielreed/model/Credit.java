package org.danielreed.model;

public class Credit {

    private int personId;
    private String name;
    private String creditRole;
    private String characterName;

    public Credit() { }

    public Credit(int personId, String name, String creditRole, String characterName) {
        this.personId = personId;
        this.name = name;
        this.creditRole = creditRole;
        this.characterName = characterName;
    }

    public int getPersonId() {
        return personId;
    }

    public void setPersonId(int personId) {
        this.personId = personId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCreditRole() {
        return creditRole;
    }

    public void setCreditRole(String creditRole) {
        this.creditRole = creditRole;
    }

    public String getCharacterName() {
        return characterName;
    }

    public void setCharacterName(String characterName) {
        this.characterName = characterName;
    }
}

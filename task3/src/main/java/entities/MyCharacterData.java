package entities;

import org.passay.CharacterData;

public enum MyCharacterData implements CharacterData {
    LowerCase("INSUFFICIENT_LOWERCASE", "abcdefghijklmnopqrstuvwxyz"),
    UpperCase("INSUFFICIENT_UPPERCASE", "ABCDEFGHIJKLMNOPQRSTUVWXYZ"),
    Digit("INSUFFICIENT_DIGIT", "0123456789"),
    Special("INSUFFICIENT_SPECIAL", "!%*");

    private final String errorCode;
    private final String characters;

    MyCharacterData(String code, String charString) {
        this.errorCode = code;
        this.characters = charString;
    }

    public String getErrorCode() {
        return this.errorCode;
    }

    public String getCharacters() {
        return this.characters;
    }
}

import entities.MyCharacterData;
import org.passay.CharacterData;
import org.passay.CharacterRule;
import org.passay.PasswordGenerator;

import java.util.ArrayList;
import java.util.List;

public class PasswordBuilder {
    private PasswordGenerator generator = new PasswordGenerator();
    private List<CharacterRule> rules = new ArrayList<>();

    public PasswordBuilder setDigitsRule(int length) {
        return addRule(MyCharacterData.Digit, length);
    }

    public PasswordBuilder setLowerCaseCharsRule(int length) {
        return addRule(MyCharacterData.LowerCase, length);
    }

    public PasswordBuilder setUpperCaseCharsRule(int length) {
        return addRule(MyCharacterData.UpperCase, length);
    }

    public PasswordBuilder setSpecialCharsRule(int length) {
        return addRule(MyCharacterData.Special, length);
    }

    public String generate(int length) {
        return generator.generatePassword(length, rules);
    }

    private PasswordBuilder addRule(CharacterData characterData, int length) {
        rules.add(new CharacterRule(characterData, length));
        return this;
    }
}

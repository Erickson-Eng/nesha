package app.nesha.backend.models.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ExpenseType {

    FIXED("FIXED"),
    OCCASIONAL("OCCASIONAL"),
    EMERGENCY("EMERGENCY");

    private final String code;

    public static ExpenseType getEnumByCode(String code) {
        for (ExpenseType value : ExpenseType.values()) {
            if (value.getCode().equalsIgnoreCase(code))
                return value;
        }
        throw new IllegalArgumentException("Invalid code");
    }
}

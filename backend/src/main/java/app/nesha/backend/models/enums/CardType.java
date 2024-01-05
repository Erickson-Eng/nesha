package app.nesha.backend.models.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum CardType {

    CREDIT("CREDIT"),
    DEBIT("DEBIT"),
    PREPAID("PREPAID");

    private final String code;

    public static CardType getEnumByCode(String code){
        for (CardType value : CardType.values()) {
            if (value.getCode().equalsIgnoreCase(code))
                return value;
        }
        throw new IllegalArgumentException("Invalid code");
    }
}

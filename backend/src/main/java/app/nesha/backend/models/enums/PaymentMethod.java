package app.nesha.backend.models.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum PaymentMethod {

    CASH ("CASH"),
    CREDIT_CARD ("CREDIT_CARD"),
    DEBIT_CARD ("DEBIT_CARD");

    private final String code;

    public static PaymentMethod getEnumByCode(String code){
        for (PaymentMethod value : PaymentMethod.values()) {
            if (value.getCode().equalsIgnoreCase(code))
                return value;
        }
        throw new IllegalArgumentException("Invalid code");
    }

}

package app.nesha.backend.models;

import app.nesha.backend.models.enums.PaymentMethod;
import jakarta.persistence.Embeddable;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Data;

@Data
@Embeddable
public class PaymentDetails {


    @Enumerated(value = EnumType.STRING)
    private PaymentMethod paymentMethod;
    private Boolean installment;
    private Integer numberOfInstallments;
}

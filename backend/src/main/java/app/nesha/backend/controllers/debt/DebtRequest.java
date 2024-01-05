package app.nesha.backend.controllers.debt;

import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

public record DebtRequest(@NotNull Double amount,
                          @NotNull Long profileId,
                          Long cardId,
                          LocalDate expenseDate,
                          String expenseType,
                          String paymentMethod,
                          Boolean installment,
                          Integer numberOfInstallments) {
}

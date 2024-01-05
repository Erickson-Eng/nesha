package app.nesha.backend.controllers.debt;

import app.nesha.backend.models.enums.ExpenseType;
import app.nesha.backend.models.enums.PaymentMethod;

import java.time.LocalDate;

public record DebtResponse(Long id, Double amount, LocalDate expenseDate, ExpenseType expenseType,
                           PaymentMethod paymentMethod, Boolean installment, Integer numberOfInstallments, Long profileId, Long cardId) {
}

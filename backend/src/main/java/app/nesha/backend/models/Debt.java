package app.nesha.backend.models;

import app.nesha.backend.models.enums.ExpenseType;
import app.nesha.backend.models.enums.PaymentMethod;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "debt")
public class Debt implements Serializable {

    @Serial
    private static final long serialVersionUID = 213141324760896930L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;
    private Double amount;
    private LocalDate expenseDate;
    @Enumerated(value = EnumType.STRING)
    private ExpenseType expenseType;

    @ManyToOne(cascade = CascadeType.REFRESH)
    @JoinColumn(name = "card_id")
    private Card card;

    @OneToOne(cascade = CascadeType.REFRESH)
    private Profile profile;

}
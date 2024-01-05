package app.nesha.backend.models;

import app.nesha.backend.models.enums.CardType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serial;
import java.io.Serializable;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "card")
public class Card implements Serializable {

    @Serial
    private static final long serialVersionUID = 213141336760896930L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(length = 15)
    private String surname;
    @Column(length = 19)
    private String cardNumber;

    @Enumerated(value = EnumType.STRING)
    private CardType cardType;

    @Column(length = 2)
    private Integer payDay;

    @Column(length = 2)
    private Integer closingDay;

    @OneToMany(mappedBy = "card")
    private List<Debt> debtList;

    @ManyToOne(cascade = {CascadeType.REFRESH})
    private Profile profile;

}
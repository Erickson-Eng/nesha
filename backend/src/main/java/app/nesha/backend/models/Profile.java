package app.nesha.backend.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serial;
import java.io.Serializable;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "profile")
public class Profile implements Serializable {

    @Serial
    private static final long serialVersionUID = 6110537891662558145L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    private Double contractualSalary;

    private Double financialGoal;

    @OneToOne(cascade = CascadeType.REFRESH, optional = false)
    @JoinColumn(name = "user_id")
    private User user;

    @OneToMany(mappedBy = "profile")
    private List<Card> cardList;

}
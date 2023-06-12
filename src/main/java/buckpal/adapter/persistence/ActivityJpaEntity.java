package buckpal.adapter.persistence;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "activity")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ActivityJpaEntity {
  @Id
  @GeneratedValue
  private Long id;

  @Column private LocalDateTime timestamp;
  @Column private long ownerAccountId;
  @Column private long sourceAccountId;
  @Column private long targetAccountId;
  @Column private long amount;

}

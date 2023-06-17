package buckpal;

import buckpal.adapter.out.persistence.AccountPersistenceAdapter;
import buckpal.adapter.persistence.ActivityJpaEntity;
import buckpal.adapter.persistence.ActivityRepository;
import buckpal.domain.Account;
import java.time.LocalDateTime;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.jdbc.Sql;

@DataJpaTest
@Import({AccountPersistenceAdapter.class, AccountMapper.class})
public class AccountPersistenceAdapterTest {

  @Autowired
  private AccountPersistenceAdapter adapter;

  @Autowired
  private ActivityRepository activityRepository;

  @Test
  @Sql("AccountPersistenceAdapterTest.sql")
  void loadsAccount() {
    Account account = adapter.loadAccount(
        new AccountId(1L),
        LocalDateTime.of(2018, 8, 10, 0, 0));

    assertThat(account.getActivityWindow().getActivities()).hasSize(2);
    assertThat(account.calculateBalance().isEqualTo(Money.of(500)));
  }

  @Test
  void updatesActivities() {
    Account account = defaultAccount()
        .withBaseLineBalance(Money.of(555L))
        .withActivityWindow(new ActivityWindow(
            defaultActivity()
                .withId(null)
                .withMoney(Money.of(1L).build()))
            .build();
    adapter.updateActivities(account);

    assertThat(activityRepository.count()).isEqualTo(1);

    ActivityJpaEntity savedActivity = activityRepository.findAll().get(0);
    assertThat(savedActivity.getAmount()).isEqualTo(1L);


        ))

  }
}

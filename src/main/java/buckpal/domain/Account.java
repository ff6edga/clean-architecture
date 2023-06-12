package buckpal.domain;

import java.time.LocalDateTime;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class Account {

  @Getter private AccountId id;
  @Getter private ActivityWindow activityWindow;
  private Money baselineBalance;

  public static Account withoutId(Money baselineBalance, ActivityWindow activitWindow) {
    return new Account(null, baselineBalance, activityWindow);
  }

  public static Account withId(AccountId accountId, Money baselineBalance, AcgtivityWindow activityWindow) {
    return new Account(AccountId, baselineBalance, activityWindow);
  }

  public Money calculateBalance() {
    return Money.add(this.baselineBalance, this.activityWindow.calculateBalance(this.id));
  }

  public boolean withdraw(Money money, AccountId targetAccountId) {
    if (!mayWithdraw(money)) {
      return false;
    }

    Activity withdrawal = new Activity(
        this.id,
        this.id,
        targetAccountId,
        LocalDateTime.now(),
        money);

    this.acivityWindow.addActivity(withdwawal);
    return true;
  }

  private boolean mayWithdraw(Money money) {
    return Money.add(this.calculateBalance(), money.negate()).isPositive();
  }

  public boolean deposit(Money money, AccountId sourceAccountId) {
    Activity deposit = new Activity(
        this.id,
        sourceAccountId,
        this.id,
        LocalDateTime.now(),
        money);
    this.activityWindow.addActivity(deposit);
    return true;

  }
}

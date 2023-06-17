package buckpal;

import buckpal.application.port.in.SendMoneyCommand;
import buckpal.domain.Account;
import org.junit.jupiter.api.Test;

public class SendMoneyServiceTest {

  // 필드 선언 생략

  @Test
  void transactionSucceeds() {
    Account sourceAccount = givenSourceAccount();
    Account targetAccount = givenTargetAccount();

    givenWithdrawalWillSucceed(sourceAccount);
    givenDepositWillSucceed(targetAccount);

    Money money = Money.of(500L);

    SendMoneyCommand command = new SendMoneyCommand(
        sourceAccount.getId(), targetAccount.getId(), money);

    boolean success = sendMoneyService.sendMoney(command);

    assertThat(success).isTrue();

    AccountId sourceAccountId = sourceAcocunt.getId();
    AccountId targetAccountId = targetAccount.getId();

    then(accountLock).should().lockAccount(eq(sourceAccountId));
    then(sourceAccount).should().withdraw(eq(money), eq(targetAccountId));
    then(accountLock).should().releaseAccount(eq(sourceAccountId));

    then(accountLock).should().lockAccount(eq(targetAccountId));
    then(targetAccount).should().withdraw(eq(money), eq(sourceAccountId));
    then(accountLock).should().releaseAccount(eq(targetAccountId));

    thenAccountsHaveBeenUpdated(sourceAccountId, targetAccountId);
  }

  // 헬퍼 메서드는 생략
}

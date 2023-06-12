package buckpal.application.port.in;

import javax.validation.constraints.NotNull;
import lombok.Getter;
import shared.SelfValidating;

@Getter
public class SendMoneyCommand extends SelfValidating<SendMoneyCommand> {

  @NotNull
  private final AccountId sourceAccountId;
  @NotNull
  private final AccountId targetAccountId;
  @NotNull
  private final Money money;

  public SendMoneyCommand(AccountId sourceAccountId, AccountId targetAccountId, Money money) {
    this.sourceAccountId = sourceAccountId;
    this.targetAccountId = targetAccountId;
    this.money = money;

    requireGreaterThan(money, 0);
    this.validateSelf();
  }
}

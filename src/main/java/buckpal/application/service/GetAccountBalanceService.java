package buckpal.application.service;

import buckpal.application.port.in.GetAccountBalanceQuery;
import buckpal.application.port.out.LoadAccountPort;
import java.time.LocalDateTime;

public class GetAccountBalanceService implements GetAccountBalanceQuery {
  private final LoadAccountPort loadAccountPort;

  @Override
  public Money getAccountBalange(AccountId accountId) {
    return loadAccountPort.loadAccount(accountId, LocalDateTime.now()).calculateBalance();

  }

}

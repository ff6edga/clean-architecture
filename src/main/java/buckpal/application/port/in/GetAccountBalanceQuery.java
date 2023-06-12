package buckpal.application.port.in;

public interface GetAccountBalanceQuery {
  Money getAccountBalange(AccountId accountId);
}

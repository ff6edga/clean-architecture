package buckpal.adapter.in.web;

import buckpal.application.port.in.GetAccountBalanceQuery;
import buckpal.application.port.in.SendMoneyUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class AccountController {

  private final GetAccountBalanceQuery getAccountBalanceQuery;
  private final ListAccountQuery listAccountsQuery;
  private final LoadAccountQuery loadAccountQuery;

  private final SendMoneyUseCase sendMoneyUseCase;
  private final CreateAccountUseCase createAccountUseCase;

  @GetMapping("/accounts")
  List<AccountResource> listAccounts() {

  }

  @GetMapping("/accounts/{accountId}")
  AccountResource getAccount(@PathVariable("accountId") Long accountId) {

  }

  @GetMapping("/accounts/{accountId}/balance")
  long getAccountBalance(@PathVariable("accountId") Long accountId) {

  }

  @PostMapping("/accounts")
  AccountResource createAccount(@RequestBody AccountResource account) {

  }

  @PostMapping("/accounts/send/{sourceAccountId}/{targetAccountId}/{amount}")
  void sendMoney(
      @PathVariable("sourceAccountId") Long sourceAccountId,
      @PathVariable("targetAccountId") Long targetAccountId,
      @PathVariable("amount") Long amount) {

  }
}

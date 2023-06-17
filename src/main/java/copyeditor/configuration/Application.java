package copyeditor.configuration;

import buckpal.adapter.in.web.SendMoneyController;
import buckpal.adapter.out.persistence.AccountPersistenceAdapter;
import buckpal.adapter.out.persistence.AccountRepository;
import buckpal.adapter.persistence.ActivityRepository;
import buckpal.application.port.in.SendMoneyUseCase;

public class Application {
  public static void main(String[] args) {
    AccountRepository accountRepository = new AccountRepository();
    ActivityRepository activityRepository = new ActivityRepository();

    AccountPersistenceAdapter accountPersistenceAdapter =
        new AccountPersistenceAdapter(accountRepository, activityRepository);

    SendMoneyUseCase sendMoneyUseCase =
        new SendMoneyUseService(
            accountPersistenceAdapter, // LoadAccountPort
            accountPersistenceAdapter); // UpdateAccountStatePort

    SendMoneyController sendMoneyController =
        new SendMoneyController(sendMoneyUseCase);

    SendMoneyController sendMoneyController =
        new SendMoneyController(sendMoneyUseCase);

    startProcessingWebRequests(sendMoneyController);

  }

}

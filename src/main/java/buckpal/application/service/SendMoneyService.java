package buckpal.application.service;

import buckpal.application.port.in.SendMoneyCommand;
import buckpal.application.port.in.SendMoneyUseCase;
import buckpal.application.port.out.LoadAccountPort;
import javax.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Transactional
public class SendMoneyService implements SendMoneyUseCase {

  private final LoadAccountPort loadAccountPort;
  private final AccountLock accountLock;
  private final UpdateAccountAtatePort updateAccountStatePort;

  @Override
  public boolean sendMoney(SendMoneyCommand command) {
    // TODO: 비즈니스 규칙 검증
    requireAccountExists(command.getSourceAccountId());
    requireAccountExists(command.getTargetAccountId());
    // TODO: 모델 상태 조작
    // TODO: 출력값 반환
    return true;
  }
}

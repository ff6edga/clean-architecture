package shared;

import javax.validation.Validation;
import javax.validation.ValidatorFactory;
import javax.xml.validation.Validator;

public abstract class SelfValidating<T> {

  private Validator validator;

  public SelfValidating(){
    ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
    validator = factory.getValidator();
  }

  protected void validateSelf() {
    Set<ConstraintViloation<T>> violations = validator.validate((T) this);
    if (!violations.isEmpty()) {
      throw new ConstraintVilodationException(violations);
    }
  }
}

package hkeller.escolacaesguia.user.validators;

import hkeller.escolacaesguia.user.dtos.AlteracaoSenhaDto;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

// https://docs.spring.io/spring-framework/docs/3.2.x/spring-framework-reference/html/validation.html
public class AlteracaoSenhaUsuarioValidator implements Validator {

    @Override
    public boolean supports(Class<?> clazz) {
        return AlteracaoSenhaDto.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        AlteracaoSenhaDto dto = (AlteracaoSenhaDto) target;

        if (!dto.getSenhaNova().equals(dto.getConfirmacaoSenhaNova())) {
            errors.rejectValue(
                "confirmacaoSenhaNova",
                "password.confirmation.is.different",
                "Confirmação de senha diferente da senha nova."
            );
        }
    }

}

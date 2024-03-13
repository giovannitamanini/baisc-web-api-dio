package dio.web.api.handler;

public class MandatoryFieldException extends BusinessException {

    public MandatoryFieldException(String campo) {
        super("O campo %s é obrigatório", campo);
    }
}

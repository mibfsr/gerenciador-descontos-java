package exceptions;

public class ListaDeProdutosVaziaException extends RuntimeException {
    public ListaDeProdutosVaziaException(String message) {
        super(message);
    }
}

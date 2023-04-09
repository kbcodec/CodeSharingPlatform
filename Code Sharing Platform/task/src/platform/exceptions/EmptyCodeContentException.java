package platform.exceptions;

public final class EmptyCodeContentException extends CustomException{
    public EmptyCodeContentException() {
        super("Code content is empty.");
    }
}

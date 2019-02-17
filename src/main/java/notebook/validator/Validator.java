package notebook.validator;

public interface Validator<T> {
    boolean validateValue(T value);

    boolean isObligatoryField();
}

package notebook;

public interface Patterns {

    String stringRegex = "^[a-zA-Zа-яА-ЯїЇєЄіІ\\,\\.\\- `']+";
    String regexPhoneNumber = "^((8|\\+3)[\\- ]?)?(\\(?\\d{3}\\)?[\\- ]?)?[\\d\\- ]{7,10}$";
    String regexStringNumber = "([A-Za-zа-яА-ЯїЇєЄіІ0-9\\,\\.\\- `']+)";
    String regexEmail = "\\w+@[a-zA-Z]+?\\.[a-zA-Z]{2,6}";
    String regexNumber = "([0-9]+)";

}

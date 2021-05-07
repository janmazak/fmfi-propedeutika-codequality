public class IllegalInputException extends Exception {
    @Override
    public String getMessage() {
        return "Nesprávny formát vstupu.";
    }
}

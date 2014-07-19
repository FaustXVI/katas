public class TranslationContext {
    private String operand;

    private String oldOperand;

    public TranslationContext(String operand) {
        this.operand = operand;
    }

    public void startTranslation() {
        oldOperand = operand;
    }

    public void endTranslation() {
        if (operand.equals(oldOperand)) {
            throw new IllegalArgumentException("Invalid character");
        }
    }

    public int check(String romanString, Integer value) {
        if (operand.startsWith(romanString)) {
            operand = operand.substring(romanString.length());
            return value;
        }
        return 0;
    }

    public boolean isValid() {
        return operand != null && !operand.isEmpty();
    }
}

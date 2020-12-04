package DesignPattern;

public class InterpreterPattern {
    public static void main(String[] args) {
        Context3 c = new Context3("123abc");
        int n = c.getS().length();
        AbstractExpression e = new TerminalExpression();
        while (n-- != 0) {
            e.interpret(c);
        }
    }
}

class Context3 {
    private String s;
    private int i;

    public String getS() {
        return s;
    }

    public void setI(int i) {
        this.i = i;
    }

    public int getI() {
        return i;
    }

    public Context3(String s) {
        this.s = s;
        i = 0;
    }
}

abstract class AbstractExpression {
    abstract void interpret(Context3 c);
}

class TerminalExpression extends AbstractExpression {

    @Override
    void interpret(Context3 c) {
        String s = c.getS();
        int i = c.getI();
        if (i >= s.length()) return;
        char cur = s.charAt(i);
        if (Character.isDigit(cur)) System.out.print("digit ");
        if (Character.isLetter(cur)) System.out.print("letter ");
        c.setI(i + 1);
    }
}

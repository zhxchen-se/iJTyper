/* Date: 1/19/17
URL: http://stackoverflow.com/questions/3422673/evaluating-a-math-expression-given-in-string-formy
 */
public class Class_8 {
    public static double eval(final java.lang.String str) {
        return new java.lang.Object() {
            int pos = -1;

            int ch;

            void nextChar() {
                ch = ((++pos) < str.length()) ? str.charAt(pos) : -1;
            }

            boolean eat(int charToEat) {
                while (ch == ' ') {
                    nextChar();
                } 
                if (ch == charToEat) {
                    nextChar();
                    return true;
                }
                return false;
            }

            double parse() {
                nextChar();
                double x = parseExpression();
                if (pos < str.length()) {
                    throw new java.lang.RuntimeException("Unexpected: " + ((char) (ch)));
                }
                return x;
            }

            // Grammar:
            // expression = term | expression `+` term | expression `-` term
            // term = factor | term `*` factor | term `/` factor
            // factor = `+` factor | `-` factor | `(` expression `)`
            // | number | functionName factor | factor `^` factor
            double parseExpression() {
                double x = parseTerm();
                for (; ;) {
                    if (eat('+')) {
                        x += parseTerm();
                    } else if (eat('-')) {
                        x -= parseTerm();
                    } else // subtraction
                    {
                        return x;
                    }
                }
            }

            double parseTerm() {
                double x = parseFactor();
                for (; ;) {
                    if (eat('*')) {
                        x *= parseFactor();
                    } else if (eat('/')) {
                        x /= parseFactor();
                    } else // division
                    {
                        return x;
                    }
                }
            }

            double parseFactor() {
                if (eat('+')) {
                    return parseFactor();
                }// unary plus

                if (eat('-')) {
                    return -parseFactor();
                }// unary minus

                double x;
                int startPos = this.pos;
                if (eat('(')) {
                    // parentheses
                    x = parseExpression();
                    eat(')');
                } else if (((ch >= '0') && (ch <= '9')) || (ch == '.')) {
                    // numbers
                    while (((ch >= '0') && (ch <= '9')) || (ch == '.')) {
                        nextChar();
                    } 
                    x = java.lang.Double.parseDouble(str.substring(startPos, this.pos));
                } else if ((ch >= 'a') && (ch <= 'z')) {
                    // functions
                    while ((ch >= 'a') && (ch <= 'z')) {
                        nextChar();
                    } 
                    java.lang.String func = str.substring(startPos, this.pos);
                    x = parseFactor();
                    if (func.equals("sqrt")) {
                        x = java.lang.Math.sqrt(x);
                    } else if (func.equals("sin")) {
                        x = java.lang.Math.sin(java.lang.Math.toRadians(x));
                    } else if (func.equals("cos")) {
                        x = java.lang.Math.cos(java.lang.Math.toRadians(x));
                    } else if (func.equals("tan")) {
                        x = java.lang.Math.tan(java.lang.Math.toRadians(x));
                    } else {
                        throw new java.lang.RuntimeException("Unknown function: " + func);
                    }
                } else {
                    throw new java.lang.RuntimeException("Unexpected: " + ((char) (ch)));
                }
                if (eat('^')) {
                    x = java.lang.Math.pow(x, parseFactor());
                }// exponentiation

                return x;
            }
        }.parse();
    }
}


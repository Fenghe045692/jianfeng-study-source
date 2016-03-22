package com.jianfeng.algorithm.jiuzhang;

import java.util.Stack;

public class EvaluateExpression {
	public static double eval(final String str) {
	    class Parser {
	        int pos = -1, c;

	        void eatChar() {
	            c = (++pos < str.length()) ? str.charAt(pos) : -1;
	        }

	        void eatSpace() {
	            while (Character.isWhitespace(c)) eatChar();
	        }

	        double parse() {
	            eatChar();
	            double v = parseExpression();
	            if (c != -1) throw new RuntimeException("Unexpected: " + (char)c);
	            return v;
	        }

	        // Grammar:
	        // expression = term | expression `+` term | expression `-` term
	        // term = factor | term `*` factor | term `/` factor | term brackets
	        // factor = brackets | number | factor `^` factor
	        // brackets = `(` expression `)`

	        double parseExpression() {
	            double v = parseTerm();
	            for (;;) {
	                eatSpace();
	                if (c == '+') { // addition
	                    eatChar();
	                    v += parseTerm();
	                } else if (c == '-') { // subtraction
	                    eatChar();
	                    v -= parseTerm();
	                } else {
	                    return v;
	                }
	            }
	        }

	        double parseTerm() {
	            double v = parseFactor();
	            for (;;) {
	                eatSpace();
	                if (c == '/') { // division
	                    eatChar();
	                    v /= parseFactor();
	                } else if (c == '*' || c == '(') { // multiplication
	                    if (c == '*') eatChar();
	                    v *= parseFactor();
	                } else {
	                    return v;
	                }
	            }
	        }

	        double parseFactor() {
	            double v;
	            boolean negate = false;
	            eatSpace();
	            if (c == '+' || c == '-') { // unary plus & minus
	                negate = c == '-';
	                eatChar();
	                eatSpace();
	            }
	            if (c == '(') { // brackets
	                eatChar();
	                v = parseExpression();
	                if (c == ')') eatChar();
	            } else { // numbers
	                StringBuilder sb = new StringBuilder();
	                while ((c >= '0' && c <= '9') || c == '.') {
	                    sb.append((char)c);
	                    eatChar();
	                }
	                if (sb.length() == 0) throw new RuntimeException("Unexpected: " + (char)c);
	                v = Double.parseDouble(sb.toString());
	            }
	            eatSpace();
	            if (c == '^') { // exponentiation
	                eatChar();
	                v = Math.pow(v, parseFactor());
	            }
	            if (negate) v = -v; // unary minus is applied after exponentiation; e.g. -3^2=-9
	            return v;
	        }
	    }
	    return new Parser().parse();
	}
	
	public static double evalStack(final String expression){
		class Parser {
			Stack<Integer> values = new Stack<Integer>();
			Stack<Character> ops = new Stack<Character>();
			double parse() {
				for(int i =0; i < expression.length(); i++){
					if(expression.charAt(i) == ' ')
						continue;
					if(expression.charAt(i) <= '9' && expression.charAt(i) >= '0'){
						String number = "";
						while(i < expression.length() && ((expression.charAt(i) <= '9' && expression.charAt(i) >= '0') || 
								expression.charAt(i) == '.'))
							number += expression.charAt(i++);
						values.add(Integer.valueOf(number));
						i--;
					}else if(expression.charAt(i) == '('){
						ops.add(expression.charAt(i));
					}else if(expression.charAt(i) == ')'){
						while(ops.peek() != '(')
							values.add(applyops(ops.pop(), values.pop(), values.pop()));
						ops.pop();
					}else if(expression.charAt(i) == '+' || expression.charAt(i) == '-' ||
							expression.charAt(i) == '*' || expression.charAt(i) == '/'){
						while(!ops.empty() && !hasPrecedence(ops.peek(), expression.charAt(i))){
							values.add(applyops(ops.pop(), values.pop(), values.pop()));
						}
						ops.add(expression.charAt(i));
					}
				}
				while(!ops.empty()){
					values.add(applyops(ops.pop(), values.pop(), values.pop()));
				}
				return values.pop();
			}
			
			boolean hasPrecedence(char op1, char op2)
		    {
		        if (op2 == '(' || op2 == ')')
		            return false;
		        if ((op1 == '*' || op1 == '/') && (op2 == '+' || op2 == '-'))
		            return false;
		        else
		            return true;
		    }
			
			int applyops(char ops, int a, int b){
				switch(ops){
				case '+': 
					return a + b;
				case '-':
		            return a - b;
		        case '*':
		            return a * b;
		        case '/':
		            if (b == 0)
		                throw new
		                UnsupportedOperationException("Cannot divide by zero");
		            return a / b;
		        }
		        return 0;
			}
		}
		return new Parser().parse();
	}
	
	
	
	public static void main(String[] args){
//		System.out.println(eval("(-3.3)"));
//		System.out.println(eval("(-3)/(3)"));
//		System.out.println(eval("100 * ( 2 + 12 ) / 14"));
//		System.out.println(eval("((4))+3"));
//		System.out.println(eval("6+5*(3-2)"));
//		System.out.println(eval("2*((0-2))"));
//		System.out.println(eval("2+-2".toLowerCase()));
		System.out.println(evalStack("100 * ( 2 + 12 ) / 14"));
	}
}

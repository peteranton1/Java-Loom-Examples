package com.example.expr;


public class Expression {

  public static void main(String[] args) {
    /*
    (-2 * 3) + (4 & 5) = -6 + 20 = 14
     */
    Expr expr = new Sum(
      new Prod(new Neg(new Const(2)), new Const(3)),
      new Prod(new Const(4), new Const(5))
      )
      ;
    Expression expression = new Expression();
    System.out.printf("Expr : %s%n", expr);
    System.out.printf("Value: %s%n", expression.eval(expr));
  }

  int eval(Expr e) {
    return switch (e) {
      case Sum(Expr a, Expr b) -> eval(a) + eval(b);
      case Prod(Expr a, Expr b) -> eval(a) * eval(b);
      case Neg(Expr a) -> -eval(a);
      case Const(int i) -> i;
    };
  }
}

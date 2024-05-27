package com.example.expr;

sealed interface Expr { }

record Sum(Expr left, Expr right) implements Expr {}
record Prod(Expr left, Expr right) implements Expr {}
record Neg(Expr e) implements Expr {}
record Const(int c) implements Expr {}


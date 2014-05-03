// Copyright (c) Mark P Jones, Portland State University
// Subject to conditions of distribution and use; see LICENSE for details
// February 3 2008 11:12 AM

package syntax;

import compiler.*;
import codegen.*;
import interp.*;

/** Provides a representation for bitwise and expressions (&amp;).
 */
public final class BitAndExpr extends BitOpExpr {
    public BitAndExpr(Position pos, Expression left, Expression right) {
        super(pos, left, right);
    }

    /** Return a true value to indicate that bitwise and is commutative.
     */ 
    boolean commutes() {
        return true; 
    }   
    
    /** Generate code to evaluate this expression and
     *  leave the result in the specified free variable.
     */ 
    public void compileExpr(Assembly a, int free) {
        compileOp(a, "andl", free);
    }

    /** Evaluate this expression.
     */
    public Value eval(State st) {
        return new IntValue(left.eval(st).getInt() & right.eval(st).getInt());
    }
}

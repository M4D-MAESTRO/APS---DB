
package com.pdv.exception;
/**
 *
 * @author Luís Henrique de C. Corrêa
 */
public class ProdutoInexistenteException extends Exception{
    
    public ProdutoInexistenteException(String msg, Throwable cause){
        super(msg, cause);
    }
}

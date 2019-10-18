
package com.pdv.exception;
/**
 *
 * @author Luís Henrique de C. Corrêa
 */
public class OutOFStockException extends Exception{
    
    public OutOFStockException(String msg, Throwable cause){
        super(msg, cause);
    }
}

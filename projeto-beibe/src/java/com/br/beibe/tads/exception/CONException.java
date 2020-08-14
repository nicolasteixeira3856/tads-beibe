/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.br.beibe.tads.exception;

/**
 *
 * @author nicol
 */
public class CONException extends Exception {

    public CONException() {
    }
    
    public CONException(String string) {
        super(string);
    }
    
    public CONException(String string, Throwable thrwbl) {
        super(string, thrwbl);
    }
}

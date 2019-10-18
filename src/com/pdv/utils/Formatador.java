package com.pdv.utils;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;


/**
 *
 * @author Luís Henrique de C. Corrêa
 */
public class Formatador {

    //Limita o campo de texto a aceitar apenas números e o . "ponto final" como caracter
    public static void formatarCampoNumerico(KeyEvent evt) { //Necessita da passagem de um KeyEvent, recomendo o KeyTyped
        
        String caracteres = "0123456789";
        if (!caracteres.contains(evt.getKeyChar() + "")) {
            evt.consume();
        }
    }

    //Limita o campo de texto a aceitar apenas letras, ou seja, não permitir inserção de números
    public static void formatarCampoLetras(KeyEvent evt) { //Necessita da passagem de um KeyEvent, recomendo o KeyTyped
        String caracteres = "0123456789";
        if (caracteres.contains(evt.getKeyChar() + "")) {
            evt.consume();
        }
    }

}
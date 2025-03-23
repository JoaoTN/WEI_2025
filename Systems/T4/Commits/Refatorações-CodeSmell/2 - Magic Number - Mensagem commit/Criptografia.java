/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ufersa.controlConsult.model.validacao;

/**
 *
 * @author Leonesio
 */
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Criptografia {

    private static MessageDigest md = null;

    static {
        try {
            md = MessageDigest.getInstance("MD5");
        } catch (NoSuchAlgorithmException ex) {
            ex.printStackTrace();
        }
    }

    private static char[] hexCodes(byte[] text) {
        final int hexCharsPerByte = 2;
        char[] hexOutput = new char[text.length * hexCharsPerByte];
        for (int i = 0; i < text.length; i++) {
            String hexString = String.format("%02X", text[i]);
            hexString.getChars(hexString.length() - hexCharsPerByte,
            hexString.length(), hexOutput, i * hexCharsPerByte);
        }
        return hexOutput;
    }

    public static char[] criptografar(char[] password_raw) {
        char[] password_hash = null;
        if (md != null) {
            try {
                byte[] password_raw_bytes = new String(password_raw).getBytes("UTF-8");
                password_hash = new String(hexCodes(md.digest(password_raw_bytes))).toCharArray();
            } catch (UnsupportedEncodingException ex) {
                Logger.getLogger(Criptografia.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return password_hash;
    }
}

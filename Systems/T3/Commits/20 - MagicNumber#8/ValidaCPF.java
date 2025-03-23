/*
MIT License

Copyright (c) 2018 Daniel da Silva Calado, Izaquiel Cavalcante da Silva, 
                   Kaio Cesar Bezerra da Silva e Wemerson Diogenes da Silva

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all
copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
SOFTWARE.
 */
package br.edu.ifpe.petpalacy.util;

import java.util.InputMismatchException;

/**
 *
 * @author Daniel da Silva Calado <danielcalado159@gmail.com>
 */
public class ValidaCPF {

   public static boolean isCPF(String CPF) {
    final String CPF_INVALIDO = "00000000000";
    final int PESO_INICIAL = 10;
    final int PESO_SEGUNDA_PARTE = 11;

    CPF = CPF.replace(".", "");
    CPF = CPF.replace("-", "");

    if (CPF.equals(CPF_INVALIDO) || CPF.length() != 11) {
        return false;
    }

    char dig10, dig11;
    int sm, i, r, num, peso;

    try {
        sm = 0;
        peso = PESO_INICIAL;
        for (i = 0; i < 9; i++) {
            num = (int) (CPF.charAt(i) - '0');
            sm += num * peso;
            peso--;
        }

        r = 11 - (sm % 11);
        if (r == 10 || r == 11) {
            dig10 = '0';
        } else {
            dig10 = (char) (r + '0');
        }

        sm = 0;
        peso = PESO_SEGUNDA_PARTE;
        for (i = 0; i < 10; i++) {
            num = (int) (CPF.charAt(i) - '0');
            sm += num * peso;
            peso--;
        }

        r = 11 - (sm % 11);
        if (r == 10 || r == 11) {
            dig11 = '0';
        } else {
            dig11 = (char) (r + '0');
        }

        return (dig10 == CPF.charAt(9) && dig11 == CPF.charAt(10));
    } catch (InputMismatchException erro) {
        return false;
    }
}

    public static String imprimeCPF(String CPF) {
        return (CPF.substring(0, 3) + "." + CPF.substring(3, 6) + "."
                + CPF.substring(6, 9) + "-" + CPF.substring(9, 11));
    }
}

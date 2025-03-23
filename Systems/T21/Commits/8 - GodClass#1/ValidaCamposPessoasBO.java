package br.sistema.crud.jdbc.bo;

import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.PlainDocument;

public class ValidaCamposPessoasBO extends PlainDocument {

    private static final long serialVersionUID = 5649489410014769260L;

    @Override
    public void insertString(int offset, String str, AttributeSet attr) throws BadLocationException {
        super.insertString(offset, removeNonAlphabeticCharacters(str), attr);
    }

    public void nome(int offset, String str, AttributeSet attr) throws BadLocationException {
        super.insertString(offset, removeNonAlphabeticCharacters(str), attr);
    }

    private String removeNonAlphabeticCharacters(String str) {
        return str.replaceAll("[^a-zA-Z ]", "");
    }
}

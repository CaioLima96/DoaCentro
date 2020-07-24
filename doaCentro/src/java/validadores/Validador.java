/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package validadores;

import java.util.InputMismatchException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author karinaxavier
 */
public class Validador {
      public static boolean isEmailValid(String email) {
        final Pattern EMAIL_REGEX = Pattern.compile("([A-Za-z0-9-_.]+@[A-Za-z0-9-_]+(?:\\.[A-Za-z0-9]+)+)", Pattern.CASE_INSENSITIVE);
        return EMAIL_REGEX.matcher(email).matches();
    }
    
    public static boolean isValidPassword(String password) {
                
                /***
                 * ^ represents starting character of the string.
                   (?=.*[0-9]) represents a digit must occur at least once.
                   (?=.*[a-z]) represents a lower case alphabet must occur at least once.
                   (?=.*[A-Z]) represents an upper case alphabet that must occur at least once.
                   (?=.*[@#$%^&-+=()]) represents a special character that must occur at least once.
                   (?=\\S+$) white spaces don’t allowed in the entire string.
                   .{8, 20} represents at least 8 characters and at most 20 characters.
                   $ represents the end of the string.
                 */

        // Regex to check valid password. 
        String regex = "^(?=.*[0-9])"
                + "(?=.*[a-z])(?=.*[A-Z])"
                + "(?=.\\p{Punct})"
                + "(?=\\S+$).{8,20}$";

        // Compile the ReGex 
        Pattern p = Pattern.compile(regex);

        // If the password is empty 
        // return false 
        if (password == null) {
            return false;
        }

        // Pattern class contains matcher() method 
        // to find matching between given password 
        // and regular expression. 
        Matcher m = p.matcher(password);
        
        // Return if the password 
        // matched the ReGex 
        return m.matches();
    }
    
    public static boolean isValidPhone(String phone){
        String regex = "\\(?\\d{2,3}\\)?\\s?\\d{4,5}-?\\s?\\d{4,5}";

        // Compile the ReGex 
        Pattern p = Pattern.compile(regex);

        // If the password is empty 
        // return false 
        if (phone == null) {
            return false;
        }

        // Pattern class contains matcher() method 
        // to find matching between given password 
        // and regular expression. 
        Matcher m = p.matcher(phone);
        
        // Return if the password 
        // matched the ReGex 
        return m.matches();
        
    }
      public static boolean validaCamposConteudo(String senhaAtual, String senhaNova) throws Exception {

        if (!"".equals(senhaAtual) && senhaNova.trim().isEmpty()) {
            throw new Exception("O campo nova senha não pode ficar vazia se o campo de senha atual tem algo!");
        }

        if (!"".equals(senhaNova) && senhaAtual.trim().isEmpty()) {
            throw new Exception("O campo senha atual não pode ficar vazia se o campo de nova senha tem algo!");
        }

        return !"".equals(senhaAtual) && !"".equals(senhaNova);

    }
      public static boolean isCPF(String CPF) {
        // considera-se erro CPF's formados por uma sequencia de numeros iguais
        if (CPF.equals("00000000000")
                || CPF.equals("11111111111")
                || CPF.equals("22222222222") || CPF.equals("33333333333")
                || CPF.equals("44444444444") || CPF.equals("55555555555")
                || CPF.equals("66666666666") || CPF.equals("77777777777")
                || CPF.equals("88888888888") || CPF.equals("99999999999")
                || (CPF.length() != 11)) {
            return (false);
        }

        char dig10, dig11;
        int sm, i, r, num, peso;

        // "try" - protege o codigo para eventuais erros de conversao de tipo (int)
        try {
            // Calculo do 1o. Digito Verificador
            sm = 0;
            peso = 10;
            for (i = 0; i < 9; i++) {
                // converte o i-esimo caractere do CPF em um numero:
                // por exemplo, transforma o caractere '0' no inteiro 0         
                // (48 eh a posicao de '0' na tabela ASCII)         
                num = (int) (CPF.charAt(i) - 48);
                sm = sm + (num * peso);
                peso = peso - 1;
            }

            r = 11 - (sm % 11);
            if ((r == 10) || (r == 11)) {
                dig10 = '0';
            } else {
                dig10 = (char) (r + 48); // converte no respectivo caractere numerico
            }
            // Calculo do 2o. Digito Verificador
            sm = 0;
            peso = 11;
            for (i = 0; i < 10; i++) {
                num = (int) (CPF.charAt(i) - 48);
                sm = sm + (num * peso);
                peso = peso - 1;
            }

            r = 11 - (sm % 11);
            if ((r == 10) || (r == 11)) {
                dig11 = '0';
            } else {
                dig11 = (char) (r + 48);
            }

            // Verifica se os digitos calculados conferem com os digitos informados.
            if ((dig10 == CPF.charAt(9)) && (dig11 == CPF.charAt(10))) {
                return (true);
            } else {
                return (false);
            }
        } catch (InputMismatchException erro) {
            return (false);
        }
    }

    public static String imprimeCPF(String CPF) {
        return (CPF.substring(0, 3) + "." + CPF.substring(3, 6) + "."
                + CPF.substring(6, 9) + "-" + CPF.substring(9, 11));
    }

    public static boolean isCNPJ(String CNPJ) {
// considera-se erro CNPJ's formados por uma sequencia de numeros iguais
        if (CNPJ.equals("00000000000000") || CNPJ.equals("11111111111111")
                || CNPJ.equals("22222222222222") || CNPJ.equals("33333333333333")
                || CNPJ.equals("44444444444444") || CNPJ.equals("55555555555555")
                || CNPJ.equals("66666666666666") || CNPJ.equals("77777777777777")
                || CNPJ.equals("88888888888888") || CNPJ.equals("99999999999999")
                || (CNPJ.length() != 14)) {
            return (false);
        }

        char dig13, dig14;
        int sm, i, r, num, peso;

// "try" - protege o código para eventuais erros de conversao de tipo (int)
        try {
// Calculo do 1o. Digito Verificador
            sm = 0;
            peso = 2;
            for (i = 11; i >= 0; i--) {
// converte o i-ésimo caractere do CNPJ em um número:
// por exemplo, transforma o caractere '0' no inteiro 0
// (48 eh a posição de '0' na tabela ASCII)
                num = (int) (CNPJ.charAt(i) - 48);
                sm = sm + (num * peso);
                peso = peso + 1;
                if (peso == 10) {
                    peso = 2;
                }
            }

            r = sm % 11;
            if ((r == 0) || (r == 1)) {
                dig13 = '0';
            } else {
                dig13 = (char) ((11 - r) + 48);
            }

// Calculo do 2o. Digito Verificador
            sm = 0;
            peso = 2;
            for (i = 12; i >= 0; i--) {
                num = (int) (CNPJ.charAt(i) - 48);
                sm = sm + (num * peso);
                peso = peso + 1;
                if (peso == 10) {
                    peso = 2;
                }
            }

            r = sm % 11;
            if ((r == 0) || (r == 1)) {
                dig14 = '0';
            } else {
                dig14 = (char) ((11 - r) + 48);
            }

// Verifica se os dígitos calculados conferem com os dígitos informados.
            if ((dig13 == CNPJ.charAt(12)) && (dig14 == CNPJ.charAt(13))) {
                return (true);
            } else {
                return (false);
            }
        } catch (InputMismatchException erro) {
            return (false);
        }
    }

    public static String imprimeCNPJ(String CNPJ) {
// máscara do CNPJ: 99.999.999.9999-99
        return (CNPJ.substring(0, 2) + "." + CNPJ.substring(2, 5) + "."
                + CNPJ.substring(5, 8) + "/" + CNPJ.substring(8, 12) + "-"
                + CNPJ.substring(12, 14));
    }
}

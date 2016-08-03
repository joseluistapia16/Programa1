/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package programa1;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author TapiaSoftware
 */
public class Validacion {

    private static final String PATTERN_EMAIL = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
            + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
private static final String PATTERN_phone = "(^[67]\\d{10}})$";

    public static boolean validateEmail(String email) {

        // Compiles the given regular expression into a pattern.
        Pattern pattern = Pattern.compile(PATTERN_EMAIL);

        // Match the given input against this pattern
        Matcher matcher = pattern.matcher(email);
        
        return matcher.matches();

    }
    
    public static boolean validateTelefono(String telefono) {
         boolean resultado=false; 
        if(telefono.length()==10){
       
              if(telefono.charAt(0)=='0' && telefono.charAt(1)=='9'){
                  resultado=true; 
              }else{
                  resultado=false; 
              }

        }else{
                  resultado=false; 
              }


        return resultado;

    }
    
}

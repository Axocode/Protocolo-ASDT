/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.axocode.service.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.axocode.dao.protocol;

/**
 *
 * @author chump
 */
public class protocolService extends Conexion<protocol>{
    
    
    public static class Resultados {
            public StringBuilder resultado1;
            public StringBuilder resultado2;

            public Resultados(StringBuilder resultado1, StringBuilder resultado2) {
                this.resultado1 = resultado1;
                this.resultado2 = resultado2;
            }
        }
    
    public static Resultados eco(protocol protocol) {
    String IUser = protocol.getIUser(); 
    String IPass = protocol.getIPass(); 

    String reglasLetras = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    String reglasNumeros = "1234567890";

    String sustitucionLetras = "EOPQSRTUVWXYZABCDFGHIJKLMN";
    String sustitucionNumeros = "0497235681";

    
    StringBuilder resultado1 = new StringBuilder();
    for (char c : IUser.toCharArray()) {
        if (Character.isLetter(c)) {
            int index = reglasLetras.indexOf(Character.toUpperCase(c));
            if (index != -1) {
                char letraCodificada = sustitucionLetras.charAt(index);
                resultado1.append(Character.isLowerCase(c) ? Character.toLowerCase(letraCodificada) : letraCodificada);
            } else {
                resultado1.append(c); 
            }
        } else if (Character.isDigit(c)) {
            int index = reglasNumeros.indexOf(c);
            if (index != -1) {
                char numeroCodificado = sustitucionNumeros.charAt(index);
                resultado1.append(numeroCodificado);
            } else {
                resultado1.append(c); 
            }
        } else {
            resultado1.append(c); 
        }
    }

    StringBuilder resultado2 = new StringBuilder();
    for (char c : IPass.toCharArray()) {
        if (Character.isLetter(c)) {
            int index = reglasLetras.indexOf(Character.toUpperCase(c));
            if (index != -1) {
                char letraCodificada = sustitucionLetras.charAt(index);
                resultado2.append(Character.isLowerCase(c) ? Character.toLowerCase(letraCodificada) : letraCodificada);
            } else {
                resultado2.append(c); 
            }
        } else if (Character.isDigit(c)) {
            int index = reglasNumeros.indexOf(c);
            if (index != -1) {
                char numeroCodificado = sustitucionNumeros.charAt(index);
                resultado2.append(numeroCodificado);
            } else {
                resultado2.append(c); 
            }
        } else {
            resultado2.append(c); 
        }
    }

    return new Resultados(resultado1, resultado2);
    }
    
    public static Resultados deco(protocol protocol) {
    String IUser = protocol.getIUser();
    String IPass = protocol.getIPass();

    
    String reglasLetras = "EOPQSRTUVWXYZABCDFGHIJKLMN";
    String reglasNumeros = "0497235681";

    String sustitucionLetras = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    String sustitucionNumeros = "1234567890";

    StringBuilder resultado1 = new StringBuilder();
    for (char c : IUser.toCharArray()) {
        if (Character.isLetter(c)) {
            int index = reglasLetras.indexOf(Character.toUpperCase(c));
            if (index != -1) {
                char letraDecodificada = sustitucionLetras.charAt(index);
                resultado1.append(Character.isLowerCase(c) ? Character.toLowerCase(letraDecodificada) : letraDecodificada);
            } else {
                resultado1.append(c); 
            }
        } else if (Character.isDigit(c)) {
            int index = reglasNumeros.indexOf(c);
            if (index != -1) {
                char numeroDecodificado = sustitucionNumeros.charAt(index);
                resultado1.append(numeroDecodificado);
            } else {
                resultado1.append(c); 
            }
        } else {
            resultado1.append(c); 
        }
    }

    StringBuilder resultado2 = new StringBuilder();
    for (char c : IPass.toCharArray()) {
        if (Character.isLetter(c)) {
            int index = reglasLetras.indexOf(Character.toUpperCase(c));
            if (index != -1) {
                char letraDecodificada = sustitucionLetras.charAt(index);
                resultado2.append(Character.isLowerCase(c) ? Character.toLowerCase(letraDecodificada) : letraDecodificada);
            } else {
                resultado2.append(c); 
            }
        } else if (Character.isDigit(c)) {
            int index = reglasNumeros.indexOf(c);
            if (index != -1) {
                char numeroDecodificado = sustitucionNumeros.charAt(index);
                resultado2.append(numeroDecodificado);
            } else {
                resultado2.append(c); 
            }
        } else {
            resultado2.append(c); 
        }
    }

    return new Resultados(resultado1, resultado2);
}

    
    
    
    public boolean convey(String usuario1, String usuario2, String contrasena1, String contrasena2) {
    if (usuario1.equals(usuario2) && contrasena1.equals(contrasena2)) {
        Connection connection = null;
        PreparedStatement statement = null;
        try {
            connection = getConnection();
            String query = "insert into users (iuser, ipassword) values (?, ?)"; 
            statement = connection.prepareStatement(query);
            statement.setString(1, usuario1);
            statement.setString(2, contrasena1);

            int filasAfectadas = statement.executeUpdate();

            return filasAfectadas > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }
    return false;
}
    
    
public protocol trow(String IUser, String IUser1) {
    if (!IUser.equals(IUser1)) {
        return null;
    }

    protocol aux = null;
    Connection connection = null;
    PreparedStatement preparedStatement = null;
    ResultSet resultSet = null;

    try {
        connection = getConnection();
        if (connection == null) {
            return null;
        }

        preparedStatement = connection.prepareStatement("select * from users where iuser = ?");
        preparedStatement.setString(1, IUser);

        resultSet = preparedStatement.executeQuery();
        if (resultSet.next()) {
            aux = new protocol();
            aux.setIUserNum(resultSet.getInt(1));
            aux.setIUser(resultSet.getString(2));
            aux.setIPass(resultSet.getString(3));
            
        }
    } catch (SQLException ex) {
        ex.printStackTrace();
    } finally {
        // Cerrar los recursos en el orden inverso
        if (resultSet != null) {
            try {
                resultSet.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (preparedStatement != null) {
            try {
                preparedStatement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    return aux;
}


}


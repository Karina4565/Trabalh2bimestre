package com.trabalho2bimestre.conexao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexaoMysql {
    
    
     public Connection getConnection() throws Exception {
        String url = "jdbc:mysql://localhost:3306/TrabalhoBD";
        String usuario = "admin";
        String senha = "123456";

        try {
            return (Connection) DriverManager.getConnection(url, usuario, senha);

        } catch (SQLException e) {
            String erro = e.getMessage();
            if (erro == null) {
                erro = "";
            }
            erro = erro.trim().toLowerCase();
            if (erro.indexOf("user") != -1) {
                throw new Exception("Usuário do Banco de Dados Inválido.");
            }

            throw new Exception("Não foi possível conectar com o banco de dados.\r\n" );
        }
    }
}

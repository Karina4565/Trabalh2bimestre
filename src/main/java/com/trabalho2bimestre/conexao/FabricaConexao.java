package com.trabalho2bimestre.conexao;

import java.sql.Connection;

public final class FabricaConexao {

    private FabricaConexao() {
    }

   private static ConexaoMysql conexaoMysql = new ConexaoMysql();
    
    public static Connection getConnectionMysql() throws Exception {
        return conexaoMysql.getConnection();
    }
}

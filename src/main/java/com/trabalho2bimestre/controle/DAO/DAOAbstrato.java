package com.trabalho2bimestre.controle.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public abstract class DAOAbstrato {

    protected Connection conn;
    protected PreparedStatement psmt;
    protected ResultSet rs;

    public DAOAbstrato(Connection conn) {
        if (conn == null) {
            System.out.println("Connection null");
        }
        this.conn = conn;
    }

    public static void fecharRecursos(Connection conn, PreparedStatement psmt, ResultSet rs) {
        if (conn != null) {
            try {
                conn.close();
            } catch (Exception e) {
            }
        }

        if (psmt != null) {
            try {
                conn.close();
            } catch (Exception e) {
            }
        }

        if (rs != null) {
            try {
                conn.close();
            } catch (Exception e) {
            }
        }
    }

    public String like(String valor) {
        return " like '%" + valor + "%'";
    }

    public String igual(String valor) {
        return " ='" + valor + "'";
    }
}

package com.trabalho2bimestre.controle.DAO;

import com.trabalho2bimestre.modelo.Cliente;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;


public class ClienteDAO extends DAOAbstrato {
 
    
    
    
     private static final String INSERIR = "INSERT INTO cliente"
            + "( nome,email,data_nascimento,genero,altura,telefone) "
            + "VALUES (?,?,?,?,?,?)";

    public ClienteDAO(Connection conn) {
        super(conn);
    }
    
    
    public void inserir(Cliente cliente) throws Exception {
        try {
            psmt = conn.prepareStatement(INSERIR, PreparedStatement.RETURN_GENERATED_KEYS);

            psmt.setString(1, cliente.getNome());
            psmt.setString(2, cliente.getEmail());
            psmt.setString(3, cliente.getDataDeNascimetno());
            psmt.setString(4, cliente.getGenero());
            psmt.setString(5, cliente.getAltura());
            psmt.setString(6, cliente.getTelefone());

            

            int res = psmt.executeUpdate();

            if (res == 1) {
                rs = psmt.getGeneratedKeys();
                rs.next();
                cliente.setId(rs.getInt(1));
            }
          } catch (SQLException e) {
            System.out.println("Erro ao inserir Pessoa: " + e.getMessage());
        } finally {
            fecharRecursos(null, psmt, rs);
        }
    }

}
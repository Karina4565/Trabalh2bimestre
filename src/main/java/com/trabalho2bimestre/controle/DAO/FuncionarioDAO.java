package com.trabalho2bimestre.controle.DAO;


import com.trabalho2bimestre.modelo.Fucionario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;


public class FucionarioDAO extends DAOAbstrato {
 
    
    
    
     private static final String INSERIR = "INSERT INTO cliente"
            + "( nome,email,telefone) "
            + "VALUES (?,?,?)";

    public FucionarioDAO(Connection conn) {
        super(conn);
    }
    
    
    public void inserir(Fucionario fucionario) throws Exception {
        try {
            psmt = conn.prepareStatement(INSERIR, PreparedStatement.RETURN_GENERATED_KEYS);

            psmt.setString(1, fucionario.getNome());
            psmt.setString(2, fucionario.getEmail());
            psmt.setString(3, fucionario.getTelefone());

            

            int res = psmt.executeUpdate();

            if (res == 1) {
                rs = psmt.getGeneratedKeys();
                rs.next();
                fucionario.setId(rs.getInt(1));
            }
          } catch (SQLException e) {
            System.out.println("Erro ao inserir Pessoa: " + e.getMessage());
        } finally {
            fecharRecursos(null, psmt, rs);
        }
    }

}

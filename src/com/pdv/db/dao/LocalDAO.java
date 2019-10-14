package com.pdv.db.dao;

import com.pdv.db.Factory;
import com.pdv.model.Cliente;
import com.pdv.model.Localidade;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class LocalDAO implements DAO<Localidade> {

    private Connection con;

    @Override
    public Localidade getById(Integer id) throws SQLException {
        String query = "SELECT * FROM localidade WHERE codlocal = ?";
        Localidade local = null;
        try {
            con = Factory.getConnection();
            con.setAutoCommit(false);
            PreparedStatement ps = con.prepareStatement(query);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            rs.first();
            local = new Localidade(rs.getInt("codlocal"), rs.getString("nome"), rs.getString("endereco"), rs.getString("telefone"));
            con.commit();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não foi encontrado local com esse código!", "Local inválido", JOptionPane.ERROR_MESSAGE);
            con.rollback();
        } catch (ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
            con.rollback();
        }
        return local;
    }

    @Override
    public List<Localidade> getAll() throws SQLException {
        String query = "SELECT * FROM localidade";
        List<Localidade> locais = new ArrayList<>();
        try {
            con = Factory.getConnection();
            con.setAutoCommit(false);
            PreparedStatement ps = con.prepareStatement(query);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                locais.add(new Localidade(rs.getInt("codlocal"), rs.getString("nome"), rs.getString("endereco"), rs.getString("telefone")));
            }
            con.commit();
        } catch (SQLException ex) {
            Logger.getLogger(LocalDAO.class.getName()).log(Level.SEVERE, null, ex);
            con.rollback();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(LocalDAO.class.getName()).log(Level.SEVERE, null, ex);
            con.rollback();
        }
        return locais;
    }

    public static void main(String args[]) throws Throwable {
        DAO dao = new LocalDAO();

        /* List<Localidade> locais = dao.getAll();        
        locais.forEach(local -> System.out.println(local));*/
 /*Localidade local = (Localidade) dao.getById(5);
       System.out.println(local);*/
    }

}

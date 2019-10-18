package com.pdv.db.dao;

import com.pdv.db.Factory;
import com.pdv.model.Cliente;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
/**
 *
 * @author Luís Henrique de C. Corrêa
 */
public class ClienteDAO implements DAO<Cliente> {

    private Connection con;

    @Override
    public Cliente getById(Integer id) throws SQLException {
        String query = "SELECT * FROM cliente WHERE codcli = ?";
        Cliente cliente = null;
        try {
            con = Factory.getConnection();
            con.setAutoCommit(false);
            PreparedStatement ps = con.prepareStatement(query);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            rs.first();
            cliente = new Cliente(rs.getInt("codcli"), rs.getString("nome"), rs.getLong("bonus"),
                    rs.getString("perfil").charAt(0), rs.getString("condicao").charAt(0));
            con.commit();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não foi encontrado cliente com esse código!", "Cliente inválido", JOptionPane.ERROR_MESSAGE);
            con.rollback();
        } catch (ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
            con.rollback();
        }
        return cliente;
    }

    @Override
    public List<Cliente> getAll() throws SQLException {
        String query = "SELECT * FROM cliente";
        List<Cliente> clientes = new ArrayList<>();
        try {
            con = Factory.getConnection();
            con.setAutoCommit(false);
            PreparedStatement ps = con.prepareStatement(query);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                clientes.add(new Cliente(rs.getInt("codcli"), rs.getString("nome"), rs.getLong("bonus"),
                        rs.getString("perfil").charAt(0), rs.getString("condicao").charAt(0)));
            }
            con.commit();
        } catch (SQLException ex) {
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
            con.rollback();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
            con.rollback();
        }
        return clientes;
    }

    public static void main(String args[]) throws Throwable {
        DAO dao = new ClienteDAO();

        /* List<Cliente> clientes = dao.getAll();        
        clientes.forEach(cli -> System.out.println(cli));*/
 /*Cliente cli = (Cliente) dao.getById(7);
        System.out.println(cli);*/
    }

}

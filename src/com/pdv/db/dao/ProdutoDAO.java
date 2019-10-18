package com.pdv.db.dao;

import com.pdv.db.Factory;
import com.pdv.model.Localidade;
import com.pdv.model.Produto;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
/**
 *
 * @author Luís Henrique de C. Corrêa
 */
public class ProdutoDAO implements DAO<Produto> {

    private Connection con;

    @Override
    public Produto getById(Integer id) throws SQLException {
        String query = "SELECT * FROM produto WHERE codprod = ?";
        Produto produto = null;
        try {
            con = Factory.getConnection();
            con.setAutoCommit(false);
            PreparedStatement ps = con.prepareStatement(query);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            rs.first();
            produto = new Produto(rs.getInt("codprod"), null, rs.getString("descricao"),
                    rs.getLong("qte_estoque"), rs.getDouble("preco_unitario"));

            query = "SELECT * FROM localidade WHERE codlocal = ?";
            ps = con.prepareStatement(query);
            ps.setInt(1, rs.getInt("codlocal"));
            rs = ps.executeQuery();
            rs.first();
            Localidade local = new Localidade(rs.getInt("codlocal"), rs.getString("nome"), rs.getString("endereco"), rs.getString("telefone"));
            produto.setLocal(local);
            con.commit();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não foi encontrado produto com esse código!", "Produto inválido", JOptionPane.ERROR_MESSAGE);
            con.rollback();
        } catch (ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
            con.rollback();
        }
        return produto;
    }

    @Override
    public List<Produto> getAll() throws SQLException {
        String query = "SELECT * FROM localidade";
        List<Produto> produtos = new ArrayList<>();
        List<Localidade> locais = new ArrayList<>();
        try {
            con = Factory.getConnection();
            con.setAutoCommit(false);
            PreparedStatement ps = con.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                locais.add(new Localidade(rs.getInt("codlocal"), rs.getString("nome"), rs.getString("endereco"), rs.getString("telefone")));
            }

            query = "SELECT * FROM produto";
            ps = con.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                produtos.add(new Produto(rs.getInt("codprod"), setLocal(locais, rs.getInt("codlocal")), rs.getString("descricao"),
                        rs.getLong("qte_estoque"), rs.getDouble("preco_unitario")));
            }
            con.commit();
        } catch (SQLException ex) {
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
            con.rollback();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
            con.rollback();
        }
        return produtos;
    }

    private Localidade setLocal(List<Localidade> locais, Integer codLocal) {
        Localidade localidade = new Localidade();
        locais.stream().forEach(local -> {
            if (local.getCodLocal() == codLocal) {
                localidade.setCodLocal(local.getCodLocal());
                localidade.setEndereco(local.getEndereco());
                localidade.setNome(local.getNome());
                localidade.setTelefone(local.getTelefone());
                return;
            }
        });

        return localidade;
    }

    public static void main(String args[]) throws Throwable {
        DAO dao = new ProdutoDAO();

        /* List<Produto> produtos = dao.getAll();
        produtos.forEach(prod -> System.out.println(prod));*/
 /* Produto prod = (Produto) dao.getById(16);
        System.out.println(prod);*/
    }

}

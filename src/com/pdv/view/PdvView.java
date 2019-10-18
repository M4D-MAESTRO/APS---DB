package com.pdv.view;

import com.pdv.db.dao.ClienteDAO;
import com.pdv.db.dao.DAO;
import com.pdv.db.dao.LocalDAO;
import com.pdv.db.dao.ProdutoDAO;
import com.pdv.db.dao.VendaDAO;
import com.pdv.model.Cliente;
import com.pdv.model.Localidade;
import com.pdv.model.Produto;
import com.pdv.utils.Formatador;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Luís Henrique de C. Corrêa
 */
public class PdvView extends javax.swing.JFrame {

    private DAO dao;
    private Cliente clienteSelecionado;
    private Localidade localSelecionado;
    private Produto produtoSelecionado;
    private Produto aSerExcluido;

    public PdvView() {
        initComponents();
        atualizarCliente();
        atualizarLocal();
        atualizarprodutos();
    }

    private void atualizarCliente() {
        dao = new ClienteDAO();
        List<Cliente> clientes = new ArrayList<>();
        try {
            clientes = dao.getAll();
        } catch (Throwable ex) {
            JOptionPane.showMessageDialog(null, "Erro desconhecido, contate a T.I: \n" + ex.toString());
        }
        String nomes[] = new String[clientes.size() + 1];
        nomes[0] = "Selecione um";
        for (int i = 0; i < nomes.length - 1; i++) {
            nomes[i + 1] = clientes.get(i).getNome() + " - " + clientes.get(i).getCodCli();
        }
        jComboBoxCliente.setModel(new DefaultComboBoxModel<>(nomes));
    }

    private void atualizarLocal() {
        dao = new LocalDAO();
        List<Localidade> locais = new ArrayList<>();
        try {
            locais = dao.getAll();
        } catch (Throwable ex) {
            JOptionPane.showMessageDialog(null, "Erro desconhecido, contate a T.I: \n" + ex.toString());
        }
        String nomes[] = new String[locais.size() + 1];
        nomes[0] = "Selecione um";
        for (int i = 0; i < nomes.length - 1; i++) {
            nomes[i + 1] = locais.get(i).getNome() + " - " + locais.get(i).getCodLocal();
        }
        jComboBoxLocal.setModel(new DefaultComboBoxModel<>(nomes));
    }

    private void atualizarprodutos() {
        dao = new ProdutoDAO();
        List<Produto> produtos = new ArrayList<>();
        try {
            produtos = dao.getAll();
        } catch (Throwable ex) {
            JOptionPane.showMessageDialog(null, "Erro desconhecido, contate a T.I: \n" + ex.toString());
        }
        String codigos[] = new String[produtos.size() + 1];
        codigos[0] = "Selecione um";
        for (int i = 0; i < codigos.length - 1; i++) {
            codigos[i + 1] = produtos.get(i).getCodProd().toString();
        }
        jComboBoxProduto.setModel(new DefaultComboBoxModel<>(codigos));
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jComboBoxCliente = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        jComboBoxLocal = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        jComboBoxProduto = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        jTextFieldQuantidade = new javax.swing.JTextField();
        jButtonVender = new javax.swing.JButton();
        jButtonExcluir = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jTextFieldDesc = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableTabela = new javax.swing.JTable();
        jLabel7 = new javax.swing.JLabel();
        jTextFieldTotalCompra = new javax.swing.JTextField();
        jButton3 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("PDV - Ponto de Venda");
        setMinimumSize(new java.awt.Dimension(800, 600));
        setPreferredSize(new java.awt.Dimension(800, 600));
        setResizable(false);

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel1.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(51, 0, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Caixa Livre");

        jLabel2.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 153));
        jLabel2.setText("Cliente Selecionado:");

        jComboBoxCliente.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel3.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 0, 153));
        jLabel3.setText("Local de Venda:");

        jComboBoxLocal.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel4.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 0, 153));
        jLabel4.setText("Código do Produto:");

        jComboBoxProduto.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jComboBoxProduto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxProdutoActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 0, 153));
        jLabel5.setText("Quantidade:");

        jTextFieldQuantidade.setText("0");
        jTextFieldQuantidade.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextFieldQuantidadeKeyTyped(evt);
            }
        });

        jButtonVender.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/pdv/resources/imgs/ok.png"))); // NOI18N
        jButtonVender.setText("Vender");
        jButtonVender.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonVenderActionPerformed(evt);
            }
        });

        jButtonExcluir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/pdv/resources/imgs/close.png"))); // NOI18N
        jButtonExcluir.setText("Excluir");
        jButtonExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonExcluirActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 0, 153));
        jLabel6.setText("Descrição do produto");

        jTableTabela.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Produto", "Quantidade", "Preço unitário", "Valor total"
            }
        ));
        jTableTabela.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jTableTabelaMouseReleased(evt);
            }
        });
        jScrollPane1.setViewportView(jTableTabela);

        jLabel7.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(0, 0, 153));
        jLabel7.setText("Total de compra:");

        jTextFieldTotalCompra.setEditable(false);

        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/pdv/resources/imgs/aperto.png"))); // NOI18N
        jButton3.setText("Fechar");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jTextFieldDesc)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 558, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jTextFieldTotalCompra, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jComboBoxCliente, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jComboBoxLocal, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jComboBoxProduto, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, 145, Short.MAX_VALUE)
                                    .addComponent(jTextFieldQuantidade))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jButtonVender, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jButtonExcluir, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(217, 217, 217)
                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jComboBoxCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jComboBoxLocal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(47, 47, 47)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jComboBoxProduto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldQuantidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonVender))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButtonExcluir)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextFieldDesc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 216, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(jTextFieldTotalCompra, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 32, Short.MAX_VALUE)
                .addComponent(jButton3)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTextFieldQuantidadeKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldQuantidadeKeyTyped
        Formatador.formatarCampoNumerico(evt);
    }//GEN-LAST:event_jTextFieldQuantidadeKeyTyped

    private void jComboBoxProdutoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxProdutoActionPerformed
        dao = new ProdutoDAO();
        try {
            Integer codigo = Integer.parseInt(jComboBoxProduto.getSelectedItem().toString());
            produtoSelecionado = (Produto) dao.getById(codigo);
            jTextFieldDesc.setText(produtoSelecionado.getDescricao());
        } catch (NumberFormatException ex) {
            jTextFieldDesc.setText("");
            return;
        } catch (Throwable ex) {
            JOptionPane.showMessageDialog(null, "Erro desconhecido, contate a T.I: \n" + ex.toString());
        }
    }//GEN-LAST:event_jComboBoxProdutoActionPerformed

    private void jButtonVenderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonVenderActionPerformed
        try {
            Long quantidade = Long.parseLong(jTextFieldQuantidade.getText());
            if (quantidade <= 0) {
                JOptionPane.showMessageDialog(null, "Quantidade igual 0");
            } else {
                dao = new ClienteDAO();
                clienteSelecionado = (Cliente) dao.getById(getCod(jComboBoxCliente.getSelectedItem().toString()));

                dao = new LocalDAO();
                localSelecionado = (Localidade) dao.getById(getCod(jComboBoxLocal.getSelectedItem().toString()));

                VendaDAO vendaDAO = new VendaDAO();

                vendaDAO.incluirVenda(clienteSelecionado.getCodCli(), localSelecionado.getCodLocal(),
                        produtoSelecionado.getCodProd(), quantidade);
                atualizarLista();
                limparCampos();
            }

        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(null, "Preencha com números inteiros POSITIVOS o campo:\n QUANTIDADE");
        } catch (Throwable ex) {
            Logger.getLogger(PdvView.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButtonVenderActionPerformed

    private void jButtonExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonExcluirActionPerformed
        try {
            Long quantidade = Long.parseLong(jTextFieldQuantidade.getText());
            if (quantidade <= 0) {

            }

            dao = new ClienteDAO();
            clienteSelecionado = (Cliente) dao.getById(getCod(jComboBoxCliente.getSelectedItem().toString()));

            dao = new LocalDAO();
            localSelecionado = (Localidade) dao.getById(getCod(jComboBoxLocal.getSelectedItem().toString()));

            VendaDAO vendaDAO = new VendaDAO();

            vendaDAO.deletarVenda(clienteSelecionado.getCodCli(), aSerExcluido.getCodProd(),
                    localSelecionado.getCodLocal(), LocalDate.now());
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(null, "Preencha com números inteiros POSITIVOS o campo:\n QUANTIDADE");
        } catch (Throwable ex) {
            Logger.getLogger(PdvView.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButtonExcluirActionPerformed

    private void jTableTabelaMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableTabelaMouseReleased
        dao = new ProdutoDAO();
        Integer row = jTableTabela.getSelectedRow();
        Integer id = (Integer) jTableTabela.getModel().getValueAt(row, 0);
        try {
            aSerExcluido = (Produto) dao.getById(id);
        } catch (Throwable ex) {
            Logger.getLogger(PdvView.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jTableTabelaMouseReleased

    private void limparCampos() {
        produtoSelecionado = null;
        jTextFieldDesc.setText("");
        jTextFieldQuantidade.setText("");
    }

    private void atualizarLista() {
        DefaultTableModel model = (DefaultTableModel) jTableTabela.getModel();
        model.addRow(new Object[]{
            produtoSelecionado.getCodProd(),
            produtoSelecionado.getDescricao(),
            jTextFieldQuantidade.getText(),
            produtoSelecionado.getPrecoUnitario(),
            (Integer.parseInt(jTextFieldQuantidade.getText()) * produtoSelecionado.getPrecoUnitario())
        });
    }

    private Integer getCod(String txt) {
        return Integer.parseInt(txt.substring(txt.indexOf("-") + 2));
    }

    public static void main(String args[]) {

        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(PdvView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PdvView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PdvView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PdvView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PdvView().setVisible(true);
            }
        });
    }
//<editor-fold defaultstate="collapsed" desc=" Declaracao de variaveis - nao mexer ">
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButtonExcluir;
    private javax.swing.JButton jButtonVender;
    private javax.swing.JComboBox<String> jComboBoxCliente;
    private javax.swing.JComboBox<String> jComboBoxLocal;
    private javax.swing.JComboBox<String> jComboBoxProduto;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTableTabela;
    private javax.swing.JTextField jTextFieldDesc;
    private javax.swing.JTextField jTextFieldQuantidade;
    private javax.swing.JTextField jTextFieldTotalCompra;
    // End of variables declaration//GEN-END:variables
//</editor-fold>
}

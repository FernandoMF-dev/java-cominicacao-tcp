package clientetcp;

import clientetcp.resource.CompraForm;
import clientetcp.resource.RelatorioDialog;
import entities.Compra;
import entities.Operacao;
import enums.OperacaoEnum;
import enums.ProdutoEnum;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class Principal extends javax.swing.JFrame {

    private CompraForm janelaCompra = null;
    private RelatorioDialog relatorioDialog = null;

    private Operacao operacao = null;

    public Principal() {
        initComponents();
        iniciarJanelaCompra();
    }

    private void iniciarJanelaCompra() {
        this.janelaCompra = new CompraForm(this, true);
        this.relatorioDialog = new RelatorioDialog(this, true);
    }

    private void iniciarOperacao() {
        operacao = new Operacao();
    }

    private void removerDadosTabela() {
        DefaultTableModel defaultTableModel = (DefaultTableModel) tableCompras.getModel();
        defaultTableModel.setRowCount(0);
    }

    private String converterProdutoEnum(ArrayList<ProdutoEnum> produtosEnum) {
        String stringFinal = "";
        for (int i = 0; i < produtosEnum.size(); i++) {
            if (i == produtosEnum.size() - 1) {
                stringFinal = stringFinal + produtosEnum.get(i).getNomeProduto();
            } else {
                stringFinal = stringFinal + produtosEnum.get(i).getNomeProduto() + ", ";
            }
        }
        return stringFinal;
    }

    private void inserirCompraTabela(Compra compra) {
        ((DefaultTableModel) tableCompras.getModel()).addRow(new Object[1]);
        int linha = tableCompras.getRowCount() - 1;
        int coluna = 0;
        tableCompras.setValueAt(compra.getId(), linha, coluna++);
        tableCompras.setValueAt(converterProdutoEnum(compra.getProdutos()), linha, coluna);
    }

    private void preencherTabelaRegistrosCompra(Operacao operacao) {
        for (int i = 0; i < operacao.getComprasEfetuadas().size(); i++) {
            inserirCompraTabela(operacao.getComprasEfetuadas().get(i));
        }
        JOptionPane.showMessageDialog(null, "Compras atualizadas com sucesso");
    }

    private void preencherOperacaoAtualizar() {
        iniciarOperacao();
        operacao.setOperacao(OperacaoEnum.ATUALIZAR);
    }
    
    private void preencherOperacaoApriori() {
        iniciarOperacao();
        operacao.setOperacao(OperacaoEnum.APRIORI);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tableCompras = new javax.swing.JTable();
        buttonNovaCompra = new javax.swing.JButton();
        buttonRelatorio = new javax.swing.JButton();
        buttonAtualizar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Cliente TCP");

        tableCompras.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Compra", "Produtos"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Long.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tableCompras);

        buttonNovaCompra.setText("Nova Compra");
        buttonNovaCompra.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonNovaCompraActionPerformed(evt);
            }
        });

        buttonRelatorio.setText("Relatório");
        buttonRelatorio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonRelatorioActionPerformed(evt);
            }
        });

        buttonAtualizar.setText("Atualizar");
        buttonAtualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonAtualizarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(buttonNovaCompra)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 119, Short.MAX_VALUE)
                        .addComponent(buttonAtualizar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(buttonRelatorio))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(buttonNovaCompra)
                    .addComponent(buttonRelatorio)
                    .addComponent(buttonAtualizar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 235, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void buttonNovaCompraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonNovaCompraActionPerformed
        this.janelaCompra.setVisible(true);
    }//GEN-LAST:event_buttonNovaCompraActionPerformed

    private void buttonAtualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonAtualizarActionPerformed
        removerDadosTabela();
        preencherOperacaoAtualizar();
        ClienteTCP clienteTCP = new ClienteTCP(operacao);
        preencherTabelaRegistrosCompra(clienteTCP.enviarSolicitacaoServidor());
    }//GEN-LAST:event_buttonAtualizarActionPerformed

    private void buttonRelatorioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonRelatorioActionPerformed
        preencherOperacaoApriori();
        ClienteTCP clienteTCP = new ClienteTCP(operacao);
        relatorioDialog.setVisible(true, clienteTCP.enviarSolicitacaoServidor().getMensagem());
    }//GEN-LAST:event_buttonRelatorioActionPerformed

    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
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
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Principal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonAtualizar;
    private javax.swing.JButton buttonNovaCompra;
    private javax.swing.JButton buttonRelatorio;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tableCompras;
    // End of variables declaration//GEN-END:variables
}

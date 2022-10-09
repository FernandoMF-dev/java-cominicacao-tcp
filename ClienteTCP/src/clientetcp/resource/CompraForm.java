package clientetcp.resource;

import clientetcp.ClienteTCP;
import entities.Operacao;
import enums.OperacaoEnum;
import enums.ProdutoEnum;
import java.util.ArrayList;
import javax.annotation.processing.SupportedSourceVersion;
import javax.lang.model.SourceVersion;
import javax.swing.JOptionPane;

@SupportedSourceVersion(SourceVersion.RELEASE_11)
public class CompraForm extends javax.swing.JDialog {

    private Operacao operacao;

    private ArrayList<ProdutoEnum> produtosSelecionados = new ArrayList<>();

    public CompraForm(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        desmarcarTodosCheckbox();
    }

    private void iniciarOperacao() {
        operacao = new Operacao();
    }

    private void obterProdutosSelecionados() {
        if (this.checkboxPao.isSelected()) {
            this.produtosSelecionados.add(ProdutoEnum.PAO);
        }

        if (this.checkboxLeite.isSelected()) {
            this.produtosSelecionados.add(ProdutoEnum.LEITE);
        }

        if (this.checkboxCafe.isSelected()) {
            this.produtosSelecionados.add(ProdutoEnum.CAFE);
        }

        if (this.checkboxSuco.isSelected()) {
            this.produtosSelecionados.add(ProdutoEnum.SUCO);
        }

        if (this.checkboxBolacha.isSelected()) {
            this.produtosSelecionados.add(ProdutoEnum.BOLACHAS);
        }

        if (this.checkboxQueijo.isSelected()) {
            this.produtosSelecionados.add(ProdutoEnum.QUEIJO);
        }

        if (this.checkboxPresunto.isSelected()) {
            this.produtosSelecionados.add(ProdutoEnum.PRESUNTO);
        }

        if (this.checkboxManteiga.isSelected()) {
            this.produtosSelecionados.add(ProdutoEnum.MANTEIGA);
        }
    }

    private void desmarcarTodosCheckbox() {
        this.checkboxPao.setSelected(false);
        this.checkboxLeite.setSelected(false);
        this.checkboxCafe.setSelected(false);
        this.checkboxSuco.setSelected(false);
        this.checkboxBolacha.setSelected(false);
        this.checkboxQueijo.setSelected(false);
        this.checkboxPresunto.setSelected(false);
        this.checkboxManteiga.setSelected(false);
    }

    private void limparLista() {
        this.produtosSelecionados.clear();
    }

    private void restricaoCompra() {
        if (this.produtosSelecionados.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Uma compra deve possuir pelo menos um item!");
        }
    }

    private void preencherOperacaoSalvar() {
        operacao.setOperacao(OperacaoEnum.SALVAR);
        operacao.setNovaCompra(produtosSelecionados);
    }

    private void verificarPersistencia(Operacao operacao) {
        if (operacao.getMensagem().equals("Sucesso")) {
            JOptionPane.showMessageDialog(null, "Compra efetuada com sucesso!");
            desmarcarTodosCheckbox();
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonCancelar = new javax.swing.JButton();
        buttonSalvar = new javax.swing.JButton();
        checkboxPao = new javax.swing.JCheckBox();
        checkboxLeite = new javax.swing.JCheckBox();
        checkboxCafe = new javax.swing.JCheckBox();
        checkboxSuco = new javax.swing.JCheckBox();
        checkboxBolacha = new javax.swing.JCheckBox();
        checkboxQueijo = new javax.swing.JCheckBox();
        checkboxPresunto = new javax.swing.JCheckBox();
        checkboxManteiga = new javax.swing.JCheckBox();
        jSeparator1 = new javax.swing.JSeparator();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Cadastrar Compra");
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
        });

        buttonCancelar.setText("Cancelar");
        buttonCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonCancelarActionPerformed(evt);
            }
        });

        buttonSalvar.setText("Salvar");
        buttonSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonSalvarActionPerformed(evt);
            }
        });

        checkboxPao.setText("Pão");

        checkboxLeite.setText("Leite");

        checkboxCafe.setText("Café");

        checkboxSuco.setText("Suco");

        checkboxBolacha.setText("Bolachas");

        checkboxQueijo.setText("Queijo");

        checkboxPresunto.setText("Presunto");

        checkboxManteiga.setText("Manteiga");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(buttonCancelar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(buttonSalvar))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(checkboxCafe)
                                .addGap(18, 18, 18)
                                .addComponent(checkboxPresunto))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(checkboxPao)
                                    .addComponent(checkboxLeite))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(checkboxQueijo)
                                    .addComponent(checkboxBolacha)))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(checkboxSuco)
                                .addGap(18, 18, 18)
                                .addComponent(checkboxManteiga)))
                        .addGap(0, 0, Short.MAX_VALUE))))
            .addComponent(jSeparator1)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(checkboxPao)
                    .addComponent(checkboxBolacha))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(checkboxQueijo)
                    .addComponent(checkboxLeite))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(checkboxCafe)
                    .addComponent(checkboxPresunto))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(checkboxSuco)
                    .addComponent(checkboxManteiga))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(buttonCancelar)
                    .addComponent(buttonSalvar))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void buttonSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonSalvarActionPerformed
        limparLista();
        System.out.println(produtosSelecionados.size());
        obterProdutosSelecionados();
        restricaoCompra();
        iniciarOperacao();
        preencherOperacaoSalvar();
        ClienteTCP clienteTCP = new ClienteTCP(operacao);
        verificarPersistencia(clienteTCP.enviarSolicitacaoServidor());
    }//GEN-LAST:event_buttonSalvarActionPerformed

    private void buttonCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonCancelarActionPerformed
        this.dispose();
    }//GEN-LAST:event_buttonCancelarActionPerformed

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
        desmarcarTodosCheckbox();
    }//GEN-LAST:event_formWindowClosed

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
            java.util.logging.Logger.getLogger(CompraForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CompraForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CompraForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CompraForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                CompraForm dialog = new CompraForm(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonCancelar;
    private javax.swing.JButton buttonSalvar;
    private javax.swing.JCheckBox checkboxBolacha;
    private javax.swing.JCheckBox checkboxCafe;
    private javax.swing.JCheckBox checkboxLeite;
    private javax.swing.JCheckBox checkboxManteiga;
    private javax.swing.JCheckBox checkboxPao;
    private javax.swing.JCheckBox checkboxPresunto;
    private javax.swing.JCheckBox checkboxQueijo;
    private javax.swing.JCheckBox checkboxSuco;
    private javax.swing.JSeparator jSeparator1;
    // End of variables declaration//GEN-END:variables
}

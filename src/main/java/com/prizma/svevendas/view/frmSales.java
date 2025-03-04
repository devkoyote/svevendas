/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.prizma.svevendas.view;

import com.prizma.svevendas.dao.CustomersDAO;
import com.prizma.svevendas.dao.ProductDAO;
import com.prizma.svevendas.dao.SuppliersDAO;
import com.prizma.svevendas.model.Customers;
import com.prizma.svevendas.model.Product;
import com.prizma.svevendas.model.Suppliers;
import com.prizma.svevendas.utils.CleanFields;
import java.awt.event.KeyEvent;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Daniel Koyote
 */
public class frmSales extends javax.swing.JFrame {

    /**
     * Variables Global
     */
    
    double price, subtotal, total;
    int quantity;
    DefaultTableModel my_products;
    Customers ctm = new Customers();
    
    public frmSales() {
        initComponents();
    }
    
    

    /* Functions extras
    ** List table Product
     */
    public void listProducts() {
        ProductDAO pdao = new ProductDAO();
        // List of products
        List<Product> listProduct = pdao.listProduct();
        // DefaultTableModel 
        DefaultTableModel data = (DefaultTableModel) tbl_product.getModel();
        data.setNumRows(0);
        for (Product p : listProduct) {
            data.addRow(
                    new Object[]{
                        p.getId(),
                        p.getDescribe(),
                        p.getPrice(),
                        p.getQtd_Stock(),
                        p.getSuppliers().getName()
                    }
            );

        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        txt_cpf = new javax.swing.JFormattedTextField();
        jLabel3 = new javax.swing.JLabel();
        txt_date = new javax.swing.JFormattedTextField();
        jLabel4 = new javax.swing.JLabel();
        txt_name = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txt_search_product = new javax.swing.JTextField();
        btn_name_search = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbl_product = new javax.swing.JTable();
        panelProduct = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        txt_id = new javax.swing.JTextField();
        txt_product = new javax.swing.JTextField();
        txt_price = new javax.swing.JTextField();
        txt_amount = new javax.swing.JTextField();
        txt_stock = new javax.swing.JTextField();
        txt_discount = new javax.swing.JTextField();
        btn_add_stock = new javax.swing.JButton();
        btn_clear = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        tbl_shooping_cart = new javax.swing.JScrollPane();
        shopping_cart = new javax.swing.JTable();
        jPanel4 = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        txt_total_sales = new javax.swing.JTextField();
        btn_receive_payment = new javax.swing.JButton();
        btn_cancel_sale = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                formWindowActivated(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(231, 231, 231));

        jLabel1.setFont(new java.awt.Font("Segoe UI Black", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 102, 51));
        jLabel1.setText("Painel de Vendas");
        jLabel1.setBorder(javax.swing.BorderFactory.createCompoundBorder());

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(410, 410, 410)
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(407, 407, 407))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addComponent(jLabel1)
                .addContainerGap(40, Short.MAX_VALUE))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Cliente"));

        jLabel2.setText("CPF:");

        try {
            txt_cpf.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("###.###.###-##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txt_cpf.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_cpfKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_cpfKeyReleased(evt);
            }
        });

        jLabel3.setText("Data:");

        txt_date.setEnabled(false);

        jLabel4.setText("Nome:");

        jLabel5.setText("Pesquisa de Produto:");

        txt_search_product.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_search_productKeyReleased(evt);
            }
        });

        btn_name_search.setText("Pesquisar");
        btn_name_search.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_name_searchActionPerformed(evt);
            }
        });

        tbl_product.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Código", "Descrição", "Preço", "Qtd. em Estoque", "Fornecedor"
            }
        ));
        tbl_product.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                tbl_productAncestorAdded(evt);
            }
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });
        tbl_product.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_productMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tbl_product);

        panelProduct.setBorder(javax.swing.BorderFactory.createTitledBorder("Produto"));

        jLabel6.setText("Código:");

        jLabel7.setText("Produto:");

        jLabel8.setText("Preço:");

        jLabel9.setText("Quantidade:");

        jLabel10.setText("Estoque:");

        jLabel11.setText("Desconto %:");

        txt_id.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_idKeyPressed(evt);
            }
        });

        txt_product.setEnabled(false);

        txt_price.setEnabled(false);

        txt_amount.setText("1");

        txt_stock.setEnabled(false);

        btn_add_stock.setText("Adicionar");
        btn_add_stock.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_add_stockActionPerformed(evt);
            }
        });

        btn_clear.setText("Limpar");
        btn_clear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_clearActionPerformed(evt);
            }
        });

        jButton1.setText("Pesquisar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelProductLayout = new javax.swing.GroupLayout(panelProduct);
        panelProduct.setLayout(panelProductLayout);
        panelProductLayout.setHorizontalGroup(
            panelProductLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelProductLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelProductLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelProductLayout.createSequentialGroup()
                        .addGroup(panelProductLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6)
                            .addComponent(jLabel7))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panelProductLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txt_id, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(panelProductLayout.createSequentialGroup()
                                .addComponent(txt_product, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton1))))
                    .addGroup(panelProductLayout.createSequentialGroup()
                        .addGroup(panelProductLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, panelProductLayout.createSequentialGroup()
                                .addComponent(jLabel10)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txt_stock))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, panelProductLayout.createSequentialGroup()
                                .addComponent(jLabel8)
                                .addGap(18, 18, 18)
                                .addComponent(txt_price, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btn_add_stock)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btn_clear)))
                .addGap(105, 105, 105)
                .addGroup(panelProductLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(panelProductLayout.createSequentialGroup()
                        .addComponent(jLabel11)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txt_discount))
                    .addGroup(panelProductLayout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addComponent(jLabel9)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txt_amount, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(42, 42, 42))
        );
        panelProductLayout.setVerticalGroup(
            panelProductLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelProductLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelProductLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(txt_id, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(panelProductLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(panelProductLayout.createSequentialGroup()
                        .addGroup(panelProductLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(txt_product, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton1))
                        .addGap(18, 18, 18)
                        .addGroup(panelProductLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8)
                            .addComponent(txt_price, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(panelProductLayout.createSequentialGroup()
                        .addGroup(panelProductLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel11)
                            .addComponent(txt_discount, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(panelProductLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel9)
                            .addComponent(txt_amount, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(18, 18, 18)
                .addGroup(panelProductLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(txt_stock, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_add_stock)
                    .addComponent(btn_clear))
                .addContainerGap(44, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(panelProduct, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane2)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel2)
                                            .addComponent(jLabel4))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(jPanel2Layout.createSequentialGroup()
                                                .addComponent(txt_cpf, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(0, 0, Short.MAX_VALUE))
                                            .addGroup(jPanel2Layout.createSequentialGroup()
                                                .addComponent(txt_name)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(btn_name_search, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(jLabel5)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txt_search_product)
                                        .addGap(98, 98, 98)))
                                .addGap(79, 79, 79)
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txt_date, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap())))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txt_cpf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(txt_date, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txt_name, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btn_name_search)))
                .addGap(12, 12, 12)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txt_search_product, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panelProduct, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(32, Short.MAX_VALUE))
        );

        tbl_shooping_cart.setBorder(javax.swing.BorderFactory.createTitledBorder("Carrinho de Compras"));

        shopping_cart.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Codigo", "Produto", "Quantidade", "Preço", "Sub. Total"
            }
        ));
        tbl_shooping_cart.setViewportView(shopping_cart);

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder("Total de Vendas"));

        jLabel12.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(204, 0, 0));
        jLabel12.setText("Total da Venda:");

        txt_total_sales.setFont(new java.awt.Font("Segoe UI", 3, 30)); // NOI18N
        txt_total_sales.setForeground(new java.awt.Color(51, 51, 51));
        txt_total_sales.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jLabel12)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txt_total_sales, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(24, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(txt_total_sales, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(35, Short.MAX_VALUE))
        );

        btn_receive_payment.setText("Receber Pagamento");
        btn_receive_payment.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_receive_paymentActionPerformed(evt);
            }
        });

        btn_cancel_sale.setText("Cancelar Venda");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(tbl_shooping_cart, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                        .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btn_receive_payment)
                        .addGap(18, 18, 18)
                        .addComponent(btn_cancel_sale, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(14, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(tbl_shooping_cart, javax.swing.GroupLayout.PREFERRED_SIZE, 306, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btn_receive_payment, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btn_cancel_sale, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(19, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tbl_productAncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_tbl_productAncestorAdded
        // TODO add your handling code here:
    }//GEN-LAST:event_tbl_productAncestorAdded

    private void tbl_productMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_productMouseClicked
        // Get the values in row of table and set in textFields
        txt_id.setText(tbl_product.getValueAt(tbl_product.getSelectedRow(), 0).toString());
        txt_product.setText(tbl_product.getValueAt(tbl_product.getSelectedRow(), 1).toString());
        txt_price.setText(tbl_product.getValueAt(tbl_product.getSelectedRow(), 2).toString());
        txt_stock.setText(tbl_product.getValueAt(tbl_product.getSelectedRow(), 3).toString());
        txt_id.setEnabled(false);

    }//GEN-LAST:event_tbl_productMouseClicked

    private void txt_cpfKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_cpfKeyReleased

    }//GEN-LAST:event_txt_cpfKeyReleased

    private void txt_cpfKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_cpfKeyPressed
        // capture key char
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            String cpf = txt_cpf.getText();
            System.out.println(cpf);
            CustomersDAO cdao = new CustomersDAO();
            Customers customer = new Customers();
            customer = cdao.SearchCustomerCPF(cpf);
            // if customer != getCPF
            if (customer.getCpf() != null) {
                // fill in the name
                txt_name.setText(customer.getName());
            } else {
                JOptionPane.showMessageDialog(null, "CPF inválido!");
            }

        }
    }//GEN-LAST:event_txt_cpfKeyPressed

    private void btn_name_searchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_name_searchActionPerformed
        String cpf = txt_cpf.getText();
        System.out.println(cpf);
        CustomersDAO cdao = new CustomersDAO();
        Customers customer = new Customers();
        customer = cdao.SearchCustomerCPF(cpf);
        // if customer != getCPF
        if (customer.getCpf() != null) {
            // fill in the name
            txt_name.setText(customer.getName());
        } else {
            JOptionPane.showMessageDialog(null, "CPF inválido!");
        }
    }//GEN-LAST:event_btn_name_searchActionPerformed

    private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated
        Date dateNow = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/YYYY | HH:mm:ss");
        txt_date.setText(String.valueOf(sdf.format(dateNow)));
        // List Products in table
        listProducts();

    }//GEN-LAST:event_formWindowActivated

    private void txt_idKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_idKeyPressed
        // key event
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            int id = Integer.valueOf(txt_id.getText());
            Product prd = new Product();
            ProductDAO pdao = new ProductDAO();

            prd = pdao.SearchProductId(id);
            // verify id != 0 n' converter types
            if (prd.getId() != 0) {
                txt_id.setText(String.valueOf(prd.getId()));
                txt_product.setText(prd.getDescribe());
                txt_price.setText(String.valueOf(prd.getPrice()));
                txt_stock.setText(String.valueOf(prd.getQtd_Stock()));
                txt_id.setEnabled(false);
            } else {
                JOptionPane.showMessageDialog(null, "Código não encontrado!");
            }
        }
    }//GEN-LAST:event_txt_idKeyPressed

    private void btn_clearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_clearActionPerformed
        CleanFields cf = new CleanFields();
        cf.cleanForm(panelProduct);
        cf.cleanForm(jPanel2);
        cf.cleanForm(jPanel4);
        txt_id.setEnabled(true);
        txt_id.requestFocus();
    }//GEN-LAST:event_btn_clearActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        int id = Integer.valueOf(txt_id.getText());
        Product prd = new Product();
        ProductDAO pdao = new ProductDAO();

        prd = pdao.SearchProductId(id);
        // verify id != 0 n' converter types
        if (prd.getId() != 0) {
            txt_id.setText(String.valueOf(prd.getId()));
            txt_product.setText(prd.getDescribe());
            txt_price.setText(String.valueOf(prd.getPrice()));
            txt_stock.setText(String.valueOf(prd.getQtd_Stock()));
            txt_id.setEnabled(false);
        } else {
            JOptionPane.showMessageDialog(null, "Código não encontrado!");
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void txt_search_productKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_search_productKeyReleased
                 // Capture text digit
        String name = "%" + txt_search_product.getText() + "%";

        ProductDAO pdao = new ProductDAO();
        List<Product> list = pdao.listSearchFilter(name);
        // Table
        DefaultTableModel dataTable = (DefaultTableModel) tbl_product.getModel();
        dataTable.setNumRows(0);

        for (Product p : list) {
            dataTable.addRow(new Object[]{
                p.getId(),
                p.getDescribe(),
                p.getPrice(),
                p.getQtd_Stock(),
                p.getSuppliers().getName()
            });
            txt_id.setEnabled(false);
        }

    }//GEN-LAST:event_txt_search_productKeyReleased

    private void btn_add_stockActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_add_stockActionPerformed
        String name = txt_product.getText();
        Product prd = new Product();
        ProductDAO pdao = new ProductDAO();
        prd = pdao.Search(name);
        
        if(prd.getDescribe() != null) {
            int stock = Integer.valueOf(txt_stock.getText());
            int qtd = Integer.valueOf(txt_amount.getText());
            price = Double.valueOf(txt_price.getText());
            quantity = Integer.valueOf(txt_amount.getText());
            subtotal = price*quantity;
            total += subtotal;
            
            if(stock >= qtd) {
                txt_total_sales.setText(String.valueOf(total));
                my_products= (DefaultTableModel) shopping_cart.getModel();
                my_products.addRow(new Object[]{
                    txt_id.getText(),
                    txt_product.getText(),
                    txt_amount.getText(),
                    txt_price.getText(),
                    subtotal
                });
                
                 // Atualiza a interface gráfica
            shopping_cart.revalidate();
            shopping_cart.repaint();
            }
            else {
                JOptionPane.showMessageDialog(null, "A quantidade desejada é maior \n que o estoque disponivel!");
            }
            
        }
        else {
            JOptionPane.showMessageDialog(null, "Não foi possivel adicionar ao carrinho de compras, Faltam informações!");
        }
    }//GEN-LAST:event_btn_add_stockActionPerformed

    private void btn_receive_paymentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_receive_paymentActionPerformed
        String name = txt_name.getText();
        String cpf = txt_cpf.getText();
        ctm = new Customers();
        CustomersDAO cdao = new CustomersDAO();
        ctm = cdao.Search(name);
        ctm = cdao.SearchCustomerCPF(cpf);
        
        if(ctm.getName() != null && ctm.getCpf() != null) {
            frmPayment screenPayment = new frmPayment();
            screenPayment.ctm = ctm;
            screenPayment.my_products = my_products;
            screenPayment.txt_total.setText(String.valueOf(total));
            // screen visible true
            screenPayment.setVisible(true);
            // close screen actualy
            this.dispose();
        }
        else {
            JOptionPane.showMessageDialog(null, "Verifique se está preenchido o Nome e o CPF!");
        }
        
        
    }//GEN-LAST:event_btn_receive_paymentActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(frmSales.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmSales.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmSales.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmSales.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frmSales().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_add_stock;
    private javax.swing.JButton btn_cancel_sale;
    private javax.swing.JButton btn_clear;
    private javax.swing.JButton btn_name_search;
    public javax.swing.JButton btn_receive_payment;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JPanel panelProduct;
    private javax.swing.JTable shopping_cart;
    public javax.swing.JTable tbl_product;
    private javax.swing.JScrollPane tbl_shooping_cart;
    private javax.swing.JTextField txt_amount;
    private javax.swing.JFormattedTextField txt_cpf;
    private javax.swing.JFormattedTextField txt_date;
    private javax.swing.JTextField txt_discount;
    private javax.swing.JTextField txt_id;
    private javax.swing.JTextField txt_name;
    private javax.swing.JTextField txt_price;
    private javax.swing.JTextField txt_product;
    private javax.swing.JTextField txt_search_product;
    private javax.swing.JTextField txt_stock;
    private javax.swing.JTextField txt_total_sales;
    // End of variables declaration//GEN-END:variables
}

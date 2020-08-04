public class OSPanel extends javax.swing.JPanel {

    public OSPanel() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lbimg = new javax.swing.JLabel();
        lbos = new javax.swing.JLabel();
        lbip = new javax.swing.JLabel();

        setBackground(new java.awt.Color(204, 255, 204));
        setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        setLayout(null);

        lbimg.setText("jLabel1");
        lbimg.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        add(lbimg);
        lbimg.setBounds(40, 10, 100, 90);

        lbos.setText("jLabel2");
        add(lbos);
        lbos.setBounds(40, 120, 170, 30);

        lbip.setText("jLabel3");
        add(lbip);
        lbip.setBounds(40, 160, 170, 30);
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JLabel lbimg;
    public javax.swing.JLabel lbip;
    public javax.swing.JLabel lbos;
    // End of variables declaration//GEN-END:variables
}

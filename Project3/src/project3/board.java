package project3;

/*
 * CS 2365 OOP Spring 2020
 * Zegedam Zegeye
 */
public class board extends javax.swing.JFrame {
    int hp1=10;
    int hp2 = 10;
    int hp3 = 10;
    int hp4 = 10;
    int hp5 = 10;
    int hp6 = 10;
    int hp7 = 10;
    int hp8 = 10;
    
    /**
     * Creates new form game
     */
    public board() {
        initComponents();
        this.setLocationRelativeTo(null);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel5 = new javax.swing.JPanel();
        p8 = new javax.swing.JLabel();
        p6 = new javax.swing.JLabel();
        p7 = new javax.swing.JLabel();
        p1 = new javax.swing.JLabel();
        p2 = new javax.swing.JLabel();
        p3 = new javax.swing.JLabel();
        p4 = new javax.swing.JLabel();
        p5 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        n1 = new javax.swing.JLabel();
        h1 = new javax.swing.JLabel();
        h2 = new javax.swing.JLabel();
        n2 = new javax.swing.JLabel();
        h3 = new javax.swing.JLabel();
        n3 = new javax.swing.JLabel();
        h4 = new javax.swing.JLabel();
        n4 = new javax.swing.JLabel();
        h5 = new javax.swing.JLabel();
        n5 = new javax.swing.JLabel();
        h6 = new javax.swing.JLabel();
        n6 = new javax.swing.JLabel();
        h7 = new javax.swing.JLabel();
        n7 = new javax.swing.JLabel();
        h8 = new javax.swing.JLabel();
        n8 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        Box2 = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel5.setBackground(new java.awt.Color(102, 102, 102));

        p8.setForeground(new java.awt.Color(255, 255, 255));
        p8.setText("A7");

        p6.setForeground(new java.awt.Color(255, 255, 255));
        p6.setText("A5");

        p7.setForeground(new java.awt.Color(255, 255, 255));
        p7.setText("A6");

        p1.setForeground(new java.awt.Color(255, 255, 255));
        p1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        p1.setText("User");

        p2.setForeground(new java.awt.Color(255, 255, 255));
        p2.setText("AI 1");

        p3.setForeground(new java.awt.Color(255, 255, 255));
        p3.setText("AI 2");

        p4.setForeground(new java.awt.Color(255, 255, 255));
        p4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        p4.setText("AI 3");

        p5.setForeground(new java.awt.Color(255, 255, 255));
        p5.setText("AI 4");

        jButton1.setBackground(new java.awt.Color(51, 204, 0));
        jButton1.setText("Next");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        n1.setForeground(new java.awt.Color(0, 0, 255));
        n1.setText("10");

        h1.setForeground(new java.awt.Color(255, 255, 255));
        h1.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        h1.setText("Health:");

        h2.setForeground(new java.awt.Color(255, 255, 255));
        h2.setText("Health:");

        n2.setForeground(new java.awt.Color(0, 0, 255));
        n2.setText("10");

        h3.setForeground(new java.awt.Color(255, 255, 255));
        h3.setText("Health:");

        n3.setForeground(new java.awt.Color(0, 0, 255));
        n3.setText("10");

        h4.setForeground(new java.awt.Color(255, 255, 255));
        h4.setText("Health:");

        n4.setForeground(new java.awt.Color(0, 0, 255));
        n4.setText("10");

        h5.setForeground(new java.awt.Color(255, 255, 255));
        h5.setText("Health:");

        n5.setForeground(new java.awt.Color(0, 0, 255));
        n5.setText("10");

        h6.setForeground(new java.awt.Color(255, 255, 255));
        h6.setText("Health:");

        n6.setForeground(new java.awt.Color(0, 0, 255));
        n6.setText("10");

        h7.setForeground(new java.awt.Color(255, 255, 255));
        h7.setText("Health:");

        n7.setForeground(new java.awt.Color(0, 0, 255));
        n7.setText("10");

        h8.setForeground(new java.awt.Color(255, 255, 255));
        h8.setText("Health:");

        n8.setForeground(new java.awt.Color(0, 0, 255));
        n8.setText("10");

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Project3/Outlaw.PNG")));

        Box2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Outlaw", "Deputy", "Sheriff", "Renegade" }));
        Box2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Box2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(p2, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(86, 86, 86))
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(48, 48, 48)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(11, 11, 11)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addComponent(p3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(78, 78, 78))
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addComponent(p8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(93, 93, 93))))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addComponent(h8)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(n8))
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addComponent(h3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(n3))
                            .addComponent(p7, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                        .addComponent(p5, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(104, 104, 104))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                        .addComponent(p6, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(101, 101, 101))))
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(283, 283, 283)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(Box2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel5Layout.createSequentialGroup()
                                        .addComponent(h4)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(n4))
                                    .addComponent(p4, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(6, 6, 6))))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(122, 122, 122)
                        .addComponent(p1, javax.swing.GroupLayout.PREFERRED_SIZE, 387, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(h1, javax.swing.GroupLayout.PREFERRED_SIZE, 303, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(n1))
                    .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel5Layout.createSequentialGroup()
                            .addGap(38, 38, 38)
                            .addComponent(h7)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(n7))
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 359, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(131, 131, 131)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(h2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(n2)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addComponent(h5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(n5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(h6)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(n6)))
                        .addGap(84, 84, 84))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                        .addComponent(jButton1)
                        .addGap(26, 26, 26))))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(86, 86, 86)
                .addComponent(p4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(h4)
                    .addComponent(n4))
                .addGap(18, 18, 18)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(p2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 18, Short.MAX_VALUE)
                    .addComponent(p3))
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(h2)
                        .addComponent(n2))
                    .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(h3)
                        .addComponent(n3)))
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(70, 70, 70)
                        .addComponent(p8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(h8)
                            .addComponent(n8)
                            .addComponent(Box2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(136, 136, 136))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(58, 58, 58)
                        .addComponent(p6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(h6)
                            .addComponent(n6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(53, 53, 53)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(p5)
                            .addComponent(p7))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(h5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(n5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(h7)
                            .addComponent(n7))
                        .addGap(67, 67, 67)))
                .addComponent(p1, javax.swing.GroupLayout.DEFAULT_SIZE, 18, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(n1)
                    .addComponent(h1, javax.swing.GroupLayout.DEFAULT_SIZE, 18, Short.MAX_VALUE))
                .addGap(26, 26, 26)
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 5, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton1)
                .addGap(50, 50, 50))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

        hp1 = hp1-1;
        hp2=hp2-2;
        hp3=hp3-3;
        hp4=hp4-1;
        hp5=hp5-1;
        hp6=hp6-3;
        hp7=hp7-4;
        hp8=hp8-2;
        String s1 = Integer.toString(hp1);
        String s2 = Integer.toString(hp2);
        String s3 = Integer.toString(hp3);
        String s4 = Integer.toString(hp4);
        String s5 = Integer.toString(hp5);
        String s6 = Integer.toString(hp6);
        String s7 = Integer.toString(hp7);
        String s8 = Integer.toString(hp8);
        n1.setText(s1);
        n2.setText(s2);
        n3.setText(s3);
        n4.setText(s4);
        n5.setText(s5);
        n6.setText(s6);
        n7.setText(s7);
        n8.setText(s8);
        if(n1.getText().contains("-")||n2.getText().contains("-")||n3.getText().contains("-")
            ||n4.getText().contains("-")||n5.getText().contains("-")||n6.getText().contains("-")
            ||n7.getText().contains("-")||n8.getText().contains("-")){
            n1.setText("0");
            n2.setText("0");
            n3.setText("0");
            n4.setText("0");
            n5.setText("0");
            n6.setText("0");
            n7.setText("0");
            n8.setText("0");
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    public void pChoice(int ch){
        if(ch == 1){
            seen();
            p7.setVisible(false);
            p3.setVisible(false);
            p2.setVisible(false);
            p5.setVisible(false);
            h7.setVisible(false);
            h3.setVisible(false);
            h2.setVisible(false);
            h5.setVisible(false);
            n7.setVisible(false);
            n3.setVisible(false);
            n2.setVisible(false);
            n5.setVisible(false);

        }
        else if(ch == 2){
            seen();
            p8.setVisible(false);
            p4.setVisible(false);
            p6.setVisible(false);
            h8.setVisible(false);
            h4.setVisible(false);
            h6.setVisible(false);
            n8.setVisible(false);
            n4.setVisible(false);
            n6.setVisible(false);
        }
        else if(ch == 3){
            seen();
            p8.setVisible(false);
            p6.setVisible(false);
            h8.setVisible(false);
            h6.setVisible(false);
            n8.setVisible(false);
            n6.setVisible(false);
        }
        else if(ch == 4){
            seen();
            p4.setVisible(false);
            h4.setVisible(false);
            n4.setVisible(false);
        }
        else if(ch == 5){
            seen();
        }
    }
    
    private void Box2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Box2ActionPerformed
        int ch = Box2.getSelectedIndex();
        if(ch == 0){
            jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/project3/Outlaw.PNG")));
        }
        else if(ch == 1){
            jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/project3/Deputy.PNG")));
        }
        else if(ch == 2){
            jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/project3/Sheriff.PNG")));
        }
        else if(ch == 3){
            jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/project3/Renegade.PNG")));
        }
    }//GEN-LAST:event_Box2ActionPerformed

    public void seen(){
                p2.setVisible(true);
                p3.setVisible(true);
                p4.setVisible(true);
                p5.setVisible(true);
                p6.setVisible(true);
                p7.setVisible(true);
                p8.setVisible(true);
                h2.setVisible(true);
                h3.setVisible(true);
                h4.setVisible(true);
                h5.setVisible(true);
                h6.setVisible(true);
                h7.setVisible(true);
                h8.setVisible(true);
                n2.setVisible(true);
                n3.setVisible(true);
                n4.setVisible(true);
                n5.setVisible(true);
                n6.setVisible(true);
                n7.setVisible(true);
                n8.setVisible(true);                
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> Box2;
    private javax.swing.JLabel h1;
    private javax.swing.JLabel h2;
    private javax.swing.JLabel h3;
    private javax.swing.JLabel h4;
    private javax.swing.JLabel h5;
    private javax.swing.JLabel h6;
    private javax.swing.JLabel h7;
    private javax.swing.JLabel h8;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JLabel n1;
    private javax.swing.JLabel n2;
    private javax.swing.JLabel n3;
    private javax.swing.JLabel n4;
    private javax.swing.JLabel n5;
    private javax.swing.JLabel n6;
    private javax.swing.JLabel n7;
    private javax.swing.JLabel n8;
    private javax.swing.JLabel p1;
    private javax.swing.JLabel p2;
    private javax.swing.JLabel p3;
    private javax.swing.JLabel p4;
    private javax.swing.JLabel p5;
    private javax.swing.JLabel p6;
    private javax.swing.JLabel p7;
    private javax.swing.JLabel p8;
    // End of variables declaration//GEN-END:variables
}

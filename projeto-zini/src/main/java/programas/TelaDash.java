/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package programas;

import classes.AzureUser;
import classes.Componentes;
import classes.ConexaoAzure;
import com.github.britooo.looca.api.core.Looca;
import javax.swing.ImageIcon;
import classes.DataAtual;
import classes.Leitura;
import java.util.*;
import java.util.Timer;
import javax.swing.JOptionPane;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import oshi.SystemInfo;

/**
 *
 * @author JAILSON e Vizer
 */
public class TelaDash extends javax.swing.JFrame {

    DataAtual data = new DataAtual(new Date());
    SystemInfo systeminfo = new SystemInfo();
    ConexaoAzure conectar = new ConexaoAzure();
    AzureUser consulta = new AzureUser();
    Looca comp = new Looca();
    Timer timer = new Timer();
    TimerTask task = new TimerTask() {
        @Override
        public void run() {
            Double memoria = comp.getMemoria().getEmUso().doubleValue() / 1000000000;
            Double disco = comp.getGrupoDeDiscos().getTamanhoTotal().doubleValue() / 1000000000;
            lbHDD.setText(String.format("%.0f GB", disco));
            lbRAM.setText(String.format("%.2f %s", memoria, porcent));
        }
    };
    TimerTask taskcpu = new TimerTask() {
        @Override
        public void run() {
            Double cpu = comp.getProcessador().getUso();
            lbProcessador.setText(String.format("%.1f %s", cpu, porcent));
        }
    };
    final long Seconds = (1000 * 3);
    final long SecondsCpu = (1000 * 1);
    String porcent = "%";
    String SO = comp.getSistema().getSistemaOperacional();
    String ultimaverif = data.getDiaHora();
    String fabSO = comp.getSistema().getFabricante();
    Long tempoIniciado = comp.getSistema().getTempoDeAtividade();
    String nomeComputador;
    String Memoriacad = "Memoria";
    String Processcad = "Processador";
    String Discocad = "Disco";
    Integer fkEquipe = 1;
    Integer fkUsuario = 2;

    /**
     * Creates new form TelaDash
     */
    public TelaDash() {
        this.timer = new Timer();
        initComponents();
        timer.scheduleAtFixedRate(task, 0, Seconds);
        timer.scheduleAtFixedRate(taskcpu, 0, SecondsCpu);

        nomeComputador = JOptionPane.showInputDialog("Digite o nome do seu desktop");

        List<Leitura> consultaCadastro = ConexaoAzure.jdbcTemplate.query(
                "Select nomeComputador, idComputador from tbComputador where nomeComputador = ?",
                new BeanPropertyRowMapper(Leitura.class),
                nomeComputador);

        List<Leitura> consultaDataHora = ConexaoAzure.jdbcTemplate.query(
                "Select ultimaVerificacaoComponentes from tbComputador where nomeComputador = ?",
                new BeanPropertyRowMapper(Leitura.class),
                nomeComputador);

        for (Leitura leitura : consultaDataHora) {
            lbData.setText(leitura.getUltimaVerificacao());
        }

        if (!consultaCadastro.isEmpty()) {
            ConexaoAzure.jdbcTemplate.update(
                    "update tbComputador set fabricanteSO = ?, tipoSistemaOperacional = ?, ultimaVerificacaoComponentes = ?, tempoAtividade  = ?, fkEquipe  = ?, fkUsuario  = ? "
                    + "where nomeComputador = ?",
                    fabSO, SO, ultimaverif, tempoIniciado, fkEquipe, fkUsuario, nomeComputador);

        } else {
            nomeComputador = JOptionPane.showInputDialog("Computador nao encontrado!! Registre um novo desktop");

            ConexaoAzure.jdbcTemplate.update(
                    "insert into tbComputador"
                    + "(nomeComputador, fabricanteSO, tipoSistemaOperacional, ultimaVerificacaoComponentes, tempoAtividade, fkEquipe, fkUsuario)"
                    + " values (?, ?, ?, ?, ?, ? ,?)", nomeComputador, fabSO, SO, ultimaverif, tempoIniciado, fkEquipe, fkUsuario);

            List<Leitura> id = ConexaoAzure.jdbcTemplate.query(
                    "select top 1 idComputador from tbComputador order by idComputador desc",
                    new BeanPropertyRowMapper(Leitura.class));

            for (Leitura caco : id) {
                ConexaoAzure.jdbcTemplate.update(
                        "Insert into tbComponentes values (?,?,?,?,?)",
                        Memoriacad, Memoriacad, 75, 90, caco.getIdComputador());
                ConexaoAzure.jdbcTemplate.update(
                        "Insert into tbComponentes values (?,?,?,?,?)",
                        Processcad, Processcad, 75, 90, caco.getIdComputador());
                ConexaoAzure.jdbcTemplate.update(
                        "Insert into tbComponentes values (?,?,?,?,?)",
                        Discocad, Discocad, 75, 90, caco.getIdComputador());
            }

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
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        lbicon3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        lbProcessador = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        lbHDD = new javax.swing.JLabel();
        lbRAM = new javax.swing.JLabel();
        lbData = new javax.swing.JLabel();
        lbicon4 = new javax.swing.JLabel();
        lbicon5 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        jPanel1.setBackground(new java.awt.Color(51, 51, 51));
        jPanel1.setLayout(null);

        jPanel2.setBackground(new java.awt.Color(252, 197, 119));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 760, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jPanel1.add(jPanel2);
        jPanel2.setBounds(10, 110, 760, 1);

        jLabel1.setFont(new java.awt.Font("Monospaced", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Dashboards");
        jPanel1.add(jLabel1);
        jLabel1.setBounds(10, 30, 770, 50);

        lbicon3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Grafico.png"))); // NOI18N
        jPanel1.add(lbicon3);
        lbicon3.setBounds(90, 190, 110, 90);

        jLabel5.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Processador");
        jPanel1.add(jLabel5);
        jLabel5.setBounds(580, 300, 150, 40);

        jLabel6.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Disco Rígido");
        jPanel1.add(jLabel6);
        jLabel6.setBounds(70, 300, 150, 40);

        jLabel7.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Memória");
        jPanel1.add(jLabel7);
        jLabel7.setBounds(350, 300, 120, 40);

        lbProcessador.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        lbProcessador.setForeground(new java.awt.Color(255, 255, 255));
        lbProcessador.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbProcessador.setText("-----");
        jPanel1.add(lbProcessador);
        lbProcessador.setBounds(520, 340, 260, 40);

        jLabel12.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(252, 197, 119));
        jLabel12.setText("Ultima data visualizada:");
        jPanel1.add(jLabel12);
        jLabel12.setBounds(220, 450, 170, 40);

        jLabel8.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Copyright ©2020  ini. Designed By   INI DEVELOPMENT"); // NOI18N
        jPanel1.add(jLabel8);
        jLabel8.setBounds(190, 510, 400, 50);

        jLabel2.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(252, 197, 119));
        jLabel2.setText("Z");
        jPanel1.add(jLabel2);
        jLabel2.setBounds(428, 527, 10, 17);

        jLabel3.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(252, 197, 119));
        jLabel3.setText("Z");
        jPanel1.add(jLabel3);
        jLabel3.setBounds(304, 527, 10, 17);

        lbHDD.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        lbHDD.setForeground(new java.awt.Color(255, 255, 255));
        lbHDD.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbHDD.setText("-----");
        jPanel1.add(lbHDD);
        lbHDD.setBounds(10, 340, 260, 40);

        lbRAM.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        lbRAM.setForeground(new java.awt.Color(255, 255, 255));
        lbRAM.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbRAM.setText("-----");
        jPanel1.add(lbRAM);
        lbRAM.setBounds(270, 340, 260, 40);

        lbData.setFont(new java.awt.Font("Monospaced", 1, 14)); // NOI18N
        lbData.setForeground(new java.awt.Color(252, 197, 119));
        jPanel1.add(lbData);
        lbData.setBounds(390, 450, 220, 40);

        lbicon4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Grafico.png"))); // NOI18N
        jPanel1.add(lbicon4);
        lbicon4.setBounds(600, 200, 110, 90);

        lbicon5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Grafico.png"))); // NOI18N
        jPanel1.add(lbicon5);
        lbicon5.setBounds(350, 190, 110, 90);

        jLabel4.setFont(new java.awt.Font("Monospaced", 1, 24)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Sair");
        jLabel4.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel4MouseClicked(evt);
            }
        });
        jPanel1.add(jLabel4);
        jLabel4.setBounds(20, 30, 80, 50);

        getContentPane().add(jPanel1);
        jPanel1.setBounds(0, -10, 790, 570);

        setSize(new java.awt.Dimension(803, 601));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jLabel4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel4MouseClicked
        int trocaUsuario = JOptionPane.showConfirmDialog(null, "Tem certeza que deseja trocar de usúario ?", "Atenção!", JOptionPane.YES_NO_OPTION);
        if (trocaUsuario == JOptionPane.YES_OPTION) {
            // System.exit(0);
           task.cancel();
           taskcpu.cancel();
            TelaLogin log = new TelaLogin();
            log.setVisible(true);
            dispose();
        }
    }//GEN-LAST:event_jLabel4MouseClicked

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
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(TelaDash.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaDash.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaDash.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaDash.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaDash().setVisible(true);

            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel lbData;
    private javax.swing.JLabel lbHDD;
    private javax.swing.JLabel lbProcessador;
    private javax.swing.JLabel lbRAM;
    private javax.swing.JLabel lbicon3;
    private javax.swing.JLabel lbicon4;
    private javax.swing.JLabel lbicon5;
    // End of variables declaration//GEN-END:variables
}

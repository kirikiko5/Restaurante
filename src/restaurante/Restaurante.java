/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package restaurante;

import java.util.ArrayList;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

/**
 *
 * @author enrique
 */
public final class Restaurante extends javax.swing.JFrame {

    /**
     * Creates new form Restaurante
     */
    private ArrayList<Grupo> arrayGrupos;
    private int gruposT;
    private final Maitre m1, m2;
    private final Mesa[] mesas2;
    private final Mesa[] mesas4;
    private final Mesa[] mesas6;
    private final Mesa[] mesas8;
    
    public Restaurante() {
        initComponents();
        metodoInicial();
        
        arrayGrupos = new ArrayList<>();
        m1 = new Maitre(this, arrayGrupos, 1, true);
        m2 = new Maitre(this, arrayGrupos, 2, false);
        Camarero[] camareros = new Camarero[5]; 
        mesas2 = new Mesa[5];
        mesas4 = new Mesa[9];
        mesas6 = new Mesa[5];
        mesas8 = new Mesa[3];
        
        for (int i = 0; i < camareros.length; i++) {
            camareros[i] = new Camarero(i, this);
        }

        Timer timer = new Timer();
        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                generarGrupos();
            }
        }, 0, (long)(500 + 1000 * Math.random()));
        
        
        Timer timer2 = new Timer();
        timer2.scheduleAtFixedRate(new TimerTask() {
            int personas = 1;
            @Override
            public void run() {
                if (arrayGrupos.isEmpty()){
                    System.out.println("No hay grupos disponibles");
                } else {
                    int tamano = arrayGrupos.size();
                    Random r = new Random();
                    int aleatorio = r.nextInt(tamano);
                        if (arrayGrupos.get(aleatorio).comprobarCompleto()){
                            System.out.println("Grupo de tamano " + arrayGrupos.get(aleatorio).getCapacidad() + " completo");
                            getMaitre().asignarEspera(arrayGrupos.remove(aleatorio));
                        } else {
                            Persona p = new Persona(personas, arrayGrupos.get(aleatorio));
                            arrayGrupos.get(aleatorio).add(p);
                            personas++;
                        }
                }
            }
        }, 250, 400);
        
        
    }
    
    public Maitre getMaitre () {
        if (m1.getDisponible() == false) {
            return m1;
        } else {
            return m2;
        }
    }
    
    public void metodoInicial() {
        TextMaitre.setEditable(false);
        TextEsp4.setEditable(false);
        TextEsp8.setEditable(false);
        TextEsp2.setEditable(false);
        TextEsp6.setEditable(false);
        TextM21.setEditable(false);
        TextM22.setEditable(false);
        TextM23.setEditable(false);
        TextM24.setEditable(false);
        TextM25.setEditable(false);
        Cam21.setEditable(false);
        Cam22.setEditable(false);
        Cam23.setEditable(false);
        Cam24.setEditable(false);
        Cam25.setEditable(false);
        TextM41.setEditable(false);
        TextM42.setEditable(false);
        TextM43.setEditable(false);
        TextM44.setEditable(false);
        TextM45.setEditable(false);
        TextM46.setEditable(false);
        TextM47.setEditable(false);
        TextM48.setEditable(false);
        TextM49.setEditable(false);
        Cam41.setEditable(false);
        Cam42.setEditable(false);
        Cam46.setEditable(false);
        Cam44.setEditable(false);
        Cam43.setEditable(false);
        Cam45.setEditable(false);
        Cam49.setEditable(false);
        Cam48.setEditable(false);
        Cam47.setEditable(false);
        TextM61.setEditable(false);
        TextM62.setEditable(false);
        TextM63.setEditable(false);
        TextM64.setEditable(false);
        Cam64.setEditable(false);
        Cam61.setEditable(false);
        Cam62.setEditable(false);
        Cam63.setEditable(false);
        TextM81.setEditable(false);
        TextM82.setEditable(false);
        TextM83.setEditable(false);
        Cam81.setEditable(false);
        Cam82.setEditable(false);
        Cam83.setEditable(false);
    }
    

    public void setTextEsp2(String cadena) {
        this.TextEsp2.setText(cadena);
    }

    public void setTextEsp4(String cadena) {
        this.TextEsp4.setText(cadena);
    }

    public void setTextEsp6(String cadena) {
        this.TextEsp6.setText(cadena);
    }

    public void setTextEsp8(String cadena) {
        this.TextEsp8.setText(cadena);
    }

    public void setTextMaitre(String cadena) {
        this.TextMaitre.setText(cadena);
    }
    
    public void setTextM21(String cadena) {
        this.TextM21.setText(cadena);
    }
    
    public void setTextM22(String cadena) {
        this.TextM22.setText(cadena);
    }
    
    public void setTextM23(String cadena) {
        this.TextM23.setText(cadena);
    }
    
    public void setTextM24(String cadena) {
        this.TextM24.setText(cadena);
    }
    
    public void setTextM25(String cadena) {
        this.TextM25.setText(cadena);
    }
    
    public void setTextM41(String cadena) {
        this.TextM41.setText(cadena);
    }
    
    public void setTextM42(String cadena) {
        this.TextM42.setText(cadena);
    }
    
    public void setTextM43(String cadena) {
        this.TextM43.setText(cadena);
    }
    
    public void setTextM44(String cadena) {
        this.TextM44.setText(cadena);
    }
    
    public void setTextM45(String cadena) {
        this.TextM45.setText(cadena);
    }
    
    public void setTextM46(String cadena) {
        this.TextM46.setText(cadena);
    }
    
    public void setTextM47(String cadena) {
        this.TextM47.setText(cadena);
    }
    
    public void setTextM48(String cadena) {
        this.TextM48.setText(cadena);
    }
    
    public void setTextM49(String cadena) {
        this.TextM49.setText(cadena);
    }
    
    public void setTextM61(String cadena) {
        this.TextM61.setText(cadena);
    }
    
    public void setTextM62(String cadena) {
        this.TextM62.setText(cadena);
    }
    
    public void setTextM63(String cadena) {
        this.TextM63.setText(cadena);
    }
    
    public void setTextM64(String cadena) {
        this.TextM64.setText(cadena);
    }
    
    public void setTextM65(String cadena) {
        this.TextM65.setText(cadena);
    }
    
    public void setTextM81(String cadena) {
        this.TextM81.setText(cadena);
    }
    
    public void setTextM82(String cadena) {
        this.TextM82.setText(cadena);
    }
    
    public void setTextM83(String cadena) {
        this.TextM83.setText(cadena);
    }
    
     public void generarGrupos() {
        
                double random = Math.random();// generamos un numero al azar entre 0 y 1
                if (random < 0.125) {// el 70% de las veces
                    Grupo g1 = new Grupo (gruposT, 1);
                    arrayGrupos.add(g1);

                } else if (random < 0.25) {// el 20% de las veces
                    Grupo g2 = new Grupo (gruposT, 2);
                    arrayGrupos.add(g2);

                } else if (random < 0.375) {// el 20% de las veces
                    Grupo g3 = new Grupo (gruposT, 3);
                    arrayGrupos.add(g3);

                } else if (random < 0.5) {// el 20% de las veces
                    Grupo g4 = new Grupo (gruposT, 4);
                    arrayGrupos.add(g4);

                } else if (random < 0.625) {// el 20% de las veces
                    Grupo g5 = new Grupo (gruposT, 5);
                    arrayGrupos.add(g5);

                } else if (random < 0.75) {// el 20% de las veces
                    Grupo g6 = new Grupo (gruposT, 6);
                    arrayGrupos.add(g6);

                } else if (random < 0.875) {// el 20% de las veces
                    Grupo g7 = new Grupo (gruposT, 7);
                    arrayGrupos.add(g7);
                    
                } else {
                    Grupo g8 = new Grupo (gruposT, 8);
                    arrayGrupos.add(g8);
                }
            gruposT++;
    }
     
    
     
     
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        TextMaitre = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        Cam21 = new javax.swing.JTextField();
        Cam22 = new javax.swing.JTextField();
        Cam23 = new javax.swing.JTextField();
        Cam24 = new javax.swing.JTextField();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        Cam42 = new javax.swing.JTextField();
        Cam41 = new javax.swing.JTextField();
        Cam46 = new javax.swing.JTextField();
        Cam44 = new javax.swing.JTextField();
        Cam45 = new javax.swing.JTextField();
        jLabel24 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        Cam43 = new javax.swing.JTextField();
        jLabel28 = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        Cam49 = new javax.swing.JTextField();
        Cam48 = new javax.swing.JTextField();
        jLabel31 = new javax.swing.JLabel();
        Cam47 = new javax.swing.JTextField();
        jLabel32 = new javax.swing.JLabel();
        jLabel33 = new javax.swing.JLabel();
        jLabel34 = new javax.swing.JLabel();
        Cam64 = new javax.swing.JTextField();
        jLabel35 = new javax.swing.JLabel();
        jLabel36 = new javax.swing.JLabel();
        jLabel37 = new javax.swing.JLabel();
        Cam61 = new javax.swing.JTextField();
        jLabel38 = new javax.swing.JLabel();
        Cam62 = new javax.swing.JTextField();
        jLabel39 = new javax.swing.JLabel();
        Cam63 = new javax.swing.JTextField();
        jScrollPane6 = new javax.swing.JScrollPane();
        TextM21 = new javax.swing.JTextArea();
        jScrollPane7 = new javax.swing.JScrollPane();
        TextM22 = new javax.swing.JTextArea();
        jScrollPane8 = new javax.swing.JScrollPane();
        TextM23 = new javax.swing.JTextArea();
        jScrollPane9 = new javax.swing.JScrollPane();
        TextM24 = new javax.swing.JTextArea();
        jScrollPane10 = new javax.swing.JScrollPane();
        TextM25 = new javax.swing.JTextArea();
        jScrollPane11 = new javax.swing.JScrollPane();
        TextM41 = new javax.swing.JTextArea();
        jScrollPane12 = new javax.swing.JScrollPane();
        TextM42 = new javax.swing.JTextArea();
        jScrollPane13 = new javax.swing.JScrollPane();
        TextM43 = new javax.swing.JTextArea();
        jScrollPane14 = new javax.swing.JScrollPane();
        TextM44 = new javax.swing.JTextArea();
        jScrollPane15 = new javax.swing.JScrollPane();
        TextM45 = new javax.swing.JTextArea();
        jScrollPane16 = new javax.swing.JScrollPane();
        TextM46 = new javax.swing.JTextArea();
        jScrollPane17 = new javax.swing.JScrollPane();
        TextM47 = new javax.swing.JTextArea();
        jScrollPane18 = new javax.swing.JScrollPane();
        TextM48 = new javax.swing.JTextArea();
        jScrollPane19 = new javax.swing.JScrollPane();
        TextM49 = new javax.swing.JTextArea();
        jScrollPane20 = new javax.swing.JScrollPane();
        TextM61 = new javax.swing.JTextArea();
        jScrollPane24 = new javax.swing.JScrollPane();
        TextM62 = new javax.swing.JTextArea();
        jScrollPane27 = new javax.swing.JScrollPane();
        TextM63 = new javax.swing.JTextArea();
        jScrollPane28 = new javax.swing.JScrollPane();
        TextM64 = new javax.swing.JTextArea();
        jLabel46 = new javax.swing.JLabel();
        jScrollPane25 = new javax.swing.JScrollPane();
        TextM65 = new javax.swing.JTextArea();
        Cam65 = new javax.swing.JTextField();
        jLabel40 = new javax.swing.JLabel();
        jLabel41 = new javax.swing.JLabel();
        jLabel42 = new javax.swing.JLabel();
        jLabel43 = new javax.swing.JLabel();
        jScrollPane5 = new javax.swing.JScrollPane();
        TextM81 = new javax.swing.JTextArea();
        Cam81 = new javax.swing.JTextField();
        jLabel44 = new javax.swing.JLabel();
        jScrollPane21 = new javax.swing.JScrollPane();
        TextM82 = new javax.swing.JTextArea();
        Cam82 = new javax.swing.JTextField();
        jLabel45 = new javax.swing.JLabel();
        jScrollPane22 = new javax.swing.JScrollPane();
        TextM83 = new javax.swing.JTextArea();
        Cam83 = new javax.swing.JTextField();
        Cam25 = new javax.swing.JTextField();
        jScrollPane23 = new javax.swing.JScrollPane();
        TextEsp2 = new javax.swing.JTextArea();
        jScrollPane26 = new javax.swing.JScrollPane();
        TextEsp4 = new javax.swing.JTextArea();
        jScrollPane1 = new javax.swing.JScrollPane();
        TextEsp6 = new javax.swing.JTextArea();
        jScrollPane2 = new javax.swing.JScrollPane();
        TextEsp8 = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("ENTRADA:");

        jLabel2.setText("Situacion del Maitre: ");

        jLabel3.setText("Esperando");

        jLabel4.setText("mesa de 2:");

        jLabel5.setText("Esperando");

        jLabel6.setText("mesa de 4:");

        jLabel7.setText("Esperando");

        jLabel8.setText("mesa de 6:");

        jLabel9.setText("Esperando");

        jLabel10.setText("mesa de 8:");

        jLabel11.setText("COMEDOR");

        jLabel12.setText("MESAS DE TAMAÑO 2:");

        jLabel13.setText("Comensales");

        jLabel14.setText("Mesa 1:");

        jLabel15.setText("Mesa 2:");

        jLabel16.setText("Mesa 3:");

        jLabel17.setText("Mesa 4:");

        jLabel18.setText("Mesa 5:");

        jLabel19.setText("Camarero atendiendo");

        jLabel20.setText("Mesa 8:");

        jLabel21.setText("Mesa 9:");

        jLabel22.setText("Mesa 10:");

        jLabel23.setText("Camarero atendiendo");

        jLabel24.setText("MESAS DE TAMAÑO 4:");

        jLabel25.setText("Comensales");

        jLabel26.setText("Mesa 6:");

        jLabel27.setText("Mesa 7:");

        jLabel28.setText("Mesa 11:");

        jLabel29.setText("Mesa 12:");

        jLabel30.setText("Mesa 13:");

        jLabel31.setText("Mesa 14:");

        jLabel32.setText("MESAS DE TAMAÑO 6:");

        jLabel33.setText("MESAS DE TAMAÑO 6:");

        jLabel34.setText("Comensales");

        jLabel35.setText("Mesa 15:");

        jLabel36.setText("Mesa 16:");

        jLabel37.setText("Camarero atendiendo");

        jLabel38.setText("Mesa 17:");

        jLabel39.setText("Mesa 18:");

        TextM21.setColumns(20);
        TextM21.setRows(5);
        jScrollPane6.setViewportView(TextM21);

        TextM22.setColumns(20);
        TextM22.setRows(5);
        jScrollPane7.setViewportView(TextM22);

        TextM23.setColumns(20);
        TextM23.setRows(5);
        jScrollPane8.setViewportView(TextM23);

        TextM24.setColumns(20);
        TextM24.setRows(5);
        jScrollPane9.setViewportView(TextM24);

        TextM25.setColumns(20);
        TextM25.setRows(5);
        jScrollPane10.setViewportView(TextM25);

        TextM41.setColumns(20);
        TextM41.setRows(5);
        jScrollPane11.setViewportView(TextM41);

        TextM42.setColumns(20);
        TextM42.setRows(5);
        jScrollPane12.setViewportView(TextM42);

        TextM43.setColumns(20);
        TextM43.setRows(5);
        jScrollPane13.setViewportView(TextM43);

        TextM44.setColumns(20);
        TextM44.setRows(5);
        jScrollPane14.setViewportView(TextM44);

        TextM45.setColumns(20);
        TextM45.setRows(5);
        jScrollPane15.setViewportView(TextM45);

        TextM46.setColumns(20);
        TextM46.setRows(5);
        jScrollPane16.setViewportView(TextM46);

        TextM47.setColumns(20);
        TextM47.setRows(5);
        jScrollPane17.setViewportView(TextM47);

        TextM48.setColumns(20);
        TextM48.setRows(5);
        jScrollPane18.setViewportView(TextM48);

        TextM49.setColumns(20);
        TextM49.setRows(5);
        jScrollPane19.setViewportView(TextM49);

        TextM61.setColumns(20);
        TextM61.setRows(5);
        jScrollPane20.setViewportView(TextM61);

        TextM62.setColumns(20);
        TextM62.setRows(5);
        jScrollPane24.setViewportView(TextM62);

        TextM63.setColumns(20);
        TextM63.setRows(5);
        jScrollPane27.setViewportView(TextM63);

        TextM64.setColumns(20);
        TextM64.setRows(5);
        jScrollPane28.setViewportView(TextM64);

        jLabel46.setText("Mesa 19:");

        TextM65.setColumns(20);
        TextM65.setRows(5);
        jScrollPane25.setViewportView(TextM65);

        jLabel40.setText("MESAS DE TAMAÑO 8:");

        jLabel41.setText("Comensales");

        jLabel42.setText("Camarero atendiendo");

        jLabel43.setText("Mesa 20:");

        TextM81.setColumns(20);
        TextM81.setRows(5);
        jScrollPane5.setViewportView(TextM81);

        jLabel44.setText("Mesa 21:");

        TextM82.setColumns(20);
        TextM82.setRows(5);
        jScrollPane21.setViewportView(TextM82);

        jLabel45.setText("Mesa 22:");

        TextM83.setColumns(20);
        TextM83.setRows(5);
        jScrollPane22.setViewportView(TextM83);

        TextEsp2.setColumns(20);
        TextEsp2.setRows(5);
        jScrollPane23.setViewportView(TextEsp2);

        TextEsp4.setColumns(20);
        TextEsp4.setRows(5);
        jScrollPane26.setViewportView(TextEsp4);

        TextEsp6.setColumns(20);
        TextEsp6.setRows(5);
        jScrollPane1.setViewportView(TextEsp6);

        TextEsp8.setColumns(20);
        TextEsp8.setRows(5);
        jScrollPane2.setViewportView(TextEsp8);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel11)
                            .addComponent(jLabel12))
                        .addComponent(jLabel13))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(5, 5, 5)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel19)
                            .addComponent(jLabel24)
                            .addComponent(jLabel25)
                            .addComponent(jLabel23)
                            .addComponent(jLabel33)
                            .addComponent(jLabel34)
                            .addComponent(jLabel37))))
                .addGap(51, 51, 51)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(139, 139, 139)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(TextMaitre, javax.swing.GroupLayout.PREFERRED_SIZE, 431, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel14)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel3)
                                    .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(Cam61, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jScrollPane20, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(Cam21, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel26)
                                    .addComponent(jScrollPane11, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(Cam41, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(23, 23, 23)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(131, 131, 131)
                                        .addComponent(jLabel32))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jScrollPane24, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(Cam62, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(18, 18, 18)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(Cam63, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jScrollPane27, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                            .addComponent(jScrollPane26, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGap(18, 18, 18)
                                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(jLabel15)
                                                .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(Cam22, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(jScrollPane12, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(Cam42, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(jLabel27)
                                                .addComponent(jLabel6)
                                                .addComponent(jLabel5)
                                                .addComponent(jLabel36))
                                            .addGap(18, 18, 18)
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                    .addComponent(jLabel8)
                                                    .addComponent(jLabel7))
                                                .addComponent(jLabel20)
                                                .addComponent(Cam43, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(jScrollPane13, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(Cam23, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(jScrollPane8, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(jLabel16)
                                                .addComponent(jLabel38))))))
                            .addComponent(jLabel35)
                            .addComponent(jScrollPane23, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(jScrollPane9, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(jLabel17)
                                                    .addComponent(Cam24, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(jLabel21))
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addGroup(layout.createSequentialGroup()
                                                        .addGap(18, 18, 18)
                                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                            .addComponent(jLabel18)
                                                            .addComponent(jScrollPane10, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                            .addComponent(Cam25, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                                    .addGroup(layout.createSequentialGroup()
                                                        .addGap(18, 18, 18)
                                                        .addComponent(jLabel22))))
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(jScrollPane28, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(24, 24, 24)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(jScrollPane25, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(Cam65, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                            .addGroup(layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(Cam44, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(jLabel39))
                                                .addGap(87, 87, 87)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(jLabel46)
                                                    .addComponent(Cam45, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addGroup(layout.createSequentialGroup()
                                                .addGap(24, 24, 24)
                                                .addComponent(jLabel28))
                                            .addGroup(layout.createSequentialGroup()
                                                .addGap(18, 18, 18)
                                                .addComponent(Cam46, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(layout.createSequentialGroup()
                                                .addGap(18, 18, 18)
                                                .addComponent(jLabel42))
                                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                    .addComponent(jLabel40)
                                                    .addComponent(jLabel41))
                                                .addGap(9, 9, 9))))
                                    .addComponent(Cam64, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jScrollPane14, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(jScrollPane15, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(jScrollPane16, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(5, 5, 5)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel29)
                                            .addComponent(jScrollPane17, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(Cam47, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(layout.createSequentialGroup()
                                                .addGap(24, 24, 24)
                                                .addComponent(jLabel30))
                                            .addGroup(layout.createSequentialGroup()
                                                .addGap(18, 18, 18)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(Cam48, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(jScrollPane18, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                        .addGap(19, 19, 19)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(Cam49, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jScrollPane19, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(18, 18, 18)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel43)
                                            .addGroup(layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(Cam81, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGap(40, 40, 40)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(Cam82, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addGroup(layout.createSequentialGroup()
                                                        .addGap(13, 13, 13)
                                                        .addComponent(jLabel31))
                                                    .addComponent(jLabel44)
                                                    .addComponent(jScrollPane21, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                        .addGap(46, 46, 46)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel45)
                                            .addComponent(jScrollPane22, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(Cam83, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(14, 14, 14)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel9)
                                    .addComponent(jLabel10)))
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(TextMaitre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel5)
                    .addComponent(jLabel7)
                    .addComponent(jLabel9))
                .addGap(2, 2, 2)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jLabel6)
                    .addComponent(jLabel8)
                    .addComponent(jLabel10))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane23, javax.swing.GroupLayout.DEFAULT_SIZE, 167, Short.MAX_VALUE)
                    .addComponent(jScrollPane26)
                    .addComponent(jScrollPane1)
                    .addComponent(jScrollPane2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 13, Short.MAX_VALUE)
                .addComponent(jLabel11)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel18, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel12)
                                        .addComponent(jLabel14)
                                        .addComponent(jLabel15)
                                        .addComponent(jLabel16)))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(6, 6, 6)
                                        .addComponent(jScrollPane10, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(Cam25, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(0, 0, Short.MAX_VALUE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGroup(layout.createSequentialGroup()
                                                    .addGap(18, 18, 18)
                                                    .addComponent(jLabel13))
                                                .addGroup(layout.createSequentialGroup()
                                                    .addGap(12, 12, 12)
                                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                            .addGroup(layout.createSequentialGroup()
                                                .addGap(6, 6, 6)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                    .addComponent(jScrollPane8, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(jScrollPane9, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                .addComponent(Cam23, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(Cam24))
                                            .addComponent(Cam21, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(Cam22, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel19, javax.swing.GroupLayout.Alignment.LEADING))))
                                .addGap(15, 15, 15)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel26)
                                    .addComponent(jLabel24)
                                    .addComponent(jLabel27)
                                    .addComponent(jLabel20)
                                    .addComponent(jLabel21)
                                    .addComponent(jLabel22)
                                    .addComponent(jLabel28)
                                    .addComponent(jLabel29)
                                    .addComponent(jLabel30)
                                    .addComponent(jLabel31))
                                .addGap(3, 3, 3))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel17)
                                .addGap(164, 164, 164)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane11, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane12, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane13, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane14, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane15, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel25)
                            .addComponent(jScrollPane16, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane17, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane18, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jScrollPane19, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Cam43, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(Cam48, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(Cam49, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(Cam44, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Cam46, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Cam47, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(Cam42, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(Cam41, javax.swing.GroupLayout.Alignment.LEADING))
                    .addComponent(Cam45, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel23))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel33)
                    .addComponent(jLabel35)
                    .addComponent(jLabel36)
                    .addComponent(jLabel38)
                    .addComponent(jLabel39)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel46)
                        .addComponent(jLabel40))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel43)
                            .addComponent(jLabel44)
                            .addComponent(jLabel45))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jScrollPane24, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel34))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(Cam62, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(6, 6, 6)
                                        .addComponent(jLabel37))))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(jScrollPane28, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jScrollPane25, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jScrollPane27, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(Cam63, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(Cam64, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(Cam65, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jScrollPane21, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jScrollPane22, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(Cam82, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(Cam83, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(0, 41, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jScrollPane20, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(Cam61, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel41)
                                .addGap(192, 192, 192)
                                .addComponent(jLabel42))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(Cam81, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 41, Short.MAX_VALUE)))
                .addComponent(jLabel32, javax.swing.GroupLayout.PREFERRED_SIZE, 0, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

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
            java.util.logging.Logger.getLogger(Restaurante.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Restaurante.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Restaurante.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Restaurante.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Restaurante().setVisible(true);
            }
        });
    }
    
   

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField Cam21;
    private javax.swing.JTextField Cam22;
    private javax.swing.JTextField Cam23;
    private javax.swing.JTextField Cam24;
    private javax.swing.JTextField Cam25;
    private javax.swing.JTextField Cam41;
    private javax.swing.JTextField Cam42;
    private javax.swing.JTextField Cam43;
    private javax.swing.JTextField Cam44;
    private javax.swing.JTextField Cam45;
    private javax.swing.JTextField Cam46;
    private javax.swing.JTextField Cam47;
    private javax.swing.JTextField Cam48;
    private javax.swing.JTextField Cam49;
    private javax.swing.JTextField Cam61;
    private javax.swing.JTextField Cam62;
    private javax.swing.JTextField Cam63;
    private javax.swing.JTextField Cam64;
    private javax.swing.JTextField Cam65;
    private javax.swing.JTextField Cam81;
    private javax.swing.JTextField Cam82;
    private javax.swing.JTextField Cam83;
    private javax.swing.JTextArea TextEsp2;
    private javax.swing.JTextArea TextEsp4;
    private javax.swing.JTextArea TextEsp6;
    private javax.swing.JTextArea TextEsp8;
    private javax.swing.JTextArea TextM21;
    private javax.swing.JTextArea TextM22;
    private javax.swing.JTextArea TextM23;
    private javax.swing.JTextArea TextM24;
    private javax.swing.JTextArea TextM25;
    private javax.swing.JTextArea TextM41;
    private javax.swing.JTextArea TextM42;
    private javax.swing.JTextArea TextM43;
    private javax.swing.JTextArea TextM44;
    private javax.swing.JTextArea TextM45;
    private javax.swing.JTextArea TextM46;
    private javax.swing.JTextArea TextM47;
    private javax.swing.JTextArea TextM48;
    private javax.swing.JTextArea TextM49;
    private javax.swing.JTextArea TextM61;
    private javax.swing.JTextArea TextM62;
    private javax.swing.JTextArea TextM63;
    private javax.swing.JTextArea TextM64;
    private javax.swing.JTextArea TextM65;
    private javax.swing.JTextArea TextM81;
    private javax.swing.JTextArea TextM82;
    private javax.swing.JTextArea TextM83;
    private javax.swing.JTextField TextMaitre;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JLabel jLabel42;
    private javax.swing.JLabel jLabel43;
    private javax.swing.JLabel jLabel44;
    private javax.swing.JLabel jLabel45;
    private javax.swing.JLabel jLabel46;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane10;
    private javax.swing.JScrollPane jScrollPane11;
    private javax.swing.JScrollPane jScrollPane12;
    private javax.swing.JScrollPane jScrollPane13;
    private javax.swing.JScrollPane jScrollPane14;
    private javax.swing.JScrollPane jScrollPane15;
    private javax.swing.JScrollPane jScrollPane16;
    private javax.swing.JScrollPane jScrollPane17;
    private javax.swing.JScrollPane jScrollPane18;
    private javax.swing.JScrollPane jScrollPane19;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane20;
    private javax.swing.JScrollPane jScrollPane21;
    private javax.swing.JScrollPane jScrollPane22;
    private javax.swing.JScrollPane jScrollPane23;
    private javax.swing.JScrollPane jScrollPane24;
    private javax.swing.JScrollPane jScrollPane25;
    private javax.swing.JScrollPane jScrollPane26;
    private javax.swing.JScrollPane jScrollPane27;
    private javax.swing.JScrollPane jScrollPane28;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JScrollPane jScrollPane9;
    // End of variables declaration//GEN-END:variables
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package restaurante;

import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author enrique
 */
public class Camarero extends Thread {

    private String id;
    private Mesa mesa;
    private Restaurante rest;
    private Maitre m;
   
    public Camarero(int id, Restaurante rest) {
        this.id = "C" + id;
        this.rest = rest;
        
    }

    @Override
    public void run() {
        this.start();
        while (true) {
            this.servir();
        }
    }

    public void servir() {
        try {
            mesa = buscarMesa();
            System.out.println("Atendiendo a grupo" + mesa.toString());
            sleep(7000);
            mesa.getGrupo().setAtendido(true);
        } catch (InterruptedException ex) {
            Logger.getLogger(Camarero.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public Mesa buscarMesa() {
        int rand;
        Mesa mesaAux = null;
        int[] aux = new int[4];
        for (int i = 0; i < 3; i++) {
            Random rn = new Random();
            rand = rn.nextInt(4);
            for (int j = 0; j < aux.length; j++) {
                if (rand == aux[j]) {
                    rand = rn.nextInt(4);
                } else {
                    if (rand == 0) {
                        for (int p = 0; p < m.getMesas2().length; p++) {
                            if (m.getMesas2(p).estaLibre()) {
                               mesaAux = m.getMesas2(p);
                            }
                        }
                    } else if (rand == 1) {
                        for (int p = 0; p < m.getMesas4().length; p++) {
                            if (m.getMesas4(p).estaLibre()) {
                               mesaAux = m.getMesas4(p);
                            }
                        }
                    } else if (rand == 2) {
                        for (int p = 0; p < m.getMesas6().length; p++) {
                            if (m.getMesas6(p).estaLibre()) {
                               mesaAux = m.getMesas6(p);
                            }
                        }
                    } else {
                        for (int p = 0; p < m.getMesas8().length; p++) {
                            if (m.getMesas8(p).estaLibre()) {
                               mesaAux = m.getMesas8(p);
                            }
                        }
                    }
                }
            }
        }
        return mesaAux;
    }

}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package restaurante;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author enrique
 */
public class Persona extends Thread {
    
    private Grupo grupo;
    private int id;
    private int capacidad;
    
    public Persona(int i, Grupo g) {
        this.id = i;
        this.grupo = g;
        start();
    }
    
    @Override
    public void run() {
        try {
            while (grupo.isAtendido()) {
                sleep(1000);
            }
        } catch (InterruptedException ex) {
            Logger.getLogger(Persona.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public String toString() {
        return Integer.toString(id);
    }

    
    
}

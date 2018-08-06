/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package restaurante;

import java.util.ArrayList;

/**
 *
 * @author enrique
 */
public class Grupo {

    private int id;
    private int capacidad;
    private boolean completo, atendido;
    private ArrayList<Persona> grupoPersonas;
    private ArrayList <Grupo> arrayGrupos = new ArrayList<>();
    
    public Grupo(int id, int capacidad) {
        grupoPersonas = new ArrayList<>();
        this.capacidad = capacidad;
        this.id = id;
        this.completo = false;
        this.atendido = false;
    }

    public int getId() {
        return id;
    }

    public int getCapacidad() {
        return capacidad;
    }

    public boolean isCompleto() {
        return completo;
    }

    public boolean comprobarCompleto () {
        if (grupoPersonas.size() >= capacidad) {
             completo = true;
             return true;
        } else {
            return false;
        }
    }
    
    public void add(Persona p) {
        grupoPersonas.add(p);
    }
    
     
    public synchronized void salirGrupo(Persona p) {
        arrayGrupos.remove(p);
        notifyAll();
    }

    public boolean isAtendido() {
        return atendido;
    }
    
    public void setAtendido(boolean atendido) {
            this.atendido = atendido;
    } 
    
    public boolean isVacio() {
        return grupoPersonas.isEmpty();
    }

    @Override
    public String toString() {
        String cadena = "";
        for (int i = 0; i < grupoPersonas.size(); i++) {
            cadena = cadena + "P" + grupoPersonas.get(i) + "-N" + capacidad + "-G" + id + "\n";
        }
        return cadena;
        
       }
    
    
}

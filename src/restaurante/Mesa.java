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
public class Mesa {
    
    private Grupo grupo;
    private int capacidad;
    private boolean libre;
    private Camarero camarero;

    public Mesa(int capacidad) {
        this.capacidad = capacidad;
        this.libre = true;
    }
    
    public void sentar(Grupo g) {
        this.grupo = g;
        libre = false;
    }
    
    public void levantarse () {
        while (!grupo.isVacio()) {
            grupo.salirGrupo(null);
        }
        libre = true;
    }
    
    public boolean estaLibre() {
        return libre;
    }
    
    public Grupo getGrupo() {
           return grupo;
    }

    @Override
    public String toString() {
        return grupo.toString();
    }
    
    
}

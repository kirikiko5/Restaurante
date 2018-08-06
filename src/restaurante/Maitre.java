/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package restaurante;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.NoSuchElementException;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author enrique
 */
public class Maitre extends Thread {

    private final Restaurante rest;
    private final ArrayList<Grupo> arrayGrupos;
    private final ConcurrentLinkedQueue<Grupo>[] listaEspera;
    private String estado;
    private final String id;
    private boolean disponible;
    private int gruposT;

    public Maitre(Restaurante rest, ArrayList<Grupo> arrayGrupos, int id, boolean disponible) {
        this.id = "M" + id;
        this.disponible = disponible;
        this.arrayGrupos = arrayGrupos;
        this.rest = rest;
        this.listaEspera = new ConcurrentLinkedQueue[4];
        for (int i = 0; i < listaEspera.length; i++) {
            this.listaEspera[i] = new ConcurrentLinkedQueue<>();
        }

        for (int i = 0; i < mesas2.length; i++) {
            mesas2[i] = new Mesa(2);
        }
        for (int i = 0; i < mesas4.length; i++) {
            mesas4[i] = new Mesa(4);
        }
        for (int i = 0; i < mesas6.length; i++) {
            mesas6[i] = new Mesa(6);
        }
        for (int i = 0; i < mesas8.length; i++) {
            mesas8[i] = new Mesa(8);
        }
        start();
    }

    @Override
    public void run() {
        while (true) {
            if (disponible) {
                try {
                    sleep(500);
                } catch (InterruptedException ex) {
                    Logger.getLogger(Maitre.class.getName()).log(Level.SEVERE, null, ex);
                }
            } else {
                if (listaEspera[0].isEmpty() && listaEspera[1].isEmpty() && listaEspera[2].isEmpty() && listaEspera[3].isEmpty()) {
                    estado = "Esperando comensales";
                    rest.setTextMaitre(estado);
                } else {
                    if (!listaEspera[0].isEmpty()) {
                        for (int i = 0; i < mesas2.length; i++) {
                            if (mesas2[i].estaLibre()) {
                                try {
                                    setDisponible(false);
                                    Grupo g = listaEspera[0].remove();
                                    acompanar(g);
                                    mesas2[i].sentar(g);
                                    rest.setTextEsp2(getListaEspera(0).toString());
                                    System.out.println(estado);
                                    pintarMesas2();
                                    volver();
                                    setDisponible(true);
                                } catch (NoSuchElementException e) {
                                    System.out.println("No existe elemento");
                                }
                            }
                        }
                    } else if (!listaEspera[1].isEmpty()) {
                        System.out.println(estado);
                        for (int i = 0; i < mesas4.length; i++) {
                            if (mesas4[i].estaLibre()) {
                                try {
                                    setDisponible(false);
                                    acompanar(listaEspera[1].element());
                                    mesas4[i].sentar(listaEspera[1].remove());
                                    rest.setTextEsp4(getListaEspera(1).toString());
                                    System.out.println(estado);
                                    pintarMesas4();
                                    volver();
                                    setDisponible(true);
                                } catch (NoSuchElementException e) {
                                    System.out.println("No existe elemento");
                                }
                            }
                        }
                    } else if (!listaEspera[2].isEmpty()) {
                        System.out.println(estado);
                        for (int i = 0; i < mesas6.length; i++) {
                            if (mesas6[i].estaLibre()) {
                                try {
                                    setDisponible(false);
                                    acompanar(listaEspera[2].element());
                                    mesas6[i].sentar(listaEspera[2].remove());
                                    rest.setTextEsp6(getListaEspera(2).toString());
                                    System.out.println(estado);
                                    pintarMesas6();
                                    volver();
                                    setDisponible(true);
                                } catch (NoSuchElementException e) {
                                    System.out.println("No existe elemento");
                                }
                            }
                        }
                    } else if (!listaEspera[3].isEmpty()) {
                        System.out.println(estado);
                        for (int i = 0; i < mesas8.length; i++) {
                            if (mesas8[i].estaLibre()) {
                                try {
                                    setDisponible(false);
                                    acompanar(listaEspera[3].element());
                                    mesas8[i].sentar(listaEspera[3].remove());
                                    rest.setTextEsp8(getListaEspera(3).toString());
                                    System.out.println(estado);
                                    pintarMesas8();
                                    volver();
                                    setDisponible(true);
                                } catch (NoSuchElementException e) {
                                    System.out.println("No existe elemento");
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    public void asignarEspera(Grupo g) {
        if (g.getCapacidad() == 1 || g.getCapacidad() == 2) {
            setListaEspera(0, g);
            rest.setTextEsp2(getListaEspera(0).toString());
        } else if (g.getCapacidad() == 3 || g.getCapacidad() == 4) {
            setListaEspera(1, g);
            rest.setTextEsp4(getListaEspera(1).toString());
        } else if (g.getCapacidad() == 5 || g.getCapacidad() == 6) {
            setListaEspera(2, g);
            rest.setTextEsp6(getListaEspera(2).toString());
        } else {
            setListaEspera(3, g);
            rest.setTextEsp8(getListaEspera(3).toString());
        }
    }

    public boolean getDisponible() {
        return disponible;
    }

    public void setDisponible(boolean disponible) {
        this.disponible = disponible;
    }

    public String getEstado() {
        return estado;
    }

    public Queue<Grupo> getListaEspera(int i) {
        return listaEspera[i];
    }

    public void setListaEspera(int i, Grupo g) {
        listaEspera[i].add(g);
    }

    public Mesa[] getMesas2() {
        return mesas2;
    }

    public Mesa[] getMesas4() {
        return mesas4;
    }

    public Mesa[] getMesas6() {
        return mesas6;
    }

    public Mesa[] getMesas8() {
        return mesas8;
    }

    public void acompanar(Grupo g) {
        try {
            estado = id + "Acompañando al Grupo " + g.getId();
            rest.setTextMaitre(rest.getMaitre().getEstado());
            sleep((long) (1500 + 1000 * Math.random()));
        } catch (InterruptedException ex) {
            Logger.getLogger(Maitre.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void volver() {
        try {
            estado = "Volviendo al atril";
            rest.setTextMaitre(estado);
            sleep((long) (500 + 1000 * Math.random()));
        } catch (InterruptedException ex) {
            Logger.getLogger(Maitre.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void pintarMesas2() {
        for (int i = 0; i < mesas2.length; i++) {
            if (i == 0 && !mesas2[i].estaLibre()) {
                rest.setTextM21(mesas2[i].toString());
            } else if (i == 1 && !mesas2[i].estaLibre()) {
                rest.setTextM22(mesas2[i].toString());
            } else if (i == 2 && !mesas2[i].estaLibre()) {
                rest.setTextM23(mesas2[i].toString());
            } else if (i == 3 && !mesas2[i].estaLibre()) {
                rest.setTextM24(mesas2[i].toString());
            } else if (i == 4 && !mesas2[i].estaLibre()) {
                rest.setTextM25(mesas2[i].toString());
            }
        }
    }

    public Mesa getMesas2(int i) {
        return mesas2[i];
    }

    public Mesa getMesas4(int i) {
        return mesas4[i];
    }

    public Mesa getMesas6(int i) {
        return mesas6[i];
    }

    public Mesa getMesas8(int i) {
        return mesas8[i];
    }

    public void pintarMesas4() {
        for (int i = 0; i < mesas4.length; i++) {
            if (i == 0 && !mesas4[i].estaLibre()) {
                rest.setTextM41(mesas4[i].toString());
            } else if (i == 1 && !mesas4[i].estaLibre()) {
                rest.setTextM42(mesas4[i].toString());
            } else if (i == 2 && !mesas4[i].estaLibre()) {
                rest.setTextM43(mesas4[i].toString());
            } else if (i == 3 && !mesas4[i].estaLibre()) {
                rest.setTextM44(mesas4[i].toString());
            } else if (i == 4 && !mesas4[i].estaLibre()) {
                rest.setTextM45(mesas4[i].toString());
            } else if (i == 5 && !mesas4[i].estaLibre()) {
                rest.setTextM46(mesas4[i].toString());
            } else if (i == 6 && !mesas4[i].estaLibre()) {
                rest.setTextM47(mesas4[i].toString());
            } else if (i == 7 && !mesas4[i].estaLibre()) {
                rest.setTextM48(mesas4[i].toString());
            } else if (i == 8 && !mesas4[i].estaLibre()) {
                rest.setTextM49(mesas4[i].toString());
            }
        }
    }

    public void pintarMesas6() {
        for (int i = 0; i < mesas6.length; i++) {
            if (i == 0 && !mesas6[i].estaLibre()) {
                rest.setTextM65(mesas6[i].toString());
            } else if (i == 1 && !mesas6[i].estaLibre()) {
                rest.setTextM64(mesas6[i].toString());
            } else if (i == 2 && !mesas6[i].estaLibre()) {
                rest.setTextM63(mesas6[i].toString());
            } else if (i == 3 && !mesas6[i].estaLibre()) {
                rest.setTextM62(mesas6[i].toString());
            } else if (i == 4 && !mesas6[i].estaLibre()) {
                rest.setTextM61(mesas6[i].toString());
            }
        }
    }

    public void pintarMesas8() {
        for (int i = 0; i < mesas8.length; i++) {
            if (i == 0 && !mesas8[i].estaLibre()) {
                rest.setTextM81(mesas8[i].toString());
            } else if (i == 1 && !mesas8[i].estaLibre()) {
                rest.setTextM82(mesas8[i].toString());
            } else if (i == 2 && !mesas8[i].estaLibre()) {
                rest.setTextM83(mesas8[i].toString());
            }
        }
    }

}

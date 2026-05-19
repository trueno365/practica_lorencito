/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.lorenzo.pr4entornos;

import java.util.ArrayList;

/**
 *
 * @author loren
 */
public class Cajero {
    String n;
    int c;
    double t;
    ArrayList<Producto> ps;
    /**
     * Este es el contructor para la clase cajero
     * Inizializa el cajero con un nombre y deja los contadores y la lista de productos a 0
     * @param n este es el nombre del cajero
     */
    public Cajero(String n) {
        this.n = n;
        this.c = 0;
        this.t = 0;
        this.ps = new ArrayList<>();
    }
    /**
     * Añade un nuevo producto a la lista de cajero
     * @param p El producto que se va a agregar
     */
    public void ANADIRPRODUCTO(Producto p) {
        ps.add(p);
    }
    /**
     * Elimina un producto especifico de la lista del cajero
     * @param p El producto que va a ser eliminado
     */
    public void eliminarProDUCTO(Producto p) {
        ps.remove(p);
    }
    /**
     * Calcula el importe total de la compra, incluyendo el subtotal, iva y el total general 
     * ademas muestra el ticket y vacia la lista de producto
     */
    public void cobrar() {
        double subt = 0;
        for (Producto p : ps) {
            subt = subt + p.calcularImporte();
        }
        double iva = subt * 0.21;
        double tot = subt + iva;

        System.out.println("===== TICKET =====");
        System.out.println("Cajero: " + n);
        for (Producto p : ps) {
            System.out.println(p.getNombre() + " x" + p.getCantidad()
                    + " = " + String.format("%.2f", p.calcularImporte()) + " EUR");
        }
        System.out.println("------------------");
        System.out.println("Subtotal: " + String.format("%.2f", subt) + " EUR");
        System.out.println("IVA (21%): " + String.format("%.2f", iva) + " EUR");
        System.out.println("TOTAL: " + String.format("%.2f", tot) + " EUR");
        System.out.println("==================");

        c = c + 1;
        t = t + tot;
        ps.clear();
    }
    /**
     * Calcula y muestra por pantalla el desgloce final de la recaudaccion tickets emitidos, total acumulado,
     * iva recaudado y recaudacion media
     */
    public void cierreCaja() {
        double ivaRec = t - (t / (1 + 0.21));

        System.out.println("===== CIERRE DE CAJA =====");
        System.out.println("Cajero: " + n);
        System.out.println("--------------------------");
        System.out.println("Tickets emitidos: " + c);
        System.out.println("Total facturado:  " + String.format("%.2f", t) + " EUR");
        System.out.println("IVA recaudado:    " + String.format("%.2f", ivaRec) + " EUR");
        System.out.println("==========================");
    }
    /**
     * Comprueba si la lista de productos del ticket esta vacia
     * @return true si la lista de productos esta vacia y false caso contrario
     */
    public boolean ticketVacio() {
        return ps.isEmpty();
    }
    /**
     * Obtiene el numero total de tickets que se ha emitido
     * @return devuelve eñ numero de tickets emitidos
     */
    public int getTicketsEmitidos() {
        return c;
    }
    /**
     * Obtiene la suma total recaudada durante el dia
     * @return devuelve el importe total acumulado del dia
     */
    public double getTotalDia() {
        return t;
    }
}

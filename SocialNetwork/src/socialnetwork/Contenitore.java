/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package socialnetwork;

/**
 *
 * @author riccobene
 */
public class Contenitore <X> {
    Object[] items = new Object[100];
    int posizione_libera = 0;
    
    void add(X u) {
        items[posizione_libera] = u;
        posizione_libera = posizione_libera + 1;
    }
}

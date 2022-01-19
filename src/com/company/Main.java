package com.company;

import sql.conexion;

import javax.swing.*;

import vistas.*;

public class Main {

    public static void main(String[] args) {

        conexion ver = new conexion();
        ver.conectar();

        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                JFrame principal = new Menu();
                principal.setVisible(true);
                principal.setSize(300, 300);
            }
        });
    }
}

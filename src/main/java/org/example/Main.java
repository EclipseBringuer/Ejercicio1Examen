package org.example;

import org.example.domain.entities.Cliente;
import org.example.domain.entities.ClienteDAO;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        ClienteDAO miDAO = new ClienteDAO();

        List<Cliente> clientes = new ArrayList<>(
                List.of(
                        new Cliente("Pepe", 200L, "activo"),
                        new Cliente("Juan", 100L, "inactivo"),
                        new Cliente("Ana", 450L, "activo"),
                        new Cliente("Jose", 0L, "inactivo"),
                        new Cliente("Francisco", 367L, "activo")
                )
        );

        for (Cliente cliente : clientes) {
            miDAO.insertarCliente(cliente);
        }

        miDAO.getCliente(3L);
        miDAO.getCliente(1L);

        miDAO.listarMejoresClientes(200L);
        miDAO.listarMejoresClientes(700L);

        miDAO.estadisticas();
    }
}
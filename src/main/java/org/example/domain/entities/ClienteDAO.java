package org.example.domain.entities;

import org.example.domain.ObjectDBUtil;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

public class ClienteDAO {

    public void insertarCliente(Cliente cliente) {
        EntityManager em = ObjectDBUtil.getEntityManagerFactory().createEntityManager();

        try {
            em.getTransaction().begin();
            em.persist(cliente);
            em.getTransaction().commit();
            System.out.println("Usuario creado con exito!");
        } catch (Exception e) {
            System.out.println("Fallo al guardar: " + e.getMessage());
        } finally {
            if (em != null && em.isOpen()) {
                em.close();
            }
        }
    }

    public void getCliente(Long id) {
        EntityManager em = ObjectDBUtil.getEntityManagerFactory().createEntityManager();

        try {
            var cliente = em.find(Cliente.class, id);
            System.out.println(cliente);
        } catch (Exception e) {
            System.out.println("ERROR: " + e.getMessage());
        } finally {
            if (em != null && em.isOpen()) {
                em.close();
            }
        }
    }

    public void listarMejoresClientes(Long cantidad) {
        EntityManager em = ObjectDBUtil.getEntityManagerFactory().createEntityManager();

        try {
            TypedQuery<Cliente> q = em.createQuery("SELECT o FROM Cliente o WHERE o.totalVentas>:cantidad", Cliente.class);
            q.setParameter("cantidad", cantidad);
            System.out.println(q.getResultList());
        } catch (Exception e) {
            System.out.println("ERROR: " + e.getMessage());
        } finally {
            if (em != null && em.isOpen()) {
                em.close();
            }
        }
    }

    public void estadisticas() {
        EntityManager em = ObjectDBUtil.getEntityManagerFactory().createEntityManager();

        try {
            TypedQuery<Cliente> q1 = em.createQuery("SELECT sum(c.totalVentas) FROM Cliente c", Cliente.class);
            var totalVentas = q1.getResultList();

            TypedQuery<Cliente> q2 = em.createQuery("SELECT avg(c.totalVentas) FROM Cliente c WHERE c.estado='activo'", Cliente.class);
            var promedio = q2.getResultList();

            TypedQuery<Cliente> q3 = em.createQuery("SELECT count(c) FROM Cliente c WHERE c.estado='inactivo' AND c.totalVentas>0", Cliente.class);
            var cantidadClientes = q3.getResultList();

            System.out.println("1. Total de ventas entre todos los clientes: "
                    + totalVentas
                    + "\n2. Promedio de ventas de los clientes inactivos: "
                    + promedio
                    + "\n3. Cantidad de clientes inactivos que tienen total de ventas mayor a cero: "
                    + cantidadClientes);
        } catch (Exception e) {
            System.out.println("ERROR: " + e.getMessage());
        } finally {
            if (em != null && em.isOpen()) {
                em.close();
            }
        }
    }
}

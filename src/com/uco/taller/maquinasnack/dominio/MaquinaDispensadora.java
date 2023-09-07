package com.uco.taller.maquinasnack.dominio;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
public class MaquinaDispensadora {
    private List<Snack> snacks;
    private int maxSnacks;
    private int maxUnidadesPorSnack;

    public MaquinaDispensadora(int maxSnacks, int maxUnidadesPorSnack) {
        this.snacks = new ArrayList<>();
        this.maxSnacks = maxSnacks;
        this.maxUnidadesPorSnack = maxUnidadesPorSnack;
    }

    public boolean agregarSnack(Snack snack) {
        if (snacks.size() < maxSnacks && snack.getCantidad() <= maxUnidadesPorSnack) {
            snacks.add(snack);
            return true;
        }
        return false;
    }

    public boolean sacarUnidadPorCodigo(int codigo) {
        for (Snack snack : snacks) {
            if (snack.getCodigo() == codigo && snack.getCantidad() > 0) {
                snack.cantidad -= 1;
                return true;
            }
        }
        return false;
    }

    public boolean sacarUnidadPorNombre(String nombre) {
        for (Snack snack : snacks) {
            if (snack.getNombre().equals(nombre) && snack.getCantidad() > 0) {
                snack.cantidad -= 1;
                return true;
            }
        }
        return false;
    }

    public boolean aumentarUnidadesPorCodigo(int codigo, int cantidad) {
        for (Snack snack : snacks) {
            if (snack.getCodigo() == codigo) {
                int nuevaCantidad = snack.getCantidad() + cantidad;
                if (nuevaCantidad <= maxUnidadesPorSnack) {
                    snack.setCantidad(nuevaCantidad);
                    return true;
                }
            }
        }
        return false;
    }

    public boolean aumentarUnidadesPorNombre(String nombre, int cantidad) {
        for (Snack snack : snacks) {
            if (snack.getNombre().equals(nombre)) {
                snack.cantidad += cantidad;
                return true;
            }
        }
        return false;
    }

    public boolean quitarSnack(int codigo) {
        for (Snack snack : snacks) {
            if (snack.getCodigo() == codigo) {
                snacks.remove(snack);
                return true;
            }
        }
        return false;
    }

    public int obtenerCantidadUnidades(int codigo) {
        for (Snack snack : snacks) {
            if (snack.getCodigo() == codigo) {
                return snack.getCantidad();
            }
        }
        return 0;
    }

    public int obtenerCantidadUnidadesPorNombre(String nombre) {
        for (Snack snack : snacks) {
            if (snack.getNombre().equals(nombre)) {
                return snack.getCantidad();
            }
        }
        return 0;
    }

    public List<Snack> obtenerSnacksAgotados() {
        List<Snack> agotados = new ArrayList<>();
        for (Snack snack : snacks) {
            if (snack.getCantidad() == 0) {
                agotados.add(snack);
            }
        }
        return agotados;
    }

    public List<Snack> obtenerSnacksPorValorDesc() {
        List<Snack> sortedSnacks = new ArrayList<>(snacks);
        Collections.sort(sortedSnacks, Comparator.comparingDouble(Snack::getValor).reversed());
        return sortedSnacks;
    }

    public List<Snack> obtenerSnacksPorCantidadAsc() {
        List<Snack> sortedSnacks = new ArrayList<>(snacks);
        Collections.sort(sortedSnacks, Comparator.comparingInt(Snack::getCantidad));
        return sortedSnacks;
    }
}


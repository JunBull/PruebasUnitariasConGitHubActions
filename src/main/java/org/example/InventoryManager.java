package org.example;

import java.util.HashMap;
import java.util.Map;

public class InventoryManager {
    private Map<String, Integer> inventory = new HashMap<>();

    public InventoryManager() {

    }

    public void addItem(String item, int quantity) {

        // --- 1. Validación del Nombre del Producto ---

        // Requerimiento: No puede ser vacío ni solo espacios.
        // Escenario 3: Mensaje específico requerido.
        if (item == null || item.trim().isEmpty()) {
            throw new IllegalArgumentException("El nombre del producto no puede estar vacío");
        }

        // Requerimiento: Longitud mínima 2, máxima 50.
        if (item.length() < 2 || item.length() > 50) {
            throw new IllegalArgumentException("El nombre debe tener entre 2 y 50 caracteres.");
        }

        // --- 2. Validación de la Cantidad ---

        // Requerimiento: Mínimo 1 (no 0 ni negativos).
        // Escenario 2: Lanzar excepción.
        if (quantity < 1) {
            throw new IllegalArgumentException("La cantidad debe ser al menos 1.");
        }

        // Requerimiento: Máximo 1000.
        if (quantity > 1000) {
            throw new IllegalArgumentException("La cantidad no puede exceder 1000 unidades por operación.");
        }

        // --- 3. Lógica de Inventario (Sumar si existe) ---

        if (inventory.containsKey(item)) {
            // Si ya existe, obtenemos el valor actual y sumamos la nueva cantidad
            int currentStock = inventory.get(item);
            inventory.put(item, currentStock + quantity);
        } else {
            // Si no existe, lo creamos con la cantidad inicial
            inventory.put(item, quantity);
        }

        // Nota: En Java 8+ esto se puede resumir en una línea:
        // inventory.merge(item, quantity, Integer::sum);
    }

    // Método auxiliar para consultar stock (útil para verificar las pruebas)
    public int getStock(String item) {
        return inventory.getOrDefault(item, 0);
    }
}

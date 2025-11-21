import org.example.InventoryManager;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class InventoryManagerTest {
    private static InventoryManager inventory;

    @BeforeEach
    public void iniciar(){
        inventory = new InventoryManager();
    }

    @Test
    public void Usuarioagreganuevoitemyloverifica(){
        String nombreItem = "Laptop";
        int cantidadItem = 5;

        inventory.addItem(nombreItem,cantidadItem);

        int resultadoEsperado = 5;

        Assertions.assertEquals(resultadoEsperado,inventory.getStock(nombreItem));
    }

    @Test
    public void Usuarioingresacantidadnegativa(){
        String nombreItem = "Mouse";
        int cantidadItem = -1;

        Assertions.assertThrows(IllegalArgumentException.class, ()->{
            inventory.addItem(nombreItem,cantidadItem);
        });
    }

    @Test
    public void Usuarioagreganuevoitemconnombrevacio(){
        String nombreItem = "";
        int cantidadItem = 5;

        Exception exception = Assertions.assertThrows(IllegalArgumentException.class, ()->{
            inventory.addItem(nombreItem,cantidadItem);
        });

        String mensaje = "El nombre del producto no puede estar vacío";

        Assertions.assertEquals(mensaje,exception.getMessage());
    }

    @Test
    public void Usuarioagreganuevoitemconnombrecortoylargo(){
        String nombreItem1 = "A";
        String nombreItem2 = "Aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa";
        int cantidadItem = 5;

        Assertions.assertThrows(IllegalArgumentException.class, ()->{
            inventory.addItem(nombreItem1,cantidadItem);
        });

        Assertions.assertThrows(IllegalArgumentException.class, ()->{
            inventory.addItem(nombreItem2,cantidadItem);
        });
    }

    @Test
    public void Usuarioingresaaitemcantidad1001(){
        String nombreItem = "Mouse";
        int cantidadItem = 1001;

        Assertions.assertThrows(IllegalArgumentException.class, ()->{
            inventory.addItem(nombreItem,cantidadItem);
        });
    }

    @Test
    public void Usuarioagrega2veceselmismoitemyloverifica(){
        String nombreItem = "Mouse";
        int cantidadItem = 5;
        int cantidadItem2 = 10;

        inventory.addItem(nombreItem,cantidadItem);
        inventory.addItem(nombreItem,cantidadItem2);

        int resultadoEsperado = 15;

        Assertions.assertEquals(resultadoEsperado,inventory.getStock(nombreItem));
    }

    @Test
    public void usuarioAgregaItemNull(){
        int cantidadItem = 5;

        Exception exception = Assertions.assertThrows(IllegalArgumentException.class, ()->{
            inventory.addItem(null,cantidadItem);
        });

        String mensaje = "El nombre del producto no puede estar vacío";

        Assertions.assertEquals(mensaje,exception.getMessage());
    }
}

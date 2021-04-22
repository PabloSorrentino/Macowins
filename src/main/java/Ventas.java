import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * que define la clase ventas de Macowins.
 *
 * @author Pablo Sorrentino
 * @version final
 */

public class Ventas {

  private final List<Venta> ventas;

  public Ventas() {
    ventas = new ArrayList<>();
  }

  public List<Venta> getVentas() {
    return ventas;
  }

  public void agregarVentas(Venta venta) {
    ventas.add(venta);
  }

  /**
   * Calcula usando stream las ganancias de un en dia en particular.
   *
   * @param dia (dia tipo LocalDate del cual se quiere obtener la suma de las ventas)
   * @return la suma de las ganancias de ese dia
   */

  public double gananciasDia(LocalDate dia) {

    return ventas
        .stream()
        .filter(venta -> venta.getFecha().equals(dia))
        .mapToDouble(Venta::precioVenta)
        .sum();
  }


}



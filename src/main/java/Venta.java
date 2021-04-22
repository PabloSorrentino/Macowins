import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

class Venta {

  private final List<Item> items;
  private final LocalDate fecha;
  private final TipoPago tipoPago;

  public Venta(TipoPago tipoPago) {
    items = new ArrayList<>();
    fecha = LocalDate.now();
    this.tipoPago = tipoPago;
  }

  public List<Item> getItems() {
    return items;
  }

  public LocalDate getFecha() {
    return fecha;
  }

  public void addItem(Item item) {
    items.add(item);
  }

  public double precioVenta() {
    return tipoPago.precioVenta(items);
  }


}

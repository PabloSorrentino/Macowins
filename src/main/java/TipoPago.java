import java.util.List;

abstract class TipoPago {


  public double precioVenta(List<Item> items) {
    return items
        .stream()
        .mapToDouble(Item::precioTotal)
        .sum();

  }

}

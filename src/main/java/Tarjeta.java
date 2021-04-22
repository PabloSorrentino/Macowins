import java.util.List;

class Tarjeta extends TipoPago {

  private int cantidadCuotas;
  private double coefecienteFijo;

  Tarjeta(int cantidadCuotas, double coefecienteFijo) {
    this.cantidadCuotas = cantidadCuotas;
    this.coefecienteFijo = coefecienteFijo;
  }

  public void setCantidadCuotas(int cantidadCuotas) {
    this.cantidadCuotas = cantidadCuotas;
  }

  public void setCoefecienteFijo(double coefecienteFijo) {
    this.coefecienteFijo = coefecienteFijo;
  }

  @Override
  public double precioVenta(List<Item> items) {
    return super.precioVenta(items)
           + cantidadCuotas * coefecienteFijo
           + valorReducidoPrendas(items);
  }


  private double valorReducidoPrendas(List<Item> items) {
    return items
        .stream()
        .mapToDouble(item -> item.precioTotal() * 0.01)
        .sum();
  }

}

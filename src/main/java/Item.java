
class Item {
  private final Prenda prenda;
  private final int cantidad;

  public Item(Prenda prenda, int cantidad) {
    this.prenda = prenda;
    this.cantidad = cantidad;
  }

  public Prenda getPrenda() {
    return prenda;
  }

  public int getCantidad() {
    return cantidad;
  }

  public double precioTotal() {
    return prenda.precioFinal() * cantidad;
  }


}

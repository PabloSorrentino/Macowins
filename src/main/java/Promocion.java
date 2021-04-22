class Promocion extends Estado {

  private double descuento;

  Promocion(double descuento) {
    this.descuento = descuento;
  }

  public void setDescuento(double descuento) {
    this.descuento = descuento;
  }

  @Override
  public double precioFinal(double precioBase) {
    return precioBase - descuento;
  }
}

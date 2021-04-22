class Prenda {

  private double precioBase;
  private final TipoPrenda tipoPrenda;
  private Estado estado;

  Prenda(double precio, TipoPrenda tipoPrenda, Estado estado) {
    this.precioBase = precio;
    this.estado = estado;
    this.tipoPrenda = tipoPrenda;
  }

  public double getPrecioBase() {
    return precioBase;
  }

  public void setPrecio(double precio) {
    this.precioBase = precio;
  }

  public TipoPrenda getTipoPrenda() {
    return tipoPrenda;
  }

  public Estado getEstado() {
    return estado;
  }

  public void setEstado(Estado estado) {
    this.estado = estado;
  }

  public double precioFinal() {
    return estado.precioFinal(precioBase);
  }

}

class Liquidacion extends Estado {

  @Override
  public double precioFinal(double precioBase) {
    return precioBase * 0.5;
  }
}

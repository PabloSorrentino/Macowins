
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class Tests {


  @Test
  public void elTipoDeUnaCamisaNuevaEsCAMISA() {
    assertEquals(camisaNueva(200).getTipoPrenda().toString(), "CAMISA");
  }

  @Test
  public void elTipoDeUnSacoEnLiquidacionEsSACO() {
    assertEquals(sacoEnLiquidacion(200).getTipoPrenda().toString(), "SACO");
  }

  @Test
  public void elPrecioDeUnaCamisaNuevaEsSuPrecioBase() {
    assertEquals(camisaNueva(4000).precioFinal(), 4000, 0);
    assertEquals(camisaNueva(5000).precioFinal(), 5000, 0);
  }

  @Test
  public void elPrecioDeUnSacoEnLiquidacionEsSuLaMitadDeSuPrecioBase() {
    assertEquals(sacoEnLiquidacion(3000).precioFinal(), 1500, 0);
    assertEquals(sacoEnLiquidacion(8000).precioFinal(), 4000, 0);
  }

  @Test
  public void elPrecioDeUnPantalonEnPromocionEsSuPrecioBaseMenosSuDecuento() {
    assertEquals(pantalonEnPromocion(1500, 200).precioFinal(), 1300, 0);
    assertEquals(pantalonEnPromocion(1500, 100).precioFinal(), 1400, 0);
  }

  @Test
  public void elPrecioDeUnPantalonNuevoEsSuPrecioBase() {
    assertEquals(pantalonNuevo(1800).precioFinal(), 1800, 0);
  }

  @Test
  public void elPrecioDeUnaCamisaEnLiquidacionEsLaMitadDeSuPrecioBase() {
    assertEquals(camisaEnLiquidacion(1600).precioFinal(), 800);
  }

  @Test
  public void elPrecioDeUnSacoEnPromocionEsSuPrecioBaseMenosElDescuento() {
    assertEquals(sacoEnPromocion(2000, 450).precioFinal(), 1550);
  }

  @Test
  public void elPrecioDeUnaVentaEnEfectivoNoSeModifica() {
    assertEquals(ventaEfectivoDeUnSacoEnPromocion(1500, 300).precioVenta(), 1200);
  }

  @Test
  public void elPrecioDeUnaVentaConTarjetaCincoCuotasAUnDiezPorcientoDeUnSacoEnPromocionYDosPantalonesNuevos() {
    assertEquals(ventaTarjetaDeUnSacoEnPromocionDosPantalonesNuevos(
        sacoEnPromocion(1500, 250),
        pantalonNuevo(2000),
        5,
        0.1).precioVenta(),
        5303);
  }


  private Venta ventaEfectivoDeUnSacoEnPromocion(double precioBase, double descuento) {
    Venta venta = new Venta(new Efectivo());
    venta.addItem(new Item(new Prenda(precioBase, TipoPrenda.SACO, new Promocion(descuento)), 1));
    return venta;
  }

  private Venta ventaTarjetaDeUnSacoEnPromocionDosPantalonesNuevos(Prenda saco, Prenda pantalon, int cuotas, double coeficiente) {
    Venta venta = new Venta(new Tarjeta(cuotas, coeficiente));
    venta.addItem(new Item(saco, 1));
    venta.addItem(new Item(pantalon, 2));
    return venta;
  }


  private Prenda pantalonEnPromocion(int precioBase, int descuento) {

    return new Prenda(precioBase, TipoPrenda.PANTALON, new Promocion(descuento));
  }

  private Prenda pantalonNuevo(int precioBase) {

    return new Prenda(precioBase, TipoPrenda.PANTALON, new Nueva());
  }


  private Prenda camisaNueva(double precioBase) {

    return new Prenda(precioBase, TipoPrenda.CAMISA, new Nueva());
  }

  private Prenda camisaEnLiquidacion(double precioBase) {

    return new Prenda(precioBase, TipoPrenda.CAMISA, new Liquidacion());
  }

  private Prenda sacoEnLiquidacion(double precioBase) {

    return new Prenda(precioBase, TipoPrenda.SACO, new Liquidacion());
  }

  private Prenda sacoEnPromocion(double precioBase, int descuento) {

    return new Prenda(precioBase, TipoPrenda.SACO, new Promocion(descuento));
  }

}

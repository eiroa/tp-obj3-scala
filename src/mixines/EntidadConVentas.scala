package mixines

trait EntidadConVentas{
	def montoVentas():Int
	def verificarVentasConsistencia() = this.montoVentas > 0
}
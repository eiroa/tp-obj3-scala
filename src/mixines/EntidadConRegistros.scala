package mixines

import scala.collection.mutable.MutableList
import entities.Registro

trait EntidadConRegistros {
  
	
	def registros():MutableList[Registro]
  
	def registrosIdentificados() = this.registros.filter(_.esIdentificado)
	
	def tieneRegistrosEnAnio(anio:Int) =  this.registros.filter(_.anio.==(anio)).size > 0

    def registrosIdentificadosDeAnio(anio:Int) = registrosIdentificados.filter(_.anio.==(anio))
	
	def registrosIdentificadosConVentasMayorA(monto:Int) = registrosIdentificados.filter(_.montoVentas > monto)
	
	def obtenerMontoTotalDeVentas()  =  this.registros.foldRight(0){(b:Registro,a:Int) =>   a + b.montoVentas }
	
    def obtenerMontoTotalDeGanacias() = this.registros.foldRight(0){(b:Registro,a:Int) =>   a + b.montoGanancia  }
    
    def aniosConVentasMayorA(monto:Int)= this.registros.filter(_.montoVentas > monto).map(_.anio)
    
    def aniosConGananciasMayorA(monto:Int)= this.registros.filter(_.montoGanancia  > monto).map(_.anio)
    
    def aniosConTasaDeGananciaMayorA(monto:Int)= this.registros.filter(_.tasaDeGanancia > monto).map(_.anio)
    
	
}
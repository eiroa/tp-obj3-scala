package mixines

import scala.collection.mutable.MutableList
import entities.Registro

trait EntidadConRegistros {
  
	
	def registros():MutableList[Registro]
  
	def registrosIdentificados() = this.registros.filter(_.esIdentificado)
	
	def tieneRegistrosEnAnio(anio:Int) =  this.registros.filter(_.anio.==(anio)).size > 0
	
	def tieneRegistrosEnAnios(anios:Int*) =  {
	  var result = 0
	  for( anioActual <- anios ){
        result = result + (this.registros.count(_.anio.==(anioActual)))
      }
	  result >0
	}
	
	def registrosDeAnio(anio:Int) = this.registros.filter(_.anio==(anio))
	

    def registrosIdentificadosDeAnio(anio:Int) = registrosIdentificados.filter(_.anio.==(anio))
	
	def registrosIdentificadosConVentasMayorA(monto:Int) = registrosIdentificados.filter(_.montoVentas > monto)
	
	def obtenerMontoTotalDeVentas()  =  this.registros.foldRight(0){(b:Registro,a:Int) =>   a + b.montoVentas }
	
    def obtenerMontoTotalDeGanacias() = this.registros.foldRight(0){(b:Registro,a:Int) =>   a + b.montoGanancia  }
    
    def aniosConVentasMayorA(monto:Int)= this.registros.filter(_.montoVentas > monto).map(_.anio)
    
    def aniosConGananciasMayorA(monto:Int)= this.registros.filter(_.montoGanancia  > monto).map(_.anio)
    
    def aniosConTasaDeGananciaMayorA(monto:Int)= this.registros.filter(_.tasaDeGanancia > monto).map(_.anio)
    
	def registrosIdentificadosDeAnios(anios:Int*) = {
      var result:MutableList[Registro] = registrosIdentificados
      var aniosABuscar:MutableList[Int]= new MutableList[Int]
      for( anioActual <- anios ){
        aniosABuscar.+=(anioActual)
      }
      result.filter(x => (aniosABuscar.contains(x.anio)))
    }
    
    def registrosDeAnios(anios:Int*) = {
      var result:MutableList[Registro] = new MutableList[Registro]
      
      for( anioActual <- anios ){
         result.++=(this.registrosDeAnio(anioActual))
      }
      result
    }
}
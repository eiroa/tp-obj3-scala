package entities

import scala.collection.mutable.MutableList

import mixines.EntidadConRegistros

class Provincia(val nombre:String) extends EntidadConRegistros{
  val registros = new MutableList[Registro]
  val departamentos = new MutableList[Departamento]
  var fuenteResponsable:Fuente = null
  
  def obtenerMontoTotalVentasDeEmpresasSegunAnio(anio:Int) = 
	    this.registros.filter(_.anio.==(anio)).foldRight(0){(b:Registro,a:Int) =>   a + b.montoVentas }

   def obtenerMontoTotalPromedioVentasDeEmpresasSegunAnio(anio:Int) = {
     if(this.tieneRegistrosEnAnio(anio)){
       this.obtenerMontoTotalVentasDeEmpresasSegunAnio(anio)  / this.registrosDeAnio(anio).size
     }else{
       0
     }
   }
	    
  
  def obtenerMontoTotalVentasDeEmpresasSegunAnios(anios:Int*) = {
		var result = 0
		for(anioActual <- anios){
		  result = result +obtenerMontoTotalVentasDeEmpresasSegunAnio(anioActual)
		}
		result
  }
  
 def obtenerMontoTotalVentasPromedioDeEmpresasSegunAnios(anios:Int*) = {
		var result = 0
		for(anioActual <- anios){
		  result = result +obtenerMontoTotalPromedioVentasDeEmpresasSegunAnio(anioActual)
		}
		result
  }
  override def toString() = {
    "Provincia (" + this.nombre  + ")"
  }
}
package entities

import scala.collection.mutable.MutableList
import mixines.EntidadConRegistros

class Provincia(val nombre:String) extends EntidadConRegistros{
  val registros = new MutableList[Registro]
  val departamentos = new MutableList[Departamento]
  
  def obtenerMontoTotalVentasDeEmpresasSegunAnio(anio:Int) = 
	    this.registros.filter(_.anio.==(anio)).foldRight(0){(b:Registro,a:Int) =>   a + b.montoVentas }
  
  
  override def toString() = {
    "Provincia (" + this.nombre  + ")"
  }
}
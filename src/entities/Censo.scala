package entities

import java.util.Date
import scala.collection.mutable.HashMap
import scala.collection.mutable.MutableList
import mixines.EntidadConRegistros

/**
 * Entidad censo, contiene una lista de registros correspondientes al año, provincia y dpto
 */
class Censo(var anio: Int , var fuente: Fuente ,
  var provincia: Provincia, var departamento: Departamento, var grupoDepartamento:GrupoDepartamento = null) 
  extends EntidadConRegistros{
	val registros: MutableList[Registro] = new MutableList()
  override def toString() = {
    "Censo(" + anio + ", hecho por " + fuente.nombre  + ", prov " + provincia.nombre  +
      ", dpto " + departamento.nombre  + " de grupo "+ grupoDepartamento + ", registros " + registros.toString
  }

  def setProvincia(prov: Provincia): Unit = {
    this.provincia = prov
  }
  
  
  
  
  
  
  
  
  
  
  
  

  
  
  def obtenerMontoVentas(): Int = {
    var result: Int = 0;    
    this.registros.foreach(x => ( result = result + x.montoVentas ))
    return result
  }
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  def obtenerMontoVentasFold() :Int = {
     return this.registros.foldRight(0) { (b: Registro, a: Int) => a + b.montoVentas }
  }
  
  
  

  def agregarRegistro(registro: Registro): Unit = {
    this.registros.+=(registro)
    //Si el registro tiene identificada la empresa, entonces se suma a si mismo el registro dentro 
    // de los registros de la empresa
    if(registro.esIdentificado){
      registro.empresa.registros.+=(registro)
    }
  }
  
  

  def obtenerMontoGanancias() = 
    this.registros.foldRight(0) { (b: Registro, a: Int) => a + b.montoGanancia }

  def obtenerMontoVentasEmpresasIdentificadas() = 
     this.registros.filter(_.esIdentificado).foldRight(0) { (b: Registro, a: Int) => a + b.montoVentas }

  def obtenerRegistrosEmpresasIdentificadas() = 
     this.registros.filter(_.esIdentificado)

  def cantidadRegistrosConVentasMayoresA(monto: Int) = 
    this.registros.filter(_.montoVentas > monto).size

  def cantidadRegistrosConGananciasMayoresA(monto: Int) = 
     this.registros.filter(_.montoGanancia > monto).size

  def cantidadRegistrosConTasaDeGananciaMayoresA(monto: Int) = 
     this.registros.filter(_.tasaDeGanancia > monto).size
     
     

}
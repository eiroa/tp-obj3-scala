package entities

import java.util.Date
import java.util.Calendar

class Registro ( 
    val anio:Int,val empresa:Empresa = null,val provincia:Provincia = null, val departamento:Departamento = null,
    val montoVentas:Int=0,val montoGanancia:Int=0,var fuente:Fuente=null){
  
  val fechaDeActualizacion:Calendar = Calendar.getInstance()
  fechaDeActualizacion.setTime(new Date())
  
  def setFuente(fuente:Fuente) = this.fuente = fuente
  
  def tasaDeGanancia()  = this.montoGanancia.toFloat /this.montoVentas.toFloat *100

  def esAnonimo()  = this.empresa == null;
  
  def esDelAnio(anio:Int) = this.fechaDeActualizacion.get(Calendar.YEAR).==(anio)

  def esIdentificado()  = this.empresa != null;
  
  def esConsistente() = 
    this.montoVentas >0
    
    override def toString() = {
    "Registro de anio " +  this.anio   + " de empresa  " + this.empresa  + " ubicado en dpto " + this.departamento 
  }

}
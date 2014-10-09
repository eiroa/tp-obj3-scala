package entities

import java.util.Date
import java.util.Calendar
import mixines.EntidadConVentas
import mixines.EntidadConAnios

class Registro ( 
    val anio:Int,val empresa:Empresa = null,val provincia:Provincia = null, val departamento:Departamento = null,
    val montoVentas:Int=0,val montoGanancia:Int=0,var fuente:Fuente=null) extends EntidadConVentas with EntidadConAnios{
  
  
   var anioDeObtencionDeDatos = this.getAnio+1
  
  def getAnio() = this.anio 
   
  def setFuente(fuente:Fuente) = this.fuente = fuente
  
  def tasaDeGanancia()  = this.montoGanancia.toFloat /this.montoVentas.toFloat *100

  def esAnonimo()  = this.empresa == null;
  
  def esIdentificado()  = this.empresa != null;
  
//  def esConsistente() = {
//	  if (this.montoVentas >0 &&  super.anioDeObtencionDeDatos >this.anio){
//	    if(this.esIdentificado){
//	      true
//	    }else{
//	      this.fuente.provinciasBajoJurisdiccion.contains(this.provincia)
//	    }
//	  }else{q
//	    false
//	  }
//	  
//  }
  
  def esConsistenteMixin() = {
	  if (super.verificarVentasConsistencia &&  super.verificarAnioConsistencia){
	    if(this.esIdentificado){
	      true
	    }else{
	      this.fuente.provinciasBajoJurisdiccion.contains(this.provincia)
	    }
	  }else{
	    false
	  }
	  
  }
    
    override def toString() = {
    "Registro de anio " +  this.anio   + " de empresa  " + this.empresa  + " ubicado en dpto " + this.departamento 
  }

}
package entities

import scala.collection.mutable.MutableList
import mixines.EntidadConRegistros





class Departamento(val nombre:String, val provincia:Provincia, var grupo:GrupoDepartamento = null) extends EntidadConRegistros{
  
    override def toString() = "departamento (" + this.nombre  + ")"
    
    def registros(): MutableList[Registro] = {
      return this.provincia.registros.filter(_.departamento.eq(this))
    }
    
    
    def registrosDeAnio(anio:Int): MutableList[Registro] = {
      return this.registros.filter(x =>( x.anio==anio) )
    }
    
    def obtenerMontoTotalVentasDeEmpresasSegunAnio(anio:Int) = 
	    this.registrosDeAnio(anio).foldRight(0){(b:Registro,a:Int) =>   a + b.montoVentas }
    

  
 }


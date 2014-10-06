package entities

import scala.collection.mutable.MutableList
import mixines.EntidadConRegistros

class GrupoDepartamento(val nombreGrupo:String) extends EntidadConRegistros{
	val departamentos = new MutableList[Departamento]
	 
	override def toString() = "grupoDepartamento (" + this.nombreGrupo  + ")"
	
	def esHomogeneo= {
	    departamentos.takeWhile( (d:Departamento) => d.provincia.eq(departamentos.head.provincia ))
	    .size == departamentos.size
	}
	
	def hayDepartamentosDeProvincia(prov:Provincia) =
	  departamentos.count(_.provincia.eq(prov)) != departamentos.size
	  
	def registros(): MutableList[Registro] = {
	  return this.departamentos.foldRight(new MutableList[Registro])
	  {(b:Departamento,a:MutableList[Registro]) =>   a.++=(b.registros)}
    }
	
    
    def registrosDeAnio(anio:Int): MutableList[Registro] = {
      return this.registros.filter(x =>(x.anio==anio) )
    }

    
    def obtenerMontoTotalVentasDeEmpresasSegunAnio(anio:Int) = 
	    this.registrosDeAnio(anio).foldRight(0){(b:Registro,a:Int) =>   a + b.montoVentas }	

    
}
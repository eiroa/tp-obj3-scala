package daos

import entities.Empresa
import scala.collection.mutable.MutableList
import scala.collection.mutable.HashMap
import entities.Provincia
import entities.Departamento

class EmpresaDao extends AbstractDao[Empresa](){
	
   def saveAndIncludeRegisters(element:Empresa,daoRegistro:RegistroDao) : Unit = {
	  this.elements += element
	  element.registros.map(daoRegistro.save(_))
	  
	}
  
	def generarMapaEmpresaMontoVentaTotal() = 
	  this.elements.
	  foldRight(new HashMap[String,Int]){(b:Empresa,a:HashMap[String,Int]) => a.+=((b.nombre,b.obtenerMontoVentasTotal))}
	
	def generarListaConNombresDeEmpresasConVentasTotalesMayoresA(monto:Int) = 
	  this.elements.filter(_.obtenerMontoVentasTotal > monto).map{_.nombre }
	
	def nombreEmpresaConMayorGananciaEnAnio(anio:Int) =
	  elements.maxBy(_.obtenerMontoGananciasEnAnio(anio)).nombre
	  
	def nombreEmpresaConMayorGananciaEnAnioYProvincia(anio:Int,prov:Provincia) =
	  elements.filter(_.provincia.eq(prov)).maxBy(_.obtenerMontoGananciasEnAnio(anio)).nombre
	  
	def nombreEmpresaConMayorGananciaEnAnioYDepartamento(anio:Int,dpto:Departamento) =
	  elements.filter(_.departamento.eq(dpto)).maxBy(_.obtenerMontoGananciasEnAnio(anio)).nombre  
	
	
}
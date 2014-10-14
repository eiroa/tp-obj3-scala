package daos

import entities.Empresa
import scala.collection.mutable.MutableList
import scala.collection.mutable.HashMap
import entities.Provincia
import entities.Departamento
import mixines.EntidadConRegistros
import entities.Registro

class EmpresaDao extends AbstractDao[Empresa]() with EntidadConRegistros{
	
  def registros = this.elements.foldRight(new MutableList[Registro])
  { (b: Empresa, a: MutableList[Registro]) => a.++=(b.registros)}
  
   def saveAndIncludeRegisters(element:Empresa,daoRegistro:RegistroDao) : Unit = {
	  this.elements += element
	  element.registros.map(daoRegistro.save(_))
	  
	}
   	def empresasConRegistrosEnAnios(anios:Int*) = {
      var result = new MutableList[Empresa]
      for( anioActual <- anios ){
        result.++=(this.elements.filter(_.tieneRegistrosEnAnio(anioActual)))
      }
      result
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
	
	
	  //Parte 3
	  
	def generarListaConNombresDeEmpresasConVentasTotalesMayoresAEnAnios(monto:Int,anios:Int*) = 
	  this.elements.filter(_.obtenerMontoVentasTotalEnAnios(anios:_*) > monto).map{_.nombre }  
	
	def nombreEmpresaConMayorGananciaEnAnios(anios:Int*) = 
	  elements.maxBy(_.obtenerMontoGananciasTotalEnAnios(anios:_*)).nombre

	def generarListaConNombresDeEmpresasConVentasPromedioTotalMayoresAEnAnios(monto:Int,anios:Int*) = 
	  this.elements.filter(_.obtenerMontoVentasPromedioTotalEnAnios(anios:_*) > monto).map{_.nombre }  
	
	def nombreEmpresaConMayorGananciaPromedioEnAnios(anios:Int*) = 
	  elements.maxBy(_.obtenerMontoGananciasPromedioTotalEnAnios(anios:_*)).nombre
}
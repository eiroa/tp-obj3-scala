package daos

import scala.collection.immutable.ListSet
import scala.collection.mutable.HashMap
import scala.collection.mutable.MutableList

import entities.Departamento
import entities.Fuente
import entities.GrupoDepartamento
import entities.Provincia
import entities.Registro

class FuenteDao extends AbstractDao[Fuente]{
	def saveAndIncludeFullRegisters(element:Fuente,registroDao:RegistroDao) :Unit = {
	  this.save(element)
	}
	
	def fuentesConRegistrosEnAnio(anio:Int) : MutableList[Fuente] = {
	  return this.elements.filter(_.censos contains(anio))
	}
	
	def fuentesConRegistrosEnAnios(anios:Int*) = {
	  var result:ListSet[Fuente] = new ListSet[Fuente]
	  for(anioActual <- anios){
	    result.++=(fuentesConRegistrosEnAnio(anioActual))
	  }
	  result
	}
	
	def fuentesConRegistrosEnAnioYProvincia(anio:Int,prov:Provincia) : MutableList[Fuente] = {
	  return this.fuentesConRegistrosEnAnio(anio).filter(_.tieneRegistrosEnProvincia(prov))
	}
	
	def fuentesConRegistrosEnAnioYDepartamento(anio:Int,dpto:Departamento) : MutableList[Fuente] = {
	  return this.fuentesConRegistrosEnAnio(anio).filter(_.tieneRegistrosEnDepartamento(dpto))
	}	
	
	def fuentesConRegistrosEnAnioYGrupo(anio:Int,grupo:GrupoDepartamento) : MutableList[Fuente] = {
	  return this.fuentesConRegistrosEnAnio(anio).filter(_.tieneRegistrosEnGrupo(grupo))
	}	
	
	def getElements():MutableList[Fuente] ={
	  return this.elements 
	}

	def getFuente(fuente:Fuente):Fuente= {
	  return getElements.find(_.eq(fuente)).get	  
	}
	
	def registrosDeFuente(fuente:Fuente) = this.getFuente(fuente).registros
	
	def generarMapaEmpresaMontoVentaTotalPorAnioYFuente(anio:Int) = {
	  this.elements.filter(_.tieneRegistrosEnAnio(anio)).
	  	foldRight(new HashMap[Fuente, Int]) { (b: Fuente, a: HashMap[Fuente, Int]) => 
	  	a.+=((b, b.obtenerMontoTotalVentasDeEmpresasSegunAnio(anio))) }
	}
	
	def registrosIdentificadosConVentasMayoresADeFuente(monto:Int,fuente:Fuente):MutableList[Registro] ={
	  return this.registrosDeFuente(fuente).filter(x=> (x.esIdentificado && x.montoVentas > monto))
	}  
	
	
	def generarListaConNombresDeEmpresasConVentasTotalesMayoresADeFuente(monto:Int,fuente:Fuente) ={
	  var result:ListSet[String] = new ListSet[String]
	  result.++(this.registrosIdentificadosConVentasMayoresADeFuente(monto,fuente).map{_.empresa.nombre})
	} 
	
	def nombreEmpresaConMayorGananciaEnAnioYFuente(anio:Int,fuente:Fuente) = 
      this.registrosDeFuente(fuente).filter(x=> (x.esIdentificado && x.anio==(anio))).maxBy(_.montoGanancia).empresa.nombre   
	
	

}
package daos

import entities._
import scala.collection.mutable.HashMap
import scala.collection.mutable.MutableList
import scala.collection.immutable.ListSet
class ProvinciaDao extends AbstractDao[Provincia]() {
  
  def saveAndIncludeRegisters(provincia:Provincia,registroDao:RegistroDao): Unit = {
    this.save(provincia)
    registroDao.elements.++=(provincia.registros )
  }
  
    def saveAndIncludeRegistersAndGroups(provincia:Provincia,registroDao:RegistroDao,
        grupoDao:GrupoDepartamentoDao): Unit = {
    this.save(provincia)
    //Concat registers
    registroDao.elements.++=(provincia.registros )
  }
    
    def getElements():MutableList[Provincia] = {
      return this.elements 
    }
    
   	def registrosDeProvincia(prov:Provincia): MutableList[Registro] = {
	 return  getElements.filter(x => (x.eq(prov) )).head.registros 
   	}
	  
	def cantidadDeRegistrosProvinciaConVentasMayoresA(monto:Int,prov:Provincia) = 
	  registrosDeProvincia(prov).count(x => (x.montoVentas > monto))
    

  
    def generarMapaEmpresaMontoVentaTotalPorAnio(anio:Int) = 
     this.elements.filter(_.tieneRegistrosEnAnio(anio)).
     foldRight(new HashMap[Provincia, Int]) { (b: Provincia, a: HashMap[Provincia, Int]) => 
     a.+=((b, b.obtenerMontoTotalVentasDeEmpresasSegunAnio(anio))) }
	
	
	def registrosIdentificadosConVentasMayoresAEnProvincia(monto:Int,prov:Provincia):MutableList[Registro] ={
	  return this.elements.filter(_.eq(prov)).foldRight(new MutableList[Registro])
	  { (b: Provincia, a: MutableList[Registro]) => a.++=(b.registrosIdentificadosConVentasMayorA(monto))}
	}  
	
	
	
	
	def generarListaConNombresDeEmpresasConVentasTotalesMayoresAEnProvincia(monto:Int,prov:Provincia) = {
	  var result:ListSet[String] = new ListSet[String]
	  result.++(this.registrosIdentificadosConVentasMayoresAEnProvincia(monto,prov).map{_.empresa.nombre})
	}
	
	  
 
  

	
}
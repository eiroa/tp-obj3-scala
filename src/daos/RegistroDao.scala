package daos

import entities.Registro
import entities.Empresa
import scala.collection.mutable.MutableList
import entities.Provincia
import entities.Departamento
import entities.GrupoDepartamento
import mixines.EntidadConRegistros

class RegistroDao extends AbstractDao[Registro] with EntidadConRegistros{	
	
    def registros = this.elements 
	
	def cantidadDeRegistrosTotalesConVentasMayorA(monto:Int) = 
	  this.elements.count(_.montoVentas > monto)
	
	def cantidadDeRegistrosTotalesConGananciasMayorA(monto:Int) = 
	  this.elements.count(_.montoGanancia  > monto)
	
	def cantidadDeRegistrosTotalesConTasaDeGananciaMayorA(monto:Int) = 
	  this.elements.count(_.tasaDeGanancia  > monto)
	
	  
	//De la parte 2 del tp  
	def cantidadDeRegistrosProvinciaConVentasMayoresA(monto:Int,prov:Provincia) = 
	  this.elements.count( x => (x.montoVentas >monto &&  x.provincia.eq(prov)))  
	  
	def cantidadDeRegistrosDepartamentoConVentasMayoresA(monto:Int,dpto:Departamento) = 
	  this.elements.count( x => (x.montoVentas >monto&&  x.departamento.eq(dpto)))  
	  
	def cantidadDeRegistrosGrupoConVentasMayoresA(monto:Int,grupo:GrupoDepartamento) = 
	  this.elements.count( x => (x.montoVentas >monto &&  (grupo.departamentos.contains(x.departamento))))
	
	  
	def cantidadDeRegistrosProvinciaConGananciasMayoresA(monto:Int,prov:Provincia) = 
	  this.elements.count( x => (x.montoGanancia  >monto &&  x.provincia.eq(prov)))  
	  
	def cantidadDeRegistrosDepartamentoConGananciasMayoresA(monto:Int,dpto:Departamento) = 
	  this.elements.count( x => (x.montoGanancia >monto&&  x.departamento.eq(dpto)))  
	  
	def cantidadDeRegistrosGrupoConGananciasMayoresA(monto:Int,grupo:GrupoDepartamento) = 
	  this.elements.count( x => (x.montoGanancia >monto && (grupo.departamentos.contains(x.departamento))))
	
	  
	def cantidadDeRegistrosProvinciaConTasaDeGananciaMayorA(monto:Int, prov:Provincia) =
	  this.elements.count( x => (x.tasaDeGanancia  >monto &&  x.provincia.eq(prov)))
	  
	def cantidadDeRegistrosDepartamentoConTasaDeGananciaMayorA(monto:Int, dpto:Departamento) =
	  this.elements.count( x => (x.tasaDeGanancia  >monto &&  x.departamento.eq(dpto)))
	  
	def cantidadDeRegistrosGrupoConTasaDeGananciaMayorA(tasa:Int, grupo:GrupoDepartamento) =
	  this.elements.count( x => (x.tasaDeGanancia >tasa && (grupo.departamentos.contains(x.departamento))))
	  
	
	def registrosConVentasMayoresAEnAnios(monto:Int, anios:Int*) = {
      var result:Int = 0
      for( anioActual <- anios ){
        result = result + (this.elements.count(x => (x.anio.==(anioActual)&& x.montoVentas>monto )))
      }
      result
    }
    

    
    def registrosConGananciasMayoresAEnAnios(monto:Int, anios:Int*) = {
      var result:Int = 0
      for( anioActual <- anios ){
        result = result + (this.elements.count(x => (x.anio.==(anioActual)&& x.montoGanancia >monto )))
      }
      result
    }
    
    def registrosConTasaDeGananciaMayorAEnAnios(monto:Int, anios:Int*) = {
      var result:Int = 0
      for( anioActual <- anios ){
        result = result + (this.elements.count(x => (x.anio.==(anioActual)&& x.tasaDeGanancia >monto )))
      }
      result
    }
	  
	  
}
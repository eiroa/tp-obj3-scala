package main

import scala.collection.mutable.HashMap
import scala.collection.mutable.MutableList

import entities.Censo
import entities.Departamento
import entities.Empresa
import entities.Fuente
import entities.Provincia
import entities.Registro

object Main {
  def main(args : Array[String]) : Unit = {
  var map:HashMap[Int,String] = new HashMap[Int,String]()
  
  map.+=((1,"reporte1"))
  var list:MutableList[Registro] = new MutableList()
  var baires:Provincia = new Provincia("Buenos Aires")
  var dpto = new Departamento("dpto",baires)
  	var censo1:Censo = new Censo(2014,new Fuente("f1"),baires,new Departamento("Avellaneda",baires))
	var censo2:Censo = new Censo(2014,new Fuente("f2"),baires,new Departamento("Avellaneda",baires))
	var censo3:Censo = new Censo(2014,new Fuente("f3"),baires,new Departamento("Quilmes",baires) )
	var censo4:Censo = new Censo(2014,new Fuente("f4"),baires,new Departamento("Avellaneda",baires))
	var censo5:Censo = new Censo(2014,new Fuente("f2"),baires,new Departamento("Quilmes",baires) )
   println(censo1.toString)
   println(censo2.toString)
   println(censo3.toString)
   println(censo4.toString)
   println(censo5.toString)
  }
}

trait volador {
  this:Empresa =>
  def volar(i:Int)
}
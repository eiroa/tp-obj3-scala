package daos

import scala.collection.mutable.MutableList

abstract class AbstractDao[t] (val elements:MutableList[t]= new MutableList[t]){
  
	def save( element: t) : Unit = this.elements.+=(element)
	
	def delete( element: t) : Unit = this.elements.dropWhile(_.==(element))
}
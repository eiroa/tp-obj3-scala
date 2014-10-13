package mixines

trait EntidadConAnios{
	def getAnio():Int	
	def anioDeObtencionDeDatos():Int
	def verificarAnioConsistencia() = this.anioDeObtencionDeDatos > this.getAnio
}
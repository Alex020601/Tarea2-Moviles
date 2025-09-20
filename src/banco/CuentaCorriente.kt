package banco

class CuentaCorriente(saldo: Float, tasaAnual: Float) : Cuenta(saldo, tasaAnual) {
    private var sobregiro: Float = 0f
    override fun retirar(cantidad: Float): Boolean {
        require(cantidad > 0f) { "Cantidad inválida" }
        if (cantidad <= saldo) {
            return super.retirar(cantidad)
        } else {
            val faltante = cantidad - saldo
            saldo = 0f
            numeroRetiros++
            sobregiro += faltante
            return true
        }
    }
    override fun consignar(cantidad: Float) {
        super.consignar(cantidad)
        if (sobregiro > 0f) {
            if (saldo >= sobregiro) {
                saldo -= sobregiro
                sobregiro = 0f
            } else {
                sobregiro -= saldo
                saldo = 0f
            }
        }
    }
    override fun imprimir() {
        val transacciones = numeroConsignaciones + numeroRetiros
        println("Saldo: $saldo")
        println("Comisión mensual: $comisionMensual")
        println("Transacciones: $transacciones")
        println("Sobregiro: $sobregiro")
    }
}

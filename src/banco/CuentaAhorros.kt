package banco

class CuentaAhorros(saldo: Float, tasaAnual: Float) : Cuenta(saldo, tasaAnual) {
    private var activa: Boolean = saldo >= 10000f
    override fun consignar(cantidad: Float) {
        if (activa) {
            super.consignar(cantidad)
        }
    }
    override fun retirar(cantidad: Float): Boolean {
        return if (activa) super.retirar(cantidad) else false
    }
    override fun extractoMensual() {
        if (numeroRetiros > 4) {
            val extras = numeroRetiros - 4
            comisionMensual += 1000f * extras
        }
        super.extractoMensual()
        activa = saldo >= 10000f
    }
    override fun imprimir() {
        val transacciones = numeroConsignaciones + numeroRetiros
        println("Saldo: $saldo")
        println("Comisión mensual: $comisionMensual")
        println("Transacciones: $transacciones")
        println("Activa: $activa")
    }
}

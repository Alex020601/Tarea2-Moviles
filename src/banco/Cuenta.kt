package banco

open class Cuenta(var saldo: Float, var tasaAnual: Float) {
    var numeroConsignaciones: Int = 0
    var numeroRetiros: Int = 0
    var comisionMensual: Float = 0f
    open fun consignar(cantidad: Float) {
        require(cantidad > 0f) { "Cantidad inválida" }
        saldo += cantidad
        numeroConsignaciones++
    }
    open fun retirar(cantidad: Float): Boolean {
        require(cantidad > 0f) { "Cantidad inválida" }
        if (cantidad <= saldo) {
            saldo -= cantidad
            numeroRetiros++
            return true
        }
        return false
    }
    fun calcularInteresMensual() {
        val interesMensual = saldo * (tasaAnual / 12f) / 100f
        saldo += interesMensual
    }
    open fun extractoMensual() {
        saldo -= comisionMensual
        if (saldo < 0f) saldo = 0f
        calcularInteresMensual()
        comisionMensual = 0f
    }
    open fun imprimir() {
        println("Saldo: $saldo")
        println("Consignaciones: $numeroConsignaciones")
        println("Retiros: $numeroRetiros")
        println("Tasa anual: $tasaAnual")
        println("Comisión mensual: $comisionMensual")
    }
}

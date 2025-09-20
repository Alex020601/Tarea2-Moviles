package banco

object MainBanco {
    @JvmStatic
    fun main(args: Array<String>) {
        val ca = CuentaAhorros(12000f, 12f)
        ca.consignar(3000f)
        ca.retirar(2000f)
        ca.retirar(500f)
        ca.retirar(500f)
        ca.retirar(500f)
        ca.retirar(500f)
        ca.extractoMensual()
        ca.imprimir()

        val cc = CuentaCorriente(2000f, 12f)
        cc.retirar(3500f)
        cc.consignar(1000f)
        cc.extractoMensual()
        cc.imprimir()
    }
}

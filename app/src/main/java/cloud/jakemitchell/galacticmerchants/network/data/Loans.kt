package cloud.jakemitchell.galacticmerchants.network.data

data class Loans(
    val due: String,
    val id: String,
    val repaymentAmount: Int,
    val status: String,
    val type: String
)
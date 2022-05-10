package ipvc.cm.cm_aulas.api

data class User(
    val int: Int,
    val name: String,
    val email: String,
    val address: Address
)

data class Address(
    val city: String,
    val zipcode: String
)

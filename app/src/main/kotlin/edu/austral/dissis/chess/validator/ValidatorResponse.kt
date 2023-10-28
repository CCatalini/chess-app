package edu.austral.dissis.chess.validator

/** Interfaz para especificar el tipo de respuesta que se espera de un validador,
 * sirve para ver el motivo de falla */
sealed interface ValidatorResponse {

    data class ValidatorResultValid(val message: String) : ValidatorResponse

    data class ValidatorResultInvalid(val message: String) : ValidatorResponse


}

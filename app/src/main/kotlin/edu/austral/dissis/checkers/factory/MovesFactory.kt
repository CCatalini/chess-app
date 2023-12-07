package edu.austral.dissis.checkers.factory

import edu.austral.dissis.checkers.validator.EnemyInBetween
import edu.austral.dissis.common.validator.Validator
import edu.austral.dissis.common.validator.board.ExactMovementValidator
import edu.austral.dissis.common.validator.board.LegalPositionValidator
import edu.austral.dissis.common.validator.board.LimitedMovementValidator
import edu.austral.dissis.common.validator.composition.AndValidator
import edu.austral.dissis.common.validator.direction.DiagonalValidator
import edu.austral.dissis.common.validator.direction.VerticalSenseValidator
import edu.austral.dissis.common.validator.obstacle.EmptyDestinationValidator

fun simpleDiagonalMoveWithSense(sense: Int) : Validator{
    return  AndValidator(listOf(
        DiagonalValidator(),
        LimitedMovementValidator(1),
        VerticalSenseValidator(sense),
        EmptyDestinationValidator(),
        LegalPositionValidator()
    ))
}

fun diagonalCaptureWithSense(sense: Int): Validator{
    // captura en diagonal, tiene que caer atrás (en diagonal) de la que se come
    return AndValidator(listOf(
        VerticalSenseValidator(sense),
        DiagonalValidator(),
        ExactMovementValidator(2),
        EnemyInBetween(),
        EmptyDestinationValidator(),
        LegalPositionValidator()
    ))
}

fun simpleDiagonalMove(): Validator{
    return AndValidator(listOf(
        DiagonalValidator(),
        LimitedMovementValidator(1),
        EmptyDestinationValidator()
    ))
}

fun diagonalCapture() : Validator{
    return  AndValidator(listOf(
        DiagonalValidator(),
        ExactMovementValidator(2),
        EnemyInBetween(),
        EmptyDestinationValidator()
    ))
}
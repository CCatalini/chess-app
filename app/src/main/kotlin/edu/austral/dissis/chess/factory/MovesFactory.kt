package edu.austral.dissis.chess.factory

import edu.austral.dissis.common.validator.Validator
import edu.austral.dissis.common.validator.composition.AndValidator
import edu.austral.dissis.common.validator.composition.OrValidator
import edu.austral.dissis.common.validator.direction.DiagonalValidator
import edu.austral.dissis.common.validator.direction.HorizontalValidator
import edu.austral.dissis.common.validator.direction.StraightValidator
import edu.austral.dissis.common.validator.obstacle.DiagonalEmptyPathValidator
import edu.austral.dissis.common.validator.obstacle.EmptyDestinationValidator
import edu.austral.dissis.common.validator.obstacle.HorizontalEmptyPathValidator
import edu.austral.dissis.common.validator.obstacle.StraightEmptyPathValidator
import edu.austral.dissis.common.validator.piece.IsEnemyValidator


fun destinationPosition(): Validator {
    return OrValidator(
        listOf(
            IsEnemyValidator(),
            EmptyDestinationValidator()
        ))
}

fun diagonalMove(): Validator {
    return AndValidator(listOf(
        DiagonalValidator(),
        DiagonalEmptyPathValidator()
    ))
}

fun straightMove(): Validator {
    return AndValidator(listOf(
        StraightValidator(),
        StraightEmptyPathValidator()
    ))
}

fun horizontalMove(): Validator{
    return AndValidator(listOf(
        HorizontalValidator(),
        HorizontalEmptyPathValidator()
    ))
}



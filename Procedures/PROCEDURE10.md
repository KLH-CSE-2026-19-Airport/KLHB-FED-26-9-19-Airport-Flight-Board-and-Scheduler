# Week 10 - Safe state updates

## Aim

Reject an invalid fixture state with a checked exception while preserving a valid fallback state.

## Procedure

1. Define `InvalidBoardStateException`.
2. Attempt an invalid `UNKNOWN` fixture.
3. Catch its message and recover using `HELD`.
4. Run and compare the output proof.

## Scope boundary

The update is a classroom state validation exercise and does not modify a live board.

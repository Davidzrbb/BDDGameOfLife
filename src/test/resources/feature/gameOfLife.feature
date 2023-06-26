Feature: Game of Life

  Scenario: A live cell with fewer than two live neighbors dies due to underpopulation
    Given a grid of size 3
    And the grid is initialized with the following state:
      """
      .O.
      ...
      ...
      """
    When I perform an iteration
    Then the grid would become:
      """
      ...
      ...
      ...
      """

  Scenario: A live cell with more than three live neighbors dies due to overcrowding
    Given a grid of size 3
    And the grid is initialized with the following state:
      """
      OOO
      O.O
      ...
      """
    When I perform an iteration
    Then the grid would become:
      """
      O.O
      O.O
      ...
      """

  Scenario: A live cell with two or three live neighbors survives
    Given a grid of size 3
    And the grid is initialized with the following state:

      """
      .O.
      OO.
      ...
      """
    When I perform an iteration
    Then the grid would become:
      """
      OO.
      OO.
      ...
      """

  Scenario: A dead cell with exactly three live neighbors becomes alive
    Given a grid of size 3
    And the grid is initialized with the following state:
      """
      ...
      O.O
      .O.
      """
    When I perform an iteration
    Then the grid would become:
      """
      ...
      .O.
      .O.
      """

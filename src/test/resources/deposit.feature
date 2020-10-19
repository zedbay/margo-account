Feature: Deposit feature

  Scenario: Un utilisateur fait un dépot
    Given Un utilisateur possède un compte avec comme solde 0€
    When Un utilisateur fait un depot de 100€
    Then La somme de son compte en banque est 100€

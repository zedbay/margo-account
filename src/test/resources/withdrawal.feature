Feature: Deposit feature

  Scenario: Un utilisateur fait un retrait avec un approvisionnement suffisant
    Given Un utilisateur possède un compte avec comme solde 100€
    When Un utilisateur fait un retrait de 10€
    Then La somme de son compte en banque est 90€

    Scenario: Un utilisateur fait un retrait avec un approvisionnement insuffisant
      Given Un utilisateur possède un compte avec comme solde 100€
      When Un utilisateur fait un retrait de 101€
      Then La somme de son compte en banque est 100€
      And Une erreur doit etre leve

      Scenario: Un utilisateur fait un retrait de l'ensemble de son solde
        Given Un utilisateur possède un compte avec comme solde 100€
        When Un utilisateur fait un retrait de 100€
        Then La somme de son compte en banque est 0€

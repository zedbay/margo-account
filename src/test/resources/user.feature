Feature: user feature

  Scenario: Un nouvel utilisateur vient d'être crée
    Given Un nouvel utilisateur est crée
    When L'utilisateur consulte la somme total de son compte
    Then La somme de son compte en banque est 0€

Feature: History feature

  Scenario: Un utilisateur fait un depot, puis il verifie que celui-ci apparait bien dans son historique
    Given Un utilisateur possède un compte
    When Un utilisateur fait un depot de 100€
    Then Le dernier releve est de type depot
    Then Le dernier releve a pour montant 100€
    Then Le dernier releve a pour balance la balance actuelle du compte

  Scenario: Un utilisateur fait un retrait, puis il verifie que celui-ci apparait bien dans son historique
    Given Un utilisateur possède un compte
    When Un utilisateur fait un retrait de 100€
    Then Le dernier releve est de type retrait
    Then Le dernier releve a pour montant 100€
    Then Le dernier releve a pour balance la balance actuelle du compte

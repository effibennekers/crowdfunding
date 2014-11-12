/**
 * Created by Roberto on 12-11-14.
 */
'use strict';

angular.module('CrowdFundingApp')
  .controller('ProfielCtrl', function ($scope, state) {
    state.active('profiel');

    $scope.klant = {
      "voornaam": "Johan",
      "tussenvoegsel": "De",
      "achternaam": "Wit",
      "straatnaam": "Lange lindeweg",
      "huisnummer": "230",
      "huisnummerav": "Zwart",
      "postcode": "1015VS",
      "plaats": "Vlissingen",
      "debtoriban": "NL31INGB3456789012",
      "creditoriban": "NL32INGB9098765477",
      "telefoonnummer": "0231234568",
      "telefoonnummermobiel": "0612345689",
      "contract": "CRWFD123456",
      "email": "johandewit@voc.nl"
    };

  })

  .value('state', {});

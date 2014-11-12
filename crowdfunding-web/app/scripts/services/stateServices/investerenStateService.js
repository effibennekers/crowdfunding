angular.module('CrowdFundingApp')
    .service('investerenStateService', function() {

        var selectedInvestering;

        function getInvesteringen() {
            return [
                {
                    "hideDetails" : false,
                    "projectid": "1",
                    "voornaam": "Maarten",
                    "tussenvoegsels": "van",
                    "achternaam": "Schelven",
                    "titel": "Aankoop macbook pro",
                    "doelbedrag": "2500",
                    "bereiktbedrag" : "25",
                    "aangemeld": "08-10-2014", // datum aangemeld
                    "opentijd": "60", //dagen voordat de investering van start gaat
                    "rentepercentage": "5",
                    "risicoprofiel": "1",
                    "status": "open", //bouw (klant is nog bezig) loopt (terugbetaal periode gestopt afgerond
                    "beschrijving": "Etiam varius est odio, eu condimentum velit euismod dapibus. Proin eget mauris at ligula gravida fringilla. Nullam vel sapien et urna laoreet pretium. Nulla facilisi. Integer eget felis leo"
                },
                {
                    "hideDetails" : false,
                    "projectid": "2",
                    "voornaam": "Hans",
                    "tussenvoegsels": "",
                    "achternaam": "Borst",
                    "titel": "Aankoop grond",
                    "doelbedrag": "45000",
                    "bereiktbedrag" : "15000",
                    "aangemeld": "08-11-2014",
                    "opentijd": "360", //dagen
                    "rentepercentage": "3",
                    "risicoprofiel": "2",
                    "status": "open", //bouw (klant is nog bezig) loopt (terugbetaal periode gestopt afgerond
                    "beschrijving": "Etiam varius est odio, eu condimentum velit euismod dapibus. Proin eget mauris at ligula gravida fringilla. Nullam vel sapien et urna laoreet pretium. Nulla facilisi. Integer eget felis leo"
                },
                {
                    "hideDetails" : false,
                    "projectid": "3",
                    "voornaam": "Thijs",
                    "tussenvoegsels": "",
                    "achternaam": "Zijp",
                    "titel": "Pampers kind",
                    "doelbedrag": "500",
                    "bereiktbedrag" : "500",
                    "aangemeld": "18-10-2014",
                    "opentijd": "31", //dagen
                    "rentepercentage": "6",
                    "risicoprofiel": "1",
                    "status": "open", //bouw (klant is nog bezig) loopt (terugbetaal periode gestopt afgerond
                    "beschrijving": "Hoeveel luiers, welke maat, welk merk zal ik al van te voren kopen? Ik dacht zelf aan de Pampers of die van kruidvat. Er zijn altijd wel diverse acties bij de kruidvat, etos etc, maar heb geen enkel idee of ik hier ook wat aan heb. Ik weet natuurlijk nog niet welke maat/ gewicht ons kleintje straks heeft en wil niet met luiers opgescheept zitten die niet meer passen. Ik moet dus massaal inslaan en heb daarvoor een klein kapitaal nodig. "
                }
            ];
        }

        function getSelectedInvestering() {
            return getInvesteringen()[selectedInvestering];
        }

        function setSelectedInvestering(index) {
            selectedInvestering = index;
        }

        return {
            getInvesteringen: getInvesteringen,
            getSelectedInvestering: getSelectedInvestering,
            setSelectedInvestering: setSelectedInvestering

        }


    });
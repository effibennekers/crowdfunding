angular.module('CrowdFundingApp')
    .service('projectenStateService', function ($http) {

        var selectedProject;

        function getProjecten() {
            console.log("getPprojects");
            return $http.get(' http://localhost:8080/rest/projecten ');
        }

        function getSelectedproject() {
            return selectedProject;
        }

        function setSelectedProject(index) {
            selectedProject = index;
        }

        return {
            getProjecten: getProjecten,
            getSelectedproject: getSelectedproject,
            setSelectedProject: setSelectedProject

        }


    });
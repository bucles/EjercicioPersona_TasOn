/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
var app = angular.module('personas', ['ngResource', 'ngGrid', 'ui.bootstrap']);

app.controller('listaPersonasCtrl', function ($scope, $rootScope, personaServicio) {


    $scope.gridOptions = {
        data: 'personas.list',

        columnDefs: [
            {field: 'Cedula', displayName: 'percedula'},
            {field: 'Nombres', displayName: 'pernombres'},
            {field: 'A. Paterno', displayName: 'perapellidopaterno'},
            {field: 'A. Materno', displayName: 'perapellidomaterno'},
            {field: 'Telefono', displayName: 'pertelefono'},
            {field: 'Estado Civil', displayName: 'perestadocivil'},
            {field: 'Genero', displayName: 'pergenero'},
            {field: 'Nacionalidad', displayName: 'pernacionalidad'},
            {field: 'Fecha Nac.', displayName: 'perfechanacimiento'},
            {field: 'Lugar Nac.', displayName: 'perlugarnacimiento'}
        ],

        multiSelect: false,
        selectedItems: [],

        afterSelectionChange: function (rowItem) {
            if (rowItem.selected) {
                $rootScope.$broadcast('personSelected', $scope.gridOptions.selectedItems[0].id);
            }
        }
    };


    $scope.refreshGrid = function () {
        personaServicio.get(function (data) {
            $scope.personas = data;
        })
    };



    $scope.$on('refreshGrid', function () {
        $scope.refreshGrid();
    });



});

app.controller('personaControlador', function ($scope, $rootScope, personaServicio) {

    $scope.clearForm = function () {
        $scope.persona = null;

        $scope.personForm.$setPristine();

        $rootScope.$broadcast('clear');
    };


    $scope.updatePerson = function () {
        personaServicio.save($scope.persona).$promise.then(
                function () {

                    $rootScope.$broadcast('personaGuardada');
                    //$scope.clearForm();
                },
                function () {

                    $rootScope.$broadcast('error');
                });
    };

    $scope.buscarPersona = function (percedula) {

        personaServicio.get({percedula: percedula}).$promise.then(
                function () {
                    $scope.persona = personaServicio.get({percedula: percedula});

                    //document.write(persona);
                    //$scope.clearForm();

                },
                function () {
                    //$rootScope.$broadcast('error');
                    $rootScope.$broadcast('personaNoEncontrada');

                });

    };


    $scope.borrarPersona = function (percedula) {
        personaServicio.delete({percedula: percedula}).$promise.then(
                function () {

                    $rootScope.$broadcast('personaEliminada');
                    $scope.clearForm();
                },
                function () {

                    $rootScope.$broadcast('error');
                });
    };


    $scope.$on('personSelected', function (event, id) {
        $scope.persona = personaServicio.get({id: id});
    });



});
app.controller('mensajesControlador', function ($scope) {

    $scope.$on('personaGuardada', function () {
        $scope.alerts = [
            {type: 'success', msg: 'Persona Guardada'}
        ];
    });


    $scope.$on('personaEliminada', function () {
        $scope.alerts = [
            {type: 'success', msg: 'Persona Eliminada'}
        ];
    });

    $scope.$on('personaEncontrada', function () {
        $scope.alerts = [
            {type: 'success', msg: 'Persona encontrada'}
        ];
    });

    $scope.$on('personaNoEncontrada', function () {
        $scope.alerts = [
            {type: 'danger', msg: 'Persona no encontrada'}
        ];
    });


    $scope.$on('error', function () {
        $scope.alerts = [
            {type: 'danger', msg: 'No se pudo guardar el registro. Intente con otro Nro. de Cedula'}
        ];
    });

    $scope.closeAlert = function (index) {
        $scope.alerts.splice(index, 1);
    };
});


app.factory('personaServicio', function ($resource) {
    return $resource('resources/personas/:percedula', );
});



var app = angular.module("myApp" , []);
app.controller("sheet" , function($scope, $parse) {
    $scope.columns = ['A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z'];
    $scope.rows = [];
    $scope.cells = [];
    $scope.cellvalue;
    $scope.cellposition;

    for(i=0; i<100; i++)
        $scope.rows[i] = i+1;

    process = function(exp) {
        var res = exp.substring(1);
        return res.replace(/[A-Z]\d+/g, function(ref) {
            return 'compute("' + ref + '")';
        });
    };
    $scope.compute = function(cell) {
        var exp = $scope.cells[cell];
        $scope.cellposition = cell;
        $scope.cellvalue = exp;
        console.log("Position : " + cell + " value : " + exp);
        console.log($scope.cells);

        send(getcellposition(), getcellvalue());

        if (exp){
            if ((exp.substring(0,1) == "=") || (exp.substring(0,1) == "+")){
                return $parse(process(exp))($scope);
            }else{
                var value;
                if (!isNaN(parseFloat(exp))){
                    value = parseFloat(exp);
                }
                return value;
            }
        }
    };
    getcellposition = function(){
        console.log("this is : " + $scope.cellposition);
        return $scope.cellposition;
    }

    getcellvalue = function(){
        return $scope.cellvalue;
    }

    insert = function(position , cell){  //insert into cell   ex) cells[A4] = "hi";
        $scope.cells[position] = cell;
        $scope.$apply();
        console.log("scope.cells : " + $scope.cells[position]);
    }
});
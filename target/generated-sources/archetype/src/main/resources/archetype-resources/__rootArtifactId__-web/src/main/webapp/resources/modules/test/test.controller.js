/**
 * Created by Pan on 2016/9/11.
 */

app.controller("TestCaseController", function (TestCaseService, $scope,$uibModal) {
    //$scope.totalItems =100 ;
    $scope.currentPage = 1;
    $scope.pageSize = 10;

    $scope.pageChanged = function() {
        //console.log('Page changed to: ' + $scope.currentPage);
        $scope.list($scope.currentPage, $scope.pageSize);
    };

    //$scope.maxSize = 5;
    //$scope.bigTotalItems = 175;
    //$scope.bigCurrentPage = 1;
    $scope.list = function(pageNum,pageSize){
        TestCaseService.list(pageNum, pageSize).then(function (data) {
            $scope.tbeans = data.resultData.lists;
            $scope.totalItems = data.resultData.pageConfig.rowCount;
            //console.log($scope.totalItems)
        });
    };
    $scope.list($scope.currentPage, $scope.pageSize);

    $scope.setDeleteId = function(id){
        $scope.deleteId=id;
    }
    $scope.delete = function (id) {
        TestCaseService.delete(id).then(function (data) {
            if (data.resultData == 1) {
                $scope.list($scope.currentPage, $scope.pageSize);
            }
        });
    };
    // 打开表单
    $scope.openForm = function (size) {
        var modalInstance = $uibModal.open({
            animation: true,
            templateUrl: 'resources/modules/test/test.form.view.html',
            controller: 'TestCaseFormController',
            size: size,
            resolve: {
                tbean: function () {
                    return null;
                }
            }
        });
        // 处理对话框提交/关闭
        modalInstance.result.then(function () {
            $scope.list($scope.currentPage, $scope.pageSize);
        });
    };
});
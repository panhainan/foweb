/**
 * Created by Pan on 2016/9/11.
 */

app.controller("TestCaseController", function (TestCaseService, $scope,$uibModal) {
    $scope.list = TestCaseService.list().then(function (data) {
        $scope.tbeans = data.resultData;
    });
    $scope.look = function (id) {
        TestCaseService.look(id).then(function (data) {
        });
    };
    $scope.delete = function (id, $index) {
        TestCaseService.delete(id).then(function (data) {
            if (data.resultData == 1) {
                $scope.tbeans.splice($index, 1);
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
            $scope.list;
        });
    };
});
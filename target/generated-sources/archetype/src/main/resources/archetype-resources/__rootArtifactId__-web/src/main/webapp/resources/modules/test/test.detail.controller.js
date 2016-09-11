/**
 * Created by Pan on 2016/9/11.
 */

app.controller("TestCaseDetailController", function (TestCaseService, $scope,$uibModal, $routeParams) {
    console.log("你dy的，哥要睡觉了！天tm都亮了，7。了都")
    $scope.look = TestCaseService.look($routeParams.id).then(function (data) {
        $scope.tbean = data.resultData;
    });
    // 打开表单
    $scope.openForm = function (size, tbean) {
        if (!$scope.tbean) {
            return false;
        }
        var modalInstance = $uibModal.open({
            animation: true,
            templateUrl: 'resources/modules/test/test.form.view.html',
            controller: 'TestCaseFormController',
            size: size,
            resolve: {
                tbean: function () {
                    return tbean;
                }
            }
        });
        // 处理对话框提交/关闭
        modalInstance.result.then(function (tbean) {
            $scope.look;
        });
    };
});
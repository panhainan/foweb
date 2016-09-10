/**
 * Created by Pan on 2016/9/11.
 */

app.controller("TestCaseFormController", function (TestCaseService,$rootScope, $scope, tbean,$uibModalInstance) {
    $scope.tbean = tbean;
    //console.log( $scope.tbean)
    // 提交表单
    $scope.save = function() {
        $scope.tbean.saveDate = new Date();
        //console.log($scope.tbean)
        TestCaseService.save($scope.tbean).then(function(data) {
            $uibModalInstance.close();
            window.location.href = '#/test-case/' + data.resultData.id;
            $rootScope.$broadcast('alert', {
                'type': 'success',
                'message': ($scope.tbean.id?'更新':'创建')+'成功'
            });
        })
    }


    // 关闭表单弹出框
    $scope.cancel = function() {
        $uibModalInstance.dismiss('cancel');
    }
});
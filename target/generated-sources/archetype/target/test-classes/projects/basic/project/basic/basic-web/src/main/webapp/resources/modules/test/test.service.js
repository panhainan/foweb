/**
 * Created by Pan on 2016/9/11.
 */
app.service("TestCaseService", function ($http, $q) {
    this.list = function (pageNum,pageSize) {
        var deferred = $q.defer();
        $http.get('/testbean/?pageNum='+pageNum+"&pageSize="+pageSize,{
            headers: {'Content-Type': 'application/x-www-form-urlencoded; charset=UTF-8'}
        }).success(function (data) {
            //console.log(data);
            deferred.resolve(data);
        });
        return deferred.promise;
    }
    this.look = function (id) {
        var deferred = $q.defer();
        $http.get('/testbean/' + id,cfg_form).success(function (data) {
            //console.log(data);
            deferred.resolve(data);
        });
        return deferred.promise;
    }
    this.save = function (tbean) {
        var deferred = $q.defer();
        if(tbean.id){
            $http.put('/testbean/',tbean,cfg_json).success(function (data) {
                //console.log(data);
                deferred.resolve(data);
            });
        }else{
            $http.post('/testbean/',tbean, cfg_json).success(function (data) {
                //console.log(data);
                deferred.resolve(data);
            });
        }
        return deferred.promise;
    }
    this.delete = function (id) {
        var deferred = $q.defer();
        $http.delete('/testbean/' + id, cfg_form).success(function (data) {
            //console.log(data);
            deferred.resolve(data);
        });
        return deferred.promise;
    }
});

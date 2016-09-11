/**
 * Created by Pan on 2016/9/12.
 */
app.factory('HttpInterceptor', function ($q, $window) {
    return {
        request: function (config) {
            if(config.url.indexOf(".html")==-1){
                //console.log("before:"+config.url)
                config.url=web_project_name+config.url;
                //console.log("after:"+config.url)
            }
            return config;
        },

        response: function (response) {
            return response || $q.when(response);
        }
    };
});
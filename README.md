## RairDemo


### 2017
#### 4.14:module_webview WebView的使用 简书：http://www.jianshu.com/p/1071b1cdbbf5
#### 4.27:module_preference_activity PreferenceActivity设置 简书：http://www.jianshu.com/p/4a65f4a912c6
#### 4.29:module_connect_manager 连接管理 简书：http://www.jianshu.com/p/c415691b282c
#### 4.29:module_wifi Wifi的简单入门使用Demo 简书：http://www.jianshu.com/p/c415691b282c
#### 5.3:module_bluetooth 蓝牙简单使用 简书：http://www.jianshu.com/p/448f9292aad2
#### 6.4:module_custom_vew 自定义View简单案例-自绘 简书：http://www.jianshu.com/p/6326420d55fb
#### 10.19:module_encrpt 加密解密算法 

### 2018
#### 01.17：module_face_detect 自动对焦检测人脸 Face++ 虹软

### 2019
#### 04.09:lib_promise 
```java
Promise<String> promise = Function.execute(new Callable<String>() {
    @Override
    public String call() throws Exception {
        // This method will run on a background thread
        return "Hello world!";
    }
});
```
```java
promise.thenOnMainThread(new Task<String>() {
    @Override
    public void run(String message) {
        Toast.makeText(getContext(), message, LENGTH_LONG);
    }
})
.onErrorOnMainThread(new Task<Throwable>() {
    @Override
    public void run(Throwable data) {
        Toast.makeText(getContext(), "Oops!", LENGTH_LONG);
    }
});
```
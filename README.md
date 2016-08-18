android activity跳转动画设置，带有多种跳转效果


看了android的源代码和资源文件，终于明白如何去修改设置Dialog和Activity的进入和退出效果了。设置Dialog首先通过getWindow()方法获取它的窗口，然后通过getAttributes()方法获得window的WindowManager.LayoutParams lp, lp有个公共属性windowAnimations, 只要把要实现的animation的id赋值给它就可以了。问题是这个animation应该怎么写呢，研究发现，窗口进入和退出的效果分别是通过@android:windowEnterAnimation和@android:windowExitAnimation两个item设定的，比如进入时的anim是@anim/dialog_enter, 退出的是@anim/dialog_exit, 则声明一个style为:

<style name="mydialog">  
    <item name="@android:windowEnterAnimation">@anim/dialog_enter</item>  
   <item name="@android:windowExitAnimation">@anim/dialog_exit</item>  
</style>  
然后把这个style的id传给lp.windowAnimations就行了。

     Activity的进入和退出效果可以通过@android:activityOpenEnterAnimation，
     @android:activityOpenExitAnimation，@android:activityCloseEnterAnimation，
     @android:activityCloseExitAnimation这几个item设定，第一个表示新的activity创建进入效果，
     第2个表示activity还没有finish()下退出效果，第3个表示上一个activity返回进入效果，第4个表示的是activity finish()之后退出效果...（好似有点乱了）。具体设置参考如下:

<style name="myact">  
       <item name="@android:activityOpenEnterAnimation">@anim/act_enter</item>  
       <item name="@android:activityOpenExitAnimation">@anim/act_exit</item>  
       <item name="@android:activityCloseEnterAnimation">@anim/act_enter</item>  
       <item name="@android:activityCloseExitAnimation">@anim/act_exit</item>  
</style>  
 <style name="mytheme" parent="@android:style/Theme">   
    <item name="@android:windowAnimationStyle">@style/myact</item>  
</style>  
然后把mytheme这个style作为Activity的theme就行了，还有一个办法就是通过Acitvity获取它的window, 然后和设置dialog一样进行设置，因为归根到底是设置Window的layoutparams里的windowAnimations值。
所以Activity的进入和退出效果也可以通过@android:windowEnterAnimation和@android:windowExitAnimation这两个item设定。


看了上面的文章有点不理解：在网上找了一点资料辅助一下：

一般来讲，Activity就是一个可视的人机交互界面。 每一个Activity都有一个默认的Window，一般来讲，这个Window都是全屏的，当然也有例外，比如Dialog的Window就是非全屏的。
Activity也可以利用默认Window以外的其它的Window，比如弹出一个Dialog对话框。 Window里可见的内容，就是一层一层的View。Window里的View是通过setContentView这个接口set进去的，
这个ContentView就是Window里处于最根部的View。

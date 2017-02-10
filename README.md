# SettingBar
Android自定义控件：SettingBar
常见于“设置”和“我的”界面的菜单条


**要点元素：**

* 顶部标题文字（默认隐藏）
* 左侧icon（默认无，30dp*30dp）
* 左侧文字
* 右侧icon（默认箭头，16dp*16dp）
* 右侧ImageView（默认无，48dp*48dp）
* 右侧文字
* 底部分割线（与左侧文字左边界对齐，默认显示）

**其他扩展：**

* 点击事件
* 所有文字均可设置颜色、字号
* 所有图片可设置圆形、圆角、大小、图片资源src


效果如下：<br/>
<img width="380px" src="http://img.blog.csdn.net/20170210205958851?watermark/2/text/aHR0cDovL2Jsb2cuY3Nkbi5uZXQvU2tpcHBlcktldmlu/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70/gravity/SouthEast" alt="实际效果" >


**如何使用：**
* 方法一：调用get/set方法赋值
* 方法二：使用SettingBarModel实体类赋值
* 方法三：在xml直接设置属性赋值（暂不完善）

请参考app中的源码。

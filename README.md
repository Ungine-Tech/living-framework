# Living-Framework

Living-Framework是一个针对于paper的 在其上层进行封装的框架

这是一个开源框架 使用Apache License 2.0开源 这一意味着您可以随意使用它 只要保留版权说明即可

### Applet

在此框架中Applet的定义: 面向用户（玩家）的针对于用户（玩家）的事件监听器

我们通过对Bukkit底层的Listener进行封装 来实现Applet

e.g.

```java

@Applet(
        value = "testApplet",
        event = PlayerJoinEvent.class,
        eventPriority = EventPriority.NORMAL
)
public class TestApplet implements net.livingsky.framework.applet.Applet {
    @Override
    public AppletResponse appletHandle(AppletRequest appletRequest, AppletResponse appletResponse) throws Exception {
        return null;
    }
}
```

当然 别忘记注册Applet 您可以在LivingJavaPlugin中的AppletManager对其进行注册

### Plotter

在此框架中Plotter的定义: 面向用户（玩家）的用户界面渲染器

### Scene

在此框架中Scene的定义: 面向用户（玩家）的用户界面的模型
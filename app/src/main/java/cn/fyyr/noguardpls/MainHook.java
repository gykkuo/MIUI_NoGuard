package cn.fyyr.noguardpls;
import android.content.Context;

import de.robv.android.xposed.IXposedHookLoadPackage;
import de.robv.android.xposed.XC_MethodHook;
import de.robv.android.xposed.XposedBridge;
import de.robv.android.xposed.XposedHelpers;
import de.robv.android.xposed.callbacks.XC_LoadPackage;
public class MainHook implements IXposedHookLoadPackage{
    @Override
    public void handleLoadPackage(XC_LoadPackage.LoadPackageParam lpparam) throws Throwable {
        if(lpparam.packageName.equals("com.miui.guardprovider")){
            int needmod = 0;
            Class<?> classs = null;
            try{
                classs = XposedHelpers.findClass("com.miui.guardprovider.GuardApplication", lpparam.classLoader);
                XposedHelpers.findAndHookMethod(classs, "e", android.content.Context.class, new XC_MethodHook() {
                    @Override
                    protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                        //XposedBridge.log("com.miui.guardprovider:执行拦截！");
                        param.setResult(false);
                    }
                });
                needmod++;
            } catch (XposedHelpers.ClassNotFoundError err){
                XposedBridge.log("Class 不存在，版本可能不兼容 --- com.miui.guardprovider --- com.miui.guardprovider.GuardApplication.e");
                return;
            } catch (NoSuchMethodError err){
                XposedBridge.log("Method 不存在，版本可能不兼容 --- com.miui.guardprovider --- com.miui.guardprovider.GuardApplication.e");
                return;
            }
            XposedBridge.log("com.miui.guardprovider:已修改 " + needmod + " 次");
        }
        if(lpparam.packageName.equals("com.miui.analytics")){
            int needmod = 0;
            Class<?> classs = null;
            //com.miui.analytics.onetrack.p.u.w
            try{
                classs = XposedHelpers.findClass("com.miui.analytics.onetrack.p.u", lpparam.classLoader);
                XposedHelpers.findAndHookMethod(classs, "w", long.class,long.class, new XC_MethodHook() {
                    @Override
                    protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                        //XposedBridge.log("com.miui.analytics:执行拦截！ --- 1");
                        param.setResult(null);
                    }
                });

                needmod++;
            } catch (XposedHelpers.ClassNotFoundError err){
                XposedBridge.log("Class 不存在，版本可能不兼容 --- com.miui.analytics --- com.miui.analytics.onetrack.p.u");
            } catch (NoSuchMethodError err){
                XposedBridge.log("Method 不存在，版本可能不兼容 --- com.miui.analytics --- com.miui.analytics.onetrack.p.u.w");
            }
            //com.miui.analytics.c.f.k.y
            try{
                classs = XposedHelpers.findClass("com.miui.analytics.c.f.k", lpparam.classLoader);
                XposedHelpers.findAndHookMethod(classs, "y", long.class,long.class, new XC_MethodHook() {
                    @Override
                    protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                        //XposedBridge.log("com.miui.analytics:执行拦截！ --- 2");
                        param.setResult(null);
                    }
                });
                needmod++;
            } catch (XposedHelpers.ClassNotFoundError err){
                XposedBridge.log("Class 不存在，版本可能不兼容 --- com.miui.analytics --- com.miui.analytics.c.f.k");
            } catch (NoSuchMethodError err){
                XposedBridge.log("Method 不存在，版本可能不兼容 --- com.miui.analytics --- com.miui.analytics.c.f.k.y");
            }
            try{
                classs = XposedHelpers.findClass("com.miui.analytics.onetrack.q.c", lpparam.classLoader);
                //com.miui.analytics.onetrack.q.c.a
                try{
                    XposedHelpers.findAndHookMethod(classs, "a", Context.class, new XC_MethodHook() {
                        @Override
                        protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                            //XposedBridge.log("com.miui.analytics:执行拦截！ --- 3");
                            param.setResult(0);
                        }
                    });
                    needmod++;
                }catch (NoSuchMethodError err){
                    XposedBridge.log("Method 不存在，版本可能不兼容 --- com.miui.analytics --- com.miui.analytics.onetrack.q.c.a");
                }
                //com.miui.analytics.onetrack.q.c.b
                try{
                    XposedHelpers.findAndHookMethod(classs, "b", Context.class, new XC_MethodHook() {
                        @Override
                        protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                            //XposedBridge.log("com.miui.analytics:执行拦截！ --- 4");
                            param.setResult("NONE");
                        }
                    });
                    needmod++;
                }catch (NoSuchMethodError err){
                    XposedBridge.log("Method 不存在，版本可能不兼容 --- com.miui.analytics --- com.miui.analytics.onetrack.q.c.b");
                }
                //com.miui.analytics.onetrack.q.c.c
                try{
                    XposedHelpers.findAndHookMethod(classs, "c",  new XC_MethodHook() {
                        @Override
                        protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                            //XposedBridge.log("com.miui.analytics:执行拦截！ --- 5");
                            param.setResult(false);
                        }
                    });
                    needmod++;
                }catch (NoSuchMethodError err){
                    XposedBridge.log("Method 不存在，版本可能不兼容 --- com.miui.analytics --- com.miui.analytics.onetrack.q.c.c");
                }
            } catch (XposedHelpers.ClassNotFoundError err){
                XposedBridge.log("Class 不存在，版本可能不兼容 --- com.miui.analytics --- com.miui.analytics.onetrack.q.c");
            }
            XposedBridge.log("com.miui.analytics:已修改 " + needmod + " 次");
        }
        //hook(lpparam);
    }
}

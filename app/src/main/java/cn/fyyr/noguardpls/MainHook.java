package cn.fyyr.noguardpls;
import android.util.Log;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import de.robv.android.xposed.IXposedHookLoadPackage;
import de.robv.android.xposed.XC_MethodHook;
import de.robv.android.xposed.XposedBridge;
import de.robv.android.xposed.XposedHelpers;
import de.robv.android.xposed.callbacks.XC_LoadPackage;
public class MainHook implements IXposedHookLoadPackage{
    @Override
    public void handleLoadPackage(XC_LoadPackage.LoadPackageParam lpparam) throws Throwable {
        if(lpparam.packageName.equals("com.miui.guardprovider")){
            Class<?> classs = null;
            try{
                classs = XposedHelpers.findClass("com.miui.guardprovider.GuardApplication", lpparam.classLoader);
                XposedHelpers.findAndHookMethod(classs, "e", android.content.Context.class, new XC_MethodHook() {
                    @Override
                    protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                        XposedBridge.log("执行拦截！");
                        param.setResult(false);
                    }
                });
            } catch (XposedHelpers.ClassNotFoundError err){
                XposedBridge.log("Class 不存在，版本可能不兼容");
                return;
            } catch (NoSuchMethodError err){
                XposedBridge.log("Method 不存在，版本可能不兼容");
                return;
            }
            XposedBridge.log("Success!成功！");




        }


        //hook(lpparam);
    }
}

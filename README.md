# OneUI Sample

This is a simple project which demonstrates how to utilize OneUI design library on Android.

## Github Repositories

- [oneui-core](https://github.com/OneUIProject/oneui-core)
- [oneui-design](https://github.com/OneUIProject/oneui-design)

## Quick notes

Here are some notes that for you getting started on using OneUI library.

### Dependencies

> **Note**: You need to remove the original `appcompat` and `material` dependencies generated in Android Studio.

```diff
-implementation 'androidx.appcompat:appcompat:1.6.1'
-implementation 'com.google.android.material:material:1.9.0'
-implementation 'androidx.constraintlayout:constraintlayout:2.1.4'

+implementation 'io.github.oneuiproject.sesl:appcompat:1.4.0'
+implementation 'io.github.oneuiproject.sesl:material:1.5.0'
+implementation 'io.github.oneuiproject.sesl:preference:1.1.0'
+implementation 'io.github.oneuiproject:icons:1.0.1'
+implementation 'io.github.oneuiproject:design:1.2.3'
```

you need to add following code in `app/build.gradle` under `dependencies` block.

```gradle
configurations.all {
    exclude group: 'androidx.appcompat', module: 'appcompat'
    exclude group: 'androidx.core', module: 'core'
}
```

### Theme settings

```xml
<application
    ...
    android:theme="@style/OneUITheme" />
```